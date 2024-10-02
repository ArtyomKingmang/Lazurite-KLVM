package com.kingmang.lazurite.parser.impl;

import com.kingmang.lazurite.exceptions.LzrException;
import com.kingmang.lazurite.parser.ast.expressions.BinaryExpression;
import com.kingmang.lazurite.parser.ast.expressions.Expression;
import com.kingmang.lazurite.parser.ast.expressions.UnaryExpression;
import com.kingmang.lazurite.parser.ast.expressions.VariableExpression;
import com.kingmang.lazurite.parser.ast.statements.*;
import com.kingmang.lazurite.parser.tokens.Token;
import com.kingmang.lazurite.parser.tokens.TokenType;

import java.util.Arrays;

public class ParserImplementation {

    private LexerImplementation lexer;
    private ParserAccumulator accumulator;
    private int label_num = -1;

    public ParserImplementation(LexerImplementation lexer) {
        this.lexer = lexer;
        this.accumulator = new ParserAccumulator();
        accumulator.previous = new Token(TokenType.EOF, "\0", -1);
        accumulator.current = accumulator.previous;
        advance();
    }

    public Statement parse() {
        BlockStatement block = new BlockStatement();
        while (accumulator.current.getType() != TokenType.EOF) {
            block.add(statement());
        }
        return block;
    }

    public Statement statement() {
        if (match(TokenType.WORD)) {
            String name = consume(TokenType.WORD).getText();
            consume(TokenType.EQ);
            return new DefineVariableAST(root(), name, line());
            //return new VariableExpression(name, null);
        }
        return new PopStatement(root());
    }

    private Expression root() {
        return conditional();
    }

    private Expression conditional() {
        Expression expr1 = term();
        return expr1;
    }

    private Expression term() {
        Expression expr = factor();
        return expr;
    }
    private Expression factor() {
        Expression expr = unary();
        return expr;
    }

    private Expression unary() {
        Expression expr = null;
        return expr == null ? primary() : expr;
    }

    private Expression primary() {
        advance();
        switch (accumulator.previous.getType()) {
            case LPAREN:
                Expression expr = root();
                match(TokenType.RPAREN);
                return expr;

            case WORD :
                return new VariableExpression(accumulator.previous.getText(), null);

            default :
                System.out.println(accumulator.previous);
                throw new LzrException("ParseException", "bad expression " + accumulator.current);
        }
    }


    private Statement blockOrStatement(){
        if(match(TokenType.LBRACE)){
            BlockStatement arr = new BlockStatement();
            while (!match(TokenType.RBRACE)){
                arr.add(statement());
            }
            return arr;
        }
        return statement();
    }

    private int line() {
        return accumulator.current.getLine();
    }

    private Token consume(TokenType... types) {
        if (match(types)) {
            return accumulator.previous;
        } else {
            throw new LzrException("ParseException", "unexpected token '" + accumulator.current + "', expected '" + Arrays.toString(types));
        }
    }

    private boolean match(TokenType... types) {
        TokenType current = accumulator.current.getType();
        for (TokenType type : types) {
            if (current == type) {
                advance();
                return true;
            }
        }
        return false;
    }

    private void advance() {
        accumulator.previous = accumulator.current;
        accumulator.current = lexer.tokenize();
    }

}

class ParserAccumulator {
    public Token current, previous;
}