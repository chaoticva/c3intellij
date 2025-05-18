package org.c3lang.intellij.rewrite.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

import static org.c3lang.intellij.rewrite.psi.C3Types.*;

%%

%class C3Lexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%states DOC_COMMENT

%%

"faultdef" { return KW_FAULTDEF; }
"module"   { return KW_MODULE;   }
"import"   { return KW_IMPORT;   }
"extern"   { return KW_EXTERN;   }
"return"   { return KW_RETURN;   }
"inline"   { return KW_INLINE;   }
"struct"   { return KW_STRUCT;   }
"union"    { return KW_UNION;    }
"macro"    { return KW_MACRO;    }
"const"    { return KW_CONST;    }
"enum"     { return KW_ENUM;     }
"fn"       { return KW_FN;       }

"$if"    { return KW_COMP_IF;    }
"else"   { return KW_COMP_ELSE;  }
"$endif" { return KW_COMP_ENDIF; }

"!=" { return NOT_EQUAL; }
"==" { return IS_EQUAL;  }
"<=" { return LTE;       }
">=" { return GTE;       }
"<"  { return LT;        }
">"  { return GT;        }

<YYINITIAL> "<*" {
    yybegin(DOC_COMMENT);
    return DOC_START;
}
<DOC_COMMENT> {
    "*>"  { yybegin(YYINITIAL); return DOC_END; }

    "@deprecated" { return KW_DOC_DEPRECATED; }
    "@require"    { return KW_DOC_REQUIRE; }
    "@ensure"     { return KW_DOC_ENSURE; }
    "@return"     { return KW_DOC_RETURN; }
    "@param"      { return KW_DOC_PARAM; }
    "@pure"       { return KW_DOC_PURE; }

    [$#a-zA-Z_][a-zA-Z0-9_]* { return IDENTIFIER;            }
    \"([^\"\\]|\\.)*\"       { return STRING;                }
    ":"                      { return COLON;                 }
    ([^*>]|\*[^>])+          { return TEXT;                  }
    [ \t\n\r]+               { return TokenType.WHITE_SPACE; }
}

"::" { return PATH_SEPARATOR; }
"=>" { return ARROW;          }
"!!" { return PANIC;          }
";"  { return SEMICOLON;      }
"&"  { return AMPERSAND;      }
"["  { return LBRACKET;       }
"]"  { return RBRACKET;       }
"."  { return PERIOD;         }
"("  { return LPAREN;         }
")"  { return RPAREN;         }
"{"  { return LBRACE;         }
"}"  { return RBRACE;         }
"="  { return EQUALS;         }
","  { return COMMA;          }
":"  { return COLON;          }
"?"  { return FAULT;          }
"!"  { return BANG;           }

@[a-z]+                { return ATTRIBUTE_NAME; }
[$#a-zA-Z][a-zA-Z_\d]* { return IDENTIFIER;     }

\"(([^\"\\]|\\.)*)\"|`(([^`\\]|\\.)*)` { return STRING;  }
'[^']'                                 { return CHAR;    }
[\d]([xX]?[\da-fA-F]*)?                { return INTEGER; }

"//"[^\n\r]* { return LINE_COMMENT; }

[\ \n\t\f]+ { return TokenType.WHITE_SPACE;   }
[^]         { return TokenType.BAD_CHARACTER; }