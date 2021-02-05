<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP4</title>
    </head>
    <body>

        <h1>exo 3</h1>

        <p>
            <?php
            function adder($a, $b)
            {
                return $a + $b;
            }

            function boolStr($b)
            {

                if ($b)
                    return 'true';
                else
                    return 'false';

            }

            function comparer($a, $b)
            {
                echo 'DEBUT DE LA PROCEDURE <br />';
                echo "Type de a : ". gettype($a). "<br/> Type de B : ". gettype($b)."<br/>";
                echo "$a  == $b  : ". boolStr($a == $b). "<br/>";
                echo "$a === $b : ". boolStr($a === $b). "<br/>";
                echo "<br/>";
            }


            $x = "123";
            $y = "654";

            echo adder($x, $y);
            echo "<br/>";
            /*
                         * "123" + "654"  = 777
                         * "123" + "aaa"  = warning(non-numeric value) + "123"
                         * "123" + "1aaa" = warning(non well formed numeric value) + 124
                         * "aaa1" + "123" = warning (non numeric value) + 123
                         * si différents que des chiffres alors warnings(non numeric) *2
            */

            $a = 123;
            $b = 123;
            echo comparer($a, $b);

            $a = 123;
            $b = '123';
            echo comparer($a, $b);

            $a = 123;
            $b = "miaou";
            echo comparer($a, $b);

            $a = 123;
            $b = "123miaou";
            echo comparer($a, $b);

            $a = 0;
            $b = "123miaou";
            echo comparer($a, $b);

            $a = 0;
            $b = "miaou";
            echo comparer($a, $b);

            $a = "123";
            $b = "123d0";
            echo comparer($a, $b);

            $a = "123";
            $b = "123e0";
            echo comparer($a, $b);
            //==
            if (1 == "miaou")
                echo "il y a un problème (1 == 'miaou') ?<br />";
            if (0 == "miaou")
                echo "il y a un problème (0 == 'miaou') ?<br />";

            ?>
        </p>
        <code>==</code> compare les valeurs et si on a un argument de type numérique
        et un autre de type chaîne, alors la chaîne est transformée en nombre.<br />
        <code>===</code> compare les valeurs et les types. Il faut que les deux
        concordent.<br />
    </body>
</html>
