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
                function tab_with_print_r ($tab){
                    echo'<pre>'. print_r($tab, true). '</pre>'. CR;
                }

                function tab_print_for ($tab){
                    echo '<table border="4">';
                    for ($i = 0; $i < count($tab); $i++)
                        echo '<tr><td>'. $i. '</td><td>'. $tab[$i]. '</td></tr>';
                    echo '</table>';
                }

                function tab_print_foreach ($tab){
                    echo '<table border="4">';
                    foreach ($tab as $key => $value)
                        echo '<tr><td>'. $key. '</td><td>'. $value. '</td></tr>';
                    echo '</table>';
                }

                $villes = array('Paris', 'Bordeaux', 'Kyoto');

                $villes[] = 123;
                $villes[] = true;

                //unset($villes[1]);
                //unset($villes[3]);

                $villes[] = "Hello !";
                $villes[10] = 'v';
                tab_with_print_r($villes);
                tab_print_for($villes);
                tab_print_foreach($villes);

                echo '<h2> Array values </h2>';
                $villesBis = array_values($villes);
                tab_with_print_r($villesBis);
                tab_print_for($villesBis);
                tab_print_foreach($villesBis);

                echo '<h2> Array keys </h2>';
                $villesBis = array_keys($villes);
                tab_with_print_r($villesBis);
                tab_print_for($villesBis);
                tab_print_foreach($villesBis);

                echo '<h2> Exercice F </h2>';
                $villes["six"] = "666";
                $villes["7"] = 420;
                tab_with_print_r($villes);
                tab_print_for($villes);
                tab_print_foreach($villes);

                echo '<h2> Array values </h2>';
                $villesBis = array_values($villes);
                tab_with_print_r($villesBis);
                tab_print_for($villesBis);
                tab_print_foreach($villesBis);

                echo '<h2> Array keys </h2>';
                $villesBis = array_keys($villes);
                tab_with_print_r($villesBis);
                tab_print_for($villesBis);
                tab_print_foreach($villesBis);

                echo '<h2> nouveau tableau</h2>';
                $villesChaines = array( 'France'   => 'Paris',
                                        'Spain'  => 'Madrid',
                                        'Denmark' => 'Copenhagen');
                tab_with_print_r($villesChaines);
                tab_print_for($villesChaines);
                tab_print_foreach($villesChaines);

                echo '<h2> Travail sur un string </h2>';
                echo  $string = "Pencroff et Ayrton procédèrent aux préparatifs du lancement";
                echo  CR;
                echo  $stringbis = str_replace(" ", "/", $string, $count);
                echo CR;
                echo  'Il y a '. $count. ' espaces dans la phrase'. CR;
                echo $stringbis = explode(" ", $string,10);
                echo  CR;
                echo $stringbis= implode("/", $stringbis);
            ?>
        </div>
    </body>
</html>
