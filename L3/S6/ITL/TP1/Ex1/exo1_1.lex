%%
(0|1)+	{printf("\n Un nombre binaire [%s] \n", yytext) ;}
.  //permet de ne pas afficher ce qui ne fait pas partie du langage
