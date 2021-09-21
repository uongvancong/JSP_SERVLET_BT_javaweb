use student_subject_db;
SET FOREIGN_KEY_CHECKS=0;
 
CREATE TABLE   student(
   id int(10) NOT NULL AUTO_INCREMENT,  
   name varchar(100) NOT NULL,
   age varchar(100)  NULL,	
   address varchar(100) NULL,
   PRIMARY KEY ( id )
);


CREATE TABLE subject(
    id int(10) not null auto_increment,
    name varchar(100) NOT NULL,
     PRIMARY KEY ( id )
);

CREATE TABLE register(
    id int(10) not null auto_increment,
    name varchar(100) NOT NULL,
    idstudent int(10) NOT NULL,
    idsubject int(10) NOT NULL,
	PRIMARY KEY ( id )
);
ALTER TABLE register ADD CONSTRAINT fk_student_register FOREIGN KEY (idstudent) REFERENCES student(id);
ALTER TABLE register ADD CONSTRAINT fk_subject_register FOREIGN KEY (idsubject) REFERENCES subject(id);

insert into student(name,age, address) values("cong", "18", "hanoi");
insert into student(name,age, address) values("minh", "19", "bac ninh");
insert into student(name,age, address) values("tuyen", "22", "bac giang");


 select * from student;
 
 