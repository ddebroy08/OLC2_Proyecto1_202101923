// Generated from c:/Users/Diego Debroy/Desktop/Proyecto1/api/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_shortVarDcl = 3, 
		RULE_funcDcl = 4, RULE_classDcl = 5, RULE_classBody = 6, RULE_params = 7, 
		RULE_stmt = 8, RULE_forInit = 9, RULE_expr = 10, RULE_call = 11, RULE_args = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "shortVarDcl", "funcDcl", "classDcl", "classBody", 
			"params", "stmt", "forInit", "expr", "call", "args"
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

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26774207714538850L) != 0)) {
				{
				{
				setState(26);
				dcl();
				}
				}
				setState(31);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DclContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ShortVarDclContext shortVarDcl() {
			return getRuleContext(ShortVarDclContext.class,0);
		}
		public ClassDclContext classDcl() {
			return getRuleContext(ClassDclContext.class,0);
		}
		public FuncDclContext funcDcl() {
			return getRuleContext(FuncDclContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				shortVarDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				classDcl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				funcDcl();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode Types() { return getToken(LanguageParser.Types, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(40);
			match(ID);
			setState(41);
			match(Types);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(42);
				match(T__1);
				setState(43);
				expr(0);
				}
			}

			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(46);
				match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ShortVarDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ShortVarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortVarDcl; }
	}

	public final ShortVarDclContext shortVarDcl() throws RecognitionException {
		ShortVarDclContext _localctx = new ShortVarDclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_shortVarDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(ID);
			setState(50);
			match(T__3);
			setState(51);
			expr(0);
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(52);
				match(T__2);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public FuncDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDcl; }
	}

	public final FuncDclContext funcDcl() throws RecognitionException {
		FuncDclContext _localctx = new FuncDclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__4);
			setState(56);
			match(ID);
			setState(57);
			match(T__5);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(58);
				params();
				}
			}

			setState(61);
			match(T__6);
			setState(62);
			match(T__7);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26774207714538850L) != 0)) {
				{
				{
				setState(63);
				dcl();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ClassBodyContext> classBody() {
			return getRuleContexts(ClassBodyContext.class);
		}
		public ClassBodyContext classBody(int i) {
			return getRuleContext(ClassBodyContext.class,i);
		}
		public ClassDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDcl; }
	}

	public final ClassDclContext classDcl() throws RecognitionException {
		ClassDclContext _localctx = new ClassDclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__9);
			setState(72);
			match(ID);
			setState(73);
			match(T__7);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398509482018L) != 0)) {
				{
				{
				setState(74);
				classBody();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public ShortVarDclContext shortVarDcl() {
			return getRuleContext(ShortVarDclContext.class,0);
		}
		public FuncDclContext funcDcl() {
			return getRuleContext(FuncDclContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBody);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				varDcl();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				shortVarDcl();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				funcDcl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(ID);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(88);
				match(T__10);
				setState(89);
				match(ID);
				}
				}
				setState(94);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SwitchStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends StmtContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends StmtContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtIniContext extends StmtContext {
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForStmtIniContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public CaseStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends StmtContext {
		public ContinueStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultStmtContext extends StmtContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public DefaultStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends StmtContext {
		public BreakStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				expr(0);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(96);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(T__11);
				setState(100);
				expr(0);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(101);
					match(T__10);
					setState(102);
					expr(0);
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(108);
				match(T__6);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(109);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(T__7);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26774207714538850L) != 0)) {
					{
					{
					setState(113);
					dcl();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(T__12);
				setState(121);
				match(T__5);
				setState(122);
				expr(0);
				setState(123);
				match(T__6);
				setState(124);
				stmt();
				setState(127);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(125);
					match(T__13);
					setState(126);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				match(T__14);
				setState(130);
				match(T__5);
				setState(131);
				expr(0);
				setState(132);
				match(T__6);
				setState(133);
				stmt();
				}
				break;
			case 6:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(135);
				match(T__15);
				setState(136);
				expr(0);
				setState(137);
				stmt();
				}
				break;
			case 7:
				_localctx = new ForStmtIniContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(139);
				match(T__15);
				setState(140);
				forInit();
				setState(141);
				match(T__2);
				setState(142);
				expr(0);
				setState(143);
				match(T__2);
				setState(144);
				expr(0);
				setState(145);
				stmt();
				}
				break;
			case 8:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(147);
				match(T__16);
				setState(148);
				expr(0);
				setState(149);
				match(T__7);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26774207714537792L) != 0)) {
					{
					{
					setState(150);
					stmt();
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(156);
				match(T__8);
				}
				break;
			case 9:
				_localctx = new CaseStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(158);
				match(T__17);
				setState(159);
				expr(0);
				setState(160);
				match(T__18);
				setState(161);
				stmt();
				}
				break;
			case 10:
				_localctx = new DefaultStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(163);
				match(T__19);
				setState(164);
				match(T__18);
				setState(165);
				stmt();
				}
				break;
			case 11:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(166);
				match(T__20);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(167);
					match(T__2);
					}
				}

				}
				break;
			case 12:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(170);
				match(T__21);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(171);
					match(T__2);
					}
				}

				}
				break;
			case 13:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(174);
				match(T__22);
				setState(176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(175);
					expr(0);
					}
					break;
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(178);
					match(T__2);
					}
				}

				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public ShortVarDclContext shortVarDcl() {
			return getRuleContext(ShortVarDclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forInit);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				shortVarDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				expr(0);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualitysContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualitysContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NewContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeOfStmtContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeOfStmtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtoiStmtContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtoiStmtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParseFloatStmtContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParseFloatStmtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketsContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BracketsContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CalleContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public CalleContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubAssignContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AddSubAssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuneContext extends ExprContext {
		public TerminalNode RUNE() { return getToken(LanguageParser.RUNE, 0); }
		public RuneContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(188);
				match(T__23);
				setState(189);
				expr(22);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(T__24);
				setState(191);
				expr(21);
				}
				break;
			case 3:
				{
				_localctx = new AddSubAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(ID);
				setState(193);
				((AddSubAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
					((AddSubAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(194);
				expr(17);
				}
				break;
			case 4:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(ID);
				setState(196);
				match(T__1);
				setState(197);
				expr(13);
				}
				break;
			case 5:
				{
				_localctx = new AtoiStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(T__39);
				setState(199);
				expr(0);
				setState(200);
				match(T__6);
				setState(202);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(201);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new ParseFloatStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(T__40);
				setState(205);
				expr(0);
				setState(206);
				match(T__6);
				setState(208);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(207);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new TypeOfStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(T__41);
				setState(211);
				expr(0);
				setState(212);
				match(T__6);
				setState(214);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(213);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(BOOL);
				}
				break;
			case 9:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(FLOAT);
				}
				break;
			case 10:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(INT);
				}
				break;
			case 12:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(RUNE);
				}
				break;
			case 13:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(T__42);
				setState(222);
				match(ID);
				setState(223);
				match(T__5);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26774207698305088L) != 0)) {
					{
					setState(224);
					args();
					}
				}

				setState(227);
				match(T__6);
				}
				break;
			case 14:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(ID);
				}
				break;
			case 15:
				{
				_localctx = new BracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(T__43);
				setState(230);
				expr(0);
				setState(231);
				match(T__44);
				setState(233);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(232);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 16:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				match(T__5);
				setState(236);
				expr(0);
				setState(237);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(262);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(242);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469762048L) != 0)) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(243);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(245);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__28) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(248);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						expr(17);
						}
						break;
					case 4:
						{
						_localctx = new EqualitysContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(251);
						((EqualitysContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__36) ) {
							((EqualitysContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(252);
						expr(16);
						}
						break;
					case 5:
						{
						_localctx = new LogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(254);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__37 || _la==T__38) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						expr(15);
						}
						break;
					case 6:
						{
						_localctx = new CalleContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(258); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(257);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(260); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	 
		public CallContext() { }
		public void copyFrom(CallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends CallContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FuncCallContext(CallContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetContext extends CallContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public GetContext(CallContext ctx) { copyFrom(ctx); }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_call);
		int _la;
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(T__5);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26774207698305088L) != 0)) {
					{
					setState(268);
					args();
					}
				}

				setState(271);
				match(T__6);
				}
				break;
			case T__45:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(T__45);
				setState(273);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			expr(0);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(277);
				match(T__10);
				setState(278);
				expr(0);
				}
				}
				setState(283);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u011d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000\u001f"+
		"\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002-\b\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00036\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004<\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004A\b\u0004\n\u0004\f\u0004D\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005L\b\u0005\n\u0005\f\u0005O\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006V\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007[\b\u0007\n\u0007\f\u0007^\t\u0007"+
		"\u0001\b\u0001\b\u0003\bb\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b"+
		"h\b\b\n\b\f\bk\t\b\u0001\b\u0001\b\u0003\bo\b\b\u0001\b\u0001\b\u0005"+
		"\bs\b\b\n\b\f\bv\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u0080\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0098"+
		"\b\b\n\b\f\b\u009b\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a9\b\b\u0001"+
		"\b\u0001\b\u0003\b\u00ad\b\b\u0001\b\u0001\b\u0003\b\u00b1\b\b\u0001\b"+
		"\u0003\b\u00b4\b\b\u0003\b\u00b6\b\b\u0001\t\u0001\t\u0003\t\u00ba\b\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00cb\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u00d1\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00d7\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00e2\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00ea\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00f0"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004"+
		"\n\u0103\b\n\u000b\n\f\n\u0104\u0005\n\u0107\b\n\n\n\f\n\u010a\t\n\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u010e\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u0113\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0118"+
		"\b\f\n\f\f\f\u011b\t\f\u0001\f\u0000\u0001\u0014\r\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0006\u0001\u0000\u001e"+
		"\u001f\u0001\u0000\u001a\u001c\u0002\u0000\u0018\u0018\u001d\u001d\u0001"+
		"\u0000 #\u0001\u0000$%\u0001\u0000&\'\u0152\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0002%\u0001\u0000\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000"+
		"\u00061\u0001\u0000\u0000\u0000\b7\u0001\u0000\u0000\u0000\nG\u0001\u0000"+
		"\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000eW\u0001\u0000\u0000\u0000"+
		"\u0010\u00b5\u0001\u0000\u0000\u0000\u0012\u00b9\u0001\u0000\u0000\u0000"+
		"\u0014\u00ef\u0001\u0000\u0000\u0000\u0016\u0112\u0001\u0000\u0000\u0000"+
		"\u0018\u0114\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000"+
		"\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000"+
		"\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000"+
		"\u001e\u0001\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000"+
		" &\u0003\u0004\u0002\u0000!&\u0003\u0010\b\u0000\"&\u0003\u0006\u0003"+
		"\u0000#&\u0003\n\u0005\u0000$&\u0003\b\u0004\u0000% \u0001\u0000\u0000"+
		"\u0000%!\u0001\u0000\u0000\u0000%\"\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000\u0000"+
		"\'(\u0005\u0001\u0000\u0000()\u00056\u0000\u0000),\u0005/\u0000\u0000"+
		"*+\u0005\u0002\u0000\u0000+-\u0003\u0014\n\u0000,*\u0001\u0000\u0000\u0000"+
		",-\u0001\u0000\u0000\u0000-/\u0001\u0000\u0000\u0000.0\u0005\u0003\u0000"+
		"\u0000/.\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\u0005\u0001"+
		"\u0000\u0000\u000012\u00056\u0000\u000023\u0005\u0004\u0000\u000035\u0003"+
		"\u0014\n\u000046\u0005\u0003\u0000\u000054\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u00006\u0007\u0001\u0000\u0000\u000078\u0005\u0005\u0000"+
		"\u000089\u00056\u0000\u00009;\u0005\u0006\u0000\u0000:<\u0003\u000e\u0007"+
		"\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=>\u0005\u0007\u0000\u0000>B\u0005\b\u0000\u0000?A\u0003\u0002"+
		"\u0001\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000EF\u0005\t\u0000\u0000F\t\u0001\u0000\u0000"+
		"\u0000GH\u0005\n\u0000\u0000HI\u00056\u0000\u0000IM\u0005\b\u0000\u0000"+
		"JL\u0003\f\u0006\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000PQ\u0005\t\u0000\u0000Q\u000b\u0001\u0000"+
		"\u0000\u0000RV\u0003\u0004\u0002\u0000SV\u0003\u0006\u0003\u0000TV\u0003"+
		"\b\u0004\u0000UR\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001"+
		"\u0000\u0000\u0000V\r\u0001\u0000\u0000\u0000W\\\u00056\u0000\u0000XY"+
		"\u0005\u000b\u0000\u0000Y[\u00056\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000"+
		"\u0000]\u000f\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_a\u0003"+
		"\u0014\n\u0000`b\u0005\u0003\u0000\u0000a`\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000b\u00b6\u0001\u0000\u0000\u0000cd\u0005\f\u0000\u0000"+
		"di\u0003\u0014\n\u0000ef\u0005\u000b\u0000\u0000fh\u0003\u0014\n\u0000"+
		"ge\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000"+
		"\u0000\u0000ln\u0005\u0007\u0000\u0000mo\u0005\u0003\u0000\u0000nm\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u00b6\u0001\u0000\u0000"+
		"\u0000pt\u0005\b\u0000\u0000qs\u0003\u0002\u0001\u0000rq\u0001\u0000\u0000"+
		"\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000"+
		"\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000w\u00b6"+
		"\u0005\t\u0000\u0000xy\u0005\r\u0000\u0000yz\u0005\u0006\u0000\u0000z"+
		"{\u0003\u0014\n\u0000{|\u0005\u0007\u0000\u0000|\u007f\u0003\u0010\b\u0000"+
		"}~\u0005\u000e\u0000\u0000~\u0080\u0003\u0010\b\u0000\u007f}\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u00b6\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005\u000f\u0000\u0000\u0082\u0083\u0005\u0006"+
		"\u0000\u0000\u0083\u0084\u0003\u0014\n\u0000\u0084\u0085\u0005\u0007\u0000"+
		"\u0000\u0085\u0086\u0003\u0010\b\u0000\u0086\u00b6\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005\u0010\u0000\u0000\u0088\u0089\u0003\u0014\n\u0000\u0089"+
		"\u008a\u0003\u0010\b\u0000\u008a\u00b6\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0005\u0010\u0000\u0000\u008c\u008d\u0003\u0012\t\u0000\u008d\u008e\u0005"+
		"\u0003\u0000\u0000\u008e\u008f\u0003\u0014\n\u0000\u008f\u0090\u0005\u0003"+
		"\u0000\u0000\u0090\u0091\u0003\u0014\n\u0000\u0091\u0092\u0003\u0010\b"+
		"\u0000\u0092\u00b6\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0011\u0000"+
		"\u0000\u0094\u0095\u0003\u0014\n\u0000\u0095\u0099\u0005\b\u0000\u0000"+
		"\u0096\u0098\u0003\u0010\b\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0001\u0000\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009c\u009d\u0005\t\u0000\u0000\u009d\u00b6"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0012\u0000\u0000\u009f\u00a0"+
		"\u0003\u0014\n\u0000\u00a0\u00a1\u0005\u0013\u0000\u0000\u00a1\u00a2\u0003"+
		"\u0010\b\u0000\u00a2\u00b6\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0014"+
		"\u0000\u0000\u00a4\u00a5\u0005\u0013\u0000\u0000\u00a5\u00b6\u0003\u0010"+
		"\b\u0000\u00a6\u00a8\u0005\u0015\u0000\u0000\u00a7\u00a9\u0005\u0003\u0000"+
		"\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00b6\u0001\u0000\u0000\u0000\u00aa\u00ac\u0005\u0016\u0000"+
		"\u0000\u00ab\u00ad\u0005\u0003\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00b6\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b0\u0005\u0017\u0000\u0000\u00af\u00b1\u0003\u0014\n\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005\u0003\u0000\u0000"+
		"\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5_\u0001\u0000\u0000\u0000\u00b5"+
		"c\u0001\u0000\u0000\u0000\u00b5p\u0001\u0000\u0000\u0000\u00b5x\u0001"+
		"\u0000\u0000\u0000\u00b5\u0081\u0001\u0000\u0000\u0000\u00b5\u0087\u0001"+
		"\u0000\u0000\u0000\u00b5\u008b\u0001\u0000\u0000\u0000\u00b5\u0093\u0001"+
		"\u0000\u0000\u0000\u00b5\u009e\u0001\u0000\u0000\u0000\u00b5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00b5\u00a6\u0001\u0000\u0000\u0000\u00b5\u00aa\u0001"+
		"\u0000\u0000\u0000\u00b5\u00ae\u0001\u0000\u0000\u0000\u00b6\u0011\u0001"+
		"\u0000\u0000\u0000\u00b7\u00ba\u0003\u0006\u0003\u0000\u00b8\u00ba\u0003"+
		"\u0014\n\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00b8\u0001\u0000"+
		"\u0000\u0000\u00ba\u0013\u0001\u0000\u0000\u0000\u00bb\u00bc\u0006\n\uffff"+
		"\uffff\u0000\u00bc\u00bd\u0005\u0018\u0000\u0000\u00bd\u00f0\u0003\u0014"+
		"\n\u0016\u00be\u00bf\u0005\u0019\u0000\u0000\u00bf\u00f0\u0003\u0014\n"+
		"\u0015\u00c0\u00c1\u00056\u0000\u0000\u00c1\u00c2\u0007\u0000\u0000\u0000"+
		"\u00c2\u00f0\u0003\u0014\n\u0011\u00c3\u00c4\u00056\u0000\u0000\u00c4"+
		"\u00c5\u0005\u0002\u0000\u0000\u00c5\u00f0\u0003\u0014\n\r\u00c6\u00c7"+
		"\u0005(\u0000\u0000\u00c7\u00c8\u0003\u0014\n\u0000\u00c8\u00ca\u0005"+
		"\u0007\u0000\u0000\u00c9\u00cb\u0005\u0003\u0000\u0000\u00ca\u00c9\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00f0\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0005)\u0000\u0000\u00cd\u00ce\u0003\u0014"+
		"\n\u0000\u00ce\u00d0\u0005\u0007\u0000\u0000\u00cf\u00d1\u0005\u0003\u0000"+
		"\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00f0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005*\u0000\u0000"+
		"\u00d3\u00d4\u0003\u0014\n\u0000\u00d4\u00d6\u0005\u0007\u0000\u0000\u00d5"+
		"\u00d7\u0005\u0003\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d7\u00f0\u0001\u0000\u0000\u0000\u00d8"+
		"\u00f0\u00051\u0000\u0000\u00d9\u00f0\u00052\u0000\u0000\u00da\u00f0\u0005"+
		"3\u0000\u0000\u00db\u00f0\u00050\u0000\u0000\u00dc\u00f0\u00054\u0000"+
		"\u0000\u00dd\u00de\u0005+\u0000\u0000\u00de\u00df\u00056\u0000\u0000\u00df"+
		"\u00e1\u0005\u0006\u0000\u0000\u00e0\u00e2\u0003\u0018\f\u0000\u00e1\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e3\u00f0\u0005\u0007\u0000\u0000\u00e4\u00f0"+
		"\u00056\u0000\u0000\u00e5\u00e6\u0005,\u0000\u0000\u00e6\u00e7\u0003\u0014"+
		"\n\u0000\u00e7\u00e9\u0005-\u0000\u0000\u00e8\u00ea\u0005\u0003\u0000"+
		"\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea\u00f0\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0006\u0000"+
		"\u0000\u00ec\u00ed\u0003\u0014\n\u0000\u00ed\u00ee\u0005\u0007\u0000\u0000"+
		"\u00ee\u00f0\u0001\u0000\u0000\u0000\u00ef\u00bb\u0001\u0000\u0000\u0000"+
		"\u00ef\u00be\u0001\u0000\u0000\u0000\u00ef\u00c0\u0001\u0000\u0000\u0000"+
		"\u00ef\u00c3\u0001\u0000\u0000\u0000\u00ef\u00c6\u0001\u0000\u0000\u0000"+
		"\u00ef\u00cc\u0001\u0000\u0000\u0000\u00ef\u00d2\u0001\u0000\u0000\u0000"+
		"\u00ef\u00d8\u0001\u0000\u0000\u0000\u00ef\u00d9\u0001\u0000\u0000\u0000"+
		"\u00ef\u00da\u0001\u0000\u0000\u0000\u00ef\u00db\u0001\u0000\u0000\u0000"+
		"\u00ef\u00dc\u0001\u0000\u0000\u0000\u00ef\u00dd\u0001\u0000\u0000\u0000"+
		"\u00ef\u00e4\u0001\u0000\u0000\u0000\u00ef\u00e5\u0001\u0000\u0000\u0000"+
		"\u00ef\u00eb\u0001\u0000\u0000\u0000\u00f0\u0108\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f2\n\u0013\u0000\u0000\u00f2\u00f3\u0007\u0001\u0000\u0000\u00f3"+
		"\u0107\u0003\u0014\n\u0014\u00f4\u00f5\n\u0012\u0000\u0000\u00f5\u00f6"+
		"\u0007\u0002\u0000\u0000\u00f6\u0107\u0003\u0014\n\u0013\u00f7\u00f8\n"+
		"\u0010\u0000\u0000\u00f8\u00f9\u0007\u0003\u0000\u0000\u00f9\u0107\u0003"+
		"\u0014\n\u0011\u00fa\u00fb\n\u000f\u0000\u0000\u00fb\u00fc\u0007\u0004"+
		"\u0000\u0000\u00fc\u0107\u0003\u0014\n\u0010\u00fd\u00fe\n\u000e\u0000"+
		"\u0000\u00fe\u00ff\u0007\u0005\u0000\u0000\u00ff\u0107\u0003\u0014\n\u000f"+
		"\u0100\u0102\n\u0014\u0000\u0000\u0101\u0103\u0003\u0016\u000b\u0000\u0102"+
		"\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104"+
		"\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105"+
		"\u0107\u0001\u0000\u0000\u0000\u0106\u00f1\u0001\u0000\u0000\u0000\u0106"+
		"\u00f4\u0001\u0000\u0000\u0000\u0106\u00f7\u0001\u0000\u0000\u0000\u0106"+
		"\u00fa\u0001\u0000\u0000\u0000\u0106\u00fd\u0001\u0000\u0000\u0000\u0106"+
		"\u0100\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108"+
		"\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109"+
		"\u0015\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b"+
		"\u010d\u0005\u0006\u0000\u0000\u010c\u010e\u0003\u0018\f\u0000\u010d\u010c"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f"+
		"\u0001\u0000\u0000\u0000\u010f\u0113\u0005\u0007\u0000\u0000\u0110\u0111"+
		"\u0005.\u0000\u0000\u0111\u0113\u00056\u0000\u0000\u0112\u010b\u0001\u0000"+
		"\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0113\u0017\u0001\u0000"+
		"\u0000\u0000\u0114\u0119\u0003\u0014\n\u0000\u0115\u0116\u0005\u000b\u0000"+
		"\u0000\u0116\u0118\u0003\u0014\n\u0000\u0117\u0115\u0001\u0000\u0000\u0000"+
		"\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u0019\u0001\u0000\u0000\u0000"+
		"\u011b\u0119\u0001\u0000\u0000\u0000\"\u001d%,/5;BMU\\aint\u007f\u0099"+
		"\u00a8\u00ac\u00b0\u00b3\u00b5\u00b9\u00ca\u00d0\u00d6\u00e1\u00e9\u00ef"+
		"\u0104\u0106\u0108\u010d\u0112\u0119";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}