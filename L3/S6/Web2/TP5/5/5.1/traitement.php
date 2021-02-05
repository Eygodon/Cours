<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>
        <h1> Listing des différentes valeurs reçues par le script </h1>

        <p>
            L'affichage est violent dans le sens où on affiche toutes
            les valeurs des tableaux $_GET, $_POST, $_FILES.<br />
            Ce n'est pas à faire sur une page à accès public.
        </p>

        <h2> Affichage des valeurs par GET </h2>

        <p>
            Les valeurs reçues dans <code>$_GET</code> sont soit issues d'un
            formulaire envoyé en mode "get" (cas peu fréquent), soit passées
            directement dans l'URL (cas le plus fréquent). Par exemple&nbsp;:<br />
            <!--<a href="traitement.php?diplome=Licence&amp;mention=Informatique,%20Math%E9matique&amp;parcours=Informatique">essayez-moi</a>-->
            <a href="traitement.php?diplome=Licence&amp;mention=Informatique,%20Mathematique&amp;parcours=Informatique">essayez-moi</a>
            (notez que les accents, espace, ... sont interdits dans une URL).
        </p>

        <?php
            echo "<pre>" . htmlentities(print_r($_GET, true)) . "</pre>";       // voir l'utilité du paramètre "true", cf. http://php.net
        ?>

        <h2> Affichage des valeurs par POST </h2>

        <?php
            echo '<h2>avec <code>print_r</code></h2>';
            echo "<pre>" . htmlentities(print_r($_POST, true)) . "</pre>";      // voir l'utilité du paramètre "true", cf. http://php.net

            echo '<h2>avec <code>var_dump</code></h2>';
            echo "<pre>";
            var_dump($_POST);
            echo "</pre>";
        ?>

        <h2> Affichage des valeurs par FILES </h2>

        <?php
            echo "<pre>" . htmlentities(print_r($_FILES, true)) . "</pre>";
        ?>


        <h1> Accès à des valeurs précises </h1>

        <p>
            La valeur de l'attribut <code>name</code> précisée dans le code HTML du formulaire
            sert d'entrée dans le tableau associatif. Attention cette entrée peut elle-même
            être un tableau.
        </p>

        <?php
            // Noubliez pas qu'un internaute peut trafiquer le code HTML et donc supprimer (ou rajouter) une entrée.
            if (! isset($_POST['nom']))
                echo 'il n\'y a pas de champ "nom" envoyé !<br />';
            else
                echo 'la valeur du champ "nom" est : ' . htmlentities($_POST['nom']) . '<br />';
            if (! isset($_POST['cb1'][1]))
                echo 'il n\'y a pas de seconde case cochée !<br />';
            else
                echo 'la seconde case cochée est : ' . htmlentities($_POST['cb1'][1]) . '<br />';
        ?>

    </body>
</html>
