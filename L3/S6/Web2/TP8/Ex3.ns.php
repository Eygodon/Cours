<?php
namespace
{
    const CTE = "Deus";

    function f()
    {
        printf("Avis<br/>");
    }
     class C
     {
        static function s()
        {
            printf("Dans");
        }
    }
}

namespace A
{
    const CTE = "lo";

    function f()
    {
        printf("de<br/>");
    }

    class C
    {
        static function s()
        {
            printf("La");
        }
    }
}

namespace A\B
{
    const CTE = "Vult";

    function f()
    {
        printf("Passage");
    }

    class C
    {
        static function s()
        {
            printf("Sauce");
        }
    }
    echo "<h2> Question sur les CTE </h2>";

    printf("Questions sur CTE de B<br/>");
    echo CTE. "<br/>";
    //echo B\CTE "erreur d'accès A\B\B"
    echo \A\B\CTE. "<br/>";

    printf("Questions sur CTE de A <br/>");
    //echo  CTE; prend B\CTE
    //echo A\CTE. "<br/>"; Undefined constant 'A\B\A\CTE'
    echo \A\CTE. "<br/>";

    printf("Questions sur CTE de global <br/>");
    //echo  CTE; prend B\CTE
    echo \CTE. "<br/>"; // ici relatif = absolu

    echo "<h2> Question sur les f </h2>";

    printf("Questions sur f de B<br/>");
    echo f(). "<br/>";
    //echo B\f(); //"erreur d'accès A\B\B"
    echo \A\B\f(). "<br/>";

    printf("Questions sur f de A <br/>");
    //echo  f() . "<br/>"; //prend A\CTE
    //echo A\f(). "<br/>";// Undefined function 'A\B\A\f()'
    echo \A\f(). "<br/>";

    printf("Questions sur f de global <br/>");
    //echo  f(); //prend B\f()
    echo \f(). "<br/>"; // ici relatif = absolu

    echo "<h2> Question sur les C </h2>";

    $cmd = 'C::s();';
    echo '   commande : ' . $cmd . "<br/>";
    echo '      -> ';
    C::s();

    $cmd = 'namespace\C::s();';
    echo '   commande : ' . $cmd . "<br/>";
    echo '      -> ';
    namespace\C::s();

    $cmd = '\A\B\C::s();';
    echo '   commande : ' . $cmd . "<br/>";
    echo '      -> ';
    \A\B\C::s();

    echo "<br/>" . '1.h ======= manipuler C de A =======' . "<br/>";

    echo '   non qualifiée : impossible.' . "<br/>";
    echo '   qualifiée relativement : impossible.' . "<br/>";
    $cmd = '\A\C::s();';
    echo '   commande : ' . $cmd . "<br/>";
    echo '      -> ';
    \A\C::s();

    echo "<br/>" . '1.i ======= manipuler C de global =======' . "<br/>";

    echo '   non qualifiée : impossible.' . "<br/>";
    echo '   qualifiée relativement : impossible.' . "<br/>";
    $cmd = '\C::s();';
    echo '   commande : ' . $cmd . "<br/>";
    echo '      -> ';
    \C::s();

}