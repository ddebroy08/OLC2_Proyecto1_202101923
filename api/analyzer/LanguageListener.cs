//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.13.2
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from Language.g4 by ANTLR 4.13.2

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

namespace analyzer {
using Antlr4.Runtime.Misc;
using IParseTreeListener = Antlr4.Runtime.Tree.IParseTreeListener;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete listener for a parse tree produced by
/// <see cref="LanguageParser"/>.
/// </summary>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.2")]
[System.CLSCompliant(false)]
public interface ILanguageListener : IParseTreeListener {
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterProgram([NotNull] LanguageParser.ProgramContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitProgram([NotNull] LanguageParser.ProgramContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.dcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterDcl([NotNull] LanguageParser.DclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.dcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitDcl([NotNull] LanguageParser.DclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.varDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterVarDcl([NotNull] LanguageParser.VarDclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.varDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitVarDcl([NotNull] LanguageParser.VarDclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.sliceDclMultidimensional"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterSliceDclMultidimensional([NotNull] LanguageParser.SliceDclMultidimensionalContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.sliceDclMultidimensional"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitSliceDclMultidimensional([NotNull] LanguageParser.SliceDclMultidimensionalContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.sliceDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterSliceDcl([NotNull] LanguageParser.SliceDclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.sliceDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitSliceDcl([NotNull] LanguageParser.SliceDclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.shortVarDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterShortVarDcl([NotNull] LanguageParser.ShortVarDclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.shortVarDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitShortVarDcl([NotNull] LanguageParser.ShortVarDclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.shortSliceDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterShortSliceDcl([NotNull] LanguageParser.ShortSliceDclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.shortSliceDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitShortSliceDcl([NotNull] LanguageParser.ShortSliceDclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.funcDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterFuncDcl([NotNull] LanguageParser.FuncDclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.funcDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitFuncDcl([NotNull] LanguageParser.FuncDclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.structDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterStructDcl([NotNull] LanguageParser.StructDclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.structDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitStructDcl([NotNull] LanguageParser.StructDclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.structInit"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterStructInit([NotNull] LanguageParser.StructInitContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.structInit"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitStructInit([NotNull] LanguageParser.StructInitContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.structField"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterStructField([NotNull] LanguageParser.StructFieldContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.structField"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitStructField([NotNull] LanguageParser.StructFieldContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.structAttribute"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterStructAttribute([NotNull] LanguageParser.StructAttributeContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.structAttribute"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitStructAttribute([NotNull] LanguageParser.StructAttributeContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.classDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterClassDcl([NotNull] LanguageParser.ClassDclContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.classDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitClassDcl([NotNull] LanguageParser.ClassDclContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.classBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterClassBody([NotNull] LanguageParser.ClassBodyContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.classBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitClassBody([NotNull] LanguageParser.ClassBodyContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.params"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterParams([NotNull] LanguageParser.ParamsContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.params"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitParams([NotNull] LanguageParser.ParamsContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.row"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRow([NotNull] LanguageParser.RowContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.row"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRow([NotNull] LanguageParser.RowContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>ExprStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterExprStmt([NotNull] LanguageParser.ExprStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>ExprStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitExprStmt([NotNull] LanguageParser.ExprStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>PrintStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterPrintStmt([NotNull] LanguageParser.PrintStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>PrintStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitPrintStmt([NotNull] LanguageParser.PrintStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>BlockStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterBlockStmt([NotNull] LanguageParser.BlockStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>BlockStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitBlockStmt([NotNull] LanguageParser.BlockStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>IfStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterIfStmt([NotNull] LanguageParser.IfStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>IfStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitIfStmt([NotNull] LanguageParser.IfStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>WhileStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterWhileStmt([NotNull] LanguageParser.WhileStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>WhileStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitWhileStmt([NotNull] LanguageParser.WhileStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>ForStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterForStmt([NotNull] LanguageParser.ForStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>ForStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitForStmt([NotNull] LanguageParser.ForStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>ForStmtIni</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterForStmtIni([NotNull] LanguageParser.ForStmtIniContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>ForStmtIni</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitForStmtIni([NotNull] LanguageParser.ForStmtIniContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>ForRangeStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterForRangeStmt([NotNull] LanguageParser.ForRangeStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>ForRangeStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitForRangeStmt([NotNull] LanguageParser.ForRangeStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>SwitchStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterSwitchStmt([NotNull] LanguageParser.SwitchStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>SwitchStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitSwitchStmt([NotNull] LanguageParser.SwitchStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>BreakStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterBreakStmt([NotNull] LanguageParser.BreakStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>BreakStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitBreakStmt([NotNull] LanguageParser.BreakStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>ContinueStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterContinueStmt([NotNull] LanguageParser.ContinueStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>ContinueStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitContinueStmt([NotNull] LanguageParser.ContinueStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>ReturnStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterReturnStmt([NotNull] LanguageParser.ReturnStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>ReturnStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitReturnStmt([NotNull] LanguageParser.ReturnStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>CaseStmt</c>
	/// labeled alternative in <see cref="LanguageParser.switchCase"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterCaseStmt([NotNull] LanguageParser.CaseStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>CaseStmt</c>
	/// labeled alternative in <see cref="LanguageParser.switchCase"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitCaseStmt([NotNull] LanguageParser.CaseStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>DefaultStmt</c>
	/// labeled alternative in <see cref="LanguageParser.switchCase"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterDefaultStmt([NotNull] LanguageParser.DefaultStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>DefaultStmt</c>
	/// labeled alternative in <see cref="LanguageParser.switchCase"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitDefaultStmt([NotNull] LanguageParser.DefaultStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.forInit"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterForInit([NotNull] LanguageParser.ForInitContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.forInit"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitForInit([NotNull] LanguageParser.ForInitContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>New</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterNew([NotNull] LanguageParser.NewContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>New</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitNew([NotNull] LanguageParser.NewContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>MultiIndexAssig</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterMultiIndexAssig([NotNull] LanguageParser.MultiIndexAssigContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>MultiIndexAssig</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitMultiIndexAssig([NotNull] LanguageParser.MultiIndexAssigContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>MulDiv</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterMulDiv([NotNull] LanguageParser.MulDivContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>MulDiv</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitMulDiv([NotNull] LanguageParser.MulDivContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Parens</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterParens([NotNull] LanguageParser.ParensContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Parens</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitParens([NotNull] LanguageParser.ParensContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Logical</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterLogical([NotNull] LanguageParser.LogicalContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Logical</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitLogical([NotNull] LanguageParser.LogicalContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>String</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterString([NotNull] LanguageParser.StringContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>String</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitString([NotNull] LanguageParser.StringContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>stringsJoin</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterStringsJoin([NotNull] LanguageParser.StringsJoinContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>stringsJoin</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitStringsJoin([NotNull] LanguageParser.StringsJoinContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>AtoiStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterAtoiStmt([NotNull] LanguageParser.AtoiStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>AtoiStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitAtoiStmt([NotNull] LanguageParser.AtoiStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Int</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterInt([NotNull] LanguageParser.IntContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Int</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitInt([NotNull] LanguageParser.IntContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Identifier</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterIdentifier([NotNull] LanguageParser.IdentifierContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Identifier</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitIdentifier([NotNull] LanguageParser.IdentifierContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>AddSubAssign</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterAddSubAssign([NotNull] LanguageParser.AddSubAssignContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>AddSubAssign</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitAddSubAssign([NotNull] LanguageParser.AddSubAssignContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Boolean</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterBoolean([NotNull] LanguageParser.BooleanContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Boolean</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitBoolean([NotNull] LanguageParser.BooleanContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>SliceInit</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterSliceInit([NotNull] LanguageParser.SliceInitContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>SliceInit</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitSliceInit([NotNull] LanguageParser.SliceInitContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Equalitys</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterEqualitys([NotNull] LanguageParser.EqualitysContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Equalitys</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitEqualitys([NotNull] LanguageParser.EqualitysContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>AddSub</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterAddSub([NotNull] LanguageParser.AddSubContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>AddSub</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitAddSub([NotNull] LanguageParser.AddSubContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>DecrementStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterDecrementStmt([NotNull] LanguageParser.DecrementStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>DecrementStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitDecrementStmt([NotNull] LanguageParser.DecrementStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>TypeOfStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterTypeOfStmt([NotNull] LanguageParser.TypeOfStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>TypeOfStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitTypeOfStmt([NotNull] LanguageParser.TypeOfStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Relational</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRelational([NotNull] LanguageParser.RelationalContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Relational</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRelational([NotNull] LanguageParser.RelationalContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>MultiIndex</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterMultiIndex([NotNull] LanguageParser.MultiIndexContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>MultiIndex</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitMultiIndex([NotNull] LanguageParser.MultiIndexContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>ParseFloatStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterParseFloatStmt([NotNull] LanguageParser.ParseFloatStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>ParseFloatStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitParseFloatStmt([NotNull] LanguageParser.ParseFloatStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>brackets</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterBrackets([NotNull] LanguageParser.BracketsContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>brackets</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitBrackets([NotNull] LanguageParser.BracketsContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>lenSlice</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterLenSlice([NotNull] LanguageParser.LenSliceContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>lenSlice</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitLenSlice([NotNull] LanguageParser.LenSliceContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Float</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterFloat([NotNull] LanguageParser.FloatContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Float</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitFloat([NotNull] LanguageParser.FloatContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Not</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterNot([NotNull] LanguageParser.NotContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Not</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitNot([NotNull] LanguageParser.NotContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>sliceIndex</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterSliceIndex([NotNull] LanguageParser.SliceIndexContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>sliceIndex</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitSliceIndex([NotNull] LanguageParser.SliceIndexContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Assign</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterAssign([NotNull] LanguageParser.AssignContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Assign</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitAssign([NotNull] LanguageParser.AssignContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Calle</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterCalle([NotNull] LanguageParser.CalleContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Calle</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitCalle([NotNull] LanguageParser.CalleContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Negate</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterNegate([NotNull] LanguageParser.NegateContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Negate</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitNegate([NotNull] LanguageParser.NegateContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>IncrementStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterIncrementStmt([NotNull] LanguageParser.IncrementStmtContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>IncrementStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitIncrementStmt([NotNull] LanguageParser.IncrementStmtContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Rune</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRune([NotNull] LanguageParser.RuneContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Rune</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRune([NotNull] LanguageParser.RuneContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>appendSlice</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterAppendSlice([NotNull] LanguageParser.AppendSliceContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>appendSlice</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitAppendSlice([NotNull] LanguageParser.AppendSliceContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>FuncCall</c>
	/// labeled alternative in <see cref="LanguageParser.call"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterFuncCall([NotNull] LanguageParser.FuncCallContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>FuncCall</c>
	/// labeled alternative in <see cref="LanguageParser.call"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitFuncCall([NotNull] LanguageParser.FuncCallContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>Get</c>
	/// labeled alternative in <see cref="LanguageParser.call"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterGet([NotNull] LanguageParser.GetContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>Get</c>
	/// labeled alternative in <see cref="LanguageParser.call"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitGet([NotNull] LanguageParser.GetContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="LanguageParser.args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterArgs([NotNull] LanguageParser.ArgsContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="LanguageParser.args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitArgs([NotNull] LanguageParser.ArgsContext context);
}
} // namespace analyzer
