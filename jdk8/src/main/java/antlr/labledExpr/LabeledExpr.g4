grammar LabeledExpr;

/** The start rule; beginparsing here. */
prog:stat+;

// # 之后是自定义 visitor 方法
stat: expr NEWLINE         # printExpr
  | ID '=' expr NEWLINE    # assign
  | 'clear'                # clear
  | NEWLINE                # blank
  ;

expr:expr op=(MUL|DIV) expr       # MulDiv
  | expr op=(ADD|SUB) expr        # AddSub
  | INT                           # int
  | ID                            # id
  | '(' expr ')'                  # parens
  ;

ID : ('a' .. 'z' | 'A' .. 'Z' | '\u4E00'..'\u9FA5' | '\uF900'..'\uFA2D')+ ; // matchidentifiers
INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ;//return newlinesto parser(end-statement signal)
WS : [ \t\r\n]+ -> skip ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;