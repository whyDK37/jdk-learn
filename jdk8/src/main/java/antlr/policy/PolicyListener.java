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
	 * Enter a parse tree produced by the {@code whenExpr}
	 * labeled alternative in {@link PolicyParser#whenExprDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWhenExpr(PolicyParser.WhenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whenExpr}
	 * labeled alternative in {@link PolicyParser#whenExprDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWhenExpr(PolicyParser.WhenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryProc}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryProc(PolicyParser.PrimaryProcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryProc}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryProc(PolicyParser.PrimaryProcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(PolicyParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(PolicyParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(PolicyParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(PolicyParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOp}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(PolicyParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOp}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(PolicyParser.LogicOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalsOrNot}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualsOrNot(PolicyParser.EqualsOrNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalsOrNot}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualsOrNot(PolicyParser.EqualsOrNotContext ctx);
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
}