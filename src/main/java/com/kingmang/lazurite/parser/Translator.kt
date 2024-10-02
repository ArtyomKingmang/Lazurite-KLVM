package com.kingmang.lazurite.parser

object Translator {
    fun getRepresentation(constant: Any): String {
        return if (constant is String) {
            "\"" + constant.toString() + "\""
        } else {
            constant.toString()
        }
    }
}