# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2020-07-11 12:13:13
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "action_group"
#

DROP TABLE IF EXISTS `action_group`;
CREATE TABLE `action_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "action_group"
#

INSERT INTO `action_group` VALUES (1,'��������','base_data'),(2,'��Ŀ����','project_mana'),(3,'��ͬ����','contract_mana'),(4,'�������','finance_mana'),(5,'ϵͳ����','system_set');

#
# Structure for table "action"
#

DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `groupId` int(11) DEFAULT NULL COMMENT 'Ȩ����Id',
  PRIMARY KEY (`id`),
  KEY `fk_action_group` (`groupId`),
  CONSTRAINT `fk_action_group` FOREIGN KEY (`groupId`) REFERENCES `action_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Data for table "action"
#

INSERT INTO `action` VALUES (1,'�ͻ���Ϣ','client_info','/clients','2019-10-17 20:27:49',NULL,1),(2,'������Ӧ����Ϣ','tsupplier_info','/tsupplier','2019-10-17 20:29:43',NULL,1),(3,'���ʹ�Ӧ����Ϣ','zsupplier_info','/zsupplier','2019-10-17 20:31:53',NULL,1),(4,'��Ŀ����Ŀ¼','project_process','/process','2019-10-17 20:31:53',NULL,1),(5,'��Ŀ����','project','/project','2019-10-17 20:35:00',NULL,2),(6,'��ĿԤ��','project_budget','/budget','2019-10-17 20:35:00',NULL,2),(7,'��Ŀ��ǲ','project_send','/send','2019-10-17 20:35:00',NULL,2),(8,'��Ŀ����','project_accept','/accept','2019-10-17 20:35:00',NULL,2),(9,'���ۺ�ͬ','sale_contract','/contracts','2019-10-17 20:39:08',NULL,3),(10,'�ɹ���ͬ','purchase_contract','/contracts','2019-10-17 20:39:08',NULL,3),(11,'��Ʊ����','bill','/bill','2019-10-17 20:39:08',NULL,4),(12,'��Ŀ��֧','project_inout','/inout','2019-10-17 20:39:08',NULL,4),(13,'��Ŀ����','project_accout','/account','2019-10-17 20:39:08',NULL,4),(14,'��û�ɱ�','sunk_cost','/cost','2019-10-17 20:39:08',NULL,4),(21,'��������','basic_data','/basic','2019-10-17 20:42:32',NULL,5),(22,'����û�','add_user','/adduser','2019-10-17 20:42:32',NULL,5),(23,'�û�Ȩ��','user_action','/action','2019-10-17 20:42:32',NULL,5);

#
# Structure for table "customer_info"
#

DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `receiveAddress` varchar(255) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `taxNumber` varchar(255) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `billNumber` varchar(100) DEFAULT NULL,
  `phone` varchar(111) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sale` varchar(50) DEFAULT NULL,
  `wechat` varchar(50) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `code` varchar(100) NOT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "customer_info"
#

INSERT INTO `customer_info` VALUES (1,'name1','Address1','receive1','bank1','taxnumber1','contact1','billNumber1','phone1','email1','sale1','wechat1','remark1','2019-10-25 02:18:38','2019-10-25 02:28:21','code1',1),(2,'name1','Address','receive','bank','taxnumber','contact','billNumber','phone','email','sale','wechat','remark','2019-10-25 02:20:10','2019-10-26 03:12:32','code',1),(3,'�ͻ�����','����׳�����������������������纸��','����׳������������й�ƽ�дﵽ','������','˰��','��ϵ��','��Ʊ','�绰','eqeqhw@qq.com','���ǻ�','΢��','��ע','2019-10-26 21:27:18','2019-10-27 00:51:53','',1),(4,'��Ϊ��˾','����׳��������������������������㳡','����׳������������й�ƽ������㳡','�й�����','dhah7123676123','�����','431556321382138712','163712137828','341516@qq.com','���ǻ�','6eyqy721371','��ע','2019-10-27 00:45:02',NULL,'KH201910001',0),(5,'С�׹�˾1','����׳��������������������������㳡','�㶫�������������㳡','�й�����1','dhah71236761231','�׾���','431556321382138712','33ee12312137828','e231@qq.com','���','2321113711','��ע','2019-10-27 00:45:52','2019-10-27 03:20:03','KH201910001',0),(6,'oppo��˾123321','����׳�������������и���������㳡','����׳�������������ƽ��������㳡','�й�����','dhah7123676123','�׾�312','431556321382138712','12312137828231','123411516@qq.com','����','232111371132','��ע12332','2019-10-27 00:46:06','2019-10-27 22:03:40','KH201910001',0),(7,'�����ֻ�','����׳��������������������������У��','�㶫���ݷ�خ���޼Ҵ�','ũ������','617371qwe63818','�ϴ�','hu3612637717','15678376340','137181@qq.com','���','12312123','���˼�������ҵ','2019-10-27 22:07:49',NULL,'KH201910002',0);

#
# Structure for table "department"
#

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(1) NOT NULL DEFAULT '1',
  `code` varchar(255) NOT NULL,
  `director` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

#
# Data for table "department"
#

INSERT INTO `department` VALUES (22,'�����',1,'1571321263954536','������'),(23,'����',1,'1571321271928460','����Ⱦ��'),(24,'�������²�',1,'1571321279370132','����'),(25,'����',1,'1571321285546677','��ɭ˹'),(26,'�󻮲�',1,'1571321291855668','������'),(27,'���̲�',1,'1571321297932398','��»�'),(28,'�豸��',1,'1571321303686805','���'),(29,'���ڲ�',1,'1571321310302518','������'),(30,'������',1,'1571321319487855','���'),(31,'����ʩ��ͼ������',1,'1571321326849558','��ɺɺ'),(32,'����ʩ��ͼ��һ��',1,'1571321335306581','������'),(33,'������Ʋ�������',1,'157132134219370','�¹���'),(34,'������Ʋ�����',1,'1571321375945688','������'),(35,'������Ʋ�����',1,'1571321425128139','����˹'),(36,'������Ʋ�����',1,'1571321432786639','�����'),(37,'������Ʋ�����',1,'1571321443282149','������'),(38,'������Ʋ�����',1,'1571321449698525','����'),(39,'������Ʋ�һ��',1,'1571321455475968','����'),(40,'��Ŀ��',1,'1571321461666488','���ǻ�');

#
# Structure for table "document"
#

DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `projectId` int(11) DEFAULT '0',
  `contractId` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

#
# Data for table "document"
#

INSERT INTO `document` VALUES (1,'QQͼƬ20190623101535.jpg','/src/static/img/project/15741034393372355.jpg','2019-11-19 02:57:19','2019-11-19 02:57:19',3,NULL,NULL),(2,'΢��ͼƬ_20191030010235.jpg','/src/static/img/project/15741034393473944.jpg','2019-11-19 02:57:19','2019-11-19 02:57:19',3,NULL,NULL),(3,'QQͼƬ20190623101520.png','/src/static/img/project/15741038177229653.png','2019-11-19 03:03:37','2019-11-19 03:03:37',3,NULL,NULL),(4,'΢��ͼƬ_20191030010235.jpg','/src/static/img/project/15741038648279763.jpg','2019-11-19 03:04:24','2019-11-19 03:04:24',3,NULL,NULL),(5,'QQͼƬ20190623101535.jpg','/src/static/img/project/15741042211014646.jpg','2019-11-19 03:10:21','2019-11-19 03:10:21',3,NULL,NULL),(6,'΢��ͼƬ_20191030010235.jpg','/src/static/img/contract/1574161788136.jpg','2019-11-19 19:09:47','2019-11-19 19:09:47',0,4,'jpg'),(7,'΢��ͼƬ_20191030010235.mkm','/src/static/img/contract/1574161791850.mkm','2019-11-19 19:09:47','2019-11-19 19:09:47',0,4,'mkm'),(8,'QQͼƬ20190623101520.png','/src/static/img/contract/1574162311600.png','2019-11-19 19:18:23','2019-11-19 19:18:23',0,5,'png'),(9,'΢��ͼƬ_20191030010235.mkm','/src/static/img/contract/1574162303294.mkm','2019-11-19 19:18:23','2019-11-19 19:18:23',0,5,'mkm'),(10,'QQͼƬ20190623101535.jpg','/src/static/img/contract/1574185837347.jpg','2019-11-20 01:50:30','2019-11-20 01:50:30',0,6,'jpg'),(11,'��Դ����-����1911-2565��.pdf','/src/static/img/contract/1574185833364.pdf','2019-11-20 01:50:30','2019-11-20 01:50:30',0,6,'pdf'),(12,'vue�ܽ�.txt','/src/static/img/contract/1574185830649.txt','2019-11-20 01:50:30','2019-11-20 01:50:30',0,6,'txt'),(13,'�������.txt','/src/static/img/contract/1574187143565.txt','2019-11-20 02:12:19','2019-11-20 02:12:19',0,7,'txt'),(15,'��ɫ.png','/src/static/img/contract/1574188393605.png','2019-11-20 02:33:12','2019-11-20 02:33:12',0,9,'png'),(17,'sql�ܽ�.txt','/src/static/img/contract/1574188434400.txt','2019-11-20 02:33:54','2019-11-20 02:33:54',0,10,'txt'),(18,'java�ܽ�.txt','/src/static/img/contract/1574188614335.txt','2019-11-20 02:36:50','2019-11-20 02:36:50',0,0,'txt'),(19,'idea.txt','/src/static/img/contract/1574188612287.txt','2019-11-20 02:36:50','2019-11-20 02:36:50',0,0,'txt'),(20,'idea.txt','/src/static/img/contract/1574188736738.txt','2019-11-20 02:38:48','2019-11-20 02:38:48',0,0,'txt'),(21,'css�ܽ�.txt','/src/static/img/contract/1574188734962.txt','2019-11-20 02:38:48','2019-11-20 02:38:48',0,0,'txt'),(22,'idea.txt','/src/static/img/contract/1574189029165.txt','2019-11-20 02:43:48','2019-11-20 02:43:48',0,1,'txt'),(23,'css�ܽ�.txt','/src/static/img/contract/1574189031733.txt','2019-11-20 02:43:48','2019-11-20 02:43:48',0,1,'txt'),(24,'idea.txt','/src/static/img/contract/1574189644718.txt','2019-11-20 02:53:56','2019-11-20 02:53:56',0,11,'txt');

#
# Structure for table "first_process"
#

DROP TABLE IF EXISTS `first_process`;
CREATE TABLE `first_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "first_process"
#

