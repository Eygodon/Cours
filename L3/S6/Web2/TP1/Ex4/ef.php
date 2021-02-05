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
            function facto ($i, $res = 1){
                if ($i == 0)
                    return $res;
                else
                    return facto($i-1, $res * $i);
            }
            echo facto(6);
            $func = 'facto';
            $toFact = 10;
            echo CR. "La factorielle de ". $toFact ." est ". $func($toFact)
            ?>
        </div>
    </body>
</html>