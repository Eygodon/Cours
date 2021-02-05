<?php
// selon qu'on est en mode console ou en mode navigateur
//define("CR", "\n");
define("CR", '<br />');

function boolStr($b)
{
    if ($b)
        return 'true';
    else
        return 'false';
}
?>
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

            for ($i = 0; $i < 10 ; $i++)
            {
                echo "ligne ". $i . " : ";
                afficheLigne($i);
            }

            function afficheLigne($numLigne)
            {
                for ($i = 0; $i < 10; $i++)
                    echo '<td>' . $numLigne * $i . "</td> ";
                echo "<br/>";
            }

            echo '<h2>Table de multiplication</h2>';
            echo '<table border = thin>';
            for ($i = 0; $i < 10; $i++)
            {
                echo '<tr>';
                echo '<td>ligne : ' . $i . '</td>';
                afficheLigne($i);
                echo '<tr/>';
            }
            echo '</table>';
            echo CR;

            $i = "miaou";
            affiche();
            function affiche()
            {
                global $i ;
                echo  $i. CR;
            }
            ?>
        </div>
    </body>
</html>