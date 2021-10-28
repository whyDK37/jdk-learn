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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, StringLiteral=16, 
		Identifier=17, DecimalLiteral=18, NEWLINE=19, MUL=20, DIV=21, ADD=22, 
		SUB=23, AND2=24, OR=25, OR2=26, GT=27, GTE=28, LT=29, LTE=30, EQL=31, 
		NEQL=32, IN=33, NOT_IN=34, CONTAIN=35, NOT_CONTAIN=36, PARAMETER=37, WS=38, 
		ANY=39;
	public static final int
		RULE_compilationUnit = 0, RULE_createDeclaration = 1, RULE_withDeclaration = 2, 
		RULE_whenDeclaration = 3, RULE_whenExprDeclaration = 4, RULE_expression = 5, 
		RULE_thenDeclaration = 6, RULE_thenExprDeclaration = 7, RULE_exeUnit = 8, 
		RULE_primary = 9, RULE_literal = 10, RULE_integerLiteral = 11, RULE_booleanLiteral = 12, 
		RULE_anytext = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "createDeclaration", "withDeclaration", "whenDeclaration", 
			"whenExprDeclaration", "expression", "thenDeclaration", "thenExprDeclaration", 
			"exeUnit", "primary", "literal", "integerLiteral", "booleanLiteral", 
			"anytext"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'create'", "'with'", "','", "'when'", "'('", "')'", "'and'", "'then'", 
			"'return'", "'message'", "'callBack'", "'EXECUTE'", "'null'", "'true'", 
			"'false'", null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'&&'", 
			"'or'", "'||'", "'>'", "'>='", "'<'", "'<='", "'='", "'!='", "'in'", 
			"'not in'", "'contains'", "'not contains'", "'PARAMETER'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "StringLiteral", "Identifier", "DecimalLiteral", 
			"NEWLINE", "MUL", "DIV", "ADD", "SUB", "AND2", "OR", "OR2", "GT", "GTE", 
			"LT", "LTE", "EQL", "NEQL", "IN", "NOT_IN", "CONTAIN", "NOT_CONTAIN", 
			"PARAMETER", "WS", "ANY"
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
	public static class ExprOpBracketContext extends WhenExprDeclarationContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprOpBracketContext(WhenExprDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExprOpBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExprOpBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitExprOpBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenExprDeclarationContext whenExprDeclaration() throws RecognitionException {
		WhenExprDeclarationContext _localctx = new WhenExprDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whenExprDeclaration);
		try {
			_localctx = new ExprOpBracketContext(_localctx);
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
	public static class AndOrContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(PolicyParser.OR, 0); }
		public TerminalNode AND2() { return getToken(PolicyParser.AND2, 0); }
		public TerminalNode OR2() { return getToken(PolicyParser.OR2, 0); }
		public AndOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterAndOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitAndOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitAndOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprEqualsContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQL() { return getToken(PolicyParser.EQL, 0); }
		public TerminalNode NEQL() { return getToken(PolicyParser.NEQL, 0); }
		public ExprEqualsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExprEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExprEquals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitExprEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryOpContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterPrimaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitPrimaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitPrimaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprContainContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CONTAIN() { return getToken(PolicyParser.CONTAIN, 0); }
		public TerminalNode NOT_CONTAIN() { return getToken(PolicyParser.NOT_CONTAIN, 0); }
		public ExprContainContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExprContain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExprContain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitExprContain(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprInContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IN() { return getToken(PolicyParser.IN, 0); }
		public TerminalNode NOT_IN() { return getToken(PolicyParser.NOT_IN, 0); }
		public ExprInContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExprIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExprIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitExprIn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SelfContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitSelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitSelf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLogicContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LTE() { return getToken(PolicyParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(PolicyParser.GTE, 0); }
		public TerminalNode GT() { return getToken(PolicyParser.GT, 0); }
		public TerminalNode LT() { return getToken(PolicyParser.LT, 0); }
		public ExprLogicContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExprLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExprLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyVisitor ) return ((PolicyVisitor<? extends T>)visitor).visitExprLogic(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
			case T__14:
			case StringLiteral:
			case Identifier:
			case DecimalLiteral:
				{
				_localctx = new PrimaryOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(64);
				primary();
				}
				break;
			case T__4:
				{
				_localctx = new SelfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(T__4);
				setState(66);
				expression(0);
				setState(67);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(89);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprLogicContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(71);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(72);
						((ExprLogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
							((ExprLogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(73);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprEqualsContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(74);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(75);
						((ExprEqualsContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQL || _la==NEQL) ) {
							((ExprEqualsContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(76);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new AndOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(77);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(78);
						((AndOrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==OR) ) {
							((AndOrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new AndOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(81);
						((AndOrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND2 || _la==OR2) ) {
							((AndOrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(82);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprContainContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(83);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(84);
						((ExprContainContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==CONTAIN || _la==NOT_CONTAIN) ) {
							((ExprContainContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(85);
						expression(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprInContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(87);
						((ExprInContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IN || _la==NOT_IN) ) {
							((ExprInContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		enterRule(_localctx, 12, RULE_thenDeclaration);
		int _la;
		try {
			_localctx = new ThenContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__7);
			setState(95);
			match(NEWLINE);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) {
				{
				{
				setState(96);
				thenExprDeclaration();
				}
				}
				setState(101);
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
		enterRule(_localctx, 14, RULE_thenExprDeclaration);
		int _la;
		try {
			int _alt;
			_localctx = new ThenExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(103); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(102);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
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
				setState(105); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(107);
			anytext();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(108);
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
			setState(111);
			match(T__11);
			setState(112);
			anytext();
			setState(113);
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
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
			case T__14:
			case StringLiteral:
			case DecimalLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
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
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DecimalLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				integerLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(StringLiteral);
				}
				break;
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				booleanLiteral();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(T__12);
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
			setState(125);
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
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
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
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(129);
					matchWildcard();
					}
					} 
				}
				setState(134);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u008a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\5\2!\n\2\3\2\3\2\5\2%"+
		"\n\2\3\2\3\2\5\2)\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\5\5:\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7H\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b\3\b\3\b\7\bd\n\b\f\b\16\bg\13"+
		"\b\3\t\6\tj\n\t\r\t\16\tk\3\t\3\t\5\tp\n\t\3\n\3\n\3\n\3\n\3\13\3\13\5"+
		"\13x\n\13\3\f\3\f\3\f\3\f\5\f~\n\f\3\r\3\r\3\16\3\16\3\17\7\17\u0085\n"+
		"\17\f\17\16\17\u0088\13\17\3\17\3\u0086\3\f\20\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\2\n\3\2\35 \3\2!\"\4\2\t\t\33\33\4\2\32\32\34\34\3\2%&\3"+
		"\2#$\3\2\13\r\3\2\20\21\2\u008e\2\36\3\2\2\2\4-\3\2\2\2\6\60\3\2\2\2\b"+
		"\67\3\2\2\2\n=\3\2\2\2\fG\3\2\2\2\16`\3\2\2\2\20i\3\2\2\2\22q\3\2\2\2"+
		"\24w\3\2\2\2\26}\3\2\2\2\30\177\3\2\2\2\32\u0081\3\2\2\2\34\u0086\3\2"+
		"\2\2\36 \5\4\3\2\37!\7\25\2\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"$\5\6"+
		"\4\2#%\7\25\2\2$#\3\2\2\2$%\3\2\2\2%&\3\2\2\2&(\5\b\5\2\')\7\25\2\2(\'"+
		"\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\5\16\b\2+,\7\2\2\3,\3\3\2\2\2-.\7\3\2\2"+
		"./\7\23\2\2/\5\3\2\2\2\60\61\7\4\2\2\61\62\7\23\2\2\62\63\7\5\2\2\63\64"+
		"\7\23\2\2\64\65\7\5\2\2\65\66\7\23\2\2\66\7\3\2\2\2\679\7\6\2\28:\7\25"+
		"\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\5\n\6\2<\t\3\2\2\2=>\7\7\2\2>?\5"+
		"\f\7\2?@\7\b\2\2@\13\3\2\2\2AB\b\7\1\2BH\5\24\13\2CD\7\7\2\2DE\5\f\7\2"+
		"EF\7\b\2\2FH\3\2\2\2GA\3\2\2\2GC\3\2\2\2H]\3\2\2\2IJ\f\b\2\2JK\t\2\2\2"+
		"K\\\5\f\7\tLM\f\7\2\2MN\t\3\2\2N\\\5\f\7\bOP\f\6\2\2PQ\t\4\2\2Q\\\5\f"+
		"\7\7RS\f\5\2\2ST\t\5\2\2T\\\5\f\7\6UV\f\4\2\2VW\t\6\2\2W\\\5\f\7\5XY\f"+
		"\3\2\2YZ\t\7\2\2Z\\\5\f\7\4[I\3\2\2\2[L\3\2\2\2[O\3\2\2\2[R\3\2\2\2[U"+
		"\3\2\2\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\r\3\2\2\2_]\3\2\2\2"+
		"`a\7\n\2\2ae\7\25\2\2bd\5\20\t\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2"+
		"\2f\17\3\2\2\2ge\3\2\2\2hj\t\b\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2"+
		"\2\2lm\3\2\2\2mo\5\34\17\2np\7\25\2\2on\3\2\2\2op\3\2\2\2p\21\3\2\2\2"+
		"qr\7\16\2\2rs\5\34\17\2st\7\2\2\3t\23\3\2\2\2ux\5\26\f\2vx\7\23\2\2wu"+
		"\3\2\2\2wv\3\2\2\2x\25\3\2\2\2y~\5\30\r\2z~\7\22\2\2{~\5\32\16\2|~\7\17"+
		"\2\2}y\3\2\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\27\3\2\2\2\177\u0080\7\24"+
		"\2\2\u0080\31\3\2\2\2\u0081\u0082\t\t\2\2\u0082\33\3\2\2\2\u0083\u0085"+
		"\13\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0087\3\2\2\2"+
		"\u0086\u0084\3\2\2\2\u0087\35\3\2\2\2\u0088\u0086\3\2\2\2\17 $(9G[]ek"+
		"ow}\u0086";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}