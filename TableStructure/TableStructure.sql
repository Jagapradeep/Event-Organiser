**************************************DBMS PROJECT*********************************************

***************CREATE****************

CREATE TABLE Users(
Name VARCHAR(15) NOT NULL,
ID NUMBER(7) NOT NULL,
Mail_ID VARCHAR(50) NOT NULL UNIQUE,
Password VARCHAR(20) NOT NULL,
CONSTRAINT pk_1 PRIMARY KEY (ID));

CREATE TABLE Groups(
Name VARCHAR(15) NOT NULL,
ID NUMBER(7) NOT NULL,
CRTR_ID NUMBER(7) NOT NULL,
Description VARCHAR(20) NOT NULL,
Location CHAR(15) NOT NULL,
CONSTRAINT FK_1 FOREIGN KEY (CRTR_ID) REFERENCES Users(ID),
CONSTRAINT pk_2 PRIMARY KEY (ID));

CREATE TABLE Joins(
User_ID NUMBER(7) NOT NULL,
Grp_ID NUMBER(7) NOT NULL,
Role VARCHAR(50) CHECK (Role in ('CO-ORGANISER','MEMBER')),
CONSTRAINT pk_3 PRIMARY KEY (User_ID,Grp_ID),
CONSTRAINT FK_2 FOREIGN KEY (User_ID) REFERENCES Users(ID),
CONSTRAINT FK_3 FOREIGN KEY (Grp_ID) REFERENCES Groups(ID));

CREATE TABLE Events(
Name VARCHAR(100) NOT NULL,
ID NUMBER(7) NOT NULL UNIQUE,
Grp_ID NUMBER(7) NOT NULL,
Place VARCHAR(50) NOT NULL,
Dat DATE NOT NULL,
Time VARCHAR(5) NOT NULL,
Duration NUMBER(1) NOT NULL,
CONSTRAINT pk_4 PRIMARY KEY (Grp_ID,Dat),
CONSTRAINT FK_4 FOREIGN KEY (Grp_ID) REFERENCES Groups(ID));
/*
CONSTRAINT pk_4 PRIMARY KEY (Grp_ID,Dat,Time),
CONSTRAINT pk_4 PRIMARY KEY (ID));
*/

CREATE TABLE Participates(
User_ID NUMBER(7) NOT NULL,
Event_ID NUMBER(7) NOT NULL,
CONSTRAINT pk_5 PRIMARY KEY (User_ID,Event_ID),
CONSTRAINT FK_5 FOREIGN KEY (User_ID) REFERENCES Users(ID),
CONSTRAINT FK_6 FOREIGN KEY (Event_ID) REFERENCES Events(ID));

CREATE TABLE Hosters(
Name VARCHAR(15) NOT NULL,
ID NUMBER(7) NOT NULL,
Grp_ID NUMBER(7) NOT NULL,
Role VARCHAR(50) CHECK (Role in ('ORGANISER','CO-ORGANISER')),
CONSTRAINT FK_7 FOREIGN KEY (Grp_ID) REFERENCES Groups(ID),
CONSTRAINT FK_8 FOREIGN KEY (ID) REFERENCES Users(ID));

CREATE TABLE Hosts(
ID NUMBER(7) NOT NULL,
Event_ID NUMBER(7) NOT NULL,
CONSTRAINT FK_9 FOREIGN KEY (ID) REFERENCES Users(ID),
CONSTRAINT FK_10 FOREIGN KEY (Event_ID) REFERENCES Events(ID));

***********INSERT**************

----Users----
INSERT INTO Users VALUES('JAGA',1000101,'JAGA@gmail.com','Jaga18062');
INSERT INTO Users VALUES('SYED',1000102,'SYED@gmail.com','22122000');
INSERT INTO Users VALUES('RESHMA',1000103,'RESHMA@gmail.com','resh12345');
INSERT INTO Users VALUES('SWATHI',1000104,'SWATHI@gmail.com','swathi02112000');
INSERT INTO Users VALUES('ARUN',1000105,'ARUN@gmail.com','11111');
INSERT INTO Users VALUES('HP',1000106,'HACKER@gmail.com','hacker9999');
INSERT INTO Users VALUES('HARAN',1000107,'HARAN@gmail.com','hari56789');
INSERT INTO Users VALUES('SHARATH',1000108,'SHARATH@gmail.com','0000sharath');
INSERT INTO Users VALUES('KISHORE',1000109,'KISHORE@gmail.com','kishore22112000');
INSERT INTO Users VALUES('HEMAMALINI',1000110,'HEMA@gmail.com','malini12345');

