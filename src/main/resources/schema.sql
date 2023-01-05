DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
employeeId INT AUTO_INCREMENT  PRIMARY KEY,
name varchar(20) NULL,
dob varchar(20)  NULL,
pan varchar(20)  NULL ,
adress varchar(20)  NULL ,
departmentId INT  NULL
);

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
deptId INT AUTO_INCREMENT  PRIMARY KEY,
deptName varchar(20)  NULL,
deptHead varchar(20)  NULL
);
