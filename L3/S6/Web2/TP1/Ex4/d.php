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
            define("CR", '<br/>');
            function magik ($var = 0 ){
                return array($var+1, $var+2, $var+3);
            }
            list($a, $b, $c) = magik(50);
            echo  $a . CR. $b . CR. $c
            ?>
        </div>
    </body>
</html>