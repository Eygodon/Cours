<?php
    // on peut encapsuler ici les fonctions de manipulation de la BD
    // on propose ici une organisation qu'il n'est pas obligatoire de suivre.

    // peut-être plus adéquat de faire les déclarations dans bd_connexion (pour éviter les variables globales) ?
    $bd_host = 'localhost';
    $bd_login = 'root';
    $bd_passwd = '';
    $bd_base = 'tp';

    // pour PDO : instance de la classe
    // Ce n'est pas élégant d'avoir une variable globale.
    // Il serait préférable que la fonction de connexion renvoie la variable
    // au script appelant. Cette variable serait alors passée en paramètre aux
    // autres fonctions.
    // Mais cette solution simplifie les scripts
    $bd_obj = null;

    // affichage d'une erreur
    function bd_erreur($msg)
    {
        echo '<h1>Erreur base de données</h1>';
        echo '<p>' . $msg . '</p>';
        exit(1);
    }

    // connexion à la BD, arrêt du script en cas d'erreur
    function bd_connexion()
    {
        global $bd_host, $bd_login, $bd_passwd, $bd_base, $bd_obj;

        try {
            $bd_obj = new PDO('mysql:dbname='.$bd_base.';host='.$bd_host, $bd_login, $bd_passwd);
        }
        catch (PDOException $e){
            echo $e->getMessage();
            exit();
        }
    }

    // déconnexion (code obligeament fourni)
    function bd_deconnexion()
    {
        global $bd_obj;
        $bd_obj = null;
    }

    // fonction envoyant la requête au serveur de base de données
    // En cas d'erreur, la fonction ne s'arrête que si l'appelant l'autorise explicitement
    // via le second paramètre
    // le premier paramètre est la chaîne de caractères contenant la requête SQL
    function bd_requete($requete, $stopOnError = false)
    {
        global $bd_obj;
        $result = $bd_obj->query($requete);

        // On ne peut pas arrêter d'office le programme s'il y a une erreur.
        // L'appelant pourrait vouloir la traiter (par exemple s'il y a une
        // violation d'une contrainte d'intégrité).
        if ($stopOnError)
        {
            if (! $result)
                bd_erreur('erreur requête "' . $requete . '"');
        }

        return $result;
    }

