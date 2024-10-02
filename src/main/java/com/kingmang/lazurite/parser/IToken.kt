package com.kingmang.lazurite.parser

import com.kingmang.lazurite.parser.tokens.TokenType

interface IToken {
    fun getType() : TokenType
    fun getText() : String
    fun getRow() : Int
}