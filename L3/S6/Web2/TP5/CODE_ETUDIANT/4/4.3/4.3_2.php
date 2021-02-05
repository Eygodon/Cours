<?php
    // pas de session_start dans cet exercice

    // Attention : la création de cookie doit se faire ici et surtout ne pas mettre
    // le moindre espace avant la balise php
    // Remarque : c'était vrai à une certaine époque et maintenant c'est plus permissif ;
    //            cependant la règle est de faire la modification des cookies avant
    //            l'envoi de l'entête (bref avant le doctype)

    // TODO
    // - vérifier que le paramètre GET 'action' existe et est un nombre entre 1 et 5
    
    // TODO
    // en fonction de la valeur de 'action'
    // - faire les modifications de cookie nécessaires
    // - mais aucun affichage ici (jamais hors des balises <body></body>)
    
    // Note : comme les affichages se font à part du traitement, il faut
    //        positionner des variables pour indiquer au code plus loin
    //        comment il doit réagir et ce qu'il doit afficher.
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 4.3, deuxième page</h1>

        <p>
            <a href="4.3_1.php">cliquer ici</a> pour revenir à la première page.
        </p>

        <h2>Actions</h2>

        <?php
            function afficheCookies()
            {
                // on peut faire ici une fonction qui teste l'existence et qui
                // affiche les cookies qui nous intéressent (et uniquement ceux-ci)
            }

            // TODO
            // si le paramètre GET 'action' n'est pas correct (cf. code avant le doctype)
            // afficher un message d'erreur explicite et sortir (fonction exit) du script

            switch($_GET['action'])
            {
                case 1:
                    // TODO : tout a été fait avant, donc ici un éventuel message d'erreur
                    break;
                case 2:
                    // TODO : tout a été fait avant, donc ici un éventuel message d'erreur
                    break;
                case 3:
                    afficheCookies();
                    break;
                case 4:
                    // TODO : tout a été fait avant, donc ici un éventuel message d'erreur
                    break;
                case 5:
                    // TODO : tout a été fait avant, donc ici un éventuel message d'erreur
                    break;
                default:
                    // déjà traité en début de fichier
            }
        ?>

        <h2>COOKIE</h2>
        <?php
            echo '<pre>';
            echo htmlspecialchars(print_r($_COOKIE, true));
            echo '</pre>';
        ?>

    </body>
</html>
