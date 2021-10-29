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
		NEQL=32, IN=33, NOT_IN=34, CONTAIN=35, NOT_CONTAIN=36, WS=37, ANY=38;
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
			"NEQL", "IN", "NOT_IN", "CONTAIN", "NOT_CONTAIN", "WS", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'create'", "'with'", "','", "'when'", "'('", "')'", "'and'", "'then'", 
			"'return'", "'message'", "'callBack'", "'EXECUTE'", "'null'", "'true'", 
			"'false'", null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'&&'", 
			"'or'", "'||'", "'>'", "'>='", "'<'", "'<='", "'='", "'!='", "'in'", 
			"'not in'", "'contains'", "'not contains'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "StringLiteral", "Identifier", "DecimalLiteral", 
			"NEWLINE", "MUL", "DIV", "ADD", "SUB", "AND2", "OR", "OR2", "GT", "GTE", 
			"LT", "LTE", "EQL", "NEQL", "IN", "NOT_IN", "CONTAIN", "NOT_CONTAIN", 
			"WS", "ANY"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u013f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\7\22\u00b3\n\22\f\22\16\22\u00b6"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u00bf\n\23\3\23\3\23\5"+
		"\23\u00c3\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00ce"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u00da\n\26"+
		"\f\26\16\26\u00dd\13\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\7\31\u00e6"+
		"\n\31\f\31\16\31\u00e9\13\31\5\31\u00eb\n\31\3\31\5\31\u00ee\n\31\3\32"+
		"\3\32\3\33\5\33\u00f3\n\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'"+
		"\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\6-\u0138\n-\r-\16-\u0139\3"+
		"-\3-\3.\3.\2\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\2#\22%\2\'\2)\2+\23-\2/\2\61\24\63\2\65\25\67\26"+
		"9\27;\30=\31?\32A\33C\34E\35G\36I\37K M!O\"Q#S$U%W&Y\'[(\3\2\n\5\2\62"+
		";CHch\4\2$$^^\7\2ddhhppttvv\4\2))^^\16\2&&C\\aac|\u00c2\u00d8\u00da\u00f8"+
		"\u00fa\u2001\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01"+
		"\21\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71"+
		"\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71"+
		"\u0e52\u0e5b\u0ed2\u0edb\u1042\u104b\4\2NNnn\5\2\13\f\17\17\"\"\2\u0146"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2#\3\2\2\2\2+\3\2"+
		"\2\2\2\61\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5d\3\2\2\2\7i\3\2\2\2\tk\3"+
		"\2\2\2\13p\3\2\2\2\rr\3\2\2\2\17t\3\2\2\2\21x\3\2\2\2\23}\3\2\2\2\25\u0084"+
		"\3\2\2\2\27\u008c\3\2\2\2\31\u0095\3\2\2\2\33\u009d\3\2\2\2\35\u00a2\3"+
		"\2\2\2\37\u00a7\3\2\2\2!\u00ad\3\2\2\2#\u00af\3\2\2\2%\u00c2\3\2\2\2\'"+
		"\u00cd\3\2\2\2)\u00cf\3\2\2\2+\u00d6\3\2\2\2-\u00de\3\2\2\2/\u00e0\3\2"+
		"\2\2\61\u00ea\3\2\2\2\63\u00ef\3\2\2\2\65\u00f2\3\2\2\2\67\u00f6\3\2\2"+
		"\29\u00f8\3\2\2\2;\u00fa\3\2\2\2=\u00fc\3\2\2\2?\u00fe\3\2\2\2A\u0101"+
		"\3\2\2\2C\u0104\3\2\2\2E\u0107\3\2\2\2G\u0109\3\2\2\2I\u010c\3\2\2\2K"+
		"\u010e\3\2\2\2M\u0111\3\2\2\2O\u0113\3\2\2\2Q\u0116\3\2\2\2S\u0119\3\2"+
		"\2\2U\u0120\3\2\2\2W\u0129\3\2\2\2Y\u0137\3\2\2\2[\u013d\3\2\2\2]^\7e"+
		"\2\2^_\7t\2\2_`\7g\2\2`a\7c\2\2ab\7v\2\2bc\7g\2\2c\4\3\2\2\2de\7y\2\2"+
		"ef\7k\2\2fg\7v\2\2gh\7j\2\2h\6\3\2\2\2ij\7.\2\2j\b\3\2\2\2kl\7y\2\2lm"+
		"\7j\2\2mn\7g\2\2no\7p\2\2o\n\3\2\2\2pq\7*\2\2q\f\3\2\2\2rs\7+\2\2s\16"+
		"\3\2\2\2tu\7c\2\2uv\7p\2\2vw\7f\2\2w\20\3\2\2\2xy\7v\2\2yz\7j\2\2z{\7"+
		"g\2\2{|\7p\2\2|\22\3\2\2\2}~\7t\2\2~\177\7g\2\2\177\u0080\7v\2\2\u0080"+
		"\u0081\7w\2\2\u0081\u0082\7t\2\2\u0082\u0083\7p\2\2\u0083\24\3\2\2\2\u0084"+
		"\u0085\7o\2\2\u0085\u0086\7g\2\2\u0086\u0087\7u\2\2\u0087\u0088\7u\2\2"+
		"\u0088\u0089\7c\2\2\u0089\u008a\7i\2\2\u008a\u008b\7g\2\2\u008b\26\3\2"+
		"\2\2\u008c\u008d\7e\2\2\u008d\u008e\7c\2\2\u008e\u008f\7n\2\2\u008f\u0090"+
		"\7n\2\2\u0090\u0091\7D\2\2\u0091\u0092\7c\2\2\u0092\u0093\7e\2\2\u0093"+
		"\u0094\7m\2\2\u0094\30\3\2\2\2\u0095\u0096\7G\2\2\u0096\u0097\7Z\2\2\u0097"+
		"\u0098\7G\2\2\u0098\u0099\7E\2\2\u0099\u009a\7W\2\2\u009a\u009b\7V\2\2"+
		"\u009b\u009c\7G\2\2\u009c\32\3\2\2\2\u009d\u009e\7p\2\2\u009e\u009f\7"+
		"w\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7n\2\2\u00a1\34\3\2\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7w\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\36\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7n\2\2\u00aa"+
		"\u00ab\7u\2\2\u00ab\u00ac\7g\2\2\u00ac \3\2\2\2\u00ad\u00ae\t\2\2\2\u00ae"+
		"\"\3\2\2\2\u00af\u00b4\7$\2\2\u00b0\u00b3\5%\23\2\u00b1\u00b3\n\3\2\2"+
		"\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b8\7$\2\2\u00b8$\3\2\2\2\u00b9\u00be\7^\2\2\u00ba\u00bf\t\4\2\2\u00bb"+
		"\u00bc\7^\2\2\u00bc\u00bf\7$\2\2\u00bd\u00bf\t\5\2\2\u00be\u00ba\3\2\2"+
		"\2\u00be\u00bb\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c3\3\2\2\2\u00c0\u00c3"+
		"\5)\25\2\u00c1\u00c3\5\'\24\2\u00c2\u00b9\3\2\2\2\u00c2\u00c0\3\2\2\2"+
		"\u00c2\u00c1\3\2\2\2\u00c3&\3\2\2\2\u00c4\u00c5\7^\2\2\u00c5\u00c6\4\62"+
		"\65\2\u00c6\u00c7\4\629\2\u00c7\u00ce\4\629\2\u00c8\u00c9\7^\2\2\u00c9"+
		"\u00ca\4\629\2\u00ca\u00ce\4\629\2\u00cb\u00cc\7^\2\2\u00cc\u00ce\4\62"+
		"9\2\u00cd\u00c4\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"(\3\2\2\2\u00cf\u00d0\7^\2\2\u00d0\u00d1\7w\2\2\u00d1\u00d2\5!\21\2\u00d2"+
		"\u00d3\5!\21\2\u00d3\u00d4\5!\21\2\u00d4\u00d5\5!\21\2\u00d5*\3\2\2\2"+
		"\u00d6\u00db\5-\27\2\u00d7\u00da\5-\27\2\u00d8\u00da\5/\30\2\u00d9\u00d7"+
		"\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc,\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\t\6\2\2"+
		"\u00df.\3\2\2\2\u00e0\u00e1\t\7\2\2\u00e1\60\3\2\2\2\u00e2\u00eb\7\62"+
		"\2\2\u00e3\u00e7\4\63;\2\u00e4\u00e6\4\62;\2\u00e5\u00e4\3\2\2\2\u00e6"+
		"\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00e3\3\2\2\2\u00eb"+
		"\u00ed\3\2\2\2\u00ec\u00ee\5\63\32\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3"+
		"\2\2\2\u00ee\62\3\2\2\2\u00ef\u00f0\t\b\2\2\u00f0\64\3\2\2\2\u00f1\u00f3"+
		"\7\17\2\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2"+
		"\u00f4\u00f5\7\f\2\2\u00f5\66\3\2\2\2\u00f6\u00f7\7,\2\2\u00f78\3\2\2"+
		"\2\u00f8\u00f9\7\61\2\2\u00f9:\3\2\2\2\u00fa\u00fb\7-\2\2\u00fb<\3\2\2"+
		"\2\u00fc\u00fd\7/\2\2\u00fd>\3\2\2\2\u00fe\u00ff\7(\2\2\u00ff\u0100\7"+
		"(\2\2\u0100@\3\2\2\2\u0101\u0102\7q\2\2\u0102\u0103\7t\2\2\u0103B\3\2"+
		"\2\2\u0104\u0105\7~\2\2\u0105\u0106\7~\2\2\u0106D\3\2\2\2\u0107\u0108"+
		"\7@\2\2\u0108F\3\2\2\2\u0109\u010a\7@\2\2\u010a\u010b\7?\2\2\u010bH\3"+
		"\2\2\2\u010c\u010d\7>\2\2\u010dJ\3\2\2\2\u010e\u010f\7>\2\2\u010f\u0110"+
		"\7?\2\2\u0110L\3\2\2\2\u0111\u0112\7?\2\2\u0112N\3\2\2\2\u0113\u0114\7"+
		"#\2\2\u0114\u0115\7?\2\2\u0115P\3\2\2\2\u0116\u0117\7k\2\2\u0117\u0118"+
		"\7p\2\2\u0118R\3\2\2\2\u0119\u011a\7p\2\2\u011a\u011b\7q\2\2\u011b\u011c"+
		"\7v\2\2\u011c\u011d\7\"\2\2\u011d\u011e\7k\2\2\u011e\u011f\7p\2\2\u011f"+
		"T\3\2\2\2\u0120\u0121\7e\2\2\u0121\u0122\7q\2\2\u0122\u0123\7p\2\2\u0123"+
		"\u0124\7v\2\2\u0124\u0125\7c\2\2\u0125\u0126\7k\2\2\u0126\u0127\7p\2\2"+
		"\u0127\u0128\7u\2\2\u0128V\3\2\2\2\u0129\u012a\7p\2\2\u012a\u012b\7q\2"+
		"\2\u012b\u012c\7v\2\2\u012c\u012d\7\"\2\2\u012d\u012e\7e\2\2\u012e\u012f"+
		"\7q\2\2\u012f\u0130\7p\2\2\u0130\u0131\7v\2\2\u0131\u0132\7c\2\2\u0132"+
		"\u0133\7k\2\2\u0133\u0134\7p\2\2\u0134\u0135\7u\2\2\u0135X\3\2\2\2\u0136"+
		"\u0138\t\t\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b-\2\2\u013c"+
		"Z\3\2\2\2\u013d\u013e\13\2\2\2\u013e\\\3\2\2\2\17\2\u00b2\u00b4\u00be"+
		"\u00c2\u00cd\u00d9\u00db\u00e7\u00ea\u00ed\u00f2\u0139\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}