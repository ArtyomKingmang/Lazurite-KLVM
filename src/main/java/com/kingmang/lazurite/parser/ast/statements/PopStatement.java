package com.kingmang.lazurite.parser.ast.statements;

import com.kingmang.lazurite.parser.ast.expressions.Expression;
import com.kingmang.lazurite.parser.ast.statements.Statement;
import com.kingmang.lazurite.patterns.visitor.ResultVisitor;
import com.kingmang.lazurite.patterns.visitor.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PopStatement implements Statement {

    private Expression ast;

    public PopStatement(Expression ast) {
        this.ast = ast;
    }

    @Override
    public String compile() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(ast.compile()).append("\n");
        buffer.append("POP\n");
        return buffer.toString();
    }

    @Override
    public void execute() {

    }

    @Override
    public void accept(@NotNull Visitor visitor) {

    }

    @Nullable
    @Override
    public <R, T> R accept(@NotNull ResultVisitor<R, T> visitor, T input) {
        return null;
    }
}
