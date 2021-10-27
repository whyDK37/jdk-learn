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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, StringLiteral=19, Identifier=20, DecimalLiteral=21, NEWLINE=22, 
		MUL=23, DIV=24, ADD=25, SUB=26, AND=27, GT=28, GTE=29, LT=30, PARAMETER=31, 
		WS=32, ANY=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "HexDigit", "StringLiteral", "EscapeSequence", "OctalEscape", 
			"UnicodeEscape", "Identifier", "Letter", "JavaIDDigit", "DecimalLiteral", 
			"IntegerTypeSuffix", "NEWLINE", "MUL", "DIV", "ADD", "SUB", "AND", "GT", 
			"GTE", "LT", "PARAMETER", "WS", "ANY"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u0113\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\25\7\25\u00aa\n\25\f\25\16\25\u00ad\13\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\5\26\u00b6\n\26\3\26\3\26\5\26\u00ba\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00c5\n\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u00d1\n\31\f\31\16\31\u00d4\13"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\7\34\u00dd\n\34\f\34\16\34\u00e0"+
		"\13\34\5\34\u00e2\n\34\3\34\5\34\u00e5\n\34\3\35\3\35\3\36\5\36\u00ea"+
		"\n\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%"+
		"\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\6(\u010c\n(\r(\16"+
		"(\u010d\3(\3(\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\25+\2-\2/\2\61\26\63\2"+
		"\65\2\67\279\2;\30=\31?\32A\33C\34E\35G\36I\37K M!O\"Q#\3\2\n\5\2\62;"+
		"CHch\4\2$$^^\7\2ddhhppttvv\4\2))^^\16\2&&C\\aac|\u00c2\u00d8\u00da\u00f8"+
		"\u00fa\u2001\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01"+
		"\21\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71"+
		"\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71"+
		"\u0e52\u0e5b\u0ed2\u0edb\u1042\u104b\4\2NNnn\5\2\13\f\17\17\"\"\2\u011a"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2)\3\2\2\2\2\61\3\2\2\2\2\67\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5Z\3\2\2\2\7_"+
		"\3\2\2\2\ta\3\2\2\2\13f\3\2\2\2\rh\3\2\2\2\17j\3\2\2\2\21o\3\2\2\2\23"+
		"v\3\2\2\2\25~\3\2\2\2\27\u0081\3\2\2\2\31\u0083\3\2\2\2\33\u0086\3\2\2"+
		"\2\35\u0089\3\2\2\2\37\u008c\3\2\2\2!\u0094\3\2\2\2#\u0099\3\2\2\2%\u009e"+
		"\3\2\2\2\'\u00a4\3\2\2\2)\u00a6\3\2\2\2+\u00b9\3\2\2\2-\u00c4\3\2\2\2"+
		"/\u00c6\3\2\2\2\61\u00cd\3\2\2\2\63\u00d5\3\2\2\2\65\u00d7\3\2\2\2\67"+
		"\u00e1\3\2\2\29\u00e6\3\2\2\2;\u00e9\3\2\2\2=\u00ed\3\2\2\2?\u00ef\3\2"+
		"\2\2A\u00f1\3\2\2\2C\u00f3\3\2\2\2E\u00f5\3\2\2\2G\u00f9\3\2\2\2I\u00fb"+
		"\3\2\2\2K\u00fe\3\2\2\2M\u0100\3\2\2\2O\u010b\3\2\2\2Q\u0111\3\2\2\2S"+
		"T\7e\2\2TU\7t\2\2UV\7g\2\2VW\7c\2\2WX\7v\2\2XY\7g\2\2Y\4\3\2\2\2Z[\7y"+
		"\2\2[\\\7k\2\2\\]\7v\2\2]^\7j\2\2^\6\3\2\2\2_`\7.\2\2`\b\3\2\2\2ab\7y"+
		"\2\2bc\7j\2\2cd\7g\2\2de\7p\2\2e\n\3\2\2\2fg\7*\2\2g\f\3\2\2\2hi\7+\2"+
		"\2i\16\3\2\2\2jk\7v\2\2kl\7j\2\2lm\7g\2\2mn\7p\2\2n\20\3\2\2\2op\7t\2"+
		"\2pq\7g\2\2qr\7v\2\2rs\7w\2\2st\7t\2\2tu\7p\2\2u\22\3\2\2\2vw\7o\2\2w"+
		"x\7g\2\2xy\7u\2\2yz\7u\2\2z{\7c\2\2{|\7i\2\2|}\7g\2\2}\24\3\2\2\2~\177"+
		"\7>\2\2\177\u0080\7?\2\2\u0080\26\3\2\2\2\u0081\u0082\7?\2\2\u0082\30"+
		"\3\2\2\2\u0083\u0084\7#\2\2\u0084\u0085\7?\2\2\u0085\32\3\2\2\2\u0086"+
		"\u0087\7?\2\2\u0087\u0088\7?\2\2\u0088\34\3\2\2\2\u0089\u008a\7q\2\2\u008a"+
		"\u008b\7t\2\2\u008b\36\3\2\2\2\u008c\u008d\7G\2\2\u008d\u008e\7Z\2\2\u008e"+
		"\u008f\7G\2\2\u008f\u0090\7E\2\2\u0090\u0091\7W\2\2\u0091\u0092\7V\2\2"+
		"\u0092\u0093\7G\2\2\u0093 \3\2\2\2\u0094\u0095\7p\2\2\u0095\u0096\7w\2"+
		"\2\u0096\u0097\7n\2\2\u0097\u0098\7n\2\2\u0098\"\3\2\2\2\u0099\u009a\7"+
		"v\2\2\u009a\u009b\7t\2\2\u009b\u009c\7w\2\2\u009c\u009d\7g\2\2\u009d$"+
		"\3\2\2\2\u009e\u009f\7h\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7n\2\2\u00a1"+
		"\u00a2\7u\2\2\u00a2\u00a3\7g\2\2\u00a3&\3\2\2\2\u00a4\u00a5\t\2\2\2\u00a5"+
		"(\3\2\2\2\u00a6\u00ab\7$\2\2\u00a7\u00aa\5+\26\2\u00a8\u00aa\n\3\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00af\7$\2\2\u00af*\3\2\2\2\u00b0\u00b5\7^\2\2\u00b1\u00b6\t\4\2\2\u00b2"+
		"\u00b3\7^\2\2\u00b3\u00b6\7$\2\2\u00b4\u00b6\t\5\2\2\u00b5\u00b1\3\2\2"+
		"\2\u00b5\u00b2\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00ba"+
		"\5/\30\2\u00b8\u00ba\5-\27\2\u00b9\u00b0\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba,\3\2\2\2\u00bb\u00bc\7^\2\2\u00bc\u00bd\4\62\65\2"+
		"\u00bd\u00be\4\629\2\u00be\u00c5\4\629\2\u00bf\u00c0\7^\2\2\u00c0\u00c1"+
		"\4\629\2\u00c1\u00c5\4\629\2\u00c2\u00c3\7^\2\2\u00c3\u00c5\4\629\2\u00c4"+
		"\u00bb\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5.\3\2\2\2"+
		"\u00c6\u00c7\7^\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9\5\'\24\2\u00c9\u00ca"+
		"\5\'\24\2\u00ca\u00cb\5\'\24\2\u00cb\u00cc\5\'\24\2\u00cc\60\3\2\2\2\u00cd"+
		"\u00d2\5\63\32\2\u00ce\u00d1\5\63\32\2\u00cf\u00d1\5\65\33\2\u00d0\u00ce"+
		"\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\62\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\t\6\2"+
		"\2\u00d6\64\3\2\2\2\u00d7\u00d8\t\7\2\2\u00d8\66\3\2\2\2\u00d9\u00e2\7"+
		"\62\2\2\u00da\u00de\4\63;\2\u00db\u00dd\4\62;\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00da\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e5\59\35\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e58\3\2\2\2\u00e6\u00e7\t\b\2\2\u00e7:\3\2\2\2\u00e8\u00ea\7\17"+
		"\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\7\f\2\2\u00ec<\3\2\2\2\u00ed\u00ee\7,\2\2\u00ee>\3\2\2\2\u00ef"+
		"\u00f0\7\61\2\2\u00f0@\3\2\2\2\u00f1\u00f2\7-\2\2\u00f2B\3\2\2\2\u00f3"+
		"\u00f4\7/\2\2\u00f4D\3\2\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7p\2\2\u00f7"+
		"\u00f8\7f\2\2\u00f8F\3\2\2\2\u00f9\u00fa\7@\2\2\u00faH\3\2\2\2\u00fb\u00fc"+
		"\7@\2\2\u00fc\u00fd\7?\2\2\u00fdJ\3\2\2\2\u00fe\u00ff\7>\2\2\u00ffL\3"+
		"\2\2\2\u0100\u0101\7R\2\2\u0101\u0102\7C\2\2\u0102\u0103\7T\2\2\u0103"+
		"\u0104\7C\2\2\u0104\u0105\7O\2\2\u0105\u0106\7G\2\2\u0106\u0107\7V\2\2"+
		"\u0107\u0108\7G\2\2\u0108\u0109\7T\2\2\u0109N\3\2\2\2\u010a\u010c\t\t"+
		"\2\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\b(\2\2\u0110P\3\2\2\2\u0111"+
		"\u0112\13\2\2\2\u0112R\3\2\2\2\17\2\u00a9\u00ab\u00b5\u00b9\u00c4\u00d0"+
		"\u00d2\u00de\u00e1\u00e4\u00e9\u010d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}