// Generated from c:/Users/Diego Debroy/Desktop/Proyecto1/api/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, Types=47, INT=48, BOOL=49, FLOAT=50, STRING=51, RUNE=52, WS=53, 
		ID=54, COMMENT=55, ML_COMMENT=56;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "Types", "INT", "BOOL", 
			"FLOAT", "STRING", "RUNE", "ESC", "WS", "ID", "COMMENT", "ML_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'func'", "'('", "')'", "'{'", "'}'", 
			"'class'", "','", "'fmt.Println('", "'if'", "'else'", "'while'", "'for'", 
			"'switch'", "'case'", "':'", "'default'", "'break'", "'continue'", "'return'", 
			"'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'+='", "'-='", "'>'", "'<'", 
			"'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'strconv.Atoi('", "'strconv.ParseFloat('", 
			"'reflect.TypeOf('", "'new'", "'['", "']'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "Types", 
			"INT", "BOOL", "FLOAT", "STRING", "RUNE", "WS", "ID", "COMMENT", "ML_COMMENT"
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

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
		"\u0004\u00008\u01b1\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!"+
		"\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001"+
		"*\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0003.\u015b\b.\u0001/\u0004/\u015e\b/\u000b/\f/\u015f"+
		"\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u0003"+
		"0\u016b\b0\u00011\u00041\u016e\b1\u000b1\f1\u016f\u00011\u00011\u0004"+
		"1\u0174\b1\u000b1\f1\u0175\u00012\u00012\u00012\u00052\u017b\b2\n2\f2"+
		"\u017e\t2\u00012\u00012\u00013\u00013\u00013\u00013\u00033\u0186\b3\u0001"+
		"3\u00013\u00014\u00014\u00014\u00015\u00045\u018e\b5\u000b5\f5\u018f\u0001"+
		"5\u00015\u00016\u00046\u0195\b6\u000b6\f6\u0196\u00017\u00017\u00017\u0001"+
		"7\u00057\u019d\b7\n7\f7\u01a0\t7\u00017\u00017\u00018\u00018\u00018\u0001"+
		"8\u00058\u01a8\b8\n8\f8\u01ab\t8\u00018\u00018\u00018\u00018\u00018\u0001"+
		"\u01a9\u00009\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i\u0000k5m6o7q8\u0001\u0000"+
		"\u0007\u0001\u000009\u0002\u0000\"\"\\\\\u0002\u0000\'\'\\\\\u0006\u0000"+
		"\"\"\'\'\\\\nnrrtt\u0003\u0000\t\n\r\r  \u0002\u0000AZaz\u0002\u0000\n"+
		"\n\r\r\u01be\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001"+
		"\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000"+
		"\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000"+
		"]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001"+
		"\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000"+
		"\u0000\u0000g\u0001\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000"+
		"m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001"+
		"\u0000\u0000\u0000\u0001s\u0001\u0000\u0000\u0000\u0003w\u0001\u0000\u0000"+
		"\u0000\u0005y\u0001\u0000\u0000\u0000\u0007{\u0001\u0000\u0000\u0000\t"+
		"~\u0001\u0000\u0000\u0000\u000b\u0083\u0001\u0000\u0000\u0000\r\u0085"+
		"\u0001\u0000\u0000\u0000\u000f\u0087\u0001\u0000\u0000\u0000\u0011\u0089"+
		"\u0001\u0000\u0000\u0000\u0013\u008b\u0001\u0000\u0000\u0000\u0015\u0091"+
		"\u0001\u0000\u0000\u0000\u0017\u0093\u0001\u0000\u0000\u0000\u0019\u00a0"+
		"\u0001\u0000\u0000\u0000\u001b\u00a3\u0001\u0000\u0000\u0000\u001d\u00a8"+
		"\u0001\u0000\u0000\u0000\u001f\u00ae\u0001\u0000\u0000\u0000!\u00b2\u0001"+
		"\u0000\u0000\u0000#\u00b9\u0001\u0000\u0000\u0000%\u00be\u0001\u0000\u0000"+
		"\u0000\'\u00c0\u0001\u0000\u0000\u0000)\u00c8\u0001\u0000\u0000\u0000"+
		"+\u00ce\u0001\u0000\u0000\u0000-\u00d7\u0001\u0000\u0000\u0000/\u00de"+
		"\u0001\u0000\u0000\u00001\u00e0\u0001\u0000\u0000\u00003\u00e2\u0001\u0000"+
		"\u0000\u00005\u00e4\u0001\u0000\u0000\u00007\u00e6\u0001\u0000\u0000\u0000"+
		"9\u00e8\u0001\u0000\u0000\u0000;\u00ea\u0001\u0000\u0000\u0000=\u00ed"+
		"\u0001\u0000\u0000\u0000?\u00f0\u0001\u0000\u0000\u0000A\u00f2\u0001\u0000"+
		"\u0000\u0000C\u00f4\u0001\u0000\u0000\u0000E\u00f7\u0001\u0000\u0000\u0000"+
		"G\u00fa\u0001\u0000\u0000\u0000I\u00fd\u0001\u0000\u0000\u0000K\u0100"+
		"\u0001\u0000\u0000\u0000M\u0103\u0001\u0000\u0000\u0000O\u0106\u0001\u0000"+
		"\u0000\u0000Q\u0114\u0001\u0000\u0000\u0000S\u0128\u0001\u0000\u0000\u0000"+
		"U\u0138\u0001\u0000\u0000\u0000W\u013c\u0001\u0000\u0000\u0000Y\u013e"+
		"\u0001\u0000\u0000\u0000[\u0140\u0001\u0000\u0000\u0000]\u015a\u0001\u0000"+
		"\u0000\u0000_\u015d\u0001\u0000\u0000\u0000a\u016a\u0001\u0000\u0000\u0000"+
		"c\u016d\u0001\u0000\u0000\u0000e\u0177\u0001\u0000\u0000\u0000g\u0181"+
		"\u0001\u0000\u0000\u0000i\u0189\u0001\u0000\u0000\u0000k\u018d\u0001\u0000"+
		"\u0000\u0000m\u0194\u0001\u0000\u0000\u0000o\u0198\u0001\u0000\u0000\u0000"+
		"q\u01a3\u0001\u0000\u0000\u0000st\u0005v\u0000\u0000tu\u0005a\u0000\u0000"+
		"uv\u0005r\u0000\u0000v\u0002\u0001\u0000\u0000\u0000wx\u0005=\u0000\u0000"+
		"x\u0004\u0001\u0000\u0000\u0000yz\u0005;\u0000\u0000z\u0006\u0001\u0000"+
		"\u0000\u0000{|\u0005:\u0000\u0000|}\u0005=\u0000\u0000}\b\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005f\u0000\u0000\u007f\u0080\u0005u\u0000\u0000"+
		"\u0080\u0081\u0005n\u0000\u0000\u0081\u0082\u0005c\u0000\u0000\u0082\n"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005(\u0000\u0000\u0084\f\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005)\u0000\u0000\u0086\u000e\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005{\u0000\u0000\u0088\u0010\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005}\u0000\u0000\u008a\u0012\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0005c\u0000\u0000\u008c\u008d\u0005l\u0000\u0000\u008d\u008e"+
		"\u0005a\u0000\u0000\u008e\u008f\u0005s\u0000\u0000\u008f\u0090\u0005s"+
		"\u0000\u0000\u0090\u0014\u0001\u0000\u0000\u0000\u0091\u0092\u0005,\u0000"+
		"\u0000\u0092\u0016\u0001\u0000\u0000\u0000\u0093\u0094\u0005f\u0000\u0000"+
		"\u0094\u0095\u0005m\u0000\u0000\u0095\u0096\u0005t\u0000\u0000\u0096\u0097"+
		"\u0005.\u0000\u0000\u0097\u0098\u0005P\u0000\u0000\u0098\u0099\u0005r"+
		"\u0000\u0000\u0099\u009a\u0005i\u0000\u0000\u009a\u009b\u0005n\u0000\u0000"+
		"\u009b\u009c\u0005t\u0000\u0000\u009c\u009d\u0005l\u0000\u0000\u009d\u009e"+
		"\u0005n\u0000\u0000\u009e\u009f\u0005(\u0000\u0000\u009f\u0018\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0005i\u0000\u0000\u00a1\u00a2\u0005f\u0000\u0000"+
		"\u00a2\u001a\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005e\u0000\u0000\u00a4"+
		"\u00a5\u0005l\u0000\u0000\u00a5\u00a6\u0005s\u0000\u0000\u00a6\u00a7\u0005"+
		"e\u0000\u0000\u00a7\u001c\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005w\u0000"+
		"\u0000\u00a9\u00aa\u0005h\u0000\u0000\u00aa\u00ab\u0005i\u0000\u0000\u00ab"+
		"\u00ac\u0005l\u0000\u0000\u00ac\u00ad\u0005e\u0000\u0000\u00ad\u001e\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0005f\u0000\u0000\u00af\u00b0\u0005o\u0000"+
		"\u0000\u00b0\u00b1\u0005r\u0000\u0000\u00b1 \u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005s\u0000\u0000\u00b3\u00b4\u0005w\u0000\u0000\u00b4\u00b5\u0005"+
		"i\u0000\u0000\u00b5\u00b6\u0005t\u0000\u0000\u00b6\u00b7\u0005c\u0000"+
		"\u0000\u00b7\u00b8\u0005h\u0000\u0000\u00b8\"\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0005c\u0000\u0000\u00ba\u00bb\u0005a\u0000\u0000\u00bb\u00bc"+
		"\u0005s\u0000\u0000\u00bc\u00bd\u0005e\u0000\u0000\u00bd$\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0005:\u0000\u0000\u00bf&\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0005d\u0000\u0000\u00c1\u00c2\u0005e\u0000\u0000\u00c2\u00c3"+
		"\u0005f\u0000\u0000\u00c3\u00c4\u0005a\u0000\u0000\u00c4\u00c5\u0005u"+
		"\u0000\u0000\u00c5\u00c6\u0005l\u0000\u0000\u00c6\u00c7\u0005t\u0000\u0000"+
		"\u00c7(\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005b\u0000\u0000\u00c9\u00ca"+
		"\u0005r\u0000\u0000\u00ca\u00cb\u0005e\u0000\u0000\u00cb\u00cc\u0005a"+
		"\u0000\u0000\u00cc\u00cd\u0005k\u0000\u0000\u00cd*\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0005c\u0000\u0000\u00cf\u00d0\u0005o\u0000\u0000\u00d0\u00d1"+
		"\u0005n\u0000\u0000\u00d1\u00d2\u0005t\u0000\u0000\u00d2\u00d3\u0005i"+
		"\u0000\u0000\u00d3\u00d4\u0005n\u0000\u0000\u00d4\u00d5\u0005u\u0000\u0000"+
		"\u00d5\u00d6\u0005e\u0000\u0000\u00d6,\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0005r\u0000\u0000\u00d8\u00d9\u0005e\u0000\u0000\u00d9\u00da\u0005t"+
		"\u0000\u0000\u00da\u00db\u0005u\u0000\u0000\u00db\u00dc\u0005r\u0000\u0000"+
		"\u00dc\u00dd\u0005n\u0000\u0000\u00dd.\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0005-\u0000\u0000\u00df0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005!"+
		"\u0000\u0000\u00e12\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005*\u0000\u0000"+
		"\u00e34\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005/\u0000\u0000\u00e56"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005%\u0000\u0000\u00e78\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0005+\u0000\u0000\u00e9:\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0005+\u0000\u0000\u00eb\u00ec\u0005=\u0000\u0000\u00ec<"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005-\u0000\u0000\u00ee\u00ef\u0005"+
		"=\u0000\u0000\u00ef>\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005>\u0000"+
		"\u0000\u00f1@\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005<\u0000\u0000\u00f3"+
		"B\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005>\u0000\u0000\u00f5\u00f6\u0005"+
		"=\u0000\u0000\u00f6D\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005<\u0000"+
		"\u0000\u00f8\u00f9\u0005=\u0000\u0000\u00f9F\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0005=\u0000\u0000\u00fb\u00fc\u0005=\u0000\u0000\u00fcH\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0005!\u0000\u0000\u00fe\u00ff\u0005=\u0000"+
		"\u0000\u00ffJ\u0001\u0000\u0000\u0000\u0100\u0101\u0005&\u0000\u0000\u0101"+
		"\u0102\u0005&\u0000\u0000\u0102L\u0001\u0000\u0000\u0000\u0103\u0104\u0005"+
		"|\u0000\u0000\u0104\u0105\u0005|\u0000\u0000\u0105N\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0005s\u0000\u0000\u0107\u0108\u0005t\u0000\u0000\u0108"+
		"\u0109\u0005r\u0000\u0000\u0109\u010a\u0005c\u0000\u0000\u010a\u010b\u0005"+
		"o\u0000\u0000\u010b\u010c\u0005n\u0000\u0000\u010c\u010d\u0005v\u0000"+
		"\u0000\u010d\u010e\u0005.\u0000\u0000\u010e\u010f\u0005A\u0000\u0000\u010f"+
		"\u0110\u0005t\u0000\u0000\u0110\u0111\u0005o\u0000\u0000\u0111\u0112\u0005"+
		"i\u0000\u0000\u0112\u0113\u0005(\u0000\u0000\u0113P\u0001\u0000\u0000"+
		"\u0000\u0114\u0115\u0005s\u0000\u0000\u0115\u0116\u0005t\u0000\u0000\u0116"+
		"\u0117\u0005r\u0000\u0000\u0117\u0118\u0005c\u0000\u0000\u0118\u0119\u0005"+
		"o\u0000\u0000\u0119\u011a\u0005n\u0000\u0000\u011a\u011b\u0005v\u0000"+
		"\u0000\u011b\u011c\u0005.\u0000\u0000\u011c\u011d\u0005P\u0000\u0000\u011d"+
		"\u011e\u0005a\u0000\u0000\u011e\u011f\u0005r\u0000\u0000\u011f\u0120\u0005"+
		"s\u0000\u0000\u0120\u0121\u0005e\u0000\u0000\u0121\u0122\u0005F\u0000"+
		"\u0000\u0122\u0123\u0005l\u0000\u0000\u0123\u0124\u0005o\u0000\u0000\u0124"+
		"\u0125\u0005a\u0000\u0000\u0125\u0126\u0005t\u0000\u0000\u0126\u0127\u0005"+
		"(\u0000\u0000\u0127R\u0001\u0000\u0000\u0000\u0128\u0129\u0005r\u0000"+
		"\u0000\u0129\u012a\u0005e\u0000\u0000\u012a\u012b\u0005f\u0000\u0000\u012b"+
		"\u012c\u0005l\u0000\u0000\u012c\u012d\u0005e\u0000\u0000\u012d\u012e\u0005"+
		"c\u0000\u0000\u012e\u012f\u0005t\u0000\u0000\u012f\u0130\u0005.\u0000"+
		"\u0000\u0130\u0131\u0005T\u0000\u0000\u0131\u0132\u0005y\u0000\u0000\u0132"+
		"\u0133\u0005p\u0000\u0000\u0133\u0134\u0005e\u0000\u0000\u0134\u0135\u0005"+
		"O\u0000\u0000\u0135\u0136\u0005f\u0000\u0000\u0136\u0137\u0005(\u0000"+
		"\u0000\u0137T\u0001\u0000\u0000\u0000\u0138\u0139\u0005n\u0000\u0000\u0139"+
		"\u013a\u0005e\u0000\u0000\u013a\u013b\u0005w\u0000\u0000\u013bV\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0005[\u0000\u0000\u013dX\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\u0005]\u0000\u0000\u013fZ\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0005.\u0000\u0000\u0141\\\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0005i\u0000\u0000\u0143\u0144\u0005n\u0000\u0000\u0144\u015b\u0005t"+
		"\u0000\u0000\u0145\u0146\u0005f\u0000\u0000\u0146\u0147\u0005l\u0000\u0000"+
		"\u0147\u0148\u0005o\u0000\u0000\u0148\u0149\u0005a\u0000\u0000\u0149\u014a"+
		"\u0005t\u0000\u0000\u014a\u014b\u00056\u0000\u0000\u014b\u015b\u00054"+
		"\u0000\u0000\u014c\u014d\u0005s\u0000\u0000\u014d\u014e\u0005t\u0000\u0000"+
		"\u014e\u014f\u0005r\u0000\u0000\u014f\u0150\u0005i\u0000\u0000\u0150\u0151"+
		"\u0005n\u0000\u0000\u0151\u015b\u0005g\u0000\u0000\u0152\u0153\u0005b"+
		"\u0000\u0000\u0153\u0154\u0005o\u0000\u0000\u0154\u0155\u0005o\u0000\u0000"+
		"\u0155\u015b\u0005l\u0000\u0000\u0156\u0157\u0005r\u0000\u0000\u0157\u0158"+
		"\u0005u\u0000\u0000\u0158\u0159\u0005n\u0000\u0000\u0159\u015b\u0005e"+
		"\u0000\u0000\u015a\u0142\u0001\u0000\u0000\u0000\u015a\u0145\u0001\u0000"+
		"\u0000\u0000\u015a\u014c\u0001\u0000\u0000\u0000\u015a\u0152\u0001\u0000"+
		"\u0000\u0000\u015a\u0156\u0001\u0000\u0000\u0000\u015b^\u0001\u0000\u0000"+
		"\u0000\u015c\u015e\u0007\u0000\u0000\u0000\u015d\u015c\u0001\u0000\u0000"+
		"\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000"+
		"\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160`\u0001\u0000\u0000\u0000"+
		"\u0161\u0162\u0005t\u0000\u0000\u0162\u0163\u0005r\u0000\u0000\u0163\u0164"+
		"\u0005u\u0000\u0000\u0164\u016b\u0005e\u0000\u0000\u0165\u0166\u0005f"+
		"\u0000\u0000\u0166\u0167\u0005a\u0000\u0000\u0167\u0168\u0005l\u0000\u0000"+
		"\u0168\u0169\u0005s\u0000\u0000\u0169\u016b\u0005e\u0000\u0000\u016a\u0161"+
		"\u0001\u0000\u0000\u0000\u016a\u0165\u0001\u0000\u0000\u0000\u016bb\u0001"+
		"\u0000\u0000\u0000\u016c\u016e\u0007\u0000\u0000\u0000\u016d\u016c\u0001"+
		"\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u016d\u0001"+
		"\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0171\u0001"+
		"\u0000\u0000\u0000\u0171\u0173\u0005.\u0000\u0000\u0172\u0174\u0007\u0000"+
		"\u0000\u0000\u0173\u0172\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000"+
		"\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000"+
		"\u0000\u0000\u0176d\u0001\u0000\u0000\u0000\u0177\u017c\u0005\"\u0000"+
		"\u0000\u0178\u017b\u0003i4\u0000\u0179\u017b\b\u0001\u0000\u0000\u017a"+
		"\u0178\u0001\u0000\u0000\u0000\u017a\u0179\u0001\u0000\u0000\u0000\u017b"+
		"\u017e\u0001\u0000\u0000\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017c"+
		"\u017d\u0001\u0000\u0000\u0000\u017d\u017f\u0001\u0000\u0000\u0000\u017e"+
		"\u017c\u0001\u0000\u0000\u0000\u017f\u0180\u0005\"\u0000\u0000\u0180f"+
		"\u0001\u0000\u0000\u0000\u0181\u0185\u0005\'\u0000\u0000\u0182\u0186\b"+
		"\u0002\u0000\u0000\u0183\u0184\u0005\\\u0000\u0000\u0184\u0186\t\u0000"+
		"\u0000\u0000\u0185\u0182\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000"+
		"\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0188\u0005\'\u0000"+
		"\u0000\u0188h\u0001\u0000\u0000\u0000\u0189\u018a\u0005\\\u0000\u0000"+
		"\u018a\u018b\u0007\u0003\u0000\u0000\u018bj\u0001\u0000\u0000\u0000\u018c"+
		"\u018e\u0007\u0004\u0000\u0000\u018d\u018c\u0001\u0000\u0000\u0000\u018e"+
		"\u018f\u0001\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f"+
		"\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191"+
		"\u0192\u00065\u0000\u0000\u0192l\u0001\u0000\u0000\u0000\u0193\u0195\u0007"+
		"\u0005\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0195\u0196\u0001"+
		"\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0196\u0197\u0001"+
		"\u0000\u0000\u0000\u0197n\u0001\u0000\u0000\u0000\u0198\u0199\u0005/\u0000"+
		"\u0000\u0199\u019a\u0005/\u0000\u0000\u019a\u019e\u0001\u0000\u0000\u0000"+
		"\u019b\u019d\b\u0006\u0000\u0000\u019c\u019b\u0001\u0000\u0000\u0000\u019d"+
		"\u01a0\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019e"+
		"\u019f\u0001\u0000\u0000\u0000\u019f\u01a1\u0001\u0000\u0000\u0000\u01a0"+
		"\u019e\u0001\u0000\u0000\u0000\u01a1\u01a2\u00067\u0000\u0000\u01a2p\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a4\u0005/\u0000\u0000\u01a4\u01a5\u0005*\u0000"+
		"\u0000\u01a5\u01a9\u0001\u0000\u0000\u0000\u01a6\u01a8\t\u0000\u0000\u0000"+
		"\u01a7\u01a6\u0001\u0000\u0000\u0000\u01a8\u01ab\u0001\u0000\u0000\u0000"+
		"\u01a9\u01aa\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ad\u0005*\u0000\u0000\u01ad\u01ae\u0005/\u0000\u0000\u01ae\u01af"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u00068\u0000\u0000\u01b0r\u0001\u0000"+
		"\u0000\u0000\r\u0000\u015a\u015f\u016a\u016f\u0175\u017a\u017c\u0185\u018f"+
		"\u0196\u019e\u01a9\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}