INSERT INTO `first_process` VALUES (4,'�����Թ滮���','2019-10-29 18:19:48'),(5,'����滮���','2019-10-29 18:19:57'),(6,'��ϸ�滮�����������','2019-10-29 18:20:12'),(7,'�������','2019-10-29 18:20:26'),(8,'ʩ��ͼ���','2019-10-29 18:20:43');

#
# Structure for table "income_out_category"
#

DROP TABLE IF EXISTS `income_out_category`;
CREATE TABLE `income_out_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

#
# Data for table "income_out_category"
#

INSERT INTO `income_out_category` VALUES (9,'�����ɱ�'),(10,'���÷�'),(11,'�д���'),(12,'�����ɱ�'),(13,'���ط�'),(14,'����ɱ�'),(15,'��Ʒ�'),(16,'��Ͷ��ɱ�');

#
# Structure for table "position_"
#

DROP TABLE IF EXISTS `position_`;
CREATE TABLE `position_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "position_"
#

INSERT INTO `position_` VALUES (1,'����',1),(2,'�ܾ���',1),(3,'���ܾ���',1),(4,'����',1),(5,'���ʦ',1);

#
# Structure for table "project_property"
#

DROP TABLE IF EXISTS `project_property`;
CREATE TABLE `project_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "project_property"
#

INSERT INTO `project_property` VALUES (3,'��������Ŀ'),(4,'��������Ŀ');

#
# Structure for table "project_type"
#

DROP TABLE IF EXISTS `project_type`;
CREATE TABLE `project_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "project_type"
#

INSERT INTO `project_type` VALUES (3,'����'),(4,'����'),(5,'���ۼӽ���');

#
# Structure for table "province"
#

DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "province"
#

INSERT INTO `province` VALUES (2,'����׳��������'),(4,'�㶫'),(5,'����ʡ'),(6,'����ʡ');

