// Generated from /Users/why/ws_my/jdk-learn/jdk8/src/main/java/antlr/policy/Policy.g4 by ANTLR 4.9.1
package antlr.policy;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PolicyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, StringLiteral=19, Identifier=20, DecimalLiteral=21, NEWLINE=22, 
		MUL=23, DIV=24, ADD=25, SUB=26, AND=27, GT=28, GTE=29, LT=30, PARAMETER=31, 
		WS=32, ANY=33;
	public static final int
		RULE_compilationUnit = 0, RULE_createDeclaration = 1, RULE_withDeclaration = 2, 
		RULE_whenDeclaration = 3, RULE_whenExprDeclaration = 4, RULE_thenDeclaration = 5, 
		RULE_thenExprDeclaration = 6, RULE_expression = 7, RULE_exeUnit = 8, RULE_primary = 9, 
		RULE_literal = 10, RULE_integerLiteral = 11, RULE_booleanLiteral = 12, 
		RULE_anytext = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "createDeclaration", "withDeclaration", "whenDeclaration", 
			"whenExprDeclaration", "thenDeclaration", "thenExprDeclaration", "expression", 
			"exeUnit", "primary", "literal", "integerLiteral", "booleanLiteral", 
			"anytext"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'create'", "'with'", "','", "'when'", "'('", "')'", "'then'", 
			"'return'", "'message'", "'<='", "'='", "'!='", "'=='", "'or'", "'EXECUTE'", 
			"'null'", "'true'", "'false'", null, null, null, null, "'*'", "'/'", 
			"'+'", "'-'", "'and'", "'>'", "'>='", "'<'", "'PARAMETER'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "StringLiteral", "Identifier", 
			"DecimalLiteral", "NEWLINE", "MUL", "DIV", "ADD", "SUB", "AND", "GT", 
			"GTE", "LT", "PARAMETER", "WS", "ANY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Policy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PolicyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public CreateDeclarationContext createDeclaration() {
			return getRuleContext(CreateDeclarationContext.class,0);
		}
		public WithDeclarationContext withDeclaration() {
			return getRuleContext(WithDeclarationContext.class,0);
		}
		public WhenDeclarationContext whenDeclaration() {
			return getRuleContext(WhenDeclarationContext.class,0);
		}
		public ThenDeclarationContext thenDeclaration() {
			return getRuleContext(ThenDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PolicyParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(PolicyParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PolicyParser.NEWLINE, i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			createDeclaration();
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(29);
				match(NEWLINE);
				}
			}

			setState(32);
			withDeclaration();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(33);
				match(NEWLINE);
				}
			}

			setState(36);
			whenDeclaration();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(37);
				match(NEWLINE);
				}
			}

			setState(40);
			thenDeclaration();
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateDeclarationContext extends ParserRuleContext {
		public CreateDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDeclaration; }
	 
		public CreateDeclarationContext() { }
		public void copyFrom(CreateDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreateContext extends CreateDeclarationContext {
		public TerminalNode Identifier() { return getToken(PolicyParser.Identifier, 0); }
		public CreateContext(CreateDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitCreate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateDeclarationContext createDeclaration() throws RecognitionException {
		CreateDeclarationContext _localctx = new CreateDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_createDeclaration);
		try {
			_localctx = new CreateContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			setState(44);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithDeclarationContext extends ParserRuleContext {
		public WithDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withDeclaration; }
	 
		public WithDeclarationContext() { }
		public void copyFrom(WithDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WithContext extends WithDeclarationContext {
		public List<TerminalNode> Identifier() { return getTokens(PolicyParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PolicyParser.Identifier, i);
		}
		public WithContext(WithDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithDeclarationContext withDeclaration() throws RecognitionException {
		WithDeclarationContext _localctx = new WithDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_withDeclaration);
		try {
			_localctx = new WithContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__1);
			setState(47);
			match(Identifier);
			setState(48);
			match(T__2);
			setState(49);
			match(Identifier);
			setState(50);
			match(T__2);
			setState(51);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenDeclarationContext extends ParserRuleContext {
		public WhenDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenDeclaration; }
	 
		public WhenDeclarationContext() { }
		public void copyFrom(WhenDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhenContext extends WhenDeclarationContext {
		public WhenExprDeclarationContext whenExprDeclaration() {
			return getRuleContext(WhenExprDeclarationContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PolicyParser.NEWLINE, 0); }
		public WhenContext(WhenDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenDeclarationContext whenDeclaration() throws RecognitionException {
		WhenDeclarationContext _localctx = new WhenDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whenDeclaration);
		int _la;
		try {
			_localctx = new WhenContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__3);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(54);
				match(NEWLINE);
				}
			}

			setState(57);
			whenExprDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenExprDeclarationContext extends ParserRuleContext {
		public WhenExprDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenExprDeclaration; }
	 
		public WhenExprDeclarationContext() { }
		public void copyFrom(WhenExprDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhenExprContext extends WhenExprDeclarationContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhenExprContext(WhenExprDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterWhenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitWhenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitWhenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenExprDeclarationContext whenExprDeclaration() throws RecognitionException {
		WhenExprDeclarationContext _localctx = new WhenExprDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whenExprDeclaration);
		try {
			_localctx = new WhenExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__4);
			setState(60);
			expression(0);
			setState(61);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThenDeclarationContext extends ParserRuleContext {
		public ThenDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenDeclaration; }
	 
		public ThenDeclarationContext() { }
		public void copyFrom(ThenDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ThenContext extends ThenDeclarationContext {
		public TerminalNode NEWLINE() { return getToken(PolicyParser.NEWLINE, 0); }
		public List<ThenExprDeclarationContext> thenExprDeclaration() {
			return getRuleContexts(ThenExprDeclarationContext.class);
		}
		public ThenExprDeclarationContext thenExprDeclaration(int i) {
			return getRuleContext(ThenExprDeclarationContext.class,i);
		}
		public ThenContext(ThenDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitThen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenDeclarationContext thenDeclaration() throws RecognitionException {
		ThenDeclarationContext _localctx = new ThenDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_thenDeclaration);
		int _la;
		try {
			_localctx = new ThenContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__6);
			setState(64);
			match(NEWLINE);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==T__8) {
				{
				{
				setState(65);
				thenExprDeclaration();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThenExprDeclarationContext extends ParserRuleContext {
		public ThenExprDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenExprDeclaration; }
	 
		public ThenExprDeclarationContext() { }
		public void copyFrom(ThenExprDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ThenExprContext extends ThenExprDeclarationContext {
		public AnytextContext anytext() {
			return getRuleContext(AnytextContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PolicyParser.NEWLINE, 0); }
		public ThenExprContext(ThenExprDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterThenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitThenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitThenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenExprDeclarationContext thenExprDeclaration() throws RecognitionException {
		ThenExprDeclarationContext _localctx = new ThenExprDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_thenExprDeclaration);
		int _la;
		try {
			int _alt;
			_localctx = new ThenExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(71);
					_la = _input.LA(1);
					if ( !(_la==T__7 || _la==T__8) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(74); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(76);
			anytext();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(77);
				match(NEWLINE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimaryProcContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryProcContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterPrimaryProc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitPrimaryProc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitPrimaryProc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PolicyParser.AND, 0); }
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicOpContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GTE() { return getToken(PolicyParser.GTE, 0); }
		public TerminalNode GT() { return getToken(PolicyParser.GT, 0); }
		public TerminalNode LT() { return getToken(PolicyParser.LT, 0); }
		public LogicOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterLogicOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitLogicOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitLogicOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsOrNotContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualsOrNotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterEqualsOrNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitEqualsOrNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitEqualsOrNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new PrimaryProcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(81);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(T__4);
				setState(83);
				expression(0);
				setState(84);
				match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new LogicOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(89);
						((LogicOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << GT) | (1L << GTE) | (1L << LT))) != 0)) ) {
							((LogicOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(90);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new EqualsOrNotContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(92);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__12) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(93);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(95);
						match(AND);
						setState(96);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(98);
						match(T__13);
						setState(99);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExeUnitContext extends ParserRuleContext {
		public AnytextContext anytext() {
			return getRuleContext(AnytextContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PolicyParser.EOF, 0); }
		public ExeUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exeUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExeUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExeUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitExeUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExeUnitContext exeUnit() throws RecognitionException {
		ExeUnitContext _localctx = new ExeUnitContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exeUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__14);
			setState(106);
			anytext();
			setState(107);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PolicyParser.Identifier, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primary);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(T__4);
				setState(110);
				expression(0);
				setState(111);
				match(T__5);
				}
				break;
			case T__15:
			case T__16:
			case T__17:
			case StringLiteral:
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(PolicyParser.StringLiteral, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literal);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DecimalLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				integerLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(StringLiteral);
				}
				break;
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				booleanLiteral();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode DecimalLiteral() { return getToken(PolicyParser.DecimalLiteral, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integerLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(DecimalLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnytextContext extends ParserRuleContext {
		public AnytextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anytext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterAnytext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitAnytext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitAnytext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnytextContext anytext() throws RecognitionException {
		AnytextContext _localctx = new AnytextContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_anytext);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(127);
					matchWildcard();
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0088\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\5\2!\n\2\3\2\3\2\5\2%"+
		"\n\2\3\2\3\2\5\2)\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\5\5:\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7E\n\7\f\7"+
		"\16\7H\13\7\3\b\6\bK\n\b\r\b\16\bL\3\b\3\b\5\bQ\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\tY\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tg\n"+
		"\t\f\t\16\tj\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13v"+
		"\n\13\3\f\3\f\3\f\3\f\5\f|\n\f\3\r\3\r\3\16\3\16\3\17\7\17\u0083\n\17"+
		"\f\17\16\17\u0086\13\17\3\17\3\u0084\3\20\20\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\2\6\3\2\n\13\4\2\f\16\36 \3\2\16\17\3\2\23\24\2\u008b\2\36\3"+
		"\2\2\2\4-\3\2\2\2\6\60\3\2\2\2\b\67\3\2\2\2\n=\3\2\2\2\fA\3\2\2\2\16J"+
		"\3\2\2\2\20X\3\2\2\2\22k\3\2\2\2\24u\3\2\2\2\26{\3\2\2\2\30}\3\2\2\2\32"+
		"\177\3\2\2\2\34\u0084\3\2\2\2\36 \5\4\3\2\37!\7\30\2\2 \37\3\2\2\2 !\3"+
		"\2\2\2!\"\3\2\2\2\"$\5\6\4\2#%\7\30\2\2$#\3\2\2\2$%\3\2\2\2%&\3\2\2\2"+
		"&(\5\b\5\2\')\7\30\2\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\5\f\7\2+,\7\2"+
		"\2\3,\3\3\2\2\2-.\7\3\2\2./\7\26\2\2/\5\3\2\2\2\60\61\7\4\2\2\61\62\7"+
		"\26\2\2\62\63\7\5\2\2\63\64\7\26\2\2\64\65\7\5\2\2\65\66\7\26\2\2\66\7"+
		"\3\2\2\2\679\7\6\2\28:\7\30\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\5\n\6"+
		"\2<\t\3\2\2\2=>\7\7\2\2>?\5\20\t\2?@\7\b\2\2@\13\3\2\2\2AB\7\t\2\2BF\7"+
		"\30\2\2CE\5\16\b\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\r\3\2\2\2"+
		"HF\3\2\2\2IK\t\2\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2"+
		"NP\5\34\17\2OQ\7\30\2\2PO\3\2\2\2PQ\3\2\2\2Q\17\3\2\2\2RS\b\t\1\2SY\5"+
		"\24\13\2TU\7\7\2\2UV\5\20\t\2VW\7\b\2\2WY\3\2\2\2XR\3\2\2\2XT\3\2\2\2"+
		"Yh\3\2\2\2Z[\f\7\2\2[\\\t\3\2\2\\g\5\20\t\b]^\f\6\2\2^_\t\4\2\2_g\5\20"+
		"\t\7`a\f\5\2\2ab\7\35\2\2bg\5\20\t\6cd\f\4\2\2de\7\20\2\2eg\5\20\t\5f"+
		"Z\3\2\2\2f]\3\2\2\2f`\3\2\2\2fc\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2"+
		"i\21\3\2\2\2jh\3\2\2\2kl\7\21\2\2lm\5\34\17\2mn\7\2\2\3n\23\3\2\2\2op"+
		"\7\7\2\2pq\5\20\t\2qr\7\b\2\2rv\3\2\2\2sv\5\26\f\2tv\7\26\2\2uo\3\2\2"+
		"\2us\3\2\2\2ut\3\2\2\2v\25\3\2\2\2w|\5\30\r\2x|\7\25\2\2y|\5\32\16\2z"+
		"|\7\22\2\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|\27\3\2\2\2}~\7\27"+
		"\2\2~\31\3\2\2\2\177\u0080\t\5\2\2\u0080\33\3\2\2\2\u0081\u0083\13\2\2"+
		"\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0085\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0085\35\3\2\2\2\u0086\u0084\3\2\2\2\17 $(9FLPXfhu{\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}