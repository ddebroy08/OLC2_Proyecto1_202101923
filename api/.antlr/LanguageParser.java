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
		T__38=39, T__39=40, T__40=41, T__41=42, Types=43, INT=44, BOOL=45, FLOAT=46, 
		STRING=47, RUNE=48, WS=49, ID=50, COMMENT=51, ML_COMMENT=52;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_shortVarDcl = 3, 
		RULE_stmt = 4, RULE_forInit = 5, RULE_expr = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "shortVarDcl", "stmt", "forInit", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'fmt.Println('", "','", "')'", 
			"'{'", "'}'", "'if'", "'('", "'else'", "'while'", "'for'", "'switch'", 
			"'case'", "':'", "'default'", "'break'", "'continue'", "'return'", "'-'", 
			"'!'", "'*'", "'/'", "'%'", "'+'", "'+='", "'-='", "'>'", "'<'", "'>='", 
			"'<='", "'=='", "'!='", "'&&'", "'||'", "'strconv.Atoi('", "'strconv.ParseFloat('", 
			"'reflect.TypeOf('", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "Types", "INT", "BOOL", "FLOAT", 
			"STRING", "RUNE", "WS", "ID", "COMMENT", "ML_COMMENT"
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
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1675380859464994L) != 0)) {
				{
				{
				setState(14);
				dcl();
				}
				}
				setState(19);
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
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				shortVarDcl();
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
			setState(25);
			match(T__0);
			setState(26);
			match(ID);
			setState(27);
			match(Types);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(28);
				match(T__1);
				setState(29);
				expr(0);
				}
			}

			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(32);
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
			setState(35);
			match(ID);
			setState(36);
			match(T__3);
			setState(37);
			expr(0);
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(38);
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
		enterRule(_localctx, 8, RULE_stmt);
		int _la;
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				expr(0);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(42);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__4);
				setState(46);
				expr(0);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(47);
					match(T__5);
					setState(48);
					expr(0);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(T__6);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(55);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(T__7);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1675380859464994L) != 0)) {
					{
					{
					setState(59);
					dcl();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				match(T__9);
				setState(67);
				match(T__10);
				setState(68);
				expr(0);
				setState(69);
				match(T__6);
				setState(70);
				stmt();
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(71);
					match(T__11);
					setState(72);
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
				setState(75);
				match(T__12);
				setState(76);
				match(T__10);
				setState(77);
				expr(0);
				setState(78);
				match(T__6);
				setState(79);
				stmt();
				}
				break;
			case 6:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				match(T__13);
				setState(82);
				expr(0);
				setState(83);
				stmt();
				}
				break;
			case 7:
				_localctx = new ForStmtIniContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				match(T__13);
				setState(86);
				forInit();
				setState(87);
				match(T__2);
				setState(88);
				expr(0);
				setState(89);
				match(T__2);
				setState(90);
				expr(0);
				setState(91);
				stmt();
				}
				break;
			case 8:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				match(T__14);
				setState(94);
				expr(0);
				setState(95);
				match(T__7);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1675380859464992L) != 0)) {
					{
					{
					setState(96);
					stmt();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				match(T__8);
				}
				break;
			case 9:
				_localctx = new CaseStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(104);
				match(T__15);
				setState(105);
				expr(0);
				setState(106);
				match(T__16);
				setState(107);
				stmt();
				}
				break;
			case 10:
				_localctx = new DefaultStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(109);
				match(T__17);
				setState(110);
				match(T__16);
				setState(111);
				stmt();
				}
				break;
			case 11:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(112);
				match(T__18);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(113);
					match(T__2);
					}
				}

				}
				break;
			case 12:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(116);
				match(T__19);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(117);
					match(T__2);
					}
				}

				}
				break;
			case 13:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(120);
				match(T__20);
				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(121);
					expr(0);
					}
					break;
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(124);
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
		enterRule(_localctx, 10, RULE_forInit);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				shortVarDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				match(T__21);
				setState(135);
				expr(20);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(T__22);
				setState(137);
				expr(19);
				}
				break;
			case 3:
				{
				_localctx = new AddSubAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(ID);
				setState(139);
				((AddSubAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
					((AddSubAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(140);
				expr(16);
				}
				break;
			case 4:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(ID);
				setState(142);
				match(T__1);
				setState(143);
				expr(12);
				}
				break;
			case 5:
				{
				_localctx = new AtoiStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(T__37);
				setState(145);
				expr(0);
				setState(146);
				match(T__6);
				setState(148);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(147);
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
				setState(150);
				match(T__38);
				setState(151);
				expr(0);
				setState(152);
				match(T__6);
				setState(154);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(153);
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
				setState(156);
				match(T__39);
				setState(157);
				expr(0);
				setState(158);
				match(T__6);
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(159);
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
				setState(162);
				match(BOOL);
				}
				break;
			case 9:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(FLOAT);
				}
				break;
			case 10:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(INT);
				}
				break;
			case 12:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(RUNE);
				}
				break;
			case 13:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(ID);
				}
				break;
			case 14:
				{
				_localctx = new BracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(T__40);
				setState(169);
				expr(0);
				setState(170);
				match(T__41);
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(171);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 15:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(T__10);
				setState(175);
				expr(0);
				setState(176);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(195);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(180);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(181);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 117440512L) != 0)) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						expr(19);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(184);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__26) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						expr(18);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(187);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						expr(16);
						}
						break;
					case 4:
						{
						_localctx = new EqualitysContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(189);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(190);
						((EqualitysContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((EqualitysContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						expr(15);
						}
						break;
					case 5:
						{
						_localctx = new LogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(193);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__36) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expr(14);
						}
						break;
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u00c9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0005\u0000\u0010"+
		"\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0018\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\u001f\b\u0002\u0001\u0002\u0003\u0002\"\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003(\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004,\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u00042\b\u0004\n\u0004\f\u00045\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u00049\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004=\b\u0004\n\u0004\f\u0004@\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004J\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004b\b\u0004\n\u0004\f\u0004e\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004s\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004w\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004{\b\u0004\u0001\u0004\u0003\u0004~\b\u0004\u0003\u0004\u0080"+
		"\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u0084\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u0095\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u009b\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00a1\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00ad\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00b3\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u00c4\b\u0006\n\u0006\f\u0006\u00c7\t\u0006\u0001"+
		"\u0006\u0000\u0001\f\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0006\u0001"+
		"\u0000\u001c\u001d\u0001\u0000\u0018\u001a\u0002\u0000\u0016\u0016\u001b"+
		"\u001b\u0001\u0000\u001e!\u0001\u0000\"#\u0001\u0000$%\u00f5\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0002\u0017\u0001\u0000\u0000\u0000\u0004\u0019"+
		"\u0001\u0000\u0000\u0000\u0006#\u0001\u0000\u0000\u0000\b\u007f\u0001"+
		"\u0000\u0000\u0000\n\u0083\u0001\u0000\u0000\u0000\f\u00b2\u0001\u0000"+
		"\u0000\u0000\u000e\u0010\u0003\u0002\u0001\u0000\u000f\u000e\u0001\u0000"+
		"\u0000\u0000\u0010\u0013\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000"+
		"\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0001\u0001\u0000"+
		"\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0014\u0018\u0003\u0004"+
		"\u0002\u0000\u0015\u0018\u0003\b\u0004\u0000\u0016\u0018\u0003\u0006\u0003"+
		"\u0000\u0017\u0014\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000"+
		"\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0003\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0005\u0001\u0000\u0000\u001a\u001b\u00052\u0000\u0000"+
		"\u001b\u001e\u0005+\u0000\u0000\u001c\u001d\u0005\u0002\u0000\u0000\u001d"+
		"\u001f\u0003\f\u0006\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0001\u0000\u0000\u0000\u001f!\u0001\u0000\u0000\u0000 \"\u0005\u0003"+
		"\u0000\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0005"+
		"\u0001\u0000\u0000\u0000#$\u00052\u0000\u0000$%\u0005\u0004\u0000\u0000"+
		"%\'\u0003\f\u0006\u0000&(\u0005\u0003\u0000\u0000\'&\u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000(\u0007\u0001\u0000\u0000\u0000)+\u0003"+
		"\f\u0006\u0000*,\u0005\u0003\u0000\u0000+*\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,\u0080\u0001\u0000\u0000\u0000-.\u0005\u0005\u0000"+
		"\u0000.3\u0003\f\u0006\u0000/0\u0005\u0006\u0000\u000002\u0003\f\u0006"+
		"\u00001/\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000068\u0005\u0007\u0000\u000079\u0005\u0003\u0000\u0000"+
		"87\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009\u0080\u0001\u0000"+
		"\u0000\u0000:>\u0005\b\u0000\u0000;=\u0003\u0002\u0001\u0000<;\u0001\u0000"+
		"\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"A\u0080\u0005\t\u0000\u0000BC\u0005\n\u0000\u0000CD\u0005\u000b\u0000"+
		"\u0000DE\u0003\f\u0006\u0000EF\u0005\u0007\u0000\u0000FI\u0003\b\u0004"+
		"\u0000GH\u0005\f\u0000\u0000HJ\u0003\b\u0004\u0000IG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000J\u0080\u0001\u0000\u0000\u0000KL\u0005"+
		"\r\u0000\u0000LM\u0005\u000b\u0000\u0000MN\u0003\f\u0006\u0000NO\u0005"+
		"\u0007\u0000\u0000OP\u0003\b\u0004\u0000P\u0080\u0001\u0000\u0000\u0000"+
		"QR\u0005\u000e\u0000\u0000RS\u0003\f\u0006\u0000ST\u0003\b\u0004\u0000"+
		"T\u0080\u0001\u0000\u0000\u0000UV\u0005\u000e\u0000\u0000VW\u0003\n\u0005"+
		"\u0000WX\u0005\u0003\u0000\u0000XY\u0003\f\u0006\u0000YZ\u0005\u0003\u0000"+
		"\u0000Z[\u0003\f\u0006\u0000[\\\u0003\b\u0004\u0000\\\u0080\u0001\u0000"+
		"\u0000\u0000]^\u0005\u000f\u0000\u0000^_\u0003\f\u0006\u0000_c\u0005\b"+
		"\u0000\u0000`b\u0003\b\u0004\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\t\u0000\u0000g\u0080"+
		"\u0001\u0000\u0000\u0000hi\u0005\u0010\u0000\u0000ij\u0003\f\u0006\u0000"+
		"jk\u0005\u0011\u0000\u0000kl\u0003\b\u0004\u0000l\u0080\u0001\u0000\u0000"+
		"\u0000mn\u0005\u0012\u0000\u0000no\u0005\u0011\u0000\u0000o\u0080\u0003"+
		"\b\u0004\u0000pr\u0005\u0013\u0000\u0000qs\u0005\u0003\u0000\u0000rq\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0080\u0001\u0000\u0000"+
		"\u0000tv\u0005\u0014\u0000\u0000uw\u0005\u0003\u0000\u0000vu\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000w\u0080\u0001\u0000\u0000\u0000"+
		"xz\u0005\u0015\u0000\u0000y{\u0003\f\u0006\u0000zy\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000|~\u0005\u0003\u0000"+
		"\u0000}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001"+
		"\u0000\u0000\u0000\u007f)\u0001\u0000\u0000\u0000\u007f-\u0001\u0000\u0000"+
		"\u0000\u007f:\u0001\u0000\u0000\u0000\u007fB\u0001\u0000\u0000\u0000\u007f"+
		"K\u0001\u0000\u0000\u0000\u007fQ\u0001\u0000\u0000\u0000\u007fU\u0001"+
		"\u0000\u0000\u0000\u007f]\u0001\u0000\u0000\u0000\u007fh\u0001\u0000\u0000"+
		"\u0000\u007fm\u0001\u0000\u0000\u0000\u007fp\u0001\u0000\u0000\u0000\u007f"+
		"t\u0001\u0000\u0000\u0000\u007fx\u0001\u0000\u0000\u0000\u0080\t\u0001"+
		"\u0000\u0000\u0000\u0081\u0084\u0003\u0006\u0003\u0000\u0082\u0084\u0003"+
		"\f\u0006\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u000b\u0001\u0000\u0000\u0000\u0085\u0086\u0006\u0006"+
		"\uffff\uffff\u0000\u0086\u0087\u0005\u0016\u0000\u0000\u0087\u00b3\u0003"+
		"\f\u0006\u0014\u0088\u0089\u0005\u0017\u0000\u0000\u0089\u00b3\u0003\f"+
		"\u0006\u0013\u008a\u008b\u00052\u0000\u0000\u008b\u008c\u0007\u0000\u0000"+
		"\u0000\u008c\u00b3\u0003\f\u0006\u0010\u008d\u008e\u00052\u0000\u0000"+
		"\u008e\u008f\u0005\u0002\u0000\u0000\u008f\u00b3\u0003\f\u0006\f\u0090"+
		"\u0091\u0005&\u0000\u0000\u0091\u0092\u0003\f\u0006\u0000\u0092\u0094"+
		"\u0005\u0007\u0000\u0000\u0093\u0095\u0005\u0003\u0000\u0000\u0094\u0093"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u00b3"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0005\'\u0000\u0000\u0097\u0098\u0003"+
		"\f\u0006\u0000\u0098\u009a\u0005\u0007\u0000\u0000\u0099\u009b\u0005\u0003"+
		"\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\u00b3\u0001\u0000\u0000\u0000\u009c\u009d\u0005(\u0000"+
		"\u0000\u009d\u009e\u0003\f\u0006\u0000\u009e\u00a0\u0005\u0007\u0000\u0000"+
		"\u009f\u00a1\u0005\u0003\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00b3\u0001\u0000\u0000\u0000"+
		"\u00a2\u00b3\u0005-\u0000\u0000\u00a3\u00b3\u0005.\u0000\u0000\u00a4\u00b3"+
		"\u0005/\u0000\u0000\u00a5\u00b3\u0005,\u0000\u0000\u00a6\u00b3\u00050"+
		"\u0000\u0000\u00a7\u00b3\u00052\u0000\u0000\u00a8\u00a9\u0005)\u0000\u0000"+
		"\u00a9\u00aa\u0003\f\u0006\u0000\u00aa\u00ac\u0005*\u0000\u0000\u00ab"+
		"\u00ad\u0005\u0003\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ad\u00b3\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0005\u000b\u0000\u0000\u00af\u00b0\u0003\f\u0006\u0000\u00b0\u00b1"+
		"\u0005\u0007\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u0085"+
		"\u0001\u0000\u0000\u0000\u00b2\u0088\u0001\u0000\u0000\u0000\u00b2\u008a"+
		"\u0001\u0000\u0000\u0000\u00b2\u008d\u0001\u0000\u0000\u0000\u00b2\u0090"+
		"\u0001\u0000\u0000\u0000\u00b2\u0096\u0001\u0000\u0000\u0000\u00b2\u009c"+
		"\u0001\u0000\u0000\u0000\u00b2\u00a2\u0001\u0000\u0000\u0000\u00b2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00b2\u00a4\u0001\u0000\u0000\u0000\u00b2\u00a5"+
		"\u0001\u0000\u0000\u0000\u00b2\u00a6\u0001\u0000\u0000\u0000\u00b2\u00a7"+
		"\u0001\u0000\u0000\u0000\u00b2\u00a8\u0001\u0000\u0000\u0000\u00b2\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b3\u00c5\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\n\u0012\u0000\u0000\u00b5\u00b6\u0007\u0001\u0000\u0000\u00b6\u00c4\u0003"+
		"\f\u0006\u0013\u00b7\u00b8\n\u0011\u0000\u0000\u00b8\u00b9\u0007\u0002"+
		"\u0000\u0000\u00b9\u00c4\u0003\f\u0006\u0012\u00ba\u00bb\n\u000f\u0000"+
		"\u0000\u00bb\u00bc\u0007\u0003\u0000\u0000\u00bc\u00c4\u0003\f\u0006\u0010"+
		"\u00bd\u00be\n\u000e\u0000\u0000\u00be\u00bf\u0007\u0004\u0000\u0000\u00bf"+
		"\u00c4\u0003\f\u0006\u000f\u00c0\u00c1\n\r\u0000\u0000\u00c1\u00c2\u0007"+
		"\u0005\u0000\u0000\u00c2\u00c4\u0003\f\u0006\u000e\u00c3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00c3\u00b7\u0001\u0000\u0000\u0000\u00c3\u00ba\u0001\u0000"+
		"\u0000\u0000\u00c3\u00bd\u0001\u0000\u0000\u0000\u00c3\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\r\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u0018\u0011\u0017\u001e!\'"+
		"+38>Icrvz}\u007f\u0083\u0094\u009a\u00a0\u00ac\u00b2\u00c3\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}