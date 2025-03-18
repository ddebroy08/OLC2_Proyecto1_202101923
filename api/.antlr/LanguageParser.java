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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, Types=52, 
		INT=53, BOOL=54, FLOAT=55, STRING=56, RUNE=57, WS=58, ID=59, COMMENT=60, 
		ML_COMMENT=61;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_sliceDcl = 3, RULE_shortVarDcl = 4, 
		RULE_shortSliceDcl = 5, RULE_funcDcl = 6, RULE_classDcl = 7, RULE_classBody = 8, 
		RULE_params = 9, RULE_stmt = 10, RULE_forInit = 11, RULE_expr = 12, RULE_call = 13, 
		RULE_args = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "sliceDcl", "shortVarDcl", "shortSliceDcl", 
			"funcDcl", "classDcl", "classBody", "params", "stmt", "forInit", "expr", 
			"call", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "'['", "']'", "'{'", "','", "'}'", "':='", 
			"'func'", "'('", "')'", "'class'", "'fmt.Println('", "'if'", "'else'", 
			"'while'", "'for'", "'switch'", "'case'", "':'", "'default'", "'break'", 
			"'continue'", "'return'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'+='", 
			"'-='", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", 
			"'strconv.Atoi('", "'strconv.ParseFloat('", "'reflect.TypeOf('", "'slices.Index('", 
			"'strings.Join('", "', \" \")'", "'append('", "'len('", "'new'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "Types", "INT", "BOOL", "FLOAT", "STRING", "RUNE", 
			"WS", "ID", "COMMENT", "ML_COMMENT"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 857790593745480786L) != 0)) {
				{
				{
				setState(30);
				dcl();
				}
				}
				setState(35);
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
		public SliceDclContext sliceDcl() {
			return getRuleContext(SliceDclContext.class,0);
		}
		public ShortSliceDclContext shortSliceDcl() {
			return getRuleContext(ShortSliceDclContext.class,0);
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
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				sliceDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				shortSliceDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				shortVarDcl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				classDcl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
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
			setState(45);
			match(T__0);
			setState(46);
			match(ID);
			setState(47);
			match(Types);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(48);
				match(T__1);
				setState(49);
				expr(0);
				}
			}

			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(52);
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
	public static class SliceDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode Types() { return getToken(LanguageParser.Types, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceDcl; }
	}

	public final SliceDclContext sliceDcl() throws RecognitionException {
		SliceDclContext _localctx = new SliceDclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sliceDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__0);
			setState(56);
			match(ID);
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(57);
				match(T__3);
				setState(58);
				match(T__4);
				setState(59);
				match(Types);
				}
				break;
			case 2:
				{
				setState(60);
				match(T__1);
				setState(61);
				match(T__3);
				setState(62);
				match(T__4);
				setState(63);
				match(Types);
				setState(64);
				match(T__5);
				setState(65);
				expr(0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(66);
					match(T__6);
					setState(67);
					expr(0);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73);
				match(T__7);
				}
				break;
			case 3:
				{
				setState(75);
				match(T__1);
				setState(76);
				expr(0);
				}
				break;
			case 4:
				{
				setState(77);
				match(T__1);
				setState(78);
				match(T__5);
				setState(79);
				expr(0);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(80);
					match(T__6);
					setState(81);
					expr(0);
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(T__7);
				}
				break;
			}
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(91);
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
		enterRule(_localctx, 8, RULE_shortVarDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			setState(95);
			match(T__8);
			setState(96);
			expr(0);
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(97);
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
	public static class ShortSliceDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode Types() { return getToken(LanguageParser.Types, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ShortSliceDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortSliceDcl; }
	}

	public final ShortSliceDclContext shortSliceDcl() throws RecognitionException {
		ShortSliceDclContext _localctx = new ShortSliceDclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_shortSliceDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ID);
			setState(101);
			match(T__8);
			setState(102);
			match(T__3);
			setState(103);
			match(T__4);
			setState(104);
			match(Types);
			setState(105);
			match(T__5);
			setState(106);
			expr(0);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(107);
				match(T__6);
				setState(108);
				expr(0);
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(T__7);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(115);
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
		enterRule(_localctx, 12, RULE_funcDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__9);
			setState(119);
			match(ID);
			setState(120);
			match(T__10);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(121);
				params();
				}
			}

			setState(124);
			match(T__11);
			setState(125);
			match(T__5);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 857790593745480786L) != 0)) {
				{
				{
				setState(126);
				dcl();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(T__7);
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
		enterRule(_localctx, 14, RULE_classDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__12);
			setState(135);
			match(ID);
			setState(136);
			match(T__5);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460752303424514L) != 0)) {
				{
				{
				setState(137);
				classBody();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(T__7);
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
		enterRule(_localctx, 16, RULE_classBody);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				varDcl();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				shortVarDcl();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
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
		enterRule(_localctx, 18, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(ID);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(151);
				match(T__6);
				setState(152);
				match(ID);
				}
				}
				setState(157);
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
		enterRule(_localctx, 20, RULE_stmt);
		int _la;
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				expr(0);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(159);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(T__13);
				setState(163);
				expr(0);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(164);
					match(T__6);
					setState(165);
					expr(0);
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(171);
				match(T__11);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(172);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(T__5);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 857790593745480786L) != 0)) {
					{
					{
					setState(176);
					dcl();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
				match(T__7);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(T__14);
				setState(184);
				expr(0);
				setState(185);
				stmt();
				setState(188);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(186);
					match(T__15);
					setState(187);
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
				setState(190);
				match(T__16);
				setState(191);
				match(T__10);
				setState(192);
				expr(0);
				setState(193);
				match(T__11);
				setState(194);
				stmt();
				}
				break;
			case 6:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(196);
				match(T__17);
				setState(197);
				expr(0);
				setState(198);
				stmt();
				}
				break;
			case 7:
				_localctx = new ForStmtIniContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				match(T__17);
				setState(201);
				forInit();
				setState(202);
				match(T__2);
				setState(203);
				expr(0);
				setState(204);
				match(T__2);
				setState(205);
				expr(0);
				setState(206);
				stmt();
				}
				break;
			case 8:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(208);
				match(T__18);
				setState(209);
				expr(0);
				setState(210);
				match(T__5);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 857790593745471568L) != 0)) {
					{
					{
					setState(211);
					stmt();
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(T__7);
				}
				break;
			case 9:
				_localctx = new CaseStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(219);
				match(T__19);
				setState(220);
				expr(0);
				setState(221);
				match(T__20);
				setState(222);
				stmt();
				}
				break;
			case 10:
				_localctx = new DefaultStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(224);
				match(T__21);
				setState(225);
				match(T__20);
				setState(226);
				stmt();
				}
				break;
			case 11:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(227);
				match(T__22);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(228);
					match(T__2);
					}
				}

				}
				break;
			case 12:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(231);
				match(T__23);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(232);
					match(T__2);
					}
				}

				}
				break;
			case 13:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(235);
				match(T__24);
				setState(237);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(236);
					expr(0);
					}
					break;
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(239);
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
		enterRule(_localctx, 22, RULE_forInit);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				shortVarDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
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
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class IndexContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IndexContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringsJoinContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StringsJoinContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtoiStmtContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtoiStmtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class SliceInitContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceInitContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class ParseFloatStmtContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParseFloatStmtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketsContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BracketsContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LenSliceContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LenSliceContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class SliceIndexContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceIndexContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
	public static class RuneContext extends ExprContext {
		public TerminalNode RUNE() { return getToken(LanguageParser.RUNE, 0); }
		public RuneContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppendSliceContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AppendSliceContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexAssigContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IndexAssigContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(249);
				match(T__25);
				setState(250);
				expr(29);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(T__26);
				setState(252);
				expr(28);
				}
				break;
			case 3:
				{
				_localctx = new AddSubAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(ID);
				setState(254);
				((AddSubAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
					((AddSubAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(255);
				expr(24);
				}
				break;
			case 4:
				{
				_localctx = new AtoiStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(T__41);
				setState(257);
				expr(0);
				setState(258);
				match(T__11);
				setState(260);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(259);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new ParseFloatStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				match(T__42);
				setState(263);
				expr(0);
				setState(264);
				match(T__11);
				setState(266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(265);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new TypeOfStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(T__43);
				setState(269);
				expr(0);
				setState(270);
				match(T__11);
				setState(272);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(271);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new SliceIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(T__44);
				setState(275);
				expr(0);
				setState(276);
				match(T__6);
				setState(277);
				expr(0);
				setState(278);
				match(T__11);
				setState(280);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(279);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new StringsJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				match(T__45);
				setState(283);
				expr(0);
				setState(284);
				match(T__46);
				setState(286);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(285);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new AppendSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(T__47);
				setState(289);
				expr(0);
				setState(290);
				match(T__6);
				setState(291);
				expr(0);
				setState(292);
				match(T__11);
				setState(294);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(293);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new LenSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296);
				match(T__48);
				setState(297);
				expr(0);
				setState(298);
				match(T__11);
				setState(300);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(299);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				match(BOOL);
				}
				break;
			case 12:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(FLOAT);
				}
				break;
			case 13:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(304);
				match(STRING);
				}
				break;
			case 14:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				match(INT);
				}
				break;
			case 15:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(306);
				match(RUNE);
				}
				break;
			case 16:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307);
				match(T__49);
				setState(308);
				match(ID);
				setState(309);
				match(T__10);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 857790593680541776L) != 0)) {
					{
					setState(310);
					args();
					}
				}

				setState(313);
				match(T__11);
				}
				break;
			case 17:
				{
				_localctx = new IndexAssigContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				match(ID);
				setState(315);
				match(T__3);
				setState(316);
				expr(0);
				setState(317);
				match(T__4);
				setState(318);
				match(T__1);
				setState(319);
				expr(6);
				}
				break;
			case 18:
				{
				_localctx = new IndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(321);
				match(ID);
				setState(322);
				match(T__3);
				setState(323);
				expr(0);
				setState(324);
				match(T__4);
				}
				break;
			case 19:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326);
				match(ID);
				}
				break;
			case 20:
				{
				_localctx = new BracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(327);
				match(T__3);
				setState(328);
				expr(0);
				setState(329);
				match(T__4);
				setState(331);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(330);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 21:
				{
				_localctx = new SliceInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(T__5);
				setState(334);
				expr(0);
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(335);
					match(T__6);
					setState(336);
					expr(0);
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(342);
				match(T__7);
				}
				break;
			case 22:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344);
				match(T__10);
				setState(345);
				expr(0);
				setState(346);
				match(T__11);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(374);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(350);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(351);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(352);
						expr(27);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(353);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(354);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__30) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(355);
						expr(26);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(356);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(357);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 257698037760L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(358);
						expr(24);
						}
						break;
					case 4:
						{
						_localctx = new EqualitysContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(359);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(360);
						((EqualitysContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__37 || _la==T__38) ) {
							((EqualitysContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(361);
						expr(23);
						}
						break;
					case 5:
						{
						_localctx = new LogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(362);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(363);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__39 || _la==T__40) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(364);
						expr(22);
						}
						break;
					case 6:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(365);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(366);
						match(T__1);
						setState(367);
						expr(21);
						}
						break;
					case 7:
						{
						_localctx = new CalleContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(368);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(370); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(369);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(372); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		enterRule(_localctx, 26, RULE_call);
		int _la;
		try {
			setState(386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(379);
				match(T__10);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 857790593680541776L) != 0)) {
					{
					setState(380);
					args();
					}
				}

				setState(383);
				match(T__11);
				}
				break;
			case T__50:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				match(T__50);
				setState(385);
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
		enterRule(_localctx, 28, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			expr(0);
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(389);
				match(T__6);
				setState(390);
				expr(0);
				}
				}
				setState(395);
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
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 26);
		case 1:
			return precpred(_ctx, 25);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 22);
		case 4:
			return precpred(_ctx, 21);
		case 5:
			return precpred(_ctx, 20);
		case 6:
			return precpred(_ctx, 27);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u018d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"3\b\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003E\b"+
		"\u0003\n\u0003\f\u0003H\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003S\b\u0003\n\u0003\f\u0003V\t\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003Z\b\u0003\u0001\u0003\u0003\u0003]\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004c\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005n\b\u0005\n\u0005\f\u0005q\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005u\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006{\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u0080\b\u0006\n\u0006\f\u0006\u0083\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u008b"+
		"\b\u0007\n\u0007\f\u0007\u008e\t\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0003\b\u0095\b\b\u0001\t\u0001\t\u0001\t\u0005\t\u009a"+
		"\b\t\n\t\f\t\u009d\t\t\u0001\n\u0001\n\u0003\n\u00a1\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u00a7\b\n\n\n\f\n\u00aa\t\n\u0001\n\u0001\n"+
		"\u0003\n\u00ae\b\n\u0001\n\u0001\n\u0005\n\u00b2\b\n\n\n\f\n\u00b5\t\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bd\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u00d5\b\n\n\n\f\n\u00d8\t\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00e6\b\n\u0001\n\u0001\n\u0003\n\u00ea\b\n"+
		"\u0001\n\u0001\n\u0003\n\u00ee\b\n\u0001\n\u0003\n\u00f1\b\n\u0003\n\u00f3"+
		"\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u00f7\b\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u0105\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u010b"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0111\b\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0119\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u011f\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0127\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u012d\b\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0138\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u014c\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u0152\b\f\n\f\f\f\u0155\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u015d\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u0173\b\f\u000b\f\f"+
		"\f\u0174\u0005\f\u0177\b\f\n\f\f\f\u017a\t\f\u0001\r\u0001\r\u0003\r\u017e"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u0183\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u0188\b\u000e\n\u000e\f\u000e\u018b\t\u000e\u0001"+
		"\u000e\u0000\u0001\u0018\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0006\u0001\u0000 !\u0001\u0000"+
		"\u001c\u001e\u0002\u0000\u001a\u001a\u001f\u001f\u0001\u0000\"%\u0001"+
		"\u0000&\'\u0001\u0000()\u01d7\u0000!\u0001\u0000\u0000\u0000\u0002+\u0001"+
		"\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000"+
		"\u0000\b^\u0001\u0000\u0000\u0000\nd\u0001\u0000\u0000\u0000\fv\u0001"+
		"\u0000\u0000\u0000\u000e\u0086\u0001\u0000\u0000\u0000\u0010\u0094\u0001"+
		"\u0000\u0000\u0000\u0012\u0096\u0001\u0000\u0000\u0000\u0014\u00f2\u0001"+
		"\u0000\u0000\u0000\u0016\u00f6\u0001\u0000\u0000\u0000\u0018\u015c\u0001"+
		"\u0000\u0000\u0000\u001a\u0182\u0001\u0000\u0000\u0000\u001c\u0184\u0001"+
		"\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f\u001e\u0001\u0000"+
		"\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\"\u0001\u0001\u0000\u0000\u0000#!\u0001\u0000"+
		"\u0000\u0000$,\u0003\u0004\u0002\u0000%,\u0003\u0006\u0003\u0000&,\u0003"+
		"\n\u0005\u0000\',\u0003\u0014\n\u0000(,\u0003\b\u0004\u0000),\u0003\u000e"+
		"\u0007\u0000*,\u0003\f\u0006\u0000+$\u0001\u0000\u0000\u0000+%\u0001\u0000"+
		"\u0000\u0000+&\u0001\u0000\u0000\u0000+\'\u0001\u0000\u0000\u0000+(\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000"+
		",\u0003\u0001\u0000\u0000\u0000-.\u0005\u0001\u0000\u0000./\u0005;\u0000"+
		"\u0000/2\u00054\u0000\u000001\u0005\u0002\u0000\u000013\u0003\u0018\f"+
		"\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000035\u0001\u0000"+
		"\u0000\u000046\u0005\u0003\u0000\u000054\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u00006\u0005\u0001\u0000\u0000\u000078\u0005\u0001\u0000"+
		"\u00008Y\u0005;\u0000\u00009:\u0005\u0004\u0000\u0000:;\u0005\u0005\u0000"+
		"\u0000;Z\u00054\u0000\u0000<=\u0005\u0002\u0000\u0000=>\u0005\u0004\u0000"+
		"\u0000>?\u0005\u0005\u0000\u0000?@\u00054\u0000\u0000@A\u0005\u0006\u0000"+
		"\u0000AF\u0003\u0018\f\u0000BC\u0005\u0007\u0000\u0000CE\u0003\u0018\f"+
		"\u0000DB\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0001\u0000\u0000\u0000HF\u0001"+
		"\u0000\u0000\u0000IJ\u0005\b\u0000\u0000JZ\u0001\u0000\u0000\u0000KL\u0005"+
		"\u0002\u0000\u0000LZ\u0003\u0018\f\u0000MN\u0005\u0002\u0000\u0000NO\u0005"+
		"\u0006\u0000\u0000OT\u0003\u0018\f\u0000PQ\u0005\u0007\u0000\u0000QS\u0003"+
		"\u0018\f\u0000RP\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000WX\u0005\b\u0000\u0000XZ\u0001\u0000\u0000\u0000"+
		"Y9\u0001\u0000\u0000\u0000Y<\u0001\u0000\u0000\u0000YK\u0001\u0000\u0000"+
		"\u0000YM\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000"+
		"\u0000\u0000[]\u0005\u0003\u0000\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]\u0007\u0001\u0000\u0000\u0000^_\u0005;\u0000\u0000"+
		"_`\u0005\t\u0000\u0000`b\u0003\u0018\f\u0000ac\u0005\u0003\u0000\u0000"+
		"ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\t\u0001\u0000\u0000"+
		"\u0000de\u0005;\u0000\u0000ef\u0005\t\u0000\u0000fg\u0005\u0004\u0000"+
		"\u0000gh\u0005\u0005\u0000\u0000hi\u00054\u0000\u0000ij\u0005\u0006\u0000"+
		"\u0000jo\u0003\u0018\f\u0000kl\u0005\u0007\u0000\u0000ln\u0003\u0018\f"+
		"\u0000mk\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000rt\u0005\b\u0000\u0000su\u0005\u0003\u0000\u0000ts\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u000b\u0001\u0000\u0000"+
		"\u0000vw\u0005\n\u0000\u0000wx\u0005;\u0000\u0000xz\u0005\u000b\u0000"+
		"\u0000y{\u0003\u0012\t\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|}\u0005\f\u0000\u0000}\u0081\u0005\u0006"+
		"\u0000\u0000~\u0080\u0003\u0002\u0001\u0000\u007f~\u0001\u0000\u0000\u0000"+
		"\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000"+
		"\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0005\b\u0000\u0000\u0085"+
		"\r\u0001\u0000\u0000\u0000\u0086\u0087\u0005\r\u0000\u0000\u0087\u0088"+
		"\u0005;\u0000\u0000\u0088\u008c\u0005\u0006\u0000\u0000\u0089\u008b\u0003"+
		"\u0010\b\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000"+
		"\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0005\b\u0000\u0000\u0090\u000f\u0001\u0000\u0000"+
		"\u0000\u0091\u0095\u0003\u0004\u0002\u0000\u0092\u0095\u0003\b\u0004\u0000"+
		"\u0093\u0095\u0003\f\u0006\u0000\u0094\u0091\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0011\u0001\u0000\u0000\u0000\u0096\u009b\u0005;\u0000\u0000\u0097\u0098"+
		"\u0005\u0007\u0000\u0000\u0098\u009a\u0005;\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u0013\u0001"+
		"\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a0\u0003"+
		"\u0018\f\u0000\u009f\u00a1\u0005\u0003\u0000\u0000\u00a0\u009f\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00f3\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u000e\u0000\u0000\u00a3\u00a8\u0003\u0018"+
		"\f\u0000\u00a4\u00a5\u0005\u0007\u0000\u0000\u00a5\u00a7\u0003\u0018\f"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ad\u0005\f\u0000\u0000\u00ac\u00ae\u0005\u0003\u0000\u0000"+
		"\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae\u00f3\u0001\u0000\u0000\u0000\u00af\u00b3\u0005\u0006\u0000\u0000"+
		"\u00b0\u00b2\u0003\u0002\u0001\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00f3\u0005\b\u0000\u0000\u00b7"+
		"\u00b8\u0005\u000f\u0000\u0000\u00b8\u00b9\u0003\u0018\f\u0000\u00b9\u00bc"+
		"\u0003\u0014\n\u0000\u00ba\u00bb\u0005\u0010\u0000\u0000\u00bb\u00bd\u0003"+
		"\u0014\n\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u00f3\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\u0011"+
		"\u0000\u0000\u00bf\u00c0\u0005\u000b\u0000\u0000\u00c0\u00c1\u0003\u0018"+
		"\f\u0000\u00c1\u00c2\u0005\f\u0000\u0000\u00c2\u00c3\u0003\u0014\n\u0000"+
		"\u00c3\u00f3\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0012\u0000\u0000"+
		"\u00c5\u00c6\u0003\u0018\f\u0000\u00c6\u00c7\u0003\u0014\n\u0000\u00c7"+
		"\u00f3\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0012\u0000\u0000\u00c9"+
		"\u00ca\u0003\u0016\u000b\u0000\u00ca\u00cb\u0005\u0003\u0000\u0000\u00cb"+
		"\u00cc\u0003\u0018\f\u0000\u00cc\u00cd\u0005\u0003\u0000\u0000\u00cd\u00ce"+
		"\u0003\u0018\f\u0000\u00ce\u00cf\u0003\u0014\n\u0000\u00cf\u00f3\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0005\u0013\u0000\u0000\u00d1\u00d2\u0003"+
		"\u0018\f\u0000\u00d2\u00d6\u0005\u0006\u0000\u0000\u00d3\u00d5\u0003\u0014"+
		"\n\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0005\b\u0000\u0000\u00da\u00f3\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005\u0014\u0000\u0000\u00dc\u00dd\u0003\u0018\f\u0000\u00dd"+
		"\u00de\u0005\u0015\u0000\u0000\u00de\u00df\u0003\u0014\n\u0000\u00df\u00f3"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u0016\u0000\u0000\u00e1\u00e2"+
		"\u0005\u0015\u0000\u0000\u00e2\u00f3\u0003\u0014\n\u0000\u00e3\u00e5\u0005"+
		"\u0017\u0000\u0000\u00e4\u00e6\u0005\u0003\u0000\u0000\u00e5\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00f3\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e9\u0005\u0018\u0000\u0000\u00e8\u00ea\u0005"+
		"\u0003\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ea\u00f3\u0001\u0000\u0000\u0000\u00eb\u00ed\u0005"+
		"\u0019\u0000\u0000\u00ec\u00ee\u0003\u0018\f\u0000\u00ed\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f0\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f1\u0005\u0003\u0000\u0000\u00f0\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f2\u009e\u0001\u0000\u0000\u0000\u00f2\u00a2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00af\u0001\u0000\u0000\u0000\u00f2\u00b7\u0001\u0000"+
		"\u0000\u0000\u00f2\u00be\u0001\u0000\u0000\u0000\u00f2\u00c4\u0001\u0000"+
		"\u0000\u0000\u00f2\u00c8\u0001\u0000\u0000\u0000\u00f2\u00d0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00db\u0001\u0000\u0000\u0000\u00f2\u00e0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00e3\u0001\u0000\u0000\u0000\u00f2\u00e7\u0001\u0000"+
		"\u0000\u0000\u00f2\u00eb\u0001\u0000\u0000\u0000\u00f3\u0015\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f7\u0003\b\u0004\u0000\u00f5\u00f7\u0003\u0018\f"+
		"\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f7\u0017\u0001\u0000\u0000\u0000\u00f8\u00f9\u0006\f\uffff\uffff"+
		"\u0000\u00f9\u00fa\u0005\u001a\u0000\u0000\u00fa\u015d\u0003\u0018\f\u001d"+
		"\u00fb\u00fc\u0005\u001b\u0000\u0000\u00fc\u015d\u0003\u0018\f\u001c\u00fd"+
		"\u00fe\u0005;\u0000\u0000\u00fe\u00ff\u0007\u0000\u0000\u0000\u00ff\u015d"+
		"\u0003\u0018\f\u0018\u0100\u0101\u0005*\u0000\u0000\u0101\u0102\u0003"+
		"\u0018\f\u0000\u0102\u0104\u0005\f\u0000\u0000\u0103\u0105\u0005\u0003"+
		"\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000"+
		"\u0000\u0000\u0105\u015d\u0001\u0000\u0000\u0000\u0106\u0107\u0005+\u0000"+
		"\u0000\u0107\u0108\u0003\u0018\f\u0000\u0108\u010a\u0005\f\u0000\u0000"+
		"\u0109\u010b\u0005\u0003\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u015d\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u0005,\u0000\u0000\u010d\u010e\u0003\u0018\f\u0000\u010e"+
		"\u0110\u0005\f\u0000\u0000\u010f\u0111\u0005\u0003\u0000\u0000\u0110\u010f"+
		"\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u015d"+
		"\u0001\u0000\u0000\u0000\u0112\u0113\u0005-\u0000\u0000\u0113\u0114\u0003"+
		"\u0018\f\u0000\u0114\u0115\u0005\u0007\u0000\u0000\u0115\u0116\u0003\u0018"+
		"\f\u0000\u0116\u0118\u0005\f\u0000\u0000\u0117\u0119\u0005\u0003\u0000"+
		"\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000"+
		"\u0000\u0119\u015d\u0001\u0000\u0000\u0000\u011a\u011b\u0005.\u0000\u0000"+
		"\u011b\u011c\u0003\u0018\f\u0000\u011c\u011e\u0005/\u0000\u0000\u011d"+
		"\u011f\u0005\u0003\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0001\u0000\u0000\u0000\u011f\u015d\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u00050\u0000\u0000\u0121\u0122\u0003\u0018\f\u0000\u0122\u0123"+
		"\u0005\u0007\u0000\u0000\u0123\u0124\u0003\u0018\f\u0000\u0124\u0126\u0005"+
		"\f\u0000\u0000\u0125\u0127\u0005\u0003\u0000\u0000\u0126\u0125\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u015d\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u00051\u0000\u0000\u0129\u012a\u0003\u0018\f"+
		"\u0000\u012a\u012c\u0005\f\u0000\u0000\u012b\u012d\u0005\u0003\u0000\u0000"+
		"\u012c\u012b\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000"+
		"\u012d\u015d\u0001\u0000\u0000\u0000\u012e\u015d\u00056\u0000\u0000\u012f"+
		"\u015d\u00057\u0000\u0000\u0130\u015d\u00058\u0000\u0000\u0131\u015d\u0005"+
		"5\u0000\u0000\u0132\u015d\u00059\u0000\u0000\u0133\u0134\u00052\u0000"+
		"\u0000\u0134\u0135\u0005;\u0000\u0000\u0135\u0137\u0005\u000b\u0000\u0000"+
		"\u0136\u0138\u0003\u001c\u000e\u0000\u0137\u0136\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"+
		"\u0139\u015d\u0005\f\u0000\u0000\u013a\u013b\u0005;\u0000\u0000\u013b"+
		"\u013c\u0005\u0004\u0000\u0000\u013c\u013d\u0003\u0018\f\u0000\u013d\u013e"+
		"\u0005\u0005\u0000\u0000\u013e\u013f\u0005\u0002\u0000\u0000\u013f\u0140"+
		"\u0003\u0018\f\u0006\u0140\u015d\u0001\u0000\u0000\u0000\u0141\u0142\u0005"+
		";\u0000\u0000\u0142\u0143\u0005\u0004\u0000\u0000\u0143\u0144\u0003\u0018"+
		"\f\u0000\u0144\u0145\u0005\u0005\u0000\u0000\u0145\u015d\u0001\u0000\u0000"+
		"\u0000\u0146\u015d\u0005;\u0000\u0000\u0147\u0148\u0005\u0004\u0000\u0000"+
		"\u0148\u0149\u0003\u0018\f\u0000\u0149\u014b\u0005\u0005\u0000\u0000\u014a"+
		"\u014c\u0005\u0003\u0000\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014b"+
		"\u014c\u0001\u0000\u0000\u0000\u014c\u015d\u0001\u0000\u0000\u0000\u014d"+
		"\u014e\u0005\u0006\u0000\u0000\u014e\u0153\u0003\u0018\f\u0000\u014f\u0150"+
		"\u0005\u0007\u0000\u0000\u0150\u0152\u0003\u0018\f\u0000\u0151\u014f\u0001"+
		"\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153\u0151\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0156\u0001"+
		"\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156\u0157\u0005"+
		"\b\u0000\u0000\u0157\u015d\u0001\u0000\u0000\u0000\u0158\u0159\u0005\u000b"+
		"\u0000\u0000\u0159\u015a\u0003\u0018\f\u0000\u015a\u015b\u0005\f\u0000"+
		"\u0000\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u00f8\u0001\u0000\u0000"+
		"\u0000\u015c\u00fb\u0001\u0000\u0000\u0000\u015c\u00fd\u0001\u0000\u0000"+
		"\u0000\u015c\u0100\u0001\u0000\u0000\u0000\u015c\u0106\u0001\u0000\u0000"+
		"\u0000\u015c\u010c\u0001\u0000\u0000\u0000\u015c\u0112\u0001\u0000\u0000"+
		"\u0000\u015c\u011a\u0001\u0000\u0000\u0000\u015c\u0120\u0001\u0000\u0000"+
		"\u0000\u015c\u0128\u0001\u0000\u0000\u0000\u015c\u012e\u0001\u0000\u0000"+
		"\u0000\u015c\u012f\u0001\u0000\u0000\u0000\u015c\u0130\u0001\u0000\u0000"+
		"\u0000\u015c\u0131\u0001\u0000\u0000\u0000\u015c\u0132\u0001\u0000\u0000"+
		"\u0000\u015c\u0133\u0001\u0000\u0000\u0000\u015c\u013a\u0001\u0000\u0000"+
		"\u0000\u015c\u0141\u0001\u0000\u0000\u0000\u015c\u0146\u0001\u0000\u0000"+
		"\u0000\u015c\u0147\u0001\u0000\u0000\u0000\u015c\u014d\u0001\u0000\u0000"+
		"\u0000\u015c\u0158\u0001\u0000\u0000\u0000\u015d\u0178\u0001\u0000\u0000"+
		"\u0000\u015e\u015f\n\u001a\u0000\u0000\u015f\u0160\u0007\u0001\u0000\u0000"+
		"\u0160\u0177\u0003\u0018\f\u001b\u0161\u0162\n\u0019\u0000\u0000\u0162"+
		"\u0163\u0007\u0002\u0000\u0000\u0163\u0177\u0003\u0018\f\u001a\u0164\u0165"+
		"\n\u0017\u0000\u0000\u0165\u0166\u0007\u0003\u0000\u0000\u0166\u0177\u0003"+
		"\u0018\f\u0018\u0167\u0168\n\u0016\u0000\u0000\u0168\u0169\u0007\u0004"+
		"\u0000\u0000\u0169\u0177\u0003\u0018\f\u0017\u016a\u016b\n\u0015\u0000"+
		"\u0000\u016b\u016c\u0007\u0005\u0000\u0000\u016c\u0177\u0003\u0018\f\u0016"+
		"\u016d\u016e\n\u0014\u0000\u0000\u016e\u016f\u0005\u0002\u0000\u0000\u016f"+
		"\u0177\u0003\u0018\f\u0015\u0170\u0172\n\u001b\u0000\u0000\u0171\u0173"+
		"\u0003\u001a\r\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0173\u0174\u0001"+
		"\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0174\u0175\u0001"+
		"\u0000\u0000\u0000\u0175\u0177\u0001\u0000\u0000\u0000\u0176\u015e\u0001"+
		"\u0000\u0000\u0000\u0176\u0161\u0001\u0000\u0000\u0000\u0176\u0164\u0001"+
		"\u0000\u0000\u0000\u0176\u0167\u0001\u0000\u0000\u0000\u0176\u016a\u0001"+
		"\u0000\u0000\u0000\u0176\u016d\u0001\u0000\u0000\u0000\u0176\u0170\u0001"+
		"\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000\u0000\u0178\u0176\u0001"+
		"\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u0019\u0001"+
		"\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u017d\u0005"+
		"\u000b\u0000\u0000\u017c\u017e\u0003\u001c\u000e\u0000\u017d\u017c\u0001"+
		"\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0001"+
		"\u0000\u0000\u0000\u017f\u0183\u0005\f\u0000\u0000\u0180\u0181\u00053"+
		"\u0000\u0000\u0181\u0183\u0005;\u0000\u0000\u0182\u017b\u0001\u0000\u0000"+
		"\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0183\u001b\u0001\u0000\u0000"+
		"\u0000\u0184\u0189\u0003\u0018\f\u0000\u0185\u0186\u0005\u0007\u0000\u0000"+
		"\u0186\u0188\u0003\u0018\f\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188"+
		"\u018b\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189"+
		"\u018a\u0001\u0000\u0000\u0000\u018a\u001d\u0001\u0000\u0000\u0000\u018b"+
		"\u0189\u0001\u0000\u0000\u0000-!+25FTY\\botz\u0081\u008c\u0094\u009b\u00a0"+
		"\u00a8\u00ad\u00b3\u00bc\u00d6\u00e5\u00e9\u00ed\u00f0\u00f2\u00f6\u0104"+
		"\u010a\u0110\u0118\u011e\u0126\u012c\u0137\u014b\u0153\u015c\u0174\u0176"+
		"\u0178\u017d\u0182\u0189";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}