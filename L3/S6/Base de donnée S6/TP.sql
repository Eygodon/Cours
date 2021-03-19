DROP TABLE Ligue CASCADE CONSTRAINTS;
CREATE TABLE Ligue (
    ligueId INTEGER,
    nomLigue VARCHAR(50),
    pays VARCHAR(50),
    CONSTRAINT PK_Ligue PRIMARY KEY (ligueId)
);

DROP TABLE Equipe CASCADE CONSTRAINTS;
CREATE TABLE Equipe (
    equipeId INTEGER,
    nomEquipe VARCHAR2(100),
    nomCourt VARCHAR2(3),
    ligueId INTEGER,
    CONSTRAINT PK_Equipe PRIMARY KEY (equipeId),
    CONSTRAINT FK_Equipe_Ligue FOREIGN KEY (ligueId) REFERENCES Ligue(ligueId)    
);

DROP TABLE Saison CASCADE CONSTRAINTS;
CREATE TABLE Saison (
    saisonId INT,
    libelle VARCHAR2(9),
    dateDeb DATE,
    dateFin DATE,
    CONSTRAINT PK_Saison PRIMARY KEY (saisonId)
);

DROP TABLE Match CASCADE CONSTRAINTS;
CREATE TABLE Match (
    matchId INTEGER,
    dateMatch DATE,
    scoreLocale NUMBER(2),
    scoreVisiteur NUMBER(2),
    equipeLocale INTEGER,
    equipeVisiteur INTEGER,
    CONSTRAINT PK_Match PRIMARY KEY (matchId),
    CONSTRAINT FK_Match_Equipe_1 FOREIGN KEY (equipeLocale) REFERENCES Equipe(equipeId),
    CONSTRAINT FK_Match_Equipe_2 FOREIGN KEY (equipeVisiteur) REFERENCES Equipe(equipeId)
);

DROP TABLE Joueur CASCADE CONSTRAINTS;
CREATE TABLE Joueur (
    joueurId INT NOT NULL,
    nomJoueur VARCHAR2(100) NOT NULL,
    prenomJoueur VARCHAR(20) NULL,
    dateNaissance DATE NULL,
    taille NUMBER(3,2) NULL,
    poids NUMBER(5,2) NULL,
    saison NUMBER(4)  NULL,
    CONSTRAINT PK_Joueur PRIMARY KEY (joueurid)
);

DROP TABLE Engager CASCADE CONSTRAINTS;
CREATE TABLE Engager (
    joueurId INTEGER,
    saisonId INTEGER,
    equipeId INTEGER,
    CONSTRAINT PK_engager PRIMARY KEY (joueurId, saisonId, equipeId),
    CONSTRAINT FK_Engager_Equipe FOREIGN KEY (equipeId) REFERENCES Equipe(equipeId),
    CONSTRAINT FK_Engager_Joueur FOREIGN KEY (joueurId) REFERENCES Joueur(joueurId),
    CONSTRAINT FK_Engager_Saison FOREIGN KEY (saisonId) REFERENCES Saison(saisonId)
);

DROP TABLE Marquer CASCADE CONSTRAINTS;
CREATE TABLE Marquer (
    joueurId INTEGER,
    matchId INTEGER,
    minute NUMBER(3),
    CONSTRAINT PK_Marquer PRIMARY KEY (joueurId, matchId, minute),
    CONSTRAINT FK_Marquer_Match FOREIGN KEY (matchId) REFERENCES Match(matchId),
    CONSTRAINT FK_Marquer_Joueur FOREIGN KEY (joueurId) REFERENCES Joueur(joueurId)
);

ALTER TABLE Marquer ADD seconde NUMBER(2);
ALTER TABLE Ligue MODIFY nomLigue VARCHAR2(150);

INSERT INTO ligue 
SELECT DISTINCT league.id, league.name, country.name
FROM DATAL3.LEAGUE , dataL3.COUNTRY  
where datal3.league.country_id = dataL3.country.id ;

insert into equipe 
select distinct team_api_id, team_long_name, team_short_name, league_id
  from dataL3.team t, dataL3.match m
 where m.home_team_api_id = t.team_api_id ;
 
DROP SEQUENCE seq_saison;
CREATE SEQUENCE seq_saison;
CREATE OR REPLACE TRIGGER trig_seq_saison
before insert on saison
for each row
begin
select seq_saison.nextval into :new.saisonId from DUAL;
end;
/

insert into saison (libelle, dateDeb, dateFin)
select distinct season,
to_date('01/08' || substr(season, 1, 4), 'DD/MM/YYYY'),
to_date('30/06' || substr(season,6 ,4), 'DD/MM/YYYY')
FROM dataL3.match;

