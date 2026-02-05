-- SQL script tạo database và bảng mẫu cho project Web_08_a
-- Chạy bằng SQL Server Management Studio (SSMS) hoặc sqlcmd

CREATE DATABASE PRJ30x_DB1;
GO
USE PRJ30x_DB1;
GO

CREATE TABLE tblUniversity (
  id VARCHAR(50) PRIMARY KEY,
  name NVARCHAR(255),
  shortName NVARCHAR(100),
  description NVARCHAR(MAX),
  foundedYear INT,
  address NVARCHAR(255),
  city NVARCHAR(100),
  region NVARCHAR(100),
  type NVARCHAR(100),
  totalStudents INT,
  totalFaculties INT,
  isDraft BIT
);
GO

INSERT INTO tblUniversity (id,name,shortName,foundedYear,city,type,totalStudents,totalFaculties,isDraft)
VALUES ('U001','Đại học A','DA',1990,'HCMC','Public',10000,20,1),
       ('U002','Đại học B','DB',1985,'Hanoi','Private',8000,15,1);
GO
