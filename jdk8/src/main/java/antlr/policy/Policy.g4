grammar Policy;

@lexer::members {
  protected boolean enumIsKeyword = true;
  protected boolean assertIsKeyword = true;
}
/** The start rule; beginparsing here. */
compilationUnit
    :   createDeclaration NEWLINE?
         withDeclaration NEWLINE
         whenDeclaration NEWLINE?
         whenExprDeclaration NEWLINE
//         thenDeclaration NEWLINE
//         thenExprDeclaration NEWLINE
//        EOF
    ;
// # 之后是自定义 visitor 方法
createDeclaration
    :   'create' Identifier    # create
    ;
withDeclaration
    :   'with' Identifier ',' Identifier ',' Identifier   # with
    ;
whenDeclaration
    :   'when'             # when
    ;


whenExprDeclaration
    :   '(' expression ')'                           # whenExpr
    ;
//
//thenDeclaration
//    :   'then'             # then
//    ;
//
//thenExprDeclaration
//    : 'message'      anytext                     # thenMsg
//    | 'return'       anytext                       # thenReturn
//    ;
//
expression
    : primary # primaryProc
    | expression op=('<=' | '>=' | '>' | '<'|'=' | '!=') expression # logicOp
    |   expression ('==' | '!=') expression                 # equalsOrNot
    //|   expression op=('+'|'-'|'*'|'/'|'%') expression     # mathOp
//    |   ID                                                # identifier
    |   expression 'and' expression                          # and
    |   expression 'or' expression                          # or
//    | NEWLINE                                               # blanke
    ;
//
primary
    :   '(' expression ')'
    |   literal
    |   Identifier
    ;

literal
    :   integerLiteral
//    |   FloatingPointLiteral
//    |   CharacterLiteral
    |   StringLiteral
    |   booleanLiteral
    |   'null'
    ;

integerLiteral
    :   DecimalLiteral
    ;

booleanLiteral
    :   'true'
    |   'false'
    ;
//
//
//
//FloatingPointLiteral
//    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
//    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
//    |   ('0'..'9')+ Exponent FloatTypeSuffix?
//    |   ('0'..'9')+ FloatTypeSuffix
//    |   ('0x' | '0X') (HexDigit )*
//        ('.' (HexDigit)*)?
//        ( 'p' | 'P' )
//        ( '+' | '-' )?
//        ( '0' .. '9' )+
//        FloatTypeSuffix?
//     ;
//
fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;
//
//fragment
//Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
//
//fragment
//FloatTypeSuffix : ('f'|'F'|'d'|'D') ;
//
//
StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

Identifier
    :   Letter (Letter|JavaIDDigit)*
    ;

fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

//DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;
//
//fragment
//IntegerTypeSuffix : ('l'|'L') ;
//
//comment : '//' anytext;
//
//anytext: ANY*;
//ANY : (. | '"' | '{' | '}');
//
//ID : ('a' .. 'z' | 'A' .. 'Z' | '\u4E00'..'\u9FA5' | '\uF900'..'\uFA2D')+ ; // matchidentifiers
//INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ;//return newlinesto parser(end-statement signal)
//MUL : '*' ;
//DIV : '/' ;
//ADD : '+' ;
//SUB : '-' ;
//AND : 'and' ;
//GT : '>' ;
//GTE : '>=' ;
//LT : '<' ;
//PARAMETER : 'PARAMETER';

WS : [ \t\r\n]+ -> skip ;
