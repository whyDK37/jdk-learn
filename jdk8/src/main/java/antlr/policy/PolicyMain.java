package antlr.policy;//Main.java

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.TestRig;
import org.antlr.v4.runtime.tree.ParseTree;

public class PolicyMain {

  public static void main(String[] args) throws Exception {
    // create a CharStream thatreads from standard input
    HashMap<String, Integer> param = new HashMap<>();
    param.put("bar", 100);
    param.put("foo", 101);
    param.put("var1", 100);
    param.put("var2", 100);
    param.put("var3", 100);
    String inputFile = "PolicyData.txt";
    InputStream is = new FileInputStream(inputFile);
    ANTLRInputStream input = new ANTLRInputStream(is);

    PolicyLexer lexer = new PolicyLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    PolicyParser parser = new PolicyParser(tokens);

    ParseTree tree = parser.compilationUnit(); // parse
    System.out.println(tree.toStringTree());
    EvalVisitor eval = new EvalVisitor(param);
    eval.visit(tree);
  }

}