#
# Structure for table "city"
#

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `provinceId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_province_city` (`provinceId`),
  CONSTRAINT `fk_province_city` FOREIGN KEY (`provinceId`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "city"
#

INSERT INTO `city` VALUES (6,'����',4),(7,'������',2),(8,'��ɽ��',4),(9,'�����',2),(10,'������',2),(11,'������',2);

#
# Structure for table "area"
#

DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_city_area` (`cityId`),
  CONSTRAINT `fk_city_area` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

#
# Data for table "area"
#

INSERT INTO `area` VALUES (4,'�����',6),(5,'��������',7),(6,'������',7),(7,'��ƽ��',9),(8,'������',9),(9,'ƽ����',9),(10,'������',10),(11,'������',11),(12,'��˷��',11),(13,'��ɽ��',11),(14,'������',6),(15,'������',6),(16,'��خ��',6);

#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "role"
#

INSERT INTO `role` VALUES (1,'�ܾ���','ceo','���Ȩ��'),(2,'���ܾ���','vince','�ڶ���Ȩ��'),(3,'��Ŀ������','project','ӵ����Ŀ�����Ȩ��'),(4,'����','director','����Ȩ��'),(5,'���ʦ','designer','����Ȩ��'),(6,'����','finance','������Ȩ��'),(7,'ϵͳ����Ա','admin','ϵͳ����Ա');

#
# Structure for table "role_action"
#

DROP TABLE IF EXISTS `role_action`;
CREATE TABLE `role_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `actionId` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_roleaction` (`roleId`),
  KEY `fk_action_roleaction` (`actionId`),
  CONSTRAINT `fk_action_roleaction` FOREIGN KEY (`actionId`) REFERENCES `action` (`id`),
  CONSTRAINT `fk_role_roleaction` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

#
# Data for table "role_action"
#

INSERT INTO `role_action` VALUES (1,1,1,'2019-10-17 21:16:52',NULL),(2,1,2,'2019-10-17 21:16:52',NULL),(3,1,3,'2019-10-17 21:16:52',NULL),(4,1,4,'2019-10-17 21:16:52',NULL),(5,1,5,'2019-10-17 21:16:52',NULL),(6,1,6,'2019-10-17 21:16:52',NULL),(7,1,7,'2019-10-17 21:16:52',NULL),(8,1,8,'2019-10-17 21:16:52',NULL),(9,1,9,'2019-10-17 21:16:52',NULL),(10,1,10,'2019-10-17 21:16:52',NULL),(11,1,11,'2019-10-17 21:16:52',NULL),(12,1,12,'2019-10-17 21:16:52',NULL),(13,1,13,'2019-10-17 21:16:52',NULL),(14,1,14,'2019-10-17 21:16:52',NULL),(15,1,21,'2019-10-17 21:16:52',NULL),(16,1,22,'2019-10-17 21:16:52',NULL),(17,1,23,'2019-10-17 21:16:52',NULL),(18,2,1,'2019-10-17 21:18:11',NULL),(19,2,2,'2019-10-17 21:18:11',NULL),(20,2,3,'2019-10-17 21:18:11',NULL),(21,2,4,'2019-10-17 21:18:11',NULL),(22,2,5,'2019-10-17 21:18:11',NULL),(23,2,6,'2019-10-17 21:18:11',NULL),(24,2,7,'2019-10-17 21:18:11',NULL),(25,2,8,'2019-10-17 21:18:11',NULL),(26,2,9,'2019-10-17 21:18:11',NULL),(27,2,10,'2019-10-17 21:18:11',NULL),(28,2,11,'2019-10-17 21:18:11',NULL),(29,2,12,'2019-10-17 21:18:11',NULL),(30,2,13,'2019-10-17 21:18:11',NULL),(31,2,14,'2019-10-17 21:18:11',NULL),(32,2,21,'2019-10-17 21:18:11',NULL),(33,2,22,'2019-10-17 21:18:11',NULL),(34,2,23,'2019-10-17 21:18:11',NULL),(35,3,5,'2019-10-17 21:20:16',NULL),(36,3,6,'2019-10-17 21:20:16',NULL),(37,3,7,'2019-10-17 21:20:16',NULL),(38,3,8,'2019-10-17 21:20:16',NULL),(39,4,1,'2019-10-17 21:26:43',NULL),(40,4,2,'2019-10-17 21:26:43',NULL),(41,4,3,'2019-10-17 21:26:43',NULL),(42,4,4,'2019-10-17 21:26:43',NULL),(43,4,7,'2019-10-17 21:26:43',NULL),(44,4,9,'2019-10-17 21:26:43',NULL),(45,4,10,'2019-10-17 21:26:43',NULL),(46,5,1,'2019-10-17 21:27:14',NULL),(47,5,2,'2019-10-17 21:27:14',NULL),(48,5,3,'2019-10-17 21:27:14',NULL),(49,5,4,'2019-10-17 21:27:14',NULL),(50,5,7,'2019-10-17 21:27:14',NULL),(51,5,9,'2019-10-17 21:27:14',NULL),(52,5,10,'2019-10-17 21:27:14',NULL),(53,6,6,'2019-10-17 21:28:02',NULL),(54,6,10,'2019-10-17 21:28:02',NULL),(55,6,11,'2019-10-17 21:28:02',NULL),(56,6,12,'2019-10-17 21:28:02',NULL),(57,6,10,'2019-10-17 21:28:02',NULL),(58,7,1,'2019-10-17 21:29:16',NULL),(59,7,2,'2019-10-17 21:29:16',NULL),(60,7,3,'2019-10-17 21:29:16',NULL),(61,7,4,'2019-10-17 21:29:16',NULL),(62,7,5,'2019-10-17 21:29:16',NULL),(63,7,6,'2019-10-17 21:29:16',NULL),(64,7,7,'2019-10-17 21:29:16',NULL),(65,7,8,'2019-10-17 21:29:16',NULL),(66,7,9,'2019-10-17 21:29:16',NULL),(67,7,10,'2019-10-17 21:29:16',NULL),(68,7,11,'2019-10-17 21:29:16',NULL),(69,7,12,'2019-10-17 21:29:16',NULL),(70,7,13,'2019-10-17 21:29:16',NULL),(71,7,14,'2019-10-17 21:29:16',NULL),(72,7,21,'2019-10-17 21:29:16',NULL),(73,7,22,'2019-10-17 21:29:16',NULL),(74,7,23,'2019-10-17 21:29:16',NULL);

#
# Structure for table "second_process"
#

DROP TABLE IF EXISTS `second_process`;
CREATE TABLE `second_process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `createDate` datetime NOT NULL,
  `firstId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_first_second_process` (`firstId`),
  CONSTRAINT `fk_first_second_process` FOREIGN KEY (`firstId`) REFERENCES `first_process` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

#
# Data for table "second_process"
#

INSERT INTO `second_process` VALUES (2,'��ƽͼ���','2019-10-29 18:52:33',4),(4,'�������','2019-10-29 18:56:45',4),(5,'�������','2019-10-29 18:56:53',4),(6,'��������','2019-10-29 18:57:05',4),(7,'�ı�����','2019-10-29 18:57:14',4),(8,'�������','2019-10-29 18:57:21',4),(9,'���б༭','2019-10-29 18:57:32',4),(10,'��ƽͼ���','2019-10-29 18:57:55',5),(11,'�������','2019-10-29 18:58:01',5),(12,'�������','2019-10-29 18:58:09',5),(13,'��������','2019-10-29 18:58:19',5),(14,'ˮ�������ƣ��豸��','2019-10-29 18:58:34',5),(15,'�ı�����','2019-10-29 18:58:44',5),(16,'�������','2019-10-29 18:58:57',5),(17,'��ͼ���','2019-10-29 18:59:24',6),(18,'������ͼ���','2019-10-29 18:59:34',6),(19,'������ͼ���','2019-10-29 18:59:49',6),(20,'�̻���ͼ���','2019-10-29 18:59:55',6),(21,'ˮ�������ͼ��ƣ��豸��','2019-10-29 19:00:11',6),(22,'��������','2019-10-29 19:00:16',6),(23,'�ı�����','2019-10-29 19:00:25',6),(24,'�������','2019-10-29 19:00:32',6),(25,'�������˵��','2019-10-29 19:01:03',7),(26,'�������','2019-10-29 19:01:09',7),(27,'԰�����','2019-10-29 19:01:16',7),(28,'ˮ��������','2019-10-29 19:01:30',7),(29,'�ṹ���','2019-10-29 19:01:39',7),(30,'�̻����','2019-10-29 19:01:43',7),(31,'�ڵ����','2019-10-29 19:01:51',7),(32,'��Ƹ���','2019-10-29 19:02:00',7),(33,'ʩ��ͼ���˵��','2019-10-29 19:02:26',8),(34,'�������','2019-10-29 19:02:33',8),(35,'԰�����','2019-10-29 19:02:40',8),(36,'ˮ��������','2019-10-29 19:02:51',8),(37,'�̻����','2019-10-29 19:03:03',8),(38,'�ڵ����','2019-10-29 19:03:10',8);

#
# Structure for table "supplier_type"
#

DROP TABLE IF EXISTS `supplier_type`;
CREATE TABLE `supplier_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "supplier_type"
#

INSERT INTO `supplier_type` VALUES (7,'���'),(8,'ԭ����');

#
# Structure for table "tsupplier_info"
#

DROP TABLE IF EXISTS `tsupplier_info`;
CREATE TABLE `tsupplier_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `wechat` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `remark1` varchar(1000) DEFAULT NULL,
  `remark2` varchar(1000) DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `code` varchar(100) NOT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  `contact` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "tsupplier_info"
#

INSERT INTO `tsupplier_info` VALUES (1,'name4','address4','EMAIL4','wechat4','phone4','remark14','remark24','2019-10-25 17:46:25','2019-10-28 17:20:41','code4',1,'contact4'),(2,'���ǵϵ��1','����׳�������������������������ǵ������㳡1','121123213@qq.com','1232331','13671366182131','��ע1�ƻ�Իͻ�����������������1','��ע2�纸��ad��1','2019-10-28 16:45:47','2019-10-28 17:20:41','GS201910001',1,'mrs��1'),(3,'���ǵϵ��','����׳������������и���������ʥ����','53165361666@qq.com','12333333','13677283781','��עһ','�Ļش��Ƕ�������������','2019-10-28 17:21:48',NULL,'GS201910001',0,'��Ż�');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(400) DEFAULT NULL,
  `userName` varchar(500) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `failNumber` int(11) DEFAULT '0',
  `departmentId` int(11) DEFAULT NULL COMMENT '��������',
  `positionId` int(11) DEFAULT NULL COMMENT 'ְλ',
  `isheadImage` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_department_user` (`departmentId`),
  KEY `fk_position_user` (`positionId`),
  CONSTRAINT `fk_department_user` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_position_user` FOREIGN KEY (`positionId`) REFERENCES `position_` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (4,'21332232@qq.com','12345678','qweweq',NULL,NULL,NULL,3,32,2,0),(5,'123456@qq.com','123456','����','had����������','123','123',0,32,4,0),(6,'1233@qq.com','123','qewqwe','31223','qwe','weqwe',0,23,4,0),(7,'123122444@qq.com','123','dsfgsfg','1232131223132','31243','2144',0,29,2,0),(8,'123@qq.com','123','���ʦ1','123123','','',0,32,5,0),(9,'2456@qq.com','2456','12332','1232@qq','13223','3231',0,29,1,0),(10,'1234@qq.com','1234','���ʦ2','321','132','123123',0,31,5,0),(11,'111@qq.com','111','��������','321333','132','123123',0,38,4,0),(12,'1505012612@qq.com','123','���ǻ�','С�׸�ƨƨ','1232123','231111111',0,32,2,0),(13,'3242342342@qq.com','123','ewqewq','234234','�������','ewqqwe',0,23,5,0),(14,'36712731@qq.com','123','qwewqewqeqwe','3121123','132','321123',0,29,5,0),(15,'2312332@qq.com','123','ewqewq','1232332','qwe1','`212',0,29,2,0),(16,'132231123@qq.com','123','����ȴȺ��Ⱥ��','3121233','','',0,27,1,0),(17,'1232323@qq.com','123','��Ȥζ��Ⱥ��','31223123','��Ȥζ','',0,29,5,0),(20,NULL,NULL,'dajkd',NULL,NULL,NULL,0,29,1,0),(21,NULL,NULL,'dajkd',NULL,NULL,NULL,0,29,1,0),(22,'123231@qq.com','123','��������','�ʹ�ҿ���','','',0,29,5,0),(23,'gdhah@qq.com','123','ewqqwewe','��ȤζȺ����','','',0,23,2,0),(24,'12213@qq.com','123','312reqr','312','','',0,27,4,0),(25,'qwe@qq.com','123','fasd','12312321321','','',0,23,4,1),(26,'150@qq.com','123','���ǻ�','С�׸�ƨƨ�����','123333333','2311111',0,38,2,1),(27,'qrewre@dd.com','123','rrr','qerwr','12332','33',0,23,4,1),(28,'12312312@qq.com','123','1323123321','�纸�����ӿ���������','','150@qq.com',0,29,2,0);

#
# Structure for table "project"
#

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(50) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `property` varchar(100) DEFAULT NULL,
  `projectDate` datetime NOT NULL,
  `origin` varchar(500) DEFAULT NULL,
  `client` varchar(100) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `workPlace` varchar(200) DEFAULT NULL,
  `buildArea` decimal(13,2) DEFAULT '0.00',
  `landArea` decimal(13,2) DEFAULT '0.00',
  `subject` decimal(13,2) DEFAULT '0.00',
  `principal` varchar(50) DEFAULT NULL,
  `tenderType` varchar(50) DEFAULT NULL,
  `supplier` varchar(50) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `cycle` int(11) DEFAULT '0',
  `status` varchar(100) DEFAULT NULL,
  `contract` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  `userId` int(11) DEFAULT NULL,
  `payment` varchar(50) DEFAULT NULL,
  `departments` varchar(500) DEFAULT NULL,
  `accept` varchar(50) DEFAULT NULL,
  `acceptDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_project_user` (`userId`),
  CONSTRAINT `fk_project_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "project"
#

INSERT INTO `project` VALUES (3,'Ѱ������Ժ1','GGS2019003','���ۼӽ���','��������Ŀ','2019-11-07 08:00:00','��Ŀ��Դ1','�׷���λ����','����׳��������','�����','��ƽ��Ѱ����1',2000.00,3000.00,400000.00,'���ǻ�','����','��ܶ�ʱ���','��Ŀ����','2019-11-07 08:00:00','2019-12-07 08:00:00',30,'approval','contract','2019-11-07 15:57:31','2019-11-19 03:10:21',0,26,'noPayment','�󻮲�, ����, ���ڲ�, ���̲�, ������','accept','2019-11-19 00:32:10'),(4,'�����������������齭����1','GZ2019004','���ۼӽ���','��������Ŀ','2019-11-11 08:00:00','��Դ�ڹ�������������','�ǻ�����','�㶫','����','���������㳡',2000.00,3000.00,1000000.00,'���ǻ�','����','����Ӧ��','��Ŀ����','2019-11-11 08:00:00','2019-12-11 08:00:00',30,'approval','contract','2019-11-07 16:16:11','2019-11-18 19:15:52',0,26,'noPayment','�󻮲�, ���̲�, ������Ʋ�һ��, ������Ʋ�����, ������Ʋ�����, ������Ʋ�����',NULL,NULL),(5,'���������������ֶ��ڹ�����β�׶�','GZ2019005','���ۼӽ���','��������Ŀ','2019-11-15 08:00:00','��Դ�ڹ�������������','�ǻ�����','�㶫','����','���������㳡',2000.00,3000.00,1000000.00,'���ǻ�','����','����Ӧ��','��Ŀ����','2019-11-15 08:00:00','2019-12-15 08:00:00',30,'toApproval','noContract','2019-11-07 16:16:34','2019-12-01 03:23:50',0,26,'noPayment','���̲�, ������Ʋ�һ��, ������Ʋ�����, ������Ʋ�����, ������Ʋ�����',NULL,NULL),(6,'���������������ֶ��ڹ�����β�׶�','GZ2019006','���ۼӽ���','��������Ŀ','2019-11-15 08:00:00','��Դ�ڹ�������������','�ǻ�����','�㶫','����','���������㳡',2000.00,3000.00,1000000.00,'���ǻ�','����','����Ӧ��','��Ŀ����','2019-11-15 08:00:00','2019-12-15 08:00:00',30,'toReview','noContract','2019-11-07 16:16:38','2019-12-01 04:40:53',0,26,'noPayment','���̲�, ������Ʋ�һ��, ������Ʋ�����, ������Ʋ�����, ������Ʋ�����',NULL,NULL),(7,'���������������ֶ��ڹ�����β�׶�','GZ2019007','���ۼӽ���','��������Ŀ','2019-11-15 08:00:00','��Դ�ڹ�������������','�ǻ�����','�㶫','����','���������㳡',2000.00,3000.00,1000000.00,'���ǻ�','����','����Ӧ��','��Ŀ����','2019-11-15 08:00:00','2019-12-15 08:00:00',30,'toSave','noContract','2019-11-07 16:16:39','2019-11-07 16:16:39',0,26,'noPayment','������Ʋ�һ��, ������Ʋ�����, ������Ʋ�����, ������Ʋ�����, ���̲�',NULL,NULL),(8,'��ӳ��黷���ܵ����蹤��1','FS2019008','����','��������Ŀ','2019-11-09 08:00:00','����������������ͳ���ֵ���1','�ǻ�����1','�㶫','��ɽ��','��ӳ���',1000.00,1500.00,400000.00,'���ǻ�','����','�Ϻ������Ƽ�','�����Ŀ�ܴ�һ��Ҫע�ⰲȫ��ʩ1','2019-11-08 08:00:00','2019-11-30 08:00:00',22,'approval','noContract','2019-11-07 18:21:24','2019-11-15 23:56:27',0,26,'noPayment','�󻮲�, ����, ���ڲ�',NULL,NULL);

#
# Structure for table "bill"
#

DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `other` varchar(500) DEFAULT NULL,
  `invoice` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `taxNumber` varchar(100) DEFAULT NULL,
  `bank` varchar(100) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `applicant` varchar(50) DEFAULT NULL,
  `applyDate` datetime DEFAULT NULL,
  `allIncome` decimal(18,2) DEFAULT NULL,
  `allBill` decimal(18,2) DEFAULT NULL,
  `thisBill` decimal(18,2) DEFAULT NULL,
  `billCompany` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `postNumber` varchar(100) DEFAULT NULL,
  `postCompany` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `invoiceType` varchar(30) DEFAULT NULL,
  `addressPhone` varchar(100) DEFAULT NULL,
  `principal` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bill_project` (`projectId`),
  CONSTRAINT `fk_bill_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "bill"
#

INSERT INTO `bill` VALUES (6,'���������������ط����������ϵ�������123123123','Ұ�ֵĹ����ܵ绰��','2019-11-29 00:28:07','2019-11-29 01:00:20','�ǻ�23672367128381123��','�й�����52312723����',3,NULL,'2019-11-30 08:00:00',123123.00,0.00,10000.00,'�ǻԿ�Ʊ��˾123123','���ǻ����ε�123','����ʦ��132','�绰238231293123��','351236716283123����','Բͨ��23123','approval','רƱ','������112312938129123��','���ǻ�'),(7,'12312312321312����ܰ���ļ���˹��˼�ʮ���ɽ��Ŀ����ǿ����˵Ĺ��ֻ��绰���ȼ���������ʲô����','3123123123123123','2019-11-29 00:30:01','2019-11-29 23:45:42','6273671738127313','��˰351273713123',3,NULL,'2019-11-30 08:00:00',123123.00,10000.00,10000.00,'1���Ķ����˹������˹','123123','1231','ˮ��ѵط�','1322222222','123123','approval','��ͨ��Ʊ','��ַ367126317283128','���ǻ�'),(8,'231222222222222','31222222','2019-11-29 23:51:20','2019-11-29 23:51:49','1231222222','132222222',3,NULL,'2019-11-30 08:00:00',123123.00,20000.00,10000.00,'��Ը�ϵ�','123','132','222312','132','32111','approval','��ͨ��Ʊ','2123333','12332'),(9,'1231231323','3123123','2019-12-01 04:35:00','2019-12-01 04:35:00','132123','13212323',3,NULL,'2019-12-11 08:00:00',123123.00,30000.00,1000.00,'12333333333','1233','132','3123','13231','123123','toApproval','��ͨ��Ʊ','123321','���ǻ�');

#
# Structure for table "budget"
#

DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expectedIncome` decimal(18,2) DEFAULT '0.00',
  `tenderCost` decimal(18,2) DEFAULT '0.00',
  `netIncome` decimal(18,2) DEFAULT '0.00',
  `outCost` decimal(18,2) DEFAULT '0.00',
  `publicCost` decimal(18,2) DEFAULT '0.00',
  `humanCost` decimal(18,2) DEFAULT '0.00',
  `serveCost` decimal(18,2) DEFAULT '0.00',
  `travelCost` decimal(18,2) DEFAULT '0.00',
  `otherCost` decimal(18,2) DEFAULT '0.00',
  `allCost` decimal(18,2) DEFAULT '0.00',
  `VAT` decimal(18,2) DEFAULT '0.00',
  `grossProfit` decimal(18,2) DEFAULT '0.00',
  `incomeTax` decimal(18,2) DEFAULT '0.00',
  `netProfit` decimal(18,2) DEFAULT '0.00',
  `taxRate` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `accounting` tinyint(1) DEFAULT '0',
  `sunk` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_budget_project` (`projectId`),
  CONSTRAINT `fk_budget_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "budget"
#

INSERT INTO `budget` VALUES (5,400000.00,100000.00,300000.00,10000.00,10000.00,129200.00,10000.00,1000.00,1000.00,161200.00,19018.87,119781.13,29945.28,89835.85,'0.06','review','2019-11-08 01:01:08','2019-11-15 23:01:26',8,0,NULL),(6,400000.00,100000.00,300000.00,1000.00,1000.00,135320.00,100.00,100.00,100.00,137620.00,19018.87,143361.13,35840.28,107520.85,'0.06','review','2019-11-15 16:35:53','2019-11-15 23:24:41',3,0,NULL),(7,1000000.00,10000.00,990000.00,1000.00,1000.00,339320.00,1000.00,100.00,1000.00,343420.00,62762.26,583817.74,145954.43,437863.31,'0.06','review','2019-11-15 16:43:37','2019-11-16 16:41:18',4,0,NULL),(8,400000.00,80000.00,320000.00,210.00,3120.00,134867.80,1000.00,1000.00,1000.00,141197.80,20286.79,158515.41,39628.85,118886.56,'0.06','accounting','2019-11-29 16:08:51','2019-11-29 16:08:51',8,1,2565.08),(9,1000000.00,10000.00,990000.00,0.00,0.00,340000.00,0.00,0.00,0.00,340000.00,62762.26,587237.74,146809.43,440428.31,'0.06','review','2019-12-01 02:47:32','2019-12-01 03:23:50',5,0,NULL),(10,1000000.00,2310.00,997690.00,0.00,0.00,340000.00,0.00,0.00,0.00,340000.00,63249.78,594440.22,148610.05,445830.17,'0.06','toReview','2019-12-01 04:40:21','2019-12-01 04:40:21',6,0,NULL);

#
# Structure for table "budget_remark"
#

DROP TABLE IF EXISTS `budget_remark`;
CREATE TABLE `budget_remark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expectedIncome` varchar(500) DEFAULT NULL,
  `tenderCost` varchar(500) DEFAULT NULL,
  `netIncome` varchar(500) DEFAULT NULL,
  `outCost` varchar(500) DEFAULT NULL,
  `publicCost` varchar(500) DEFAULT NULL,
  `humanCost` varchar(500) DEFAULT NULL,
  `serveCost` varchar(500) DEFAULT NULL,
  `travelCost` varchar(500) DEFAULT NULL,
  `otherCost` varchar(500) DEFAULT NULL,
  `allCost` varchar(500) DEFAULT NULL,
  `VAT` varchar(500) DEFAULT NULL,
  `grossProfit` varchar(500) DEFAULT NULL,
  `incomeTax` varchar(500) DEFAULT NULL,
  `netProfit` varchar(500) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `budgetId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_remark_budget` (`budgetId`),
  CONSTRAINT `fk_remark_budget` FOREIGN KEY (`budgetId`) REFERENCES `budget` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "budget_remark"
#

INSERT INTO `budget_remark` VALUES (2,'1','2','3','4','5','6','7','8','9','10','11','12','13','14','2019-11-08 01:01:08','2019-11-09 23:28:32',5),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-15 16:35:53','2019-11-15 23:22:24',6),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-15 16:43:37','2019-11-15 16:43:37',7),(5,'1','2','3','4','5','6','7','8','9','10','11','12','13','14','2019-11-29 16:08:51','2019-11-29 16:08:51',8),(6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-12-01 02:47:32','2019-12-01 02:47:32',9),(7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-12-01 04:40:21','2019-12-01 04:40:21',10);

