
CREATE ROLE c##tpAdmin;
CREATE ROLE c##tpComment;
CREATE ROLE c##tpInternaute;
CREATE user c##Admin identified by tpAdmin;
CREATE USER c##Comment identified by tpComment;
CREATE USER c##Intern identified by tpIntern;
GRANT c##tpAdmin TO c##admin;
GRANT c##tpComment TO c##tpComment;
GRANT c##tpInternaute TO c##Intern;
grant create view to tp;
GRANT CREATE MATERIALIZED VIEW TO TP;