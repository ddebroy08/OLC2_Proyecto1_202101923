grammar Language;

program: dcl*;

dcl: varDcl | stmt | shortVarDcl;

varDcl: 'var' ID Types ('=' expr)? (';')?;

shortVarDcl: ID ':=' expr (';')?;

stmt: 
	expr (';')? # ExprStmt 
	| 'fmt.Println(' expr (',' expr)* ')' (';')? # PrintStmt
	| '{' dcl* '}' # BlockStmt
	| 'if' '(' expr ')' stmt ('else' stmt)? # IfStmt
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
	'-' expr						# Negate
	| '!' expr						# Not
	| expr op = ('*' | '/' | '%') expr	# MulDiv
	| expr op = ('+' | '-') expr	# AddSub
	| ID op = ('+=' | '-=') expr 	# AddSubAssign
	| expr op = ('>' | '<' | '>=' | '<=') expr # Relational
	| expr op = ('==' | '!=') expr 	# Equalitys
	| expr op = ('&&' | '||') expr 	# Logical
	| ID '=' expr					# Assign
	| 'strconv.Atoi(' expr ')' (';')? # AtoiStmt
	| 'strconv.ParseFloat(' expr ')' (';')? # ParseFloatStmt
	| 'reflect.TypeOf(' expr ')' (';')? # TypeOfStmt
	| BOOL							# Boolean
	| FLOAT							# Float
	| STRING						# String			
	| INT							# Int
	| RUNE							# Rune
	| ID							# Identifier
	| '[' expr ']' (';')? 			# brackets
	| '(' expr ')'					# Parens;


Types: 'int' | 'float64' | 'string' | 'bool' | 'rune';

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
ID: [a-zA-Z]+; // Identificador
COMMENT : '//' ~[\r\n]*    -> skip;            // Comentarios de una sola línea
ML_COMMENT : '/*' .*? '*/' -> skip;  // Comentarios de múltiples líneas
