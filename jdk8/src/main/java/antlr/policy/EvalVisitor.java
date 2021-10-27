package antlr.policy;

import antlr.policy.PolicyParser.CreateContext;
import antlr.policy.PolicyParser.ThenContext;
import antlr.policy.PolicyParser.ThenExprContext;
import antlr.policy.PolicyParser.WhenContext;
import antlr.policy.PolicyParser.WhenExprContext;
import antlr.policy.PolicyParser.WithContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;


public class EvalVisitor extends PolicyBaseVisitor<String> {

  final Map<String, Integer> params;
  String TRUE = "1";
  String FALSE = "0";
  // 保存计算中的变量
  Map<String, Integer> memory = new HashMap<>();

  public EvalVisitor(Map<String, Integer> params) {
    this.params = params;
  }


  @Override
  public String visitCreate(CreateContext ctx) {
    String id = ctx.Identifier().getText(); // id is left-hand side of '='
    println("create " + id);
    return super.visitCreate(ctx);
  }

  @Override
  public String visitWith(WithContext ctx) {
    List<TerminalNode> id1 = ctx.Identifier();
    print("with ");
    for (TerminalNode terminalNode : id1) {
      print(terminalNode.getText() + ",");
    }
    println("");
    return super.visitWith(ctx);
  }

  @Override
  public String visitWhen(WhenContext ctx) {
    println(ctx.getText());
    return super.visitWhen(ctx);
  }

  @Override
  public String visitWhenExpr(WhenExprContext ctx) {
    println(ctx.getText());
    return super.visitWhenExpr(ctx);
  }


//  @Override
//  public String visitLogicOp(LogicOpContext ctx) {
//    String left = visit(ctx.expression(0)); // get value ofleft subexpression
//    String right = visit(ctx.expression(1)); // get value ofright subexpression
//    if (ctx.op.getType() == PolicyParser.GT) {
//      return TRUE;
//    }
//    return FALSE;
//  }

  @Override
  public String visitThen(ThenContext ctx) {
    println(ctx.getText());
    return super.visitThen(ctx);
  }

  @Override
  public String visitThenExpr(ThenExprContext ctx) {
    println(ctx.getText());
    return super.visitThenExpr(ctx);
  }

  //  @Override
//  public String visitThenMessage(ThenMessageContext ctx) {
//    println(ctx.getText());
//    return super.visitThenMessage(ctx);
//  }

//  @Override
//  public String visitThenReturn(ThenReturnContext ctx) {
//    for (ParseTree child : ctx.children) {
//      print(child.getText() + " ");
//    }
//    println();
//    return super.visitThenReturn(ctx);
//  }

//  @Override
//  public String visitIdentifier(IdentifierContext ctx) {
//    return ctx.getText();
////    return super.visitIdentifier(ctx);
//  }

  //  @Override
//  public String visitLogicOp(LogicOpContext ctx) {
//    String left = visit(ctx.expression(0)); // get value ofleft subexpression
//    String right = visit(ctx.expression(1)); // get value ofright subexpression
//    if (ctx.op.getType() == PolicyParser.GT) {
//      Integer li = params.containsKey(left) ? params.get(left) : Integer.valueOf(left);
//      Integer ri = params.containsKey(right) ? params.get(right) : Integer.valueOf(right);
//      return li > ri ? TRUE : FALSE;
//    }
//    return FALSE; // must be DIV
//  }

//  @Override
//  public String visitPExpression(PExpressionContext ctx) {
//    return super.visitPExpression(ctx);
//  }

//  @Override
//  public String visitDoWhen(DoWhenContext ctx) {
//    return super.visitDoWhen(ctx);
//  }

  private void println(String str) {
    System.out.println("->" + str);
  }

  private void println() {
    System.out.println("->");
  }

  private void print(String str) {
    System.out.print("->" + str);
  }

  private void print() {
    System.out.print("->");
  }
}