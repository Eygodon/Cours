<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP4</title>
    </head>
    <body>
        <h1>Exercice 3.c</h1>

        <div>
            <?php
            function boolStr($b)
            {
                if ($b)
                    return 'true';
                else
                    return 'false';
            }
            function varState ($var)
            {
                echo "La variable existe : ". boolStr(isset($var)). "<br/>";
                echo "La variable est null : ". boolStr(is_null($var)). "<br/>";
                echo "var == NULL : ". boolStr($var == NULL). "<br/>";
                echo "var === NULL : ". boolStr($var === NULL). "<br/>";
                echo "Valeur de la variable : ". $var. "<br/> <br/>";
            }
            varState($v);

            $v = "manger";
            varState($v);

            $v = null;
            varState($v);

            $v = "";
            varState($v);

            unset($v);
            varState($v);

            ?>
        </div>
    </body>
</html>