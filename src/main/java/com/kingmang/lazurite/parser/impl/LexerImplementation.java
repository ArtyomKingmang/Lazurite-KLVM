package com.kingmang.lazurite.parser.impl;

import com.kingmang.lazurite.exceptions.LzrException;
import com.kingmang.lazurite.parser.tokens.Token;
import com.kingmang.lazurite.parser.tokens.TokenType;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.toLowerCase;


public class LexerImplementation {
    private static final String OPERATOR_CHARS = "+-*/%()[]{}=:<>,!^.;|";
    private static final Map<String, TokenType> OPERATORS;
    private static final Map<String, TokenType> KEYWORDS = new HashMap<>();
    private static final TokenType[] tokenTypes = TokenType.values();

    private static final String[] keywords = {
            "assert",
            "do",
            "enum",
            "macro",
            "try",
            "catch",
            "throw",
            "print",
            "println",
            "if",
            "else",
            "while",
            "for",
            "break",
            "continue",
            "func",
            "return",
            "using",
            "match",
            "case",
            "class",
            "new"
    };
    static {
        OPERATORS = new HashMap<>();
        OPERATORS.put("+", TokenType.PLUS);
        OPERATORS.put("-", TokenType.MINUS);
        OPERATORS.put("*", TokenType.STAR);
        OPERATORS.put("/", TokenType.SLASH);
        OPERATORS.put("%", TokenType.PERCENT);
        OPERATORS.put("(", TokenType.LPAREN);
        OPERATORS.put(")", TokenType.RPAREN);
        OPERATORS.put("[", TokenType.LBRACKET);
        OPERATORS.put("]", TokenType.RBRACKET);
        OPERATORS.put("{", TokenType.LBRACE);
        OPERATORS.put("}", TokenType.RBRACE);
        OPERATORS.put("=", TokenType.EQ);
        OPERATORS.put(":", TokenType.COLON);
        OPERATORS.put("<", TokenType.LT);
        OPERATORS.put(">", TokenType.GT);
        OPERATORS.put(",", TokenType.COMMA);
        OPERATORS.put(".", TokenType.DOT);
        OPERATORS.put("^", TokenType.CARET);
        OPERATORS.put("|", TokenType.BAR);
        OPERATORS.put("!", TokenType.EXCL);

        OPERATORS.put("!=", TokenType.EXCLEQ);
        OPERATORS.put("==", TokenType.EQEQ);
        OPERATORS.put(">=", TokenType.GTEQ);
        OPERATORS.put("<=", TokenType.LTEQ);
        OPERATORS.put("+=", TokenType.PLUSEQ);
        OPERATORS.put("-=", TokenType.MINUSEQ);
        OPERATORS.put("*=", TokenType.STAREQ);
        OPERATORS.put("/=", TokenType.SLASHEQ);
        OPERATORS.put("++", TokenType.PLUSPLUS);
        OPERATORS.put("--", TokenType.MINUSMINUS);

        OPERATORS.put("::", TokenType.COLONCOLON);
    }

    static {
        for (int i = 0; i < keywords.length; i++) {
            if (i < tokenTypes.length) {
                KEYWORDS.put(keywords[i], tokenTypes[i]);
            } else {
                System.err.print("Not enough token types for all tokens");
                break;
            }
        }

    }

    private String input;
    private int pos;
    private int line;

    public LexerImplementation(String input) {
        this.input = input;
        //System.out.println(input);
        this.pos = 0;
        this.line = 1;
    }

    public Token tokenize() {
        if (isAtEnd())
            return token(TokenType.EOF, "\0");

        char c = current();

        if (c == '/') {
            c = advance();
            if(c == '/')
                comment();
        }

        if (OPERATORS.containsKey(String.valueOf(c))) {
            return operator();
        } else if (Character.isDigit(c)) {
            return number();
        } else if (Character.isLetter(c)) {
            return word();
        } else if (c == '"' || c == '\'') {
            return string();
        } else if (c == '$') {
            return hex();
        }


        advance();
        return tokenize();
    }

    private Token hex() {
        StringBuilder buffer = new StringBuilder();
        char c = advance(); // skip $
        while (isHexNumber(c) || Character.isDigit(c)) {
            buffer.append(c);
            c = advance();
        }
        return token(TokenType.HEX_NUMBER, buffer.toString());
    }

    private void comment() {
        char c = current();
        while ("\r\n\0".indexOf(c) == -1) {
            c = advance();
        }
    }

    private Token string() {
        StringBuffer buffer = new StringBuffer();
        boolean quoteType = current() == '"';

        char c = advance(); // skip '"'
        while (c != (quoteType ? '"' : '\'')) {
            if (c == '\\') {
                c = advance();
                switch (c) {
                    case 'n': {
                        buffer.append("\n");
                        break;
                    }
                    case 't': {
                        buffer.append("\t");
                        break;
                    }
                    case 'r': {
                        buffer.append("\r");
                        break;
                    }
                    case '0': {
                        buffer.append("\0");
                        break;
                    }
                    case 'b': {
                        buffer.append("\b");
                        break;
                    }
                    case 'f': {
                        buffer.append("\f");
                        break;
                    }
                    default: {
                        throw new LzrException("LexerException", "unknown escape character '" + c + "'");
                    }
                }
                c = advance();
                continue;
            }
            if (isAtEnd() || c == '\0')
                throw new LzrException("LexerException", "reached end of file when parsing quoted string");
            buffer.append(c);
            c = advance();
        }
        advance(); // skip '"'
        return token(TokenType.TEXT, buffer.toString());
    }

    private Token word() {
        StringBuilder buffer = new StringBuilder();

        char c = current();
        while (Character.isLetterOrDigit(c) || c == '_' || c == '&') {
            buffer.append(c);
            c = advance();
        }
        String word = buffer.toString();
        if (KEYWORDS.containsKey(word)) {
            return token(KEYWORDS.get(word), word);
        }
        return token(TokenType.WORD, buffer.toString());
    }

    private Token number() {
        StringBuilder buffer = new StringBuilder();
        char c = current();
        boolean containsDot = false;

        while (Character.isDigit(c) || c == '.') {
            if (c == '.') {
                if (containsDot)
                    throw new LzrException("LexerException", "found second dot in float number");
                containsDot = true;
            }
            buffer.append(c);
            c = advance();
        }
        return token(TokenType.NUMBER, buffer.toString());
    }

    private Token operator() {
        String currentChar = String.valueOf(current());
        if(currentChar == "=") {
            advance();
            return token(TokenType.EQ, "=");
        } else {
            advance();
            return token(TokenType.PLUS, "+");
        }
        //String nextChar = String.valueOf(relativeCurrent(pos + 1 >= input.length() ? 0 : 1));

        //if (OPERATORS.containsKey(currentChar + nextChar)) {
            //advance(); advance();
            //return token(OPERATORS.get(currentChar + nextChar),
                    //currentChar + nextChar);
        //} else {
           // advance();
            //return token(OPERATORS.get(currentChar), currentChar);
        //}
    }

    private char advance() {
        pos++;
        if (isAtEnd()) return '\0';
        if (current() == '\n') line++;
        return current();
    }

    private char relativeCurrent(int shift) {
        if (isAtEnd()) return '\0';
        return input.charAt(pos + shift);
    }

    private char current() {
        return input.charAt(pos);
    }

    private boolean isAtEnd() {
        return pos < 0 || pos >= input.length();
    }
    private Token token(TokenType type, String value) {
        return new Token(type, value, line);
    }


    private static boolean isHexNumber(char current) {
        return "abcdef".indexOf(toLowerCase(current)) != -1;
    }
}