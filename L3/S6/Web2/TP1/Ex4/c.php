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
            function carre_decalage($sqr, $d = 0)
            {
                return $sqr * $sqr + $d;
            }
            echo carre_decalage(5). CR;
            echo carre_decalage(5,5);
            ?>
        </div>
    </body>
</html>