----Groups----
INSERT INTO Groups VALUES('TAMILROCKERS',1000501,1000101,'MOVIES','COIMBATORE');
INSERT INTO Groups VALUES('GDG',1000502,1000101,'TECHNOLOGY','CHENNAI');
INSERT INTO Groups VALUES('PLAYSTATION',1000503,1000110,'GAMES','TRICHY');
INSERT INTO Groups VALUES('FOSS',1000504,1000106,'MOVIES','COIMBATORE');
INSERT INTO Groups VALUES('ANALYTICS',1000505,1000102,'MACHINE LEARNING','TIRUPUR');
INSERT INTO Groups VALUES('WEB-DESIGNING',1000506,1000105,'WEB','COIMBATORE');
INSERT INTO Groups VALUES('TECHIE',1000507,1000101,'TECHNOLOGY','TIRUPUR');
INSERT INTO Groups VALUES('ANIME',1000508,1000110,'DRAWING','COIMBATORE');
INSERT INTO Groups VALUES('TAMILYOGI',1000509,1000102,'MOVIES','COIMBATORE');
INSERT INTO Groups VALUES('MEETUP',1000510,1000105,'OUTDOOR','COIMBATORE');

----Joins----
INSERT INTO Joins VALUES(1000103,1000501,'MEMBER');
INSERT INTO Joins VALUES(1000104,1000501,'CO-ORGANISER');
INSERT INTO Joins VALUES(1000107,1000505,'MEMBER');
INSERT INTO Joins VALUES(1000107,1000504,'MEMBER');
INSERT INTO Joins VALUES(1000108,1000501,'MEMBER');
INSERT INTO Joins VALUES(1000103,1000503,'CO-ORGANISER');
INSERT INTO Joins VALUES(1000101,1000503,'CO-ORGANISER');
INSERT INTO Joins VALUES(1000102,1000503,'MEMBER');
INSERT INTO Joins VALUES(1000106,1000503,'MEMBER');
INSERT INTO Joins VALUES(1000110,1000502,'MEMBER');
INSERT INTO Joins VALUES(1000109,1000506,'MEMBER');
INSERT INTO Joins VALUES(1000105,1000509,'CO-ORGANISER');
INSERT INTO Joins VALUES(1000104,1000503,'MEMBER');
INSERT INTO Joins VALUES(1000104,1000510,'MEMBER');
INSERT INTO Joins VALUES(1000108,1000503,'MEMBER');
INSERT INTO Joins VALUES(1000109,1000507,'MEMBER');
INSERT INTO Joins VALUES(1000103,1000504,'CO-ORGANISER');
INSERT INTO Joins VALUES(1000107,1000503,'CO-ORGANISER');
INSERT INTO Joins VALUES(1000101,1000504,'MEMBER');
INSERT INTO Joins VALUES(1000109,1000508,'MEMBER');
INSERT INTO Joins VALUES(1000101,1000506,'MEMBER');
INSERT INTO Joins VALUES(1000102,1000501,'MEMBER');
INSERT INTO Joins VALUES(1000103,1000502,'MEMBER');
INSERT INTO Joins VALUES(1000105,1000504,'MEMBER');
INSERT INTO Joins VALUES(1000106,1000505,'MEMBER');
INSERT INTO Joins VALUES(1000107,1000507,'MEMBER');
INSERT INTO Joins VALUES(1000108,1000508,'MEMBER');
INSERT INTO Joins VALUES(1000109,1000509,'MEMBER');
INSERT INTO Joins VALUES(1000110,1000510,'MEMBER');

----Events----
INSERT INTO Events VALUES('INTRODUCTION TO REACTJS',1006001,1000506,'CODISSIA',TO_DATE('2020-06-09','YYYY-MM-DD'),'13:00',1);
INSERT INTO Events VALUES('DOWNLOADING HD MOVIES',1006002,1000501,'HAPPENING ONLINE',TO_DATE('2020-06-09','YYYY-MM-DD'),'09:00',1);
INSERT INTO Events VALUES('INTRO TO MACHINE LEARNING',1006003,1000502,'TOWN HALL',TO_DATE('2020-06-09','YYYY-MM-DD'),'13:00',1);
INSERT INTO Events VALUES('ADVENTURE GAMES',1006004,1000503,'HAPPENING ONLINE',TO_DATE('2020-06-09','YYYY-MM-DD'),'17:00',1);
INSERT INTO Events VALUES('DEATH NOTE',1006005,1000504,'VELAN HOTEL',TO_DATE('2020-06-09','YYYY-MM-DD'),'18:00',1);
INSERT INTO Events VALUES('INTRO TO MACHINE LEARNING',1006006,1000505,'GINGER HOTEL',TO_DATE('2020-07-09','YYYY-MM-DD'),'17:00',1);
INSERT INTO Events VALUES('IOT',1006007,1000507,'HAPPENING ONLINE',TO_DATE('2020-07-10','YYYY-MM-DD'),'13:00',1);
INSERT INTO Events VALUES('DRAWING TECHNIQUES',1006008,1000508,'HAPPENING ONLINE',TO_DATE('2020-07-11','YYYY-MM-DD'),'13:00',1);
INSERT INTO Events VALUES('TORRENT DOWNLOAD',1006009,1000509,'HAPPENING ONLINE',TO_DATE('2020-07-12','YYYY-MM-DD'),'13:00',1);
INSERT INTO Events VALUES('TRECKING PREPARATION',1006010,1000510,'HAPPENING ONLINE',TO_DATE('2020-07-13','YYYY-MM-DD'),'13:00',1);
INSERT INTO Events VALUES('INTRO TO REACT NATIVE',1006011,1000506,'HAPPENING ONLINE',TO_DATE('2020-06-10','YYYY-MM-DD'),'17:00',1);
INSERT INTO Events VALUES('BLURAY DOWNLOAD',1006012,1000501,'HAPPENING ONLINE',TO_DATE('2020-06-10','YYYY-MM-DD'),'13:00',1);
INSERT INTO Events VALUES('INTRO TO RASPERRY PIE',1006013,1000502,'HAPPENING ONLINE',TO_DATE('2020-06-10','YYYY-MM-DD'),'17:00',1);
INSERT INTO Events VALUES('HIGH END GAMES',1006014,1000503,'HAPPENING ONLINE',TO_DATE('2020-06-10','YYYY-MM-DD'),'09:00',1);
INSERT INTO Events VALUES('SERIES DOWNLOAD',1006015,1000504,'HAPPENING ONLINE',TO_DATE('2020-06-10','YYYY-MM-DD'),'09:00',1);