insert into joueur (joueurId, nomJoueur, prenomJoueur, dateNaissance, taille, poids)
select distinct dataL3.player.player_api_id,
       substr(player_name, instr(player_name, ' ',1)+1),
       substr(player_name, 1, instr(player_name, ' ', 1)-1),
       to_date(birthday, 'YYYY-MM-DD HH24:MI:SS'),
       height/100,
       weight/2.2046
from dataL3.player;

insert into match 
select id, 
to_date(mdate, 'YYYY-MM-DD HH24:MI:SS'),
home_team_goal, away_team_goal, home_team_api_id, away_team_api_id
FROM dataL3.match;

insert into engager (equipeId, joueurId, saisonId)
select distinct home_team_api_id, home_player_1, (SELECT saisonId FROM SAISON WHERE LIBELLE = SEASON)
FROM dataL3.MATCH
WHERE home_player_1 is not null;

/*set serveroutput on;
DECLARE i INTEGER := 1;
QUERY VARCHAR2(5000) := 'SELECT DISTINCT HOME_TEAM_API_ID, HOME_PLAYER_1, (SELECT FROM SAISONID WHERE LIBELLE = SEASON) from
DATAL3.MATCH WHERE HOME_PLAYER_1 IS NOT NULL';
begin
DBMS_OUTPUT.PUT_LINE('insert into engager (equipeId, joueurId, saisonId)');
LOOP
    DBMS_OUTPUT.PUT_LINE (REPLACE(query, 'player_1', 'player_' || i));
    DBMS_OUTPUT.PUT_LINE('UNION');
    DBMS_OUTPUT.PUT_LINE(REPLACE(REPLACE(QUERY, 'PLAYER_1', 'PLAYER_'|| i), 'home', 'away'));
    exit when i = 11;
    DBMS_OUTPUT.PUT_line('union');
    i := i+1;
END loop;
END;
*/
insert into  Marquer (joueurId, matchId, minute) values (
        (SELECT joueurId from Joueur where nomJoueur = 'Cabella'),
        (SELECT  matchId from Match inner join Equipe on match.equipeLocale = Equipe.equipeId
            where dateMatch = to_date('07-02-2016', 'DD-MM-YYYY') and
                  nomEquipe = 'Olympique de Marseille'),
                                                         25)
                                                         ;
                                                         
insert into  Marquer (joueurId, matchId, minute) values (
        (SELECT joueurId from Joueur where nomJoueur = 'Ibrahimovic'),
        (SELECT  matchId from Match inner join Equipe on match.equipeLocale = Equipe.equipeId
            where dateMatch = to_date('07-02-2016', 'DD-MM-YYYY') and
                  nomEquipe = 'Olympique de Marseille'),
                                                         25)
                                                         ;
insert into  Marquer (joueurId, matchId, minute) values (
        (SELECT joueurId from Joueur where nomJoueur = 'Di Maria'),
        (SELECT  matchId from Match inner join Equipe on match.equipeLocale = Equipe.equipeId
            where dateMatch = to_date('07-02-2016', 'DD-MM-YYYY') and
                  nomEquipe = 'Olympique de Marseille'),
                                                         25)
                                                         ;

update ligue set pays = upper(pays);

delete from match where (scoreVisiteur - scoreLocale) =
                        (select max(scoreVisiteur-Match.scoreLocale) from Match)
;

SELECT nomJoueur, prenomJoueur, trunc((sysdate - dateNaissance)/365.25)
  FROM joueur where datenaissance = (
    SELECT max(dateNaissance) from joueur
  );

-- E2

SELECT nomJoueur, prenomJoueur, trunc((sysdate - dateNaissance)/365.25), nomEquipe, nomLigue
  FROM joueur, engager, equipe, ligue
  WHERE joueur.joueurId = engager.joueurId
    AND equipe.equipeId = engager.equipeId
    AND equipe.ligueId = ligue.ligueId
    AND dateNaissance = (
      SELECT max(dateNaissance) FROM joueur
    );
    
-- TP2


-- A1
-- à exécuter en tant qu'administrateur
SHOW PARAMETER DB_BLOCK_SIZE; -- 8192 Ko

-- A2
-- taille du segment

SELECT blocks, ((bytes / 1024) / 1024) AS Taille FROM user_segments WHERE SEGMENT_NAME = 'JOUEUR';

-- taille moyenne d'une ligne
SELECT blocks, ((bytes) / nb_lignes) AS Taille_moyenne_ligne FROM user_segments, (SELECT COUNT(*) AS nb_lignes FROM joueur) WHERE SEGMENT_NAME = 'JOUEUR';


