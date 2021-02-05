<DOCTYPE = <!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>TP5</title>
    </head>
    <body>
        <h1>Exercice 3</h1>
        <div>
            <?php
            define('CR', '<br/>');
            function tab_print_foreach ($tab){
                echo '<table border="4">';
                foreach ($tab as $key => $value)
                    echo '<tr><td>'. $key. '</td><td>'. $value. '</td></tr>';
                echo '</table>';
            }
            echo "affichage de _SERVER ". tab_print_foreach($_SERVER) .CR. CR;
            echo "affichage de _ENV ". print_r($_ENV) .CR. CR;
            echo "affichage de _REQUEST ". print_r($_REQUEST) .CR. CR;
            echo "affichage de _SESSION ". print_r($_SESSION) .CR. CR;
            echo "affichage de _COOKIE ". print_r($_COOKIE) .CR. CR;
            echo "affichage de _POST ". print_r($_POST) .CR. CR;
            echo "affichage de _GET ". print_r($_GET) .CR.CR;
            echo "affichage de _FILES ". print_r($_FILES) .CR.CR;
            echo "affichage de GLOBALS ". print_r($GLOBALS) .CR.CR;
            phpinfo();
            ?>
        </div>
    </body>
</html>