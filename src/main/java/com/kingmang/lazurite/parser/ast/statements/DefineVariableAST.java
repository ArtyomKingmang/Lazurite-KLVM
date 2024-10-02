package com.kingmang.lazurite.parser.ast.statements;


import com.kingmang.lazurite.parser.ast.expressions.Expression;
import com.kingmang.lazurite.patterns.visitor.ResultVisitor;
import com.kingmang.lazurite.patterns.visitor.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DefineVariableAST implements Statement {

    private Expression expr;
    private String name;
    private int line;

    public DefineVariableAST(Expression expr, String name, int line) {
        this.expr = expr;
        this.name = name;
        this.line = line;
    }

    @Override
    public String compile() {
        String acc = "";
        acc += expr.compile() + "\n";
        acc += "CREATE_VAR " + name + "\n";
        return acc;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "DefineVariableStmt " + expr + name + line;
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