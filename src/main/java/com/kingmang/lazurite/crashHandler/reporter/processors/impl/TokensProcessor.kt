package com.kingmang.lazurite.crashHandler.reporter.processors.impl

import com.kingmang.lazurite.parser.tokens.Token
import com.kingmang.lazurite.parser.tokens.TokenType
import com.kingmang.lazurite.crashHandler.reporter.processors.ICrashProcessor

class TokensProcessor (
    private var tokens: List<Token>
) : ICrashProcessor {

    override val name: String
        get() = "tokens"

    override fun proceed(throwable: Throwable): String {
        return """
            Summary: ${tokens.size} tokens
            Tokens: ${tokens.joinToString(", ") { it.toString() }}
            
            TEXT: ${tokens.filter { it.getType() == TokenType.TEXT }.joinToString(", ") { "[${it.getRow()}] \"${it.getText()}\"" }}
            WORD: ${tokens.filter { it.getType() == TokenType.WORD }.joinToString(", ") { "[${it.getRow()}] \"${it.getText()}\"" }}
        """.trimIndent()
    }

}
