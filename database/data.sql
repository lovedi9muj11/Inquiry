INSERT INTO `ROLE` (`id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `ROLE` (`id`, `name`) VALUES ('2', 'SUP');
INSERT INTO `ROLE` (`id`, `name`) VALUES ('3', 'USER');

INSERT INTO `USER` (`ID`, `Name`, `SurName`, `Password`, `Username`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `LoginFlag`) VALUES (1, 'fname', 'lname', '5f4dcc3b5aa765d61d8327deb882cf99', 'admin', NULL, '2018-06-28 11:45:43.357761', NULL, '0000-00-00 00:00:00.000000', 'N');
INSERT INTO `USER` (`ID`, `Name`, `SurName`, `Password`, `Username`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `LoginFlag`) VALUES (2, 'fname1', 'lname2', '5f4dcc3b5aa765d61d8327deb882cf99', 'Epis1', NULL, '2018-06-28 11:45:59.323910', NULL, '0000-00-00 00:00:00.000000', 'Y');
INSERT INTO `USER` (`ID`, `Name`, `SurName`, `Password`, `Username`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `LoginFlag`) VALUES (3, 'fname3', 'lname3', '5f4dcc3b5aa765d61d8327deb882cf99', 'Epis11', NULL, '2018-06-28 11:46:08.152196', NULL, '0000-00-00 00:00:00.000000', 'Y');
INSERT INTO `USER` (`ID`, `Name`, `SurName`, `Password`, `Username`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `LoginFlag`) VALUES (4, 'fname4', 'lname4', '5f4dcc3b5aa765d61d8327deb882cf99', 'Epis12', NULL, '2018-06-28 11:46:14.200390', NULL, '0000-00-00 00:00:00.000000', 'Y');
INSERT INTO `USER` (`ID`, `Name`, `SurName`, `Password`, `Username`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `LoginFlag`) VALUES
	(5, 'EPIS6', 'Agent', '5f4dcc3b5aa765d61d8327deb882cf99', 'EPIS6', NULL, '2018-07-01 16:53:47.381260', NULL, '0000-00-00 00:00:00.000000', 'Y'),
	(6, 'EPIS7', 'GFMIS', '5f4dcc3b5aa765d61d8327deb882cf99', 'EPIS7', NULL, '2018-07-01 16:53:47.392668', NULL, '0000-00-00 00:00:00.000000', 'Y'),
	(7, 'EPIS5', 'Agent', '5f4dcc3b5aa765d61d8327deb882cf99', 'EPIS5', NULL, '2018-07-01 16:53:47.398618', NULL, '0000-00-00 00:00:00.000000', 'Y'),
	(9, 'EPIS3', 'Agent', '5f4dcc3b5aa765d61d8327deb882cf99', 'EPIS3', NULL, '2018-07-01 16:53:47.407548', NULL, '0000-00-00 00:00:00.000000', 'Y'),
	(10, 'EPIS2', 'Supervisor', '5f4dcc3b5aa765d61d8327deb882cf99', 'EPIS2', NULL, '2018-07-01 16:53:47.411019', NULL, '0000-00-00 00:00:00.000000', 'Y'),
	(11, 'preecha', 'Wiengpak', 'e10adc3949ba59abbe56e057f20f883e', 'preechaW', NULL, '2018-07-01 16:53:47.414985', NULL, '0000-00-00 00:00:00.000000', 'Y'),
	(12, 'kun', 'BACK', '5f4dcc3b5aa765d61d8327deb882cf99', 'kunback', NULL, '2018-07-01 16:53:47.418956', NULL, '0000-00-00 00:00:00.000000', 'Y');


INSERT INTO `USER_ROLE` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `USER_ROLE` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `USER_ROLE` (`user_id`, `role_id`) VALUES ('3', '3');
INSERT INTO `USER_ROLE` (`user_id`, `role_id`) VALUES ('4', '3');
INSERT INTO `USER_ROLE` (`User_ID`, `Role_ID`) VALUES
	(5, 3),
	(6, 3),
	(7, 3),
	(9, 3),
	(10, 2),
	(11, 3),
	(12, 3);

INSERT INTO `map_gl_service_type` (`ID`, `GL_CODE`, `SERVICE_CODE`, `PRODUCT_CODE`, `PRODUCT_NAME`, `SUB_PRODUCT_CODE`, `SUB_PRODUCT_NAME`, `SERVICE_NAME`, `REVENUE_TYPE_CODE`, `REVENUE_TYPE_NAME`, `SEGMENT_CODE`, `SEGMENT_NAME`, `STATUS`, `SOURCE`, `REMARK`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `RECORD_STATUS`) VALUES
	(1, '212121', 'CAT01', '101010001', 'บ.CAT 001', '01', 'บ.CAT 001	', '212121 02 - รด.บริการ-นปท. 01 - บ.CAT 001', '02', 'รด.บริการ-นปท.', '10101', 'IDD', '1', 'OTHER', NULL, 'EPIS0', '2018-09-16 00:00:00.000000', 'EPIS0', '2018-09-16 00:00:00.000000', NULL),
	(2, '0021902202', 'my', '104010002', 'บ.my-PREPAID', '02', 'บ.VOICE	', 'บริการเติมเงิน my by CAT', '99', 'อื่น', '10401', 'my', '1', 'TOPUP', NULL, 'EPIS00', '2018-09-16 00:00:00.000000', 'EPIS00', '2018-09-16 00:00:00.000000', NULL);
	
INSERT INTO `master_data` (`ID`, `KEYCODE`, `VALUE`, `GROUP_KEY`, `TYPE`, `STATUS`, `ORDERED`, `PARENT_ID`, `REF_ID`, `PROPERTY_1`, `PROPERTY_2`, `PROPERTY_3`, `PROPERTY_4`, `PROPERTY_5`, `REMARK`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `RECORD_STATUS`) VALUES
	(1, 'Trigger_MS', '0 15 10 15 * ?', 'TriggerGoup', 'null', 'null', 'Master Data', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'every month', 'null', '2018-05-26 00:00:00.000000', 'null', '2018-05-26 00:00:00.000000', NULL),
	(2, 'Trigger_GL', '0 15 10 ? * SUN', 'TriggerGoup', 'null', 'null', 'Map GL', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'every week', 'null', '2018-05-26 00:00:00.000000', 'null', '2018-05-26 00:00:00.000000', NULL),
	(3, 'Trigger_User', '0 15 10 * * ?', 'TriggerGoup', 'null', 'null', 'Sync User', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'every day', 'null', '2018-05-26 00:00:00.000000', 'null', '2018-05-26 00:00:00.000000', NULL),
	(4, 'Trigger_Minus', '0 15 10 * * ?', 'TriggerGoup', 'null', 'null', 'Minus Online', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'every time', 'null', '2018-05-26 00:00:00.000000', 'null', '2018-05-26 00:00:00.000000', NULL),