#
# Structure for table "contract"
#

DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `client` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `remark1` varchar(500) DEFAULT NULL,
  `remark2` varchar(500) DEFAULT NULL,
  `remark3` varchar(500) DEFAULT NULL,
  `remark4` varchar(500) DEFAULT NULL,
  `remark5` varchar(500) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `signDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_project` (`projectId`),
  CONSTRAINT `fk_contract_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "contract"
#

INSERT INTO `contract` VALUES (1,'001','�ͻ�����','��ϵ��',123123123.00,'2019-11-19 14:51:07','2019-11-20 02:44:05','��ע1��Ȥζ','��ע2132','��ע3312132','��ע4132','��ע513232',8,'sale','2019-11-21 00:00:00'),(5,'GZ2019004-001','С�׹�˾1','�׾���',2131.00,'2019-11-19 19:18:22','2019-11-19 19:18:22','1231','4111111111','412','12444444','124444444444',4,'sale','2019-11-20 00:00:00'),(7,'GZ2019006-001','oppo��˾123321','�׾�312',123132.00,'2019-11-20 02:12:19','2019-11-20 02:12:19','','','','','',6,'sale','2019-11-20 00:00:00'),(8,'GZ2019006-002','oppo��˾123321','�׾�312344',12313233.00,'2019-11-20 02:32:28','2019-11-20 02:32:28','134324','5424354','525','243535','254254',6,'sale','2019-11-20 00:00:00'),(9,'GZ2019006-003','oppo��˾123321','�׾�312344',12313233.00,'2019-11-20 02:33:12','2019-11-20 02:33:12','134324','5424354','525','243535','254254',6,'sale','2019-11-20 00:00:00'),(10,'GZ2019006-004','oppo��˾123321','�׾�312344',12313233.00,'2019-11-20 02:33:54','2019-11-20 02:33:54','134324','5424354','525','243535','254254',6,'sale','2019-11-20 00:00:00'),(11,'FS2019008-001','oppo��˾123321','�׾�312',123123.00,'2019-11-20 02:53:56','2019-11-20 02:54:18','1321323','13232','123','13232','1321323',8,'purchase','2019-11-12 00:00:00');

#
# Structure for table "first_send"
#

DROP TABLE IF EXISTS `first_send`;
CREATE TABLE `first_send` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `sendTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  `departmentId` int(11) DEFAULT NULL,
  `special` tinyint(1) DEFAULT '0',
  `projectId` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_first_department` (`departmentId`),
  KEY `fk_first_project` (`projectId`),
  CONSTRAINT `fk_first_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

