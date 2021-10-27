package antlr.labledExpr;//Main.java

import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class LabledExprMain {

  public static void main(String[] args) throws Exception {
    // create a CharStream thatreads from standard input
    String inputFile = "labledExprData.txt";
    InputStream is = System.in;

    if (inputFile != null) {
      is = new FileInputStream(inputFile);
    }
    ANTLRInputStream input = new ANTLRInputStream(is);

    LabeledExprLexer lexer = new LabeledExprLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    LabeledExprParser parser = new LabeledExprParser(tokens);
    ParseTree tree = parser.prog(); // parse
    EvalVisitor eval = new EvalVisitor();
    eval.visit(tree);
  }
}