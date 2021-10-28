// Generated from /Users/why/ws_my/jdk-learn/jdk8/src/main/java/antlr/policy/Policy.g4 by ANTLR 4.9.1
package antlr.policy;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PolicyParser}.
 */
public interface PolicyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PolicyParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(PolicyParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(PolicyParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code create}
	 * labeled alternative in {@link PolicyParser#createDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCreate(PolicyParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code create}
	 * labeled alternative in {@link PolicyParser#createDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCreate(PolicyParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code with}
	 * labeled alternative in {@link PolicyParser#withDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWith(PolicyParser.WithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code with}
	 * labeled alternative in {@link PolicyParser#withDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWith(PolicyParser.WithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code when}
	 * labeled alternative in {@link PolicyParser#whenDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWhen(PolicyParser.WhenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code when}
	 * labeled alternative in {@link PolicyParser#whenDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWhen(PolicyParser.WhenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOpBracket}
	 * labeled alternative in {@link PolicyParser#whenExprDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExprOpBracket(PolicyParser.ExprOpBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOpBracket}
	 * labeled alternative in {@link PolicyParser#whenExprDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExprOpBracket(PolicyParser.ExprOpBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndOr(PolicyParser.AndOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndOr(PolicyParser.AndOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprEquals}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprEquals(PolicyParser.ExprEqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprEquals}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprEquals(PolicyParser.ExprEqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryOp}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryOp(PolicyParser.PrimaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryOp}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryOp(PolicyParser.PrimaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprContain}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprContain(PolicyParser.ExprContainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprContain}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprContain(PolicyParser.ExprContainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIn}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprIn(PolicyParser.ExprInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIn}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprIn(PolicyParser.ExprInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code self}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSelf(PolicyParser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code self}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSelf(PolicyParser.SelfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogic(PolicyParser.ExprLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLogic}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogic(PolicyParser.ExprLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code then}
	 * labeled alternative in {@link PolicyParser#thenDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterThen(PolicyParser.ThenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code then}
	 * labeled alternative in {@link PolicyParser#thenDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitThen(PolicyParser.ThenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thenExpr}
	 * labeled alternative in {@link PolicyParser#thenExprDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterThenExpr(PolicyParser.ThenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thenExpr}
	 * labeled alternative in {@link PolicyParser#thenExprDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitThenExpr(PolicyParser.ThenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyParser#exeUnit}.
	 * @param ctx the parse tree
	 */
	void enterExeUnit(PolicyParser.ExeUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyParser#exeUnit}.
	 * @param ctx the parse tree
	 */
	void exitExeUnit(PolicyParser.ExeUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(PolicyParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(PolicyParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PolicyParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PolicyParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(PolicyParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(PolicyParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(PolicyParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(PolicyParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolicyParser#anytext}.
	 * @param ctx the parse tree
	 */
	void enterAnytext(PolicyParser.AnytextContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyParser#anytext}.
	 * @param ctx the parse tree
	 */
	void exitAnytext(PolicyParser.AnytextContext ctx);
}