#
# Data for table "first_send"
#

INSERT INTO `first_send` VALUES (1,'�����Թ滮���','�ڲ���ǲ','','2019-11-08 08:00:00','2019-11-11 08:00:00',0,'31223132131','finish',0,32,0,8,'2019-11-09 14:36:20','2019-11-18 01:17:18'),(2,'����滮���','�ڲ���ǲ','','2019-11-11 08:00:00','2019-11-13 08:00:00',2,'312222222222',NULL,0,31,0,8,'2019-11-09 14:36:20','2019-11-15 15:19:13'),(4,'�����Թ滮���','�ڲ���ǲ','���ǵϵ��','2019-11-14 08:00:00','2019-11-20 08:00:00',0,'132231231hdasjdda','send',0,38,0,8,'2019-11-09 14:49:42','2019-12-01 04:11:20'),(5,'�������','�����ǲ','���ǵϵ��','2019-11-15 08:00:00','2019-11-19 08:00:00',4,'1323212331','toSendSecond',0,0,1,8,'2019-11-09 14:54:23','2019-11-15 15:19:13'),(6,'ʩ��ͼ���','�����ǲ','���ǵϵ��','2019-11-13 08:00:00','2019-11-16 08:00:00',3,'1323132','toSendSecond',0,0,1,8,'2019-11-09 14:55:03','2019-11-15 15:19:13'),(7,'ʩ��ͼ���','�ڲ���ǲ','','2019-11-20 08:00:00','2019-11-23 08:00:00',3,'13222222','toSendSecond',0,37,0,8,'2019-11-09 15:02:54','2019-11-15 15:19:13'),(8,'�������','�����ǲ','���ǵϵ��','2019-11-13 08:00:00','2019-11-18 08:00:00',0,'','toSendSecond',1,0,1,8,'2019-11-09 15:14:19','2019-11-15 14:36:08'),(9,'��ϸ�滮�����������','�����ǲ','���ǵϵ��','2019-11-20 08:00:00','2019-11-25 08:00:00',0,'','toSendSecond',1,0,1,8,'2019-11-09 15:15:25','2019-11-15 14:37:21'),(10,'ʩ��ͼ���','�ڲ���ǲ','','2019-11-08 08:00:00','2019-11-11 08:00:00',0,'31223132131',NULL,1,32,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:34'),(11,'����滮���','�ڲ���ǲ','','2019-11-11 08:00:00','2019-11-13 08:00:00',0,'312222222222',NULL,1,31,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:38'),(12,'��ϸ�滮�����������','�ڲ���ǲ','���ǵϵ��','2019-11-13 08:00:00','2019-11-16 08:00:00',0,'132231231dgahshda','toSendSecond',1,38,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:40'),(13,'�������','�����ǲ','���ǵϵ��','2019-11-15 08:00:00','2019-11-19 08:00:00',0,'1323212331','toSendSecond',1,0,1,8,'2019-11-15 15:07:15','2019-11-15 15:10:41'),(14,'ʩ��ͼ���','�����ǲ','���ǵϵ��','2019-11-13 08:00:00','2019-11-16 08:00:00',0,'1323132','toSendSecond',1,0,1,8,'2019-11-15 15:07:15','2019-11-15 15:10:43'),(15,'ʩ��ͼ���','�ڲ���ǲ','','2019-11-20 08:00:00','2019-11-23 08:00:00',0,'13222222','toSendSecond',1,37,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:44'),(16,'��ϸ�滮�����������','�ڲ���ǲ','','2019-11-23 08:00:00','2019-11-26 08:00:00',3,'1232asfdasads','toSendSecond',0,29,0,8,'2019-11-15 15:18:27','2019-11-15 15:19:13'),(17,'�����Թ滮���','�ڲ���ǲ','','2019-11-15 08:00:00','2019-11-20 08:00:00',5,'132222222222222','invalid',0,32,0,4,'2019-11-15 16:44:19','2019-11-18 16:59:09'),(18,'����滮���','�ڲ���ǲ','','2019-11-20 08:00:00','2019-11-25 08:00:00',5,'1233333333','toSendSecond',0,31,0,4,'2019-11-15 16:44:19','2019-11-18 16:59:09'),(19,'��ϸ�滮�����������','�����ǲ','���ǵϵ��','2019-11-16 08:00:00','2019-11-21 08:00:00',5,'','toSendSecond',0,0,1,4,'2019-11-15 16:44:19','2019-11-18 16:59:09'),(20,'�������','�ڲ���ǲ','','2019-11-15 08:00:00','2019-11-20 08:00:00',5,'','toSendSecond',0,26,0,3,'2019-11-15 16:46:57','2019-11-15 23:59:00'),(21,'ʩ��ͼ���','�ڲ���ǲ','','2019-11-21 08:00:00','2019-11-26 08:00:00',5,'','toSendSecond',0,40,0,3,'2019-11-15 16:46:57','2019-11-15 23:59:00'),(22,'�����Թ滮���','�ڲ���ǲ','','2019-12-04 08:00:00','2019-11-16 14:57:12',32,'31222222222','toSendSecond',0,26,0,5,'2019-12-01 02:47:48','2019-12-01 02:47:48'),(23,'�����Թ滮���','�ڲ���ǲ','','2019-12-04 08:00:00','2019-12-06 08:00:00',2,'','toSendSecond',0,32,0,6,'2019-12-01 04:40:53','2019-12-01 04:40:53'),(24,'����滮���','�ڲ���ǲ','','2019-12-07 08:00:00','2019-12-09 08:00:00',2,'','toSendSecond',0,32,0,6,'2019-12-01 04:40:53','2019-12-01 04:40:53');

