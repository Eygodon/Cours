<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>TP 5</title>
    </head>
    <body>

        <h1>exo 5.2, formulaire</h1>

        <!-- TODO : rien à faire, le fichier est complet -->

        <form id="id_form"
              action="5.2_trait.php"
              method="post" enctype="multipart/form-data">

            <fieldset>
                <legend>Votre identité</legend>

                <p>
                    <label for="id_f_nom">nom</label><br />
                    <input type="text" name="nom" id="id_f_nom" size="20"
                           maxlength="30" value=""
                           tabindex="10" />
                </p>

                <p>
                    <label for="id_f_nom_interne">nom interne (read only)</label><br />
                    <input type="text" name="nom_interne" id="id_f_nom_interne"
                           size="20" maxlength="30" value="0xaff23df03"
                           readonly="readonly" tabindex="20" />
                </p>

                <p>
                    <label for="id_f_passwd">passwd</label><br />
                    <input type="password" name="passwd" id="id_f_passwd"
                           size="8" maxlength="20" value="" tabindex="30" />
                </p>

                <p>
                    <label for="id_f_cv">CV</label><br />
                    <textarea name="cv" id="id_f_cv" rows="4" cols="20" tabindex="40"></textarea>
                </p>

                <p>
                    <label>données cachées ! donc on ne les voie pas</label><br />
                    <input type="hidden" name="cache" id="id_f_cache" value="test caché" />
                </p>
            </fieldset>

            <fieldset>
                <legend>Vos caractérisques (choix parmi plusieurs)</legend>

                <p>
                    Etat civil (choix radio sans case précochée) :<br />
                    <input type="radio" name="radio1" id="id_f_r1_m"
                           value="M" tabindex="60" />
                    <label for="id_f_r1_m">Monsieur</label>
                    <br />

                    <input type="radio" name="radio1" id="id_f_r1_mme"
                           value="Mme" tabindex="70" />
                    <label for="id_f_r1_mme">Madame</label>
                    <br />

                    <input type="radio" name="radio1" id="id_f_r1_mlle"
                           value="Mlle" tabindex="80" />
                    <label for="id_f_r1_mlle">Mademoiselle</label>
                </p>

                <p>
                    Age (autre choix radio avec case précochée) :<br />
                    <input type="radio" name="radio2" id="id_f_r2_17"
                           value="17-" tabindex="90" />
                    <label for="id_f_r2_17" >0-17 ans</label>
                    <br />

                    <input type="radio" name="radio2" id="id_f_r2_18_65"
                           value="18-65"  checked="checked" tabindex="100" />
                    <label for="id_f_r2_18_65" >18-65 ans</label>
                    <br />

                    <input type="radio" name="radio2" id="id_f_r2_66"
                           value="66+" tabindex="110" />
                    <label for="id_f_r2_66" >66 ans et plus</label>
                </p>

                <p>
                    Centres d'intérêt (cases à cocher) :<br />
                    <input type="checkbox" name="cb1[]" value="info"
                           id="id_f_cb1_info" checked="checked"
                           tabindex="120" />
                    <label for="id_f_cb1_info">Informatique</label>
                    <br />

                    <input type="checkbox" name="cb1[]" value="maths"
                           id="id_f_cb1_maths" tabindex="130" />
                    <label for="id_f_cb1_maths">Mathématiques</label>
                    <br />

                    <input type="checkbox" name="cb1[]" value="phys"
                           id="id_f_cb1_phys" tabindex="140" />
                    <label for="id_f_cb1_phys">Physique</label>
                    <br />

                    <input type="checkbox" name="cb1[]" value="jeux"
                           id="id_f_cb1_jeux" checked="checked"
                           tabindex="150" />
                    <label for="id_f_cb1_jeux">Jeux Vidéo</label>
                    <br />

                    <input type="checkbox" name="cb1[]" value="lecture"
                           id="id_f_cb1_lecture" tabindex="160" />
                    <label for="id_f_cb1_lecture">Lecture</label>
                    <br />
                </p>
            </fieldset>

            <fieldset>
                <legend>Plus sur vous (listes)</legend>

                <p>
                    <label for="id_f_liste2">Votre pays (liste déroulante avec
                        groupes et présélection) :</label> <br />
                    <select name="liste2" id="id_f_liste2" size="1" tabindex="180">
                        <optgroup label="Amérique">
                            <option value="canada"> Canada </option>
                            <option value="etatsunis"> États-Unis </option>
                            <option value="mexique"> Mexique </option>
                        </optgroup>
                        <optgroup label="Europe">
                            <option value="allemagne"> Allemagne </option>
                            <option value="espagne"> Espagne </option>
                            <option value="france" selected="selected">France</option>
                            <option value="italie"> Italie </option>
                        </optgroup>
                        <optgroup label="Afrique">
                            <option value="algérie"> Algérie </option>
                            <option value="togo"> Togo </option>
                            <option value="lesotho"> Lesotho </option>
                        </optgroup>
                    </select>
                </p>

                <p>
                    <label for="id_f_liste3">Votre pays bis repetita (liste avec
                        ascenseur, groupes et présélection) :</label> <br />
                    <select name="liste3" id="id_f_liste3" size="3" tabindex="190">
                        <optgroup label="Amérique">
                            <option value="canada"> Canada </option>
                            <option value="etatsunis"> Etats-Unis </option>
                            <option value="mexique"> Mexique </option>
                        </optgroup>
                        <optgroup label="Europe">
                            <option value="allemagne"> Allemagne </option>
                            <option value="espagne"> Espagne </option>
                            <option value="france" selected="selected">France</option>
                            <option value="italie"> Italie </option>
                        </optgroup>
                        <optgroup label="Afrique">
                            <option value="algérie"> Algérie </option>
                            <option value="togo"> Togo </option>
                            <option value="lesotho"> Lesotho </option>
                        </optgroup>
                    </select>
                </p>

                <p>
                    <label for="id_f_liste4">Vos centres d'intérêt bis repetita aussi
                        (liste avec ascenseur, groupes, présélections et
                        choix multiples) :</label> <br />
                    <select name="liste4[]" id="id_f_liste4" size="5" multiple="multiple"
                            tabindex="200">
                        <optgroup label="Sciences">
                            <option value="info" selected="selected"> Informatique
                            </option>
                            <option value="maths"> Mathématiques </option>
                            <option value="phys"> Physique </option>
                        </optgroup>
                        <optgroup label="Culture">
                            <option value="jeux" selected="selected"> Jeux vidéo </option>
                            <option value="lecture"> Lecture </option>
                            <option value="cinema"> Cinéma </option>
                            <option value="theatre" selected="selected"> Théâtre </option>
                        </optgroup>
                        <optgroup label="Musique">
                            <option value="classique1"> Classique </option>
                            <option value="classique2"> Classique </option>
                            <option value="classique3"> Classique </option>
                            <option value="autre"> Autre chose ? </option>
                        </optgroup>
                    </select>
                </p>
            </fieldset>

            <fieldset>
                <legend>Envoi de fichier</legend>
                <p>
                    <label>taille max (cachée)</label><br />
                    <input type="hidden" name="MAX_FILE_SIZE" id="id_f_max_size" value="50000" />
                </p>

                <p>
                    <label for="id_f_fichier">fichier</label><br />
                    <input type="file" name="fichier" id="id_f_fichier" size="40"
                           tabindex="210" />
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
