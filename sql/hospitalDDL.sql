-- 의료기관, 의료진
DROP TABLE custodian cascade constraint;

-- 환자
DROP TABLE patient constraint;

-- 진단내역
DROP TABLE problem cascade constraint;

--의뢰 및 예약 대상 의료기관
DROP TABLE informationrecipient cascade constraint;

DROP SEQUENCE patient_id_seq;

DROP TABLE problem;
DROP TABLE patient;
DROP TABLE custodian;
DROP TABLE informationrecipient;

CREATE TABLE custodian (
       MedicalLicenseID     NUMBER(5) PRIMARY KEY,
       CustodianName        VARCHAR2(20) NOT NULL,
       TelecomNumber        VARCHAR2(20) NOT NULL,
       OID               	NUMBER(9) NOT NULL,
       DoctorName           VARCHAR2(20) NOT NULL,
       DoctorTelecomNumber  VARCHAR2(20) NOT NULL,
       DepartmentCode       NUMBER(4) NOT NULL,
       DepartmentName       VARCHAR2(20) NOT NULL
);
​
CREATE TABLE informationrecipient (
	   OID     		        NUMBER(9) PRIMARY KEY,
	   OrganizationName 	VARCHAR2(20) NOT NULL,
       DoctorName           VARCHAR2(20) NOT NULL,       
       TelecomNumber        VARCHAR2(20) NOT NULL,
       City           		VARCHAR2(20) NOT NULL, 
       DepartmentName      	VARCHAR2(20) NOT NULL,
       DepartmentCode      	NUMBER(4) NOT NULL
);

CREATE TABLE patient (
       PatientId        	VARCHAR2(20) PRIMARY KEY,
       DateOfBirth          NUMBER(8) NOT NULL,
       PatientName          VARCHAR2(20) NOT NULL,
       Gender               VARCHAR2(20) NOT NULL,
       TelecomNumber        VARCHAR2(20) NOT NULL,
       City                 VARCHAR2(20) NOT NULL,
       ReservationDate      VARCHAR2(20) NOT NULL,
       ReservationTime      VARCHAR2(20) NOT NULL,
       MedicalLicenseID     NUMBER(5) NOT NULL
);
​
CREATE TABLE problem (
       PatientId          	VARCHAR2(20) NOT NULL,
       StartDate            NUMBER(10) NOT NULL,
       ProblemCode  	    VARCHAR2(20) NOT NULL,
       ProblemName  	    VARCHAR2(200) NOT NULL
);

CREATE SEQUENCE patient_id_seq;

ALTER TABLE problem ADD FOREIGN KEY (PatientId)  REFERENCES patient (PatientId);
ALTER TABLE patient  ADD FOREIGN KEY (MedicalLicenseID) REFERENCES custodian (MedicalLicenseID);
ALTER TABLE custodian ADD FOREIGN KEY (OID) REFERENCES informationrecipient (OID);