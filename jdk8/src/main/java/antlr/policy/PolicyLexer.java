// Generated from /Users/why/ws_my/jdk-learn/jdk8/src/main/java/antlr/policy/Policy.g4 by ANTLR 4.9.1
package antlr.policy;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PolicyLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "HexDigit", "StringLiteral", 
			"EscapeSequence", "OctalEscape", "UnicodeEscape", "Identifier", "Letter", 
			"JavaIDDigit", "DecimalLiteral", "IntegerTypeSuffix", "NEWLINE", "MUL", 
			"DIV", "ADD", "SUB", "AND2", "OR", "OR2", "GT", "GTE", "LT", "LTE", "EQL", 
			"NEQL", "IN", "NOT_IN", "CONTAIN", "NOT_CONTAIN", "PARAMETER", "WS", 
			"ANY"
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


	  protected boolean enumIsKeyword = true;
	  protected boolean assertIsKeyword = true;


	public PolicyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Policy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u014b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\7\22\u00b5\n\22\f\22\16\22\u00b8"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u00c1\n\23\3\23\3\23\5"+
		"\23\u00c5\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d0"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u00dc\n\26"+
		"\f\26\16\26\u00df\13\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\7\31\u00e8"+
		"\n\31\f\31\16\31\u00eb\13\31\5\31\u00ed\n\31\3\31\5\31\u00f0\n\31\3\32"+
		"\3\32\3\33\5\33\u00f5\n\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'"+
		"\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3.\6.\u0144\n.\r.\16.\u0145\3.\3.\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\2#\22%\2\'\2)"+
		"\2+\23-\2/\2\61\24\63\2\65\25\67\269\27;\30=\31?\32A\33C\34E\35G\36I\37"+
		"K M!O\"Q#S$U%W&Y\'[(])\3\2\n\5\2\62;CHch\4\2$$^^\7\2ddhhppttvv\4\2))^"+
		"^\16\2&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa\u2001\u3042\u3191\u3302"+
		"\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21\2\62;\u0662\u066b\u06f2"+
		"\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9"+
		"\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u1042"+
		"\u104b\4\2NNnn\5\2\13\f\17\17\"\"\2\u0152\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2#\3\2\2\2\2+\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\3_\3\2\2\2\5f\3\2\2\2\7k\3\2\2\2\tm\3\2\2\2\13r\3\2\2"+
		"\2\rt\3\2\2\2\17v\3\2\2\2\21z\3\2\2\2\23\177\3\2\2\2\25\u0086\3\2\2\2"+
		"\27\u008e\3\2\2\2\31\u0097\3\2\2\2\33\u009f\3\2\2\2\35\u00a4\3\2\2\2\37"+
		"\u00a9\3\2\2\2!\u00af\3\2\2\2#\u00b1\3\2\2\2%\u00c4\3\2\2\2\'\u00cf\3"+
		"\2\2\2)\u00d1\3\2\2\2+\u00d8\3\2\2\2-\u00e0\3\2\2\2/\u00e2\3\2\2\2\61"+
		"\u00ec\3\2\2\2\63\u00f1\3\2\2\2\65\u00f4\3\2\2\2\67\u00f8\3\2\2\29\u00fa"+
		"\3\2\2\2;\u00fc\3\2\2\2=\u00fe\3\2\2\2?\u0100\3\2\2\2A\u0103\3\2\2\2C"+
		"\u0106\3\2\2\2E\u0109\3\2\2\2G\u010b\3\2\2\2I\u010e\3\2\2\2K\u0110\3\2"+
		"\2\2M\u0113\3\2\2\2O\u0115\3\2\2\2Q\u0118\3\2\2\2S\u011b\3\2\2\2U\u0122"+
		"\3\2\2\2W\u012b\3\2\2\2Y\u0138\3\2\2\2[\u0143\3\2\2\2]\u0149\3\2\2\2_"+
		"`\7e\2\2`a\7t\2\2ab\7g\2\2bc\7c\2\2cd\7v\2\2de\7g\2\2e\4\3\2\2\2fg\7y"+
		"\2\2gh\7k\2\2hi\7v\2\2ij\7j\2\2j\6\3\2\2\2kl\7.\2\2l\b\3\2\2\2mn\7y\2"+
		"\2no\7j\2\2op\7g\2\2pq\7p\2\2q\n\3\2\2\2rs\7*\2\2s\f\3\2\2\2tu\7+\2\2"+
		"u\16\3\2\2\2vw\7c\2\2wx\7p\2\2xy\7f\2\2y\20\3\2\2\2z{\7v\2\2{|\7j\2\2"+
		"|}\7g\2\2}~\7p\2\2~\22\3\2\2\2\177\u0080\7t\2\2\u0080\u0081\7g\2\2\u0081"+
		"\u0082\7v\2\2\u0082\u0083\7w\2\2\u0083\u0084\7t\2\2\u0084\u0085\7p\2\2"+
		"\u0085\24\3\2\2\2\u0086\u0087\7o\2\2\u0087\u0088\7g\2\2\u0088\u0089\7"+
		"u\2\2\u0089\u008a\7u\2\2\u008a\u008b\7c\2\2\u008b\u008c\7i\2\2\u008c\u008d"+
		"\7g\2\2\u008d\26\3\2\2\2\u008e\u008f\7e\2\2\u008f\u0090\7c\2\2\u0090\u0091"+
		"\7n\2\2\u0091\u0092\7n\2\2\u0092\u0093\7D\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7e\2\2\u0095\u0096\7m\2\2\u0096\30\3\2\2\2\u0097\u0098\7G\2\2\u0098"+
		"\u0099\7Z\2\2\u0099\u009a\7G\2\2\u009a\u009b\7E\2\2\u009b\u009c\7W\2\2"+
		"\u009c\u009d\7V\2\2\u009d\u009e\7G\2\2\u009e\32\3\2\2\2\u009f\u00a0\7"+
		"p\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7n\2\2\u00a3\34"+
		"\3\2\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7w\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\36\3\2\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7c\2\2\u00ab"+
		"\u00ac\7n\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7g\2\2\u00ae \3\2\2\2\u00af"+
		"\u00b0\t\2\2\2\u00b0\"\3\2\2\2\u00b1\u00b6\7$\2\2\u00b2\u00b5\5%\23\2"+
		"\u00b3\u00b5\n\3\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00ba\7$\2\2\u00ba$\3\2\2\2\u00bb\u00c0\7^\2\2\u00bc"+
		"\u00c1\t\4\2\2\u00bd\u00be\7^\2\2\u00be\u00c1\7$\2\2\u00bf\u00c1\t\5\2"+
		"\2\u00c0\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c5"+
		"\3\2\2\2\u00c2\u00c5\5)\25\2\u00c3\u00c5\5\'\24\2\u00c4\u00bb\3\2\2\2"+
		"\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7"+
		"^\2\2\u00c7\u00c8\4\62\65\2\u00c8\u00c9\4\629\2\u00c9\u00d0\4\629\2\u00ca"+
		"\u00cb\7^\2\2\u00cb\u00cc\4\629\2\u00cc\u00d0\4\629\2\u00cd\u00ce\7^\2"+
		"\2\u00ce\u00d0\4\629\2\u00cf\u00c6\3\2\2\2\u00cf\u00ca\3\2\2\2\u00cf\u00cd"+
		"\3\2\2\2\u00d0(\3\2\2\2\u00d1\u00d2\7^\2\2\u00d2\u00d3\7w\2\2\u00d3\u00d4"+
		"\5!\21\2\u00d4\u00d5\5!\21\2\u00d5\u00d6\5!\21\2\u00d6\u00d7\5!\21\2\u00d7"+
		"*\3\2\2\2\u00d8\u00dd\5-\27\2\u00d9\u00dc\5-\27\2\u00da\u00dc\5/\30\2"+
		"\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de,\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e1\t\6\2\2\u00e1.\3\2\2\2\u00e2\u00e3\t\7\2\2\u00e3\60\3\2\2\2\u00e4"+
		"\u00ed\7\62\2\2\u00e5\u00e9\4\63;\2\u00e6\u00e8\4\62;\2\u00e7\u00e6\3"+
		"\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec\u00e5\3\2"+
		"\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00f0\5\63\32\2\u00ef\u00ee\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\62\3\2\2\2\u00f1\u00f2\t\b\2\2\u00f2\64\3\2\2\2\u00f3"+
		"\u00f5\7\17\2\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3"+
		"\2\2\2\u00f6\u00f7\7\f\2\2\u00f7\66\3\2\2\2\u00f8\u00f9\7,\2\2\u00f98"+
		"\3\2\2\2\u00fa\u00fb\7\61\2\2\u00fb:\3\2\2\2\u00fc\u00fd\7-\2\2\u00fd"+
		"<\3\2\2\2\u00fe\u00ff\7/\2\2\u00ff>\3\2\2\2\u0100\u0101\7(\2\2\u0101\u0102"+
		"\7(\2\2\u0102@\3\2\2\2\u0103\u0104\7q\2\2\u0104\u0105\7t\2\2\u0105B\3"+
		"\2\2\2\u0106\u0107\7~\2\2\u0107\u0108\7~\2\2\u0108D\3\2\2\2\u0109\u010a"+
		"\7@\2\2\u010aF\3\2\2\2\u010b\u010c\7@\2\2\u010c\u010d\7?\2\2\u010dH\3"+
		"\2\2\2\u010e\u010f\7>\2\2\u010fJ\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112"+
		"\7?\2\2\u0112L\3\2\2\2\u0113\u0114\7?\2\2\u0114N\3\2\2\2\u0115\u0116\7"+
		"#\2\2\u0116\u0117\7?\2\2\u0117P\3\2\2\2\u0118\u0119\7k\2\2\u0119\u011a"+
		"\7p\2\2\u011aR\3\2\2\2\u011b\u011c\7p\2\2\u011c\u011d\7q\2\2\u011d\u011e"+
		"\7v\2\2\u011e\u011f\7\"\2\2\u011f\u0120\7k\2\2\u0120\u0121\7p\2\2\u0121"+
		"T\3\2\2\2\u0122\u0123\7e\2\2\u0123\u0124\7q\2\2\u0124\u0125\7p\2\2\u0125"+
		"\u0126\7v\2\2\u0126\u0127\7c\2\2\u0127\u0128\7k\2\2\u0128\u0129\7p\2\2"+
		"\u0129\u012a\7u\2\2\u012aV\3\2\2\2\u012b\u012c\7p\2\2\u012c\u012d\7q\2"+
		"\2\u012d\u012e\7v\2\2\u012e\u012f\7\"\2\2\u012f\u0130\7e\2\2\u0130\u0131"+
		"\7q\2\2\u0131\u0132\7p\2\2\u0132\u0133\7v\2\2\u0133\u0134\7c\2\2\u0134"+
		"\u0135\7k\2\2\u0135\u0136\7p\2\2\u0136\u0137\7u\2\2\u0137X\3\2\2\2\u0138"+
		"\u0139\7R\2\2\u0139\u013a\7C\2\2\u013a\u013b\7T\2\2\u013b\u013c\7C\2\2"+
		"\u013c\u013d\7O\2\2\u013d\u013e\7G\2\2\u013e\u013f\7V\2\2\u013f\u0140"+
		"\7G\2\2\u0140\u0141\7T\2\2\u0141Z\3\2\2\2\u0142\u0144\t\t\2\2\u0143\u0142"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0148\b.\2\2\u0148\\\3\2\2\2\u0149\u014a\13\2\2\2"+
		"\u014a^\3\2\2\2\17\2\u00b4\u00b6\u00c0\u00c4\u00cf\u00db\u00dd\u00e9\u00ec"+
		"\u00ef\u00f4\u0145\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}