----PARTICIPATES----
INSERT INTO Participates VALUES(1000101,1006001);
INSERT INTO Participates VALUES(1000102,1006002);
INSERT INTO Participates VALUES(1000103,1006003);
INSERT INTO Participates VALUES(1000104,1006004);
INSERT INTO Participates VALUES(1000105,1006005);
INSERT INTO Participates VALUES(1000106,1006006);
INSERT INTO Participates VALUES(1000107,1006007);
INSERT INTO Participates VALUES(1000108,1006008);
INSERT INTO Participates VALUES(1000109,1006009);
INSERT INTO Participates VALUES(1000110,1006010);
INSERT INTO Participates VALUES(1000101,1006011);
INSERT INTO Participates VALUES(1000102,1006012);
INSERT INTO Participates VALUES(1000103,1006013);
INSERT INTO Participates VALUES(1000104,1006014);
INSERT INTO Participates VALUES(1000105,1006015);
INSERT INTO Participates VALUES(1000109,1006001);

----1,2,5,6,10----

*************DROP TABLES***************
DROP TABLE Hosts;
DROP TABLE Participates;
DROP TABLE Joins;
DROP TABLE Hosters;
DROP TABLE Events;
DROP TABLE Groups;
DROP TABLE Users;

*************QUERIES********************
 select G.ID,G.Name
 from Users U,Joins J,Groups G
 where U.ID=J.User_ID
 and G.ID=J.Grp_ID
 and U.ID=1000101;

 select Name,ID
 from Groups
 where ID=1000503
 and CRTR_ID=1000101;

 select G.ID,G.Name
 from Users U,Joins J,Groups G
 where U.ID=J.User_ID
 and G.ID=J.Grp_ID
 and U.ID NOT IN 1000101;

 select Name,Description,Location
 from Groups
 where CRTR_ID NOT IN 1000101;

 select G.Name,U.Name,G.Description,G.Location
 from Users U,Groups G
 where U.ID=G.CRTR_ID
 and G.ID=1000501;

 select User_ID,Grp_ID
 from Joins
 where User_ID=1000103
 and Grp_ID=1000501;

 select Name,Place,Dat,Time,Duration,ID
 from Events
 where Grp_ID=1000506;

 select U.Name,U.Mail_ID
 from Users U,Participates P
 where U.ID=P.User_ID
 and P.Event_ID=1006001;

SELECT Name,Description,Location,ID
FROM Groups
Where ID NOT IN (SELECT G.ID
FROM Groups G,Joins J
Where J.User_ID = 1000101
and J.Grp_ID = G.ID)
and CRTR_ID NOT IN 1000101;

SELECT E.Name,E.Place,E.Dat
from Events E,Participates P
where E.ID = P.Event_ID
and P.User_ID=1000101;
/*********************SUMMA***********************
CREATE TABLE Summa(
Name VARCHAR(20),
Dat DATE ,
Time TIMESTAMP(0),
Age NUMBER(2));

INSERT INTO Summa VALUES('JAGA',TO_DATE('1965-01-09','YYYY-MM-DD'),TO_TIMESTAMP('13:00','HH24:MI'),20);
INSERT INTO Summa VALUES('FUCKER',TO_DATE('1965-01-09 14:00','YYYY-MM-DD HH24:MI'),20);
INSERT INTO Summa VALUES('SWATHI',20);

DROP TABLE Summa;

*************************************************/