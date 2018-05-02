CREATE DATABASE IF NOT EXISTS `EPIS`; USE `EPIS`;
DROP TABLE IF EXISTS `DEDUCTION_MANUAL`;
DROP TABLE IF EXISTS `RECEIPT_MANUAL`;
DROP TABLE IF EXISTS `PAYMENT_INVOICE`;
DROP TABLE IF EXISTS `PAYMENT_INVOICE_MANUAL`;
DROP TABLE IF EXISTS `TRSCREDITREF_MANUAL`;
DROP TABLE IF EXISTS `TRSCHEQUEREF_MANUAL`;
DROP TABLE IF EXISTS `TRSMETHOD_MANUAL`;
DROP TABLE IF EXISTS `METHOD_MANUAL_ID`;
DROP TABLE IF EXISTS `ROLE`;
DROP TABLE IF EXISTS `USER`;
DROP TABLE IF EXISTS `USER_ROLE`;
DROP TABLE IF EXISTS `MASTER_DATA`;

CREATE TABLE IF NOT EXISTS `EPIS`.`DEDUCTION_MANUAL` (
	DEDUCTION_MANUAL_ID BIGINT NOT NULL AUTO_INCREMENT,
	DEDUCTIONNO VARCHAR(40),
	DEDUCTIONTYPE VARCHAR(10),
	AMOUNT DECIMAL(14,4),
	PAYMENTDATE DATE,
	UPDATEDTTM TIMESTAMP(6),
	UPDATESYSTEM CHAR(3),
	UPDATEUSER VARCHAR(32),
	VERSIONSTAMP BIGINT,
	INVOICE_NO VARCHAR(30),
	REMARK VARCHAR(100),
	CREATE_BY VARCHAR(20),
	CREATE_DATE TIMESTAMP(6),
	UPDATE_BY VARCHAR(20),
	UPDATE_DATE TIMESTAMP(6),
	RECORD_STATUS VARCHAR(20),
	MANUAL_ID BIGINT, PRIMARY KEY (DEDUCTION_MANUAL_ID)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`RECEIPT_MANUAL` (
	MANUAL_ID BIGINT NOT NULL AUTO_INCREMENT,
	PAYMENT_ID BIGINT,
	INVOICE_NO VARCHAR(30),
	RECEIPT_NO_MANUAL VARCHAR(30),
	PAID_DATE TIMESTAMP(6),
	BRANCH_AREA VARCHAR(100),
	BRANCH_CODE VARCHAR(20),
	PAID_AMOUNT DECIMAL(14,4),
	SOURCE VARCHAR(20),
	CLEARING VARCHAR(20),
	REMARK VARCHAR(50),
	CREATE_BY VARCHAR(20),
	CREATE_DATE TIMESTAMP(6),
	UPDATE_BY VARCHAR(20),
	UPDATE_DATE TIMESTAMP(6),
	RECORD_STATUS VARCHAR(20),
	REF_ID BIGINT,
	ACCOUNT_NO VARCHAR(35),
	PAY_TYPE VARCHAR(20),
	DOCTYPE VARCHAR(20),
	CHANG DECIMAL(14,4),
	AMOUNT DECIMAL(14,4),
	VAT_RATE INT ,
	VAT_AMOUNT DECIMAL(14,4),PRIMARY KEY (MANUAL_ID)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`PAYMENT_INVOICE` (
	INV_ID BIGINT NOT NULL AUTO_INCREMENT,
	MANUAL_ID BIGINT,
	INVOICE_NO varchar(30) ,
	INVOICE_DATE timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
	DATE_LINE timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
	BEFOR_VAT decimal(14,4) ,
  VAT_AMOUNT decimal(14,4) ,
  PAID_AMOUNT decimal(14,4) ,
	AMOUNT decimal(14,4) ,
  VAT_RATE varchar(10),
  CUSTOMER_NAME varchar(300),
  CUSTOMER_ADDRESS varchar(300) ,
  CUSTOMER_SEGMENT varchar(300),
  CUSTOMER_BRANCH varchar(300) ,
  TAXNO varchar(25) ,
  ACCOUNTSUBNO varchar(25) ,
  PERIOD varchar(20) ,
	SERVICENAME varchar(300) ,
  SERVICE_TYPE varchar(45) ,
	CHANG decimal(14,4)	,
	CREATE_BY VARCHAR(20),
	CREATE_DATE TIMESTAMP(6),
	UPDATE_BY VARCHAR(20),
	UPDATE_DATE TIMESTAMP(6),
	RECORD_STATUS VARCHAR(20),
	DISCOUNT decimal(14,4) ,
	PRIMARY KEY (INV_ID) 
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`PAYMENT_INVOICE_MANUAL` (
  PAYMENT_INVOICE_MANUAL_ID BIGINT NOT NULL AUTO_INCREMENT,
  MANUAL_ID bigint(20) ,
  SOURCE varchar(30) ,
  INVOICE_NO varchar(30) ,
  BEFOR_VAT decimal(14,4) ,
  VAT_AMOUNT decimal(14,4) ,
  AMOUNT decimal(14,4) ,
  VAT_RATE varchar(10),
  CUSTOMER_NAME varchar(300),
  CUSTOMER_ADDRESS varchar(300) ,
  CUSTOMER_SEGMENT varchar(300),
  CUSTOMER_BRANCH varchar(300) ,
  TAXNO varchar(25) ,
  ACCOUNTSUBNO varchar(25) ,
  PERIOD varchar(20) ,
  SERVICE_TYPE varchar(45) ,
  CLEARING varchar(20) ,
  PRINT_RECEIPT varchar(20) ,
  REMARK varchar(100) ,
  CREATE_BY varchar(20) ,
  CREATE_DATE timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  UPDATE_BY varchar(20)  ,
  UPDATE_DATE timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  RECORD_STATUS varchar(20) ,
  QUANTITY int(11) ,
  INCOMETYPE varchar(50) ,
  DISCOUNTBEFORVAT decimal(10,0) ,
  DISCOUNTSPECIAL decimal(10,0) ,
  AMOUNTTYPE varchar(10) ,
  DEPARTMENT varchar(50) ,
  SERVICENAME varchar(300) ,
  SERVICECODE varchar(300) ,
  INVOICE_DATE TIMESTAMP(6),
  PRIMARY KEY (PAYMENT_INVOICE_MANUAL_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`TRSCREDITREF_MANUAL` (
	ID BIGINT NOT NULL AUTO_INCREMENT,
	CREDITNO VARCHAR(40),
	PUBLISHERDEC VARCHAR(20),
	CARDTYPE VARCHAR(20),
	AMOUNT DECIMAL(14,2),
	UPDATEDTTM TIMESTAMP(6),
	UPDATESYSTEM CHAR(3),
	UPDATEUSER VARCHAR(32),
	VERSIONSTAMP DECIMAL,
	METHOD_MANUAL_ID BIGINT, PRIMARY KEY (ID)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`TRSCHEQUEREF_MANUAL` (
	ID BIGINT NOT NULL AUTO_INCREMENT,
	CHEQUENO VARCHAR(40),
	PUBLISHERID VARCHAR(20),
	PUBLISHER VARCHAR(300),
	BRANCH VARCHAR(300),
	AMOUNT DECIMAL(14,2),
	UPDATEDTTM TIMESTAMP(6),
	UPDATESYSTEM CHAR(3),
	UPDATEUSER VARCHAR(32),
	VERSIONSTAMP BIGINT,
	CHEQUEDATE TIMESTAMP(6),
	BOUNCE_CHEQUE_DATE TIMESTAMP(6),
	REVERSE_AR_DATE TIMESTAMP(6),
	BOUNCE_STATUS VARCHAR(20),
	METHOD_MANUAL_ID BIGINT, PRIMARY KEY (ID)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`TRSMETHOD_MANUAL` (
	METHOD_MANUAL_ID BIGINT NOT NULL AUTO_INCREMENT,
	CODE VARCHAR(13),
	NAME VARCHAR(200),
	CHEQUENO VARCHAR(40),
	CREDITNO VARCHAR(40),
	ACCOUNTNO VARCHAR(40),
	AMOUNT DECIMAL(14,4),
	UPDATEDTTM TIMESTAMP(6),
	UPDATESYSTEM CHAR(3),
	UPDATEUSER VARCHAR(32),
	VERSIONSTAMP BIGINT,
	OFFSET_DOCUMENT_NO VARCHAR(255),
	OFFSET_ACCOUNT_CODE VARCHAR(255),
	OFFSET_ACCOUNT_NAME VARCHAR(255),
	REMARK VARCHAR(100),
	CREATE_BY VARCHAR(20),
	CREATE_DATE TIMESTAMP(6),
	UPDATE_BY VARCHAR(20),
	UPDATE_DATE TIMESTAMP(6),
	RECORD_STATUS VARCHAR(20),
	REF_ID BIGINT,
	DEDUCTION_MANUAL_ID BIGINT,
	MANUAL_ID BIGINT, PRIMARY KEY (METHOD_MANUAL_ID)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`ROLE` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`USER` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`password` VARCHAR(255) NULL DEFAULT NULL,
	`username` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`USER_ROLE` (
	`user_id` BIGINT(20) NOT NULL,
	`role_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`user_id`, `role_id`)
)DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `EPIS`.`MASTER_DATA` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`valueKey` VARCHAR(255) NULL DEFAULT NULL,
	`text` VARCHAR(255) NULL DEFAULT NULL,
	`groupType` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8;