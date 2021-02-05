<?php
    /*
     * TODO
     * Si on ne reçoit pas de formulaire
     *     rien à faire à part peut-être initialiser des variables pour l'affichage dans le body
     * sinon
     *     vérifier si l'entrée "nom" existe et n'est pas vide
     *     vérifier si l'entrée "passwd" existe et a au moins 3 caractères
     *     vérifier si l'entrée "civil" existe et est positionnée à "M", "Mme" ou "Mlle"
     *     note : dans chacune des vérifications, c'est une bonne idée de remplir des variables
     *            pour connaître les champs erronés et les messages d'erreur à afficher
     *            ça facilitera le code dans le body
     *
     *     s'il n'y a pas eu d'erreur
     *         recopier les 3 valeurs du formulaire dans un fichier
     *         faire une redirection vers "5.3_reussite.php"
     *         note : on ne peut pass arriver ici : on a quitté le script pour exécuter l'autre fichier
     *     finsi
     *
     *     note : si on est ici, c'est que le formulaire est erroné
     * finsi
     *
     * note : si on est ici :
     *        soit le formulaire est erroné,
     *        soit on n'a pas reçu de formulaire (premier accès à la page)
     *        Dans les deux cas il faut afficher le formulaire
     */
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
        <link rel="stylesheet" media="all" type="text/css" title="Mon Style" href="5.3.css" />
    </head>
    <body>
        <?php
            // si on est ici, c'est parce que :
            // - soit c'est l'affichage du formulaire vide
            // - soit le formulaire est erroné
            // s'il est correct, alors on a déjà fait une redirection
        ?>

        <h1>exo 5.3, formulaire</h1>

        <form id="id_form"
              action="5.3_form.php"
              method="post">

            <fieldset>
                <legend>Votre identité</legend>

                <p>
                    <?php
                        // il est conseillé de précalculer ici l'"echo" qui doit être fait dans le input
                        // à moins qu'il n'est été précalculté auparavant
                    ?>
                    <label for="id_f_nom">nom</label><br />
                    <input type="text" name="nom" id="id_f_nom" size="20"
                           maxlength="30" placeholder="votre login"
                           value="<?php /* TODO peut-être une valeur */ ?>"
                           tabindex="10" />

                    <?php
                        // TODO : éventuellement un message d'erreur
                    ?>
                </p>

                <p>
                    <?php
                        // il est conseillé de précalculer ici l'"echo" qui doit être fait dans le input
                        // à moins qu'il n'est été précalculté auparavant
                    ?>
                    <label for="id_f_passwd">passwd</label><br />
                    <input type="password" name="passwd" id="id_f_passwd"
                           size="8" maxlength="20" placeholder="mot de passe"
                           value="<?php /* TODO peut-être une valeur */ ?>"
                           tabindex="30" />

                    <?php
                        // TODO : éventuellement un message d'erreur
                    ?>
                </p>

                <p>
                    État civil (choix radio sans case précochée) :<br />
                    <?php
                        // il est conseillé de précalculer ici l'"echo" qui doit être fait dans le input
                        // à moins qu'il n'est été précalculté auparavant
                    ?>
                    <input type="radio" name="civil" id="id_f_r1_m"
                           value="M"
                           <?php /* TODO peut-être cocher le bouton */ ?>
                           tabindex="60" />
                    <label for="id_f_r1_m">Monsieur</label>
                    <br />

                    <?php
                        // il est conseillé de précalculer ici l'"echo" qui doit être fait dans le input
                        // à moins qu'il n'est été précalculté auparavant
                    ?>
                    <input type="radio" name="civil" id="id_f_r1_mme"
                           value="Mme"
                           <?php /* TODO peut-être cocher le bouton */ ?>
                           tabindex="70" />
                    <label for="id_f_r1_mme">Madame</label>
                    <br />

                    <?php
                        // il est conseillé de précalculer ici l'"echo" qui doit être fait dans le input
                        // à moins qu'il n'est été précalculté auparavant
                    ?>
                    <input type="radio" name="civil" id="id_f_r1_mlle"
                           value="Mlle"
                           <?php /* TODO peut-être cocher le bouton */ ?>
                           tabindex="80" />
                    <label for="id_f_r1_mlle">Mademoiselle</label>

                    <?php
                        // TODO : éventuellement un message d'erreur
                    ?>
                </p>
            </fieldset>

            <fieldset>
                <legend>Validation (boutons)</legend>
                <input type="submit" value="envoi" tabindex="220" />
                <input type="reset" value="efface" tabindex="230" />
            </fieldset>
        </form>


        <h2>GET</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_GET, true));
            echo '</pre>';
        ?>

        <h2>POST</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_POST, true));
            echo '</pre>';
        ?>

        <h2>FILES</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_FILES, true));
            echo '</pre>';
        ?>

   </body>
</html>
