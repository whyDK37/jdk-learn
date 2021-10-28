package antlr;

import org.antlr.v4.gui.TestRig;
import org.junit.jupiter.api.Test;

/**
 * <pre>
 *   java org.antlr.v4.gui.TestRig GrammarName startRuleName
 *   [-tokens] [-tree] [-gui] [-ps file.ps] [-encoding encodingname]
 *   [-trace] [-diagnostics] [-SLL]
 *   [input-filename(s)]
 *  Use startRuleName='tokens' if GrammarName is a lexer grammar.
 *  Omitting input-filename makes rig read from stdin.
 * </pre>
 */
public class PolicyTest {

  public static void main(String[] args) throws Exception {
//    String[] arg = {"antlr.labledExpr.LabeledExpr", "prog","-gui","/Users/why/ws_my/jdk-learn/labledExprData.txt"};

    String[] arg = {"antlr.policy.Policy", "compilationUnit","-gui","/Users/why/ws_my/jdk-learn/PolicyData.txt"};
//    String[] arg = {"antlr.policy.Policy", "whenExprDeclaration","-gui","/Users/why/ws_my/jdk-learn/PolicyWhenDec.txt"};
    TestRig.main(arg);

    if( 1>= 0){

    }
  }

}