#
# Structure for table "second_send"
#

DROP TABLE IF EXISTS `second_send`;
CREATE TABLE `second_send` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process` varchar(100) DEFAULT NULL,
  `sendTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  `special` tinyint(1) DEFAULT '0',
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `firstId` int(11) DEFAULT NULL,
  `principal` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_first_user` (`userId`),
  KEY `fk_first_first` (`firstId`),
  CONSTRAINT `fk_first_first` FOREIGN KEY (`firstId`) REFERENCES `first_send` (`id`),
  CONSTRAINT `fk_first_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "second_send"
#

INSERT INTO `second_send` VALUES (1,'��ƽͼ���','2019-11-14 08:00:00','2019-11-17 08:00:00',3,'12312132132qeqwe','finish',0,0,'2019-11-17 01:54:16','2019-11-18 00:15:18',8,1,'���ʦ1'),(2,'���б༭','2019-11-18 08:00:00','2019-11-21 08:00:00',3,'1233333wqeww','finish',0,0,'2019-11-17 01:54:16','2019-11-18 00:20:34',8,1,'���ʦ1'),(3,'�������','2019-11-21 08:00:00','2019-11-24 08:00:00',3,'1231323ewq','finish',0,0,'2019-11-17 01:54:16','2019-11-18 00:16:40',8,1,'���ʦ1'),(4,'�������','2019-11-12 08:00:00','2019-11-18 08:00:00',6,'fsfsdfsdfsf','finish',0,1,'2019-11-17 02:31:03','2019-11-18 00:20:40',8,1,'���ʦ1'),(5,'��ƽͼ���','2019-11-17 08:00:00','2019-11-20 08:00:00',3,'1322����','invalid',0,0,'2019-11-17 21:46:18','2019-11-18 16:55:58',8,17,'���ʦ1'),(6,'�������','2019-11-20 08:00:00','2019-11-24 08:00:00',4,'12333333123213','invalid',0,0,'2019-11-17 21:46:18','2019-11-18 16:55:58',8,17,'���ʦ1'),(7,'�������','2019-11-17 08:00:00','2019-11-22 08:00:00',5,'132222222222','invalid',0,1,'2019-11-17 21:46:18','2019-11-18 16:55:58',10,17,'���ʦ2'),(8,'�ı�����','2019-11-24 08:00:00','2019-11-28 08:00:00',4,'1322222222222222','invalid',0,0,'2019-11-17 21:46:18','2019-11-18 16:55:58',10,17,'���ʦ2'),(9,'��ƽͼ���','2019-12-01 08:00:00','2019-12-04 08:00:00',3,'1321323','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'����'),(10,'�������','2019-12-04 08:00:00','2019-12-06 08:00:00',2,'12333333','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'����'),(11,'�������','2019-12-06 08:00:00','2019-12-08 08:00:00',2,'','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'����'),(12,'��������','2019-12-10 08:00:00','2019-12-12 08:00:00',2,'','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'����');

