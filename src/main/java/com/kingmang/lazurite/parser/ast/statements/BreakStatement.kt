package com.kingmang.lazurite.parser.ast.statements

import com.kingmang.lazurite.patterns.visitor.ResultVisitor
import com.kingmang.lazurite.patterns.visitor.Visitor

class BreakStatement : RuntimeException(), Statement {
    override fun execute() =
        throw this

    override fun compile(): String {
        return "break impl"
    }
    override fun accept(visitor: Visitor) =
        visitor.visit(this)

    override fun <R, T> accept(visitor: ResultVisitor<R, T>, input: T): R? =
        visitor.visit(this, input)

    override fun toString(): String =
        "break"
}
