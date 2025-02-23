grammar Language;

program: dcl*;

dcl: varDcl | stmt;

varDcl: 'var' ID Types '=' expr ';';

stmt: 
	expr ';' # ExprStmt 
	| 'fmt.Println(' expr ')' ';' # PrintStmt
	|'{' dcl* '}' # BlockStmt
	| 'if' '(' expr ')' stmt ('else' stmt)? # IfStmt;


expr:
	'-' expr						# Negate
	| expr op = ('*' | '/') expr	# MulDiv
	| expr op = ('+' | '-') expr	# AddSub
	| expr op = ('>' | '<' | '>=' | '<=') expr # Relational
	| expr op = ('==' | '!=') expr 	# Equalitys
	| ID '=' expr					# Assign
	| BOOL							# Boolean
	| FLOAT							# Float
	| STRING						# String			
	| INT							# Int
	| RUNE							# Rune
	| ID							# Identifier
	| '(' expr ')'					# Parens;


Types: 'int' | 'float64' | 'string' | 'bool' | 'rune';
INT: [0-9]+;
BOOL: 'true'
	| 'false';
FLOAT: [0-9]+'.'[0-9]+;
STRING: '"' ~'"'* '"';
RUNE: '\'' (~['\\] | '\\' .) '\'';
WS: [ \t\r\n]+ -> skip;
ID: [a-zA-Z]+;
COMMENT
    : '//' ~[\r\n]*                // Comentarios de una sola línea
    | '/*' '*/' // Comentarios de múltiples líneas
    ; 