-- A3 
SHOW PARAMETER DB_FILE_MULTIBLOCK_READ_COUNT;
-- 36

-- A4
DESC user_indexes;
SELECT * FROM user_indexes;

SELECT 
DECODE(index_type, 'NORMAL', 'B-Ttree'),
DECODE(blevel, NULL, 0, blevel),
DECODE(clustering_factor, NULL, 0, clustering_factor)
FROM user_indexes;

--A5

select blocks, bytes/1024/1024 as Mo
from user_segments
where segment_name = 'PK_JOUEUR';

--B1
Exec dbms_stats.gather_schema_stats('TP');

--B2
SELECT * FROM user_tab_statistics
Where TABLE_NAME = 'JOUEUR';

--B3
SELECT * FROM user_ind_statistics
Where TABLE_NAME = 'JOUEUR';

--B4
EXEC dbms_stats.gather_table_stats('TP','Joueur');
--B5
select 
  num_distinct,
  to_char(utl_raw.cast_to_number(low_value)) as lv,
  to_char(utl_raw.cast_to_number(high_value)) as hv,
  num_nulls
  from user_TAB_COL_STATISTICS where table_name = 'JOUEUR' and column_name = 'TAILLE'
  ;
  
--B6

SELECT   ENDPOINT_VALUE, ENDPOINT_NUMBER
FROM     USER_TAB_HISTOGRAMS
WHERE    TABLE_NAME = 'JOUEUR' AND COLUMN_NAME = 'TAILLE'
ORDER BY ENDPOINT_NUMBER asc;

--C1
Set AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT * FROM joueur 
WHERE taille > 2
ORDER BY taille;

--C2
Set AUTOTRACE ON EXPLAIN;
SET TIMING ON;
select /*+ NO_INDEX(JOUEUR PK_JOUEUR) */ * from joueur where joueurId = 46509;

Set AUTOTRACE ON EXPLAIN;
SET TIMING ON;
select /*+ INDEX(JOUEUR PK_JOUEUR) */ * from joueur where joueurId = 46509;

--C3
Set AUTOTRACE ON EXPLAIN;
SET TIMING ON;
select /*+ NO_INDEX(equipe PK_equipe) */ datematch, nom_equipe
from match, equipe 
where equipelocale=equipeid;

Set AUTOTRACE ON EXPLAIN;
SET TIMING ON;
select /*+ INDEX(equipe PK_equipe) */ datematch, equipe.nomequipe
from match, equipe 
where equipelocale=equipeid;

--D1
Set AUTOTRACE ON EXPLAIN;
SET TIMING ON;
select /*+ NO_INDEX(joueur idx_joueur_nom) */* from joueur where nomjoueur > 'von';
drop index idx_joueur_nom;
create index idx_joueur_nom on joueur(nomjoueur);
drop index idx_prenom_joueur;
create index idx_prenom_joueur on joueur(prenomjoueur);
drop index idx_taille_joueur;
create index idx_taille_joueur on joueur(taille);

--D2

Set AUTOTRACE ON EXPLAIN;
SET TIMING ON;
select /*+ INDEX(joueur idx_joueur_nom) */ * from joueur where nomjoueur < 'von';

--D3
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /* + INDEX(joueur idx_joueur_nom) */ * from joueur where nomjoueur > 'van';

--D4
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /* + INDEX(joueur idx_prenom_joueur) */ * from joueur where prenomjoueur is null;

--D5
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ NO_INDEX( joueur idx_joueur_nom) */ * from joueur where  nomjoueur LIKE 'Ib%';

--D6
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ NO_INDEX( joueur idx_joueur_nom) */ * from joueur where  nomjoueur LIKE '%oz';

--D7
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ INDEX( joueur idx_joueur_nom) */ COUNT (*) from joueur where  nomjoueur LIKE '%oz';

--D8
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ INDEX( joueur idx_joueur_nom) */ * from joueur where nomjoueur LIKE upper('macdonald');

--D9
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ INDEX(joueur idx_taille_joueur) */ * from joueur where taille = '1,57' OR taille = '1,60' OR taille='1,63';

--D10
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ NO_INDEX(joueur idx_taille_joueur) NO_INDEX(joueur idx_taille_joueur) */ * from joueur where taille = '2,03' AND nomjoueur LIKE 'M%';

--D11
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ INDEX(joueur idx_taille_joueur) */ * from joueur where taille = '1,96' AND nomjoueur LIKE '%Z';

--D12
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
select * from joueur where taille not in (1.65,1.68,1.7,1.73,1.75,1.78,1.8,1.83,1.85,1.88,1.91,1.93,1.96,1.98,2.01,2.03,2.08);
--c'est comme la 9

