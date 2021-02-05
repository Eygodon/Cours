<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP4</title>
    </head>
    <body>
        <h1>Exercice 3.g</h1>

        <div>
            <?php
            define('CR', '<br/>');
            $capitale_France = 'Paris';
            $capitale_Espagne = 'Madrid';
            $capitale_Italie = 'Rome';
            $choix = 'France';
            echo "La capitale de ". $choix. " est ". ${'capitale_'. $choix}. CR;
            ?>
        </div>
    </body>
</html>