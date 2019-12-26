create table phone
(
    phone_id     serial       not null
        constraint phone_pk
            primary key,
    phone_number varchar(100) not null
);

alter table phone
    owner to netelement;

create unique index phone_phone_number_uindex
    on phone (phone_number);


create table division
(
    division_id   serial       not null
        constraint division_pk
            primary key,
    division_name varchar(100) not null
);

alter table division
    owner to netelement;

create unique index division_division_name_uindex
    on division (division_name);

create table stuff
(
    stuff_id    serial       not null
        constraint stuff_pk
            primary key,
    stuff_name  varchar(100) not null,
    division_id integer      not null
        constraint stuff_division_division_id_fk
            references division
            on update cascade
);

alter table stuff
    owner to netelement;

create table stuff_phone
(
    stuff_phone_id serial  not null
        constraint stuff_phone_pk
            primary key,
    stuff_id       integer not null
        constraint stuff_phone_stuff_stuff_id_fk
            references stuff
            on delete cascade,
    phone_id       integer not null
        constraint stuff_phone_phone_phone_id_fk
            references phone
            on delete cascade
);

alter table stuff_phone
    owner to netelement;





INSERT INTO stuff_schema.phone (phone_id,phone_number) VALUES (1,'108-7601'),(2,'1-919-735-7326'),(3,'1-729-748-8087'),(4,'1-507-233-2273'),(5,'184-6863'),(6,'1-862-624-3462'),(7,'1-133-873-8017'),(8,'1-714-780-1438'),(9,'398-0645'),(10,'1-423-576-5172');
INSERT INTO stuff_schema.phone (phone_id,phone_number) VALUES (11,'1-211-625-2456'),(12,'1-865-399-9244'),(13,'366-2285'),(14,'431-3401'),(15,'631-1303'),(16,'1-492-953-5945'),(17,'1-733-941-1549'),(18,'1-408-152-3197'),(19,'1-622-475-4758'),(20,'530-2095');
INSERT INTO stuff_schema.phone (phone_id,phone_number) VALUES (21,'1-221-396-1518'),(22,'468-4890'),(23,'1-353-991-6269'),(24,'1-251-163-3237'),(25,'131-5174'),(26,'1-889-440-0514'),(27,'213-8455'),(28,'1-309-914-0097'),(29,'523-5267'),(30,'666-8442');


INSERT INTO stuff_schema.division (division_id,division_name) VALUES (1,'NIZ'),(2,'LIP'),(3,'ROS'),(4,'Irkutsk Oblast'),(5,'KIR'),(6,'Volgograd Oblast'),(7,'RYA'),(8,'Kirov Oblast'),(9,'Moscow City'),(10,'Kaluga Oblast');

INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (1,'Brent Hancock',4),(2,'Brandon Kelley',5),(3,'August Morrow',2),(4,'Troy Petersen',6),(5,'Alexander Moreno',7),(6,'Matthew Townsend',7),(7,'Wesley Morales',4),(8,'Carson Lowery',6),(9,'Colorado Chapman',10),(10,'Vaughan Riggs',4);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (11,'Alexander Mccarty',7),(12,'Ian Flynn',6),(13,'Brock Roy',3),(14,'Rigel Gallegos',10),(15,'Keane Reeves',9),(16,'Leo Mcmillan',3),(17,'Dexter Whitehead',9),(18,'Raymond Atkinson',10),(19,'Mufutau Huber',6),(20,'Edan Mccormick',1);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (21,'Tate Macias',10),(22,'Thane Herring',6),(23,'Neil Baird',4),(24,'Brody Snow',5),(25,'Vance Herman',9),(26,'Jerry Cooper',6),(27,'Rooney Wells',1),(28,'Kato Roach',4),(29,'Zeph Lynn',9),(30,'Mannix Gentry',7);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (31,'Norman Monroe',5),(32,'Zachary Walters',2),(33,'Reed Holder',3),(34,'Rooney Gilbert',2),(35,'James Hutchinson',10),(36,'Zephania Francis',6),(37,'Craig Martinez',7),(38,'Aladdin Adams',3),(39,'Nasim Simmons',1),(40,'Connor Atkins',1);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (41,'Marshall Bates',9),(42,'Fletcher Sexton',7),(43,'Linus Joseph',8),(44,'Kieran Dickson',5),(45,'Ivan Ray',1),(46,'Ian Melendez',3),(47,'Gregory Mack',9),(48,'Bert Morris',4),(49,'Gil Fry',2),(50,'Daquan Holloway',2);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (51,'Akeem Patrick',6),(52,'Zachary Burks',5),(53,'Chester Moses',8),(54,'Hammett Little',10),(55,'Harper Richards',8),(56,'Calvin Daniels',9),(57,'Alexander Mathews',3),(58,'Reed Jacobs',5),(59,'Armando Hunt',8),(60,'Ferris Bishop',2);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (61,'Amery Collins',10),(62,'Bradley Mills',8),(63,'Camden Howell',8),(64,'Axel Haley',8),(65,'Neil Kennedy',7),(66,'Dale Stewart',8),(67,'Hoyt Dillon',9),(68,'Eagan Martin',1),(69,'Acton Torres',2),(70,'Chester Singleton',4);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (71,'Garth Simon',8),(72,'Duncan Petty',4),(73,'Uriel Castaneda',9),(74,'Griffin Barton',1),(75,'Flynn Banks',7),(76,'Branden Booker',10),(77,'Magee Paul',8),(78,'Rudyard Vang',3),(79,'Theodore Burks',8),(80,'August Skinner',5);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (81,'Abbot Snow',3),(82,'Hakeem Combs',1),(83,'Kenyon Cox',2),(84,'Aladdin Stephens',5),(85,'Timon Guy',9),(86,'Walker King',9),(87,'Samuel Hardin',7),(88,'Ralph Mcmahon',6),(89,'Chase Dunlap',6),(90,'Paul Hardy',4);
INSERT INTO stuff_schema.stuff (stuff_id,stuff_name,division_id) VALUES (91,'Abraham Marsh',2),(92,'Ahmed Klein',6),(93,'Arsenio Jordan',9),(94,'Sean Kaufman',4),(95,'Adrian Jennings',4),(96,'Lewis Richardson',3),(97,'Thomas Stanton',9),(98,'Chaney Thompson',5),(99,'Howard Gilmore',7),(100,'Yuli Baldwin',5);


INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (1,51,9),(2,98,19),(3,17,26),(4,18,20),(5,26,26),(6,19,28),(7,49,26),(8,36,27),(9,74,1),(10,70,12);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (11,100,11),(12,66,22),(13,25,11),(14,19,26),(15,23,8),(16,13,25),(17,52,1),(18,40,11),(19,93,5),(20,9,14);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (21,10,6),(22,30,3),(23,22,9),(24,88,7),(25,31,18),(26,76,8),(27,33,16),(28,32,21),(29,69,17),(30,68,10);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (31,83,9),(32,14,23),(33,66,25),(34,34,6),(35,65,22),(36,17,14),(37,18,10),(38,23,9),(39,83,1),(40,99,27);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (41,91,4),(42,86,11),(43,84,27),(44,50,18),(45,68,9),(46,11,26),(47,41,24),(48,49,24),(49,8,15),(50,77,14);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (51,91,4),(52,58,13),(53,21,21),(54,9,29),(55,60,3),(56,74,21),(57,12,22),(58,26,3),(59,94,21),(60,75,23);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (61,32,26),(62,49,26),(63,94,22),(64,16,18),(65,69,5),(66,57,26),(67,80,1),(68,24,27),(69,56,13),(70,27,17);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (71,86,23),(72,71,12),(73,36,11),(74,77,30),(75,14,1),(76,2,7),(77,40,30),(78,29,25),(79,93,28),(80,57,11);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (81,60,6),(82,98,20),(83,50,22),(84,47,25),(85,84,27),(86,78,8),(87,69,13),(88,19,25),(89,79,17),(90,17,26);
INSERT INTO stuff_schema.stuff_phone (stuff_phone_id,stuff_id,phone_id) VALUES (91,80,17),(92,61,1),(93,55,28),(94,11,4),(95,94,10),(96,88,12),(97,46,3),(98,100,20),(99,24,12),(100,48,7);

SELECT setval('stuff_schema.stuff_stuff_id_seq', 100, true);
SELECT setval('stuff_schema.stuff_phone_stuff_phone_id_seq', 100, true);
SELECT setval('stuff_schema.phone_phone_id_seq', 30, true);
SELECT setval('stuff_schema.division_division_id_seq', 10, true);

commit;
