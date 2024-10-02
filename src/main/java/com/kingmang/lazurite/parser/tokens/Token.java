package com.kingmang.lazurite.parser.tokens;

import com.kingmang.lazurite.parser.IToken;
import com.kingmang.lazurite.parser.tokens.TokenType;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class Token implements IToken {
    @Setter
    private TokenType type;
    @Setter
    private String text;
    @Getter
    private int line;

    public Token(TokenType type, String text, int line) {
        this.type = type;
        this.text = text;
        this.line = line;
    }

    public Token() {
    }

    @NotNull
    @Override
    public TokenType getType() {
        return type;
    }

    @NotNull
    @Override
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", type, text, line);
    }


    @Override
    public int getRow() {
        return 0;
    }
}