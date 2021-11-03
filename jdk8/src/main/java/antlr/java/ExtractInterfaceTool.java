package antlr.java;
/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ExtractInterfaceTool {

  public static void main(/*args*/String[] args) throws Exception {
    String inputFile = null;
      if (args.length > 0) {
          inputFile = args[0];
      }
    InputStream is = System.in;
    if (inputFile != null) {
      is = new FileInputStream(inputFile);
    }
    ANTLRInputStream input = new ANTLRInputStream(is);

    JavaLexer lexer = new JavaLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);
    ParseTree tree = parser.compilationUnit(); // parse

    ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker

    // 抽取接口
    ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
    walker.walk(extractor, tree); // initiate walk of tree with listener

    // 增加 serialVersionUID
    InsertSerialIDListener interfaceListener = new InsertSerialIDListener(tokens);
    walker.walk(interfaceListener, tree); // initiate walk of tree with listener
    System.out.println(interfaceListener.rewriter.getText());
  }
}
