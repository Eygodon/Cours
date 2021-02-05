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
            function tab_print_foreach ($tab){
                echo '<table border="4">';
                foreach ($tab as $key => $value)
                    echo '<tr><td>'. $key. '</td><td>'. $value. '</td></tr>';
                echo '</table>';
            }
            echo function_exists("tab_print_foreach") . CR;
            $tabl[] = get_defined_functions();
            print_r($tabl);
            ?>
        </div>
    </body>
</html>