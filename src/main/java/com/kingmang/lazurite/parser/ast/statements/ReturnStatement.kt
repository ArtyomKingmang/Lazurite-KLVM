package com.kingmang.lazurite.parser.ast.statements

import com.kingmang.lazurite.parser.ast.expressions.Expression
import com.kingmang.lazurite.patterns.visitor.ResultVisitor
import com.kingmang.lazurite.patterns.visitor.Visitor
import com.kingmang.lazurite.runtime.values.LzrValue

data class ReturnStatement(val expression: Expression) : RuntimeException(), Statement {
    var result: LzrValue? = null
        private set

    override fun execute() {
        this.result = this.expression.eval()
        throw this
    }

    override fun compile(): String {
        return "return impl"
    }

    override fun accept(visitor: Visitor) =
        visitor.visit(this)

    override fun <R, T> accept(visitor: ResultVisitor<R, T>, input: T): R? =
        visitor.visit(this, input)

    override fun toString(): String =
        "return ${this.expression}"
}
