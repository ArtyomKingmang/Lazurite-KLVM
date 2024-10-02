package com.kingmang.lazurite.runner;

import com.kingmang.lazurite.parser.ast.statements.Statement;
import com.kingmang.lazurite.parser.impl.LexerImplementation;
import com.kingmang.lazurite.parser.impl.ParserImplementation;
import com.kingmang.lazurite.utils.Loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestComp {
    public static void main(String[] args) throws IOException {
        String arg = "test/test.lzr";
        ParserImplementation parser;

        //parser = new ParserImplementation(new LexerImplementation(Loader.readSource(arg)));

        System.out.println(new LexerImplementation(Loader.readSource(arg)).tokenize());
        //Statement ast = parser.parse();
        //String str = ast.compile();
        //System.out.println("\n" + str + "\n" + "HALT");
    }
}