#
# Structure for table "income"
#

DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` varchar(500) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `netAmount` decimal(18,2) DEFAULT NULL,
  `cost` decimal(18,2) DEFAULT NULL,
  `sunk` tinyint(1) DEFAULT '0',
  `projectId` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `outDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_income_project` (`projectId`),
  CONSTRAINT `fk_income_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "income"
#

INSERT INTO `income` VALUES (1,'��ע','account','2019-11-27 18:41:33','2019-11-27 18:41:33',64127.00,213.00,73812.00,0,8,'��Ʒ�','2019-11-27 18:41:33'),(4,'�Ĺ滮�ȹ���','�й�����123123123','2019-11-27 21:55:56','2019-11-27 21:55:56',123213.00,123123.00,213123.00,0,3,'��Ʒ�','2019-11-22 08:00:00'),(5,'123333','13123123','2019-11-28 23:35:02','2019-11-28 23:35:02',12333.00,2133.00,123.00,0,8,'��Ʒ�','2019-11-28 08:00:00'),(6,'123123','36172318939','2019-11-29 23:48:46','2019-11-29 23:48:46',12312332.00,123321.00,123123.00,0,4,'��Ʒ�','2019-11-30 08:00:00'),(7,'351625371638123','123','2019-11-29 23:49:25','2019-11-29 23:49:25',10000.00,10000.00,1000.00,0,7,'��Ʒ�','2019-11-30 08:00:00'),(8,'31222222','123132','2019-11-29 23:52:25','2019-11-29 23:52:25',123123.00,10002.00,123.00,0,8,'��Ʒ�','2019-11-30 08:00:00'),(9,'132','1233123','2019-11-30 00:17:54','2019-11-30 00:17:54',13232.00,13223.00,312332.00,0,8,'��Ʒ�','2019-11-30 08:00:00');

#
# Structure for table "outlay"
#

