<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP4</title>
    </head>
    <body>
        <h1>Ex4.a</h1>

        <div>
            <?php
            define('CR', '<br/>');
            $a = 69;
            $b = $a;
            $b = 420;
            echo $a;
            unset($a);
            unset($b);

            echo CR;
            $a = 69;
            $b = &$a;
            $b = 420;
            echo $a;
            unset($a);
            unset($b);

            echo CR;
            $a = array("paris", "swamp");
            $b = $a;
            $b[2] = "Shrek";
            print_r($a);
            unset($a);
            unset($b);

            echo CR;
            $a = array("paris", "swamp");
            $b = &$a;
            $b[2] = "Shrek";
            print_r($a);
            unset($a);
            unset($b);

            echo CR;
            $a = array("paris", "swamp");
            $b = &$a;
            $c = 123;
            $b = $c;
            print_r($a);
            unset($a);
            unset($b);
            ?>
        </div>
    </body>
</html>