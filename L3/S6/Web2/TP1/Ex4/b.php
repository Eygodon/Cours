<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>TP4</title>
    </head>
    <body>
        <h1>Ex4.b</h1>
        <div>
            <?php
            define('CR', '<br/>');

            echo '<h2>Test sur un entier</h2>';
            function modify ($var){
                $var += 1;
                return $var;
            }
            $temp = 100;
            echo "La variable vaut d'abord : ". $temp. CR;
            echo "La varibale modifiée vaut : ". modify($temp). CR;
            echo "La variable vaut maintenant : ".$temp. CR;

            echo '<h2>Test sur un tableau</h2>';

            function modify_arr ($tab){
                $tab[1] = "Berk je m'appelle Charmant";
                return $tab;
            }
            function tab_print_for ($tab){
                echo '<table border="4">';
                for ($i = 0; $i < count($tab); $i++)
                    echo '<tr><td>'. $i. '</td><td>'. $tab[$i]. '</td></tr>';
                echo '</table>';
            }

            $temp_tab = array("Shrek", "L'ane", "Fiona");
            echo "le tableau vaut d'abord :";
            tab_print_for($temp_tab);
            echo "Le tableau modifié vaut : ";
            echo tab_print_for(modify_arr($temp_tab)). CR;
            echo  "Le tableau vaut maintenant : ";
            tab_print_for($temp_tab);

            echo '<h2>Test par référence</h2>';

            function modify_ref(&$var){
                $var ++;
                return $var;
            }
            $test = 100;
            echo "Avant la variable vaut ".$test. CR;
            echo "La variable modifiée vaut ". modify_ref($test). CR;
            echo "La variable vaut maintenant ". $test. CR;
            //echo modify_ref(5);
            ?>
        </div>
    </body>
</html>