grammar Language;

program: dcl*;

dcl: varDcl | sliceDcl | shortSliceDcl | stmt | shortVarDcl | classDcl | funcDcl;

varDcl: 'var' ID Types ('=' expr)? (';')?;




sliceDcl: 'var' ID ('[' ']' Types | '=' '[' ']' Types '{' expr (',' expr)* '}' | '=' expr | '=' '{' expr (',' expr)* '}')? (';')?;

shortVarDcl: ID ':=' expr (';')?;

shortSliceDcl: ID ':=' '[' ']' Types '{' expr (',' expr)* '}' (';')?;

funcDcl: 'func' ID '(' params? ')' '{' dcl* '}';

classDcl: 'class' ID '{' classBody* '}';

classBody: varDcl | shortVarDcl | funcDcl;

params: ID (',' ID)*;

stmt: 
	expr (';')? # ExprStmt 
	| 'fmt.Println(' expr (',' expr)* ')' (';')? # PrintStmt
	| '{' dcl* '}' # BlockStmt
	| 'if'  expr  stmt ('else' stmt)? # IfStmt
	| 'while' '(' expr ')' stmt # WhileStmt
	| 'for' expr  stmt  # ForStmt
	| 'for' forInit ';' expr ';' expr stmt # ForStmtIni
	| 'switch' expr '{' stmt* '}' # SwitchStmt
    | 'case' expr ':' stmt # CaseStmt
    | 'default' ':' stmt # DefaultStmt
	| 'break' (';')? # BreakStmt
	| 'continue' (';')? # ContinueStmt
	| 'return' expr? (';')? # ReturnStmt
	;

forInit: shortVarDcl | expr;

expr:
	'-' expr									# Negate
	| '!' expr									# Not
	| expr call+  								# Calle
	| expr op = ('*' | '/' | '%') expr			# MulDiv
	| expr op = ('+' | '-') expr				# AddSub
	| ID op = ('+=' | '-=') expr 				# AddSubAssign
	| expr op = ('>' | '<' | '>=' | '<=') expr 	# Relational
	| expr op = ('==' | '!=') expr 				# Equalitys
	| expr op = ('&&' | '||') expr 				# Logical
	| expr '=' expr								# Assign
	| 'strconv.Atoi(' expr ')' (';')? 			# AtoiStmt
	| 'strconv.ParseFloat(' expr ')' (';')? 	# ParseFloatStmt
	| 'reflect.TypeOf(' expr ')' (';')? 		# TypeOfStmt
	| 'slices.Index(' expr ',' expr ')'  (';')?	# sliceIndex
	| 'strings.Join(' expr ', " ")' (';')?		# stringsJoin
	| 'append(' expr ',' expr ')' (';')?		# appendSlice
	| 'len(' expr ')' (';')?					# lenSlice	
	| BOOL										# Boolean
	| FLOAT										# Float
	| STRING									# String			
	| INT										# Int
	| RUNE										# Rune
	| 'new' ID '(' args? ')'					# New
	| ID '[' expr ']' '=' expr					# IndexAssig
	| ID '[' expr ']' 							# Index
	| ID										# Identifier
	| '[' expr ']' (';')? 						# brackets
    | '{' expr (',' expr)* '}'                  # SliceInit
	| '(' expr ')'								# Parens;

call: '(' args? ')' #FuncCall | '.' ID #Get;
args: expr (',' expr)*;

Types: 'int' | 'float64' | 'string' | 'bool' | 'rune' ;

// Tipos de datos
INT: [0-9]+;
BOOL: 'true'
	| 'false';
FLOAT: [0-9]+'.'[0-9]+;
STRING: '"' (ESC | ~["\\])* '"';
RUNE: '\'' (~['\\] | '\\' .) '\'';

// Secuencias de escape válidas
fragment ESC: '\\' ['"\\nrt];

WS: [ \t\r\n]+ -> skip; // Ignorar espacios en blanco
ID: [a-zA-Z] [a-zA-Z0-9]*; // Identificador
COMMENT : '//' ~[\r\n]*    -> skip;            // Comentarios de una sola línea
ML_COMMENT : '/*' .*? '*/' -> skip;  // Comentarios de múltiples líneas
