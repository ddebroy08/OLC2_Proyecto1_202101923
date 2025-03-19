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
using Antlr4.Runtime.Tree;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete generic visitor for a parse tree produced
/// by <see cref="LanguageParser"/>.
/// </summary>
/// <typeparam name="Result">The return type of the visit operation.</typeparam>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.2")]
[System.CLSCompliant(false)]
public interface ILanguageVisitor<Result> : IParseTreeVisitor<Result> {
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitProgram([NotNull] LanguageParser.ProgramContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.dcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDcl([NotNull] LanguageParser.DclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.varDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitVarDcl([NotNull] LanguageParser.VarDclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.sliceDclMultidimensional"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSliceDclMultidimensional([NotNull] LanguageParser.SliceDclMultidimensionalContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.sliceDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSliceDcl([NotNull] LanguageParser.SliceDclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.shortVarDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitShortVarDcl([NotNull] LanguageParser.ShortVarDclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.shortSliceDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitShortSliceDcl([NotNull] LanguageParser.ShortSliceDclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.funcDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFuncDcl([NotNull] LanguageParser.FuncDclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.structDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStructDcl([NotNull] LanguageParser.StructDclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.structInit"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStructInit([NotNull] LanguageParser.StructInitContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.structField"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStructField([NotNull] LanguageParser.StructFieldContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.structAttribute"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStructAttribute([NotNull] LanguageParser.StructAttributeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.classDcl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassDcl([NotNull] LanguageParser.ClassDclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.classBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassBody([NotNull] LanguageParser.ClassBodyContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.params"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitParams([NotNull] LanguageParser.ParamsContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.row"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRow([NotNull] LanguageParser.RowContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ExprStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExprStmt([NotNull] LanguageParser.ExprStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>PrintStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitPrintStmt([NotNull] LanguageParser.PrintStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>BlockStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBlockStmt([NotNull] LanguageParser.BlockStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>IfStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIfStmt([NotNull] LanguageParser.IfStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>WhileStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitWhileStmt([NotNull] LanguageParser.WhileStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ForStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForStmt([NotNull] LanguageParser.ForStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ForStmtIni</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForStmtIni([NotNull] LanguageParser.ForStmtIniContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>SwitchStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSwitchStmt([NotNull] LanguageParser.SwitchStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>CaseStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitCaseStmt([NotNull] LanguageParser.CaseStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>DefaultStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDefaultStmt([NotNull] LanguageParser.DefaultStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>BreakStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBreakStmt([NotNull] LanguageParser.BreakStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ContinueStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitContinueStmt([NotNull] LanguageParser.ContinueStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ReturnStmt</c>
	/// labeled alternative in <see cref="LanguageParser.stmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitReturnStmt([NotNull] LanguageParser.ReturnStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.forInit"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForInit([NotNull] LanguageParser.ForInitContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>New</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNew([NotNull] LanguageParser.NewContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>MultiIndexAssig</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMultiIndexAssig([NotNull] LanguageParser.MultiIndexAssigContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>MulDiv</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMulDiv([NotNull] LanguageParser.MulDivContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Parens</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitParens([NotNull] LanguageParser.ParensContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Logical</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLogical([NotNull] LanguageParser.LogicalContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Index</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIndex([NotNull] LanguageParser.IndexContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>String</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitString([NotNull] LanguageParser.StringContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>stringsJoin</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStringsJoin([NotNull] LanguageParser.StringsJoinContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>AtoiStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAtoiStmt([NotNull] LanguageParser.AtoiStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Int</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitInt([NotNull] LanguageParser.IntContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Identifier</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIdentifier([NotNull] LanguageParser.IdentifierContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>AddSubAssign</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAddSubAssign([NotNull] LanguageParser.AddSubAssignContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Boolean</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBoolean([NotNull] LanguageParser.BooleanContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>SliceInit</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSliceInit([NotNull] LanguageParser.SliceInitContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Equalitys</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEqualitys([NotNull] LanguageParser.EqualitysContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>AddSub</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAddSub([NotNull] LanguageParser.AddSubContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>TypeOfStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeOfStmt([NotNull] LanguageParser.TypeOfStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Relational</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRelational([NotNull] LanguageParser.RelationalContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>MultiIndex</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMultiIndex([NotNull] LanguageParser.MultiIndexContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ParseFloatStmt</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitParseFloatStmt([NotNull] LanguageParser.ParseFloatStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>brackets</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBrackets([NotNull] LanguageParser.BracketsContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>lenSlice</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLenSlice([NotNull] LanguageParser.LenSliceContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Float</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFloat([NotNull] LanguageParser.FloatContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Not</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNot([NotNull] LanguageParser.NotContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>sliceIndex</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSliceIndex([NotNull] LanguageParser.SliceIndexContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Assign</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAssign([NotNull] LanguageParser.AssignContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Calle</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitCalle([NotNull] LanguageParser.CalleContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Negate</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNegate([NotNull] LanguageParser.NegateContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Rune</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRune([NotNull] LanguageParser.RuneContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>appendSlice</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAppendSlice([NotNull] LanguageParser.AppendSliceContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>IndexAssig</c>
	/// labeled alternative in <see cref="LanguageParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIndexAssig([NotNull] LanguageParser.IndexAssigContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>FuncCall</c>
	/// labeled alternative in <see cref="LanguageParser.call"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFuncCall([NotNull] LanguageParser.FuncCallContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>Get</c>
	/// labeled alternative in <see cref="LanguageParser.call"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitGet([NotNull] LanguageParser.GetContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="LanguageParser.args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArgs([NotNull] LanguageParser.ArgsContext context);
}
} // namespace analyzer
