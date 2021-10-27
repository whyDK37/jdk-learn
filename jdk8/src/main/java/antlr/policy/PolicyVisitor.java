// Generated from /Users/why/ws_my/jdk-learn/jdk8/src/main/java/antlr/policy/Policy.g4 by ANTLR 4.9.1
package antlr.policy;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PolicyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PolicyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PolicyParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(PolicyParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code create}
	 * labeled alternative in {@link PolicyParser#createDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate(PolicyParser.CreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code with}
	 * labeled alternative in {@link PolicyParser#withDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith(PolicyParser.WithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code when}
	 * labeled alternative in {@link PolicyParser#whenDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(PolicyParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whenExpr}
	 * labeled alternative in {@link PolicyParser#whenExprDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenExpr(PolicyParser.WhenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code then}
	 * labeled alternative in {@link PolicyParser#thenDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen(PolicyParser.ThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thenExpr}
	 * labeled alternative in {@link PolicyParser#thenExprDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThenExpr(PolicyParser.ThenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryProc}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryProc(PolicyParser.PrimaryProcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(PolicyParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(PolicyParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicOp}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOp(PolicyParser.LogicOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalsOrNot}
	 * labeled alternative in {@link PolicyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsOrNot(PolicyParser.EqualsOrNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyParser#exeUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExeUnit(PolicyParser.ExeUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(PolicyParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PolicyParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(PolicyParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(PolicyParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolicyParser#anytext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnytext(PolicyParser.AnytextContext ctx);
}