--D13
SET AUTOTRACE ON EXPLAIN;
SET TIMING ON;
SELECT /*+ USE_HASH(equipe, match)*/ *
FROM Equipe, match 
WHERE equipe.equipeid = match.equipelocale;

--D14 

--TP3
--A1
create view E5 as 
select nomligue, sum(scorelocale + scorevisiteur) as nbbuts
from match, equipe, ligue, saison
where match.datematch between saison.datedeb and saison.datefin
 and match.equipelocale = equipe.equipeid
 and equipe.ligueid = ligue.ligueid
 and saison.libelle = '2015/2016'
group by ligue.ligueid, ligue.nomligue 
order by sum(scorelocale + scorevisiteur) desc;

select nomligue, sum(scorelocale + scorevisiteur) as nbbuts
from match, equipe, ligue, saison
where match.datematch between saison.datedeb and saison.datefin
 and match.equipelocale = equipe.equipeid
 and equipe.ligueid = ligue.ligueid
 and saison.libelle = '2015/2016'
group by ligue.ligueid, ligue.nomligue 
order by sum(scorelocale + scorevisiteur) desc
;

--A2

select equipe, sum(pts) as pts, count(*) as nombre_match
from equipe_point
group by equipe
order by pts desc;

CREATE or replace view E_classement as
select equipe, SUM(pts) as points, COUNT(*) as MJ
from equipe_point
GROUP BY equipe
ORDER BY points DESC;

select avg(nbbuts), avg(nbbuts)/38
from E5;

--A3

CREATE OR REPLACE VIEW a3_view AS
SELECT equipe, count(*) as nb_match, sum(pts) as points, 
sum(g) as G, sum(n) as N, sum(p) as P, 
sum(bp) as BP, sum(bc) as BC, sum(db) as DB
FROM equipe_point
GROUP BY equipe
ORDER BY points desc, G desc;

create or replace view match_aller as 
select nomequipe as equipe,
        CASE 
         WHEN scorelocale > scorevisiteur then 3
         WHEN scorelocale = scorevisiteur then 1
         ELSE 0
        END as Pts,
        CASE 
         WHEN scorelocale > scorevisiteur then 1
         ELSE 0
        END as G,
        CASE 
         WHEN scorelocale = scorevisiteur then 1
         ELSE 0
        END as N,
        CASE 
         WHEN scorelocale < scorevisiteur then 1
         ELSE 0
        END as P,
        scorelocale as BP,
        scorevisiteur as BC,
        scorelocale - scorevisiteur as DB
from match, equipe, ligue, saison
where match.datematch between saison.datedeb and saison.datefin
 and match.equipelocale = equipe.equipeid
 and equipe.ligueid = ligue.ligueid
 and saison.libelle = '2014/2015'
 and ligue.nomligue = 'France Ligue 1';
 
 CREATE OR REPLACE VIEW E_JOUEUR_1990 as
select * from JOUEUR
where datenaissance >= '01/01/90'
ORDER BY datenaissance;

CREATE OR REPLACE VIEW player_before_90 AS
    SELECT * FROM joueur
    WHERE datenaissance > TO_DATE('01-01-1990', 'DD-MM-YYYY')
    ORDER BY datenaissance;
    
    --A4
INSERT INTO E_JOUEUR_1990 VALUES (100000,'Jean','Philippe','01/02/91',1.80,75.00);

UPDATE E_JOUEUR_1990 SET taille = 1.81
where JOUEURID = 100000;

DELETE FROM E_JOUEUR_1990
WHERE JOUEURID = 100000;

--A5

CREATE OR REPLACE VIEW E_JOUEUR_1990 as
select * from JOUEUR
where datenaissance >= '01/01/90' 
ORDER BY datenaissance WITH CHECK OPTION;

INSERT INTO E_JOUEUR_1990 VALUES (100000,'Jean','Philippe','01/02/89',1.80,75.00);

CREATE OR REPLACE VIEW Equipe_detaille AS SELECT E.EQUIPEID, E.NOMEQUIPE, L.PAYS
FROM EQUIPE E, LIGUE L
WHERE L.LIGUEID = e.ligueid
WITH CHECK OPTION;

--A10
CREATE MATERIALIZED VIEW material_view
TABLESPACE USERS
BUILD IMMEDIATE
REFRESH complete
ENABLE QUERY REWRITE
AS 
SELECT Equipe . nomequipe , MATCH . dateMatch
FROM Equipe , MATCH
WHERE Equipe . equipeid = MATCH . equipelocale;

--A11