DROP TABLE IF EXISTS `outlay`;
CREATE TABLE `outlay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` varchar(500) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `sunk` tinyint(1) DEFAULT '0',
  `projectId` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `outDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_outlay_project` (`projectId`),
  CONSTRAINT `fk_outlay_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "outlay"
#

INSERT INTO `outlay` VALUES (3,'��ע','account','2019-11-27 18:43:49','2019-11-27 18:43:49',64127.00,1,8,'��Ʒ�','2019-11-27 18:43:49'),(4,'��ע','account','2019-11-27 18:43:55','2019-11-27 18:43:55',64127.00,1,8,'��Ʒ�','2019-11-27 18:43:54'),(5,'123213123','�й����еĺۼ���','2019-11-27 23:10:15','2019-11-27 23:10:15',12342523.00,0,6,'����ɱ�','2019-11-22 08:00:00'),(6,'123123333','�й���������','2019-11-27 23:13:33','2019-11-27 23:13:33',100000.00,0,8,'�д���','2019-11-14 08:00:00'),(7,'123333','3123','2019-11-29 23:49:45','2019-11-29 23:49:45',123213.00,0,8,'���ط�','2019-11-30 08:00:00'),(8,'���õظ��ܵ���','123','2019-11-29 23:50:00','2019-11-29 23:50:00',10002.00,0,7,'�����ɱ�','2019-11-30 08:00:00'),(9,'3���23123��2��123','12390293','2019-11-29 23:50:22','2019-11-29 23:50:22',100232.00,0,3,'�д���','2019-11-30 08:00:00'),(10,'31233','12312','2019-11-29 23:52:48','2019-11-29 23:52:48',1322.00,0,4,'����ɱ�','2019-11-30 08:00:00'),(11,'123333333','124444444444','2019-11-30 00:08:52','2019-11-30 00:08:52',12323.00,0,4,'���ط�','2019-11-30 08:00:00'),(12,'123132','312312','2019-11-30 00:18:34','2019-11-30 00:18:34',12333.00,0,8,'���ط�','2019-11-30 08:00:00');

#
# Structure for table "payment_node"
#

DROP TABLE IF EXISTS `payment_node`;
CREATE TABLE `payment_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process` varchar(100) DEFAULT NULL,
  `paymentTime` datetime DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_project` (`projectId`),
  CONSTRAINT `fk_payment_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "payment_node"
#

INSERT INTO `payment_node` VALUES (1,'�����Թ滮���','2019-11-01 08:00:00','һ�ڿ���','noPayment',200000.00,'2019-11-18 19:15:52','2019-11-18 19:15:52',4),(2,'����滮���','2019-11-18 08:00:00','���ڿ���','payment',400000.00,'2019-11-18 19:15:52','2019-11-18 19:51:52',4),(3,'��ϸ�滮�����������','2019-11-30 08:00:00','���ڿ���','payment',400000.00,'2019-11-18 19:15:52','2019-11-18 19:51:42',4),(4,'�������','2019-11-19 08:00:00','����һ','noPayment',200000.00,'2019-11-19 00:32:10','2019-11-19 00:32:10',3),(5,'ʩ��ͼ���','2019-11-28 08:00:00','�����','noPayment',200000.00,'2019-11-19 00:32:10','2019-11-19 00:32:10',3);

#
# Structure for table "dynamic"
#

DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dynamic_user` (`userId`),
  CONSTRAINT `fk_dynamic_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Data for table "dynamic"
#

INSERT INTO `dynamic` VALUES (2,9,'������һ����Ŀ����','/inout/income/6','2019-11-29 23:48:46'),(3,9,'������һ����Ŀ����','/inout/income/7','2019-11-29 23:49:25'),(4,9,'������һ����Ŀ֧��','/inout/out/7','2019-11-29 23:49:45'),(5,9,'������һ����Ŀ֧��','/inout/out/8','2019-11-29 23:50:00'),(6,9,'������һ����Ŀ֧��','/inout/out/9','2019-11-29 23:50:22'),(7,9,'�������µĿ�Ʊ��Ϣ','/bill/8','2019-11-29 23:51:21'),(8,9,'�����һ�ʿ�Ʊ��Ϣ','/bill/8','2019-11-29 23:51:49'),(9,9,'������һ����Ŀ����','/inout/income/8','2019-11-29 23:52:25'),(10,9,'������һ����Ŀ֧��','/inout/out/10','2019-11-29 23:52:48'),(11,9,'������һ����Ŀ֧��','/inout/out/11','2019-11-30 00:08:52'),(12,26,'������һ����Ŀ����','/inout/income/9','2019-11-30 00:17:54'),(13,26,'������һ����Ŀ֧��','/inout/out/12','2019-11-30 00:18:34'),(14,26,'�������µĿ�Ʊ��Ϣ','/bill/9','2019-12-01 04:35:00');

#
# Structure for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_userrole` (`userId`),
  KEY `fk_role_userrole` (`roleId`),
  CONSTRAINT `fk_role_userrole` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_userrole` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

#
# Data for table "user_role"
#

INSERT INTO `user_role` VALUES (26,22,7,'2019-10-19 18:39:30',NULL),(27,22,6,'2019-10-19 18:39:30',NULL),(28,22,5,'2019-10-19 18:39:30',NULL),(29,22,4,'2019-10-19 18:39:30',NULL),(30,23,7,'2019-10-19 18:46:26',NULL),(31,23,6,'2019-10-19 18:46:26',NULL),(32,23,4,'2019-10-19 18:46:26',NULL),(33,23,3,'2019-10-19 18:46:26',NULL),(34,24,7,'2019-10-19 18:48:07',NULL),(35,24,6,'2019-10-19 18:48:07',NULL),(36,24,5,'2019-10-19 18:48:07',NULL),(37,25,7,'2019-10-19 19:08:58',NULL),(38,25,6,'2019-10-19 19:08:58',NULL),(39,25,5,'2019-10-19 19:08:58',NULL),(40,25,3,'2019-10-19 19:08:58',NULL),(41,25,4,'2019-10-19 19:08:58',NULL),(42,26,1,'2019-10-19 19:52:11',NULL),(43,27,7,'2019-10-19 20:03:14',NULL),(44,4,7,'2019-10-21 17:37:45',NULL),(45,4,6,'2019-10-21 17:37:45',NULL),(46,4,5,'2019-10-21 17:37:45',NULL),(57,6,3,'2019-10-21 18:48:26',NULL),(58,6,7,'2019-10-21 18:48:26',NULL),(59,6,6,'2019-10-21 18:48:26',NULL),(60,6,1,'2019-10-21 18:48:26',NULL),(64,7,3,'2019-10-21 18:57:16',NULL),(67,28,7,'2019-10-21 19:50:40',NULL),(68,28,6,'2019-10-21 19:50:40',NULL),(69,9,6,'2019-10-21 20:28:30',NULL),(70,5,4,'2019-11-16 15:32:40',NULL),(71,8,5,'2019-11-17 21:39:44',NULL),(72,10,5,'2019-11-17 21:45:06',NULL),(73,11,4,'2019-12-01 04:10:07',NULL);

#
# Structure for table "zsupplier_info"
#

DROP TABLE IF EXISTS `zsupplier_info`;
CREATE TABLE `zsupplier_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `charges` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `createDate` datetime NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `isDelete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Data for table "zsupplier_info"
#

INSERT INTO `zsupplier_info` VALUES (1,'name1','type1','�շѱ�׼1','contact1','phone1','2019-10-25 17:55:12','2019-10-28 19:52:06',1),(2,'�����᰸����','ԭ����','','','','2019-10-28 20:02:54','2019-10-28 20:43:42',1),(3,'','ԭ����','','','','2019-10-28 20:04:46','2019-10-28 20:43:42',1),(4,'','���','','','','2019-10-28 20:11:13','2019-10-28 20:43:42',1),(5,'�ྩơ��234234','���','324Ԫ/Ͱ','�ʹ����32','213333333333214344','2019-10-28 20:43:15','2019-10-28 21:30:54',0),(6,'�ྩơ��1','ԭ����','5Ԫ/Ͱ','�ʹ����','21333333333321','2019-10-28 20:43:24','2019-10-28 20:43:52',1),(7,'�ྩơ��13123','ԭ����','5Ԫ/Ͱ','�ʹ����','21333333333321','2019-10-28 20:43:31',NULL,0),(8,'13213','���','123','123','12333','2019-10-28 20:44:06','2019-10-28 20:45:00',1),(9,'13213','���','123','123','12333','2019-10-28 20:44:10','2019-10-28 20:45:00',1),(10,'12312','���','13212','132','23123','2019-10-28 20:49:41','2019-10-28 21:31:11',1),(11,'12312','���','13212','132','23123','2019-10-28 20:49:44','2019-10-28 20:49:53',1),(12,'12312','���','13212','132','23123','2019-10-28 20:49:45','2019-10-28 20:49:53',1),(13,'����¹�','ԭ����','35712573','341265345','31233','2019-10-28 22:45:59',NULL,0),(14,'����¹�123','���','35712573','341265345','31233','2019-10-28 22:46:04',NULL,0),(15,'12312','���','32','123','13213','2019-10-28 22:46:48',NULL,0),(16,'12312','���','32','123','13213','2019-10-28 22:46:49',NULL,0),(17,'12312','���','32','123','13213','2019-10-28 22:46:50',NULL,0),(18,'1231eqe1232213','���','32','123','13213','2019-10-28 22:46:57',NULL,0),(19,'1223qe1232213','���','32','123','13213','2019-10-28 22:46:59',NULL,0),(20,'1223qe1232213213','���','32','123','13213','2019-10-28 22:47:02','2019-10-28 22:58:01',1),(21,'1223qe1232213213','���','32','123','13213','2019-10-28 22:47:03','2019-10-28 22:58:01',1),(22,'1223qe1232213213','���','32','123','13213','2019-10-28 22:47:04',NULL,0),(23,'1223qe1232213213','���','32','123','13213','2019-10-28 22:47:05',NULL,0);
