grammar Language;

program: dcl*;

dcl: varDcl | stmt;

varDcl: 'var' ID Types ('=' expr)? ';';

stmt: 
	expr ';' # ExprStmt 
	| 'fmt.Println(' expr ')' ';' # PrintStmt
	|'{' dcl* '}' # BlockStmt
	| 'if' '(' expr ')' stmt ('else' stmt)? # IfStmt
	| 'while' '(' expr ')' stmt # WhileStmt;


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
	| BOOL							# Boolean
	| FLOAT							# Float
	| STRING						# String			
	| INT							# Int
	| RUNE							# Rune
	| ID							# Identifier
	| '(' expr ')'					# Parens;


Types: 'int' | 'float64' | 'string' | 'bool' | 'rune';

// Tipos de datos
INT: [0-9]+;
BOOL: 'true'
	| 'false';
FLOAT: [0-9]+'.'[0-9]+;
STRING: '"' ~'"'* '"';
RUNE: '\'' (~['\\] | '\\' .) '\'';

escapeSequence: '\\' ('"' | '\\' | 'n' | 'r' | 't');


WS: [ \t\r\n]+ -> skip; // Ignorar espacios en blanco
ID: [a-zA-Z]+; // Identificador
COMMENT
    : '//' ~[\r\n]*                // Comentarios de una sola línea
    | '/*' '*/' // Comentarios de múltiples líneas
    ; 