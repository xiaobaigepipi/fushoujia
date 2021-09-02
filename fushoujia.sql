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

INSERT INTO `action_group` VALUES (1,'基础资料','base_data'),(2,'项目管理','project_mana'),(3,'合同管理','contract_mana'),(4,'财务管理','finance_mana'),(5,'系统设置','system_set');

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
  `groupId` int(11) DEFAULT NULL COMMENT '权限组Id',
  PRIMARY KEY (`id`),
  KEY `fk_action_group` (`groupId`),
  CONSTRAINT `fk_action_group` FOREIGN KEY (`groupId`) REFERENCES `action_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Data for table "action"
#

INSERT INTO `action` VALUES (1,'客户信息','client_info','/clients','2019-10-17 20:27:49',NULL,1),(2,'技术供应商信息','tsupplier_info','/tsupplier','2019-10-17 20:29:43',NULL,1),(3,'资质供应商信息','zsupplier_info','/zsupplier','2019-10-17 20:31:53',NULL,1),(4,'项目工序目录','project_process','/process','2019-10-17 20:31:53',NULL,1),(5,'项目立项','project','/project','2019-10-17 20:35:00',NULL,2),(6,'项目预算','project_budget','/budget','2019-10-17 20:35:00',NULL,2),(7,'项目派遣','project_send','/send','2019-10-17 20:35:00',NULL,2),(8,'项目验收','project_accept','/accept','2019-10-17 20:35:00',NULL,2),(9,'销售合同','sale_contract','/contracts','2019-10-17 20:39:08',NULL,3),(10,'采购合同','purchase_contract','/contracts','2019-10-17 20:39:08',NULL,3),(11,'开票申请','bill','/bill','2019-10-17 20:39:08',NULL,4),(12,'项目收支','project_inout','/inout','2019-10-17 20:39:08',NULL,4),(13,'项目核算','project_accout','/account','2019-10-17 20:39:08',NULL,4),(14,'沉没成本','sunk_cost','/cost','2019-10-17 20:39:08',NULL,4),(21,'基础数据','basic_data','/basic','2019-10-17 20:42:32',NULL,5),(22,'添加用户','add_user','/adduser','2019-10-17 20:42:32',NULL,5),(23,'用户权限','user_action','/action','2019-10-17 20:42:32',NULL,5);

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

INSERT INTO `customer_info` VALUES (1,'name1','Address1','receive1','bank1','taxnumber1','contact1','billNumber1','phone1','email1','sale1','wechat1','remark1','2019-10-25 02:18:38','2019-10-25 02:28:21','code1',1),(2,'name1','Address','receive','bank','taxnumber','contact','billNumber','phone','email','sale','wechat','remark','2019-10-25 02:20:10','2019-10-26 03:12:32','code',1),(3,'客户名称','广西壮族自治区南宁市西乡塘区电焊机','广西壮族自治区贵港市桂平市达到','开户行','税号','联系人','开票','电话','eqeqhw@qq.com','李星辉','微信','备注','2019-10-26 21:27:18','2019-10-27 00:51:53','',1),(4,'华为公司','广西壮族自治区南宁市西乡塘区明珠广场','广西壮族自治区贵港市桂平市人民广场','中国银行','dhah7123676123','余大嘴','431556321382138712','163712137828','341516@qq.com','李星辉','6eyqy721371','备注','2019-10-27 00:45:02',NULL,'KH201910001',0),(5,'小米公司1','广西壮族自治区南宁市西乡塘区明珠广场','广东广州天河区人民广场','中国银行1','dhah71236761231','雷军额','431556321382138712','33ee12312137828','e231@qq.com','李环宇','2321113711','备注','2019-10-27 00:45:52','2019-10-27 03:20:03','KH201910001',0),(6,'oppo公司123321','广西壮族自治区南宁市高新区明珠广场','广西壮族自治区贵港市平南县人民广场','中国银行','dhah7123676123','雷军312','431556321382138712','12312137828231','123411516@qq.com','离团','232111371132','备注12332','2019-10-27 00:46:06','2019-10-27 22:03:40','KH201910001',0),(7,'魅族手机','广西壮族自治区柳州市柳江区蝴蝶结校区','广东广州番禺区罗家村','农商银行','617371qwe63818','老大','hu3612637717','15678376340','137181@qq.com','李环宇','12312123','贱人贱己贱行业','2019-10-27 22:07:49',NULL,'KH201910002',0);

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

INSERT INTO `department` VALUES (22,'管理层',1,'1571321263954536','第三代'),(23,'商务部',1,'1571321271928460','热污染若'),(24,'行政人事部',1,'1571321279370132','福成'),(25,'财务部',1,'1571321285546677','帕森斯'),(26,'企划部',1,'1571321291855668','康复科'),(27,'工程部',1,'1571321297932398','李德华'),(28,'设备部',1,'1571321303686805','李东升'),(29,'室内部',1,'1571321310302518','二七王'),(30,'建筑部',1,'1571321319487855','李安安'),(31,'景观施工图部二所',1,'1571321326849558','李珊珊'),(32,'景观施工图部一所',1,'1571321335306581','单萨安'),(33,'景观设计部后期所',1,'157132134219370','德国哈'),(34,'景观设计部六所',1,'1571321375945688','姬爱丹'),(35,'景观设计部五所',1,'1571321425128139','阿巴斯'),(36,'景观设计部四所',1,'1571321432786639','李大萨'),(37,'景观设计部三所',1,'1571321443282149','李丽仙'),(38,'景观设计部二所',1,'1571321449698525','立单'),(39,'景观设计部一所',1,'1571321455475968','离团'),(40,'项目部',1,'1571321461666488','李星辉');

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

INSERT INTO `document` VALUES (1,'QQ图片20190623101535.jpg','/src/static/img/project/15741034393372355.jpg','2019-11-19 02:57:19','2019-11-19 02:57:19',3,NULL,NULL),(2,'微信图片_20191030010235.jpg','/src/static/img/project/15741034393473944.jpg','2019-11-19 02:57:19','2019-11-19 02:57:19',3,NULL,NULL),(3,'QQ图片20190623101520.png','/src/static/img/project/15741038177229653.png','2019-11-19 03:03:37','2019-11-19 03:03:37',3,NULL,NULL),(4,'微信图片_20191030010235.jpg','/src/static/img/project/15741038648279763.jpg','2019-11-19 03:04:24','2019-11-19 03:04:24',3,NULL,NULL),(5,'QQ图片20190623101535.jpg','/src/static/img/project/15741042211014646.jpg','2019-11-19 03:10:21','2019-11-19 03:10:21',3,NULL,NULL),(6,'微信图片_20191030010235.jpg','/src/static/img/contract/1574161788136.jpg','2019-11-19 19:09:47','2019-11-19 19:09:47',0,4,'jpg'),(7,'微信图片_20191030010235.mkm','/src/static/img/contract/1574161791850.mkm','2019-11-19 19:09:47','2019-11-19 19:09:47',0,4,'mkm'),(8,'QQ图片20190623101520.png','/src/static/img/contract/1574162311600.png','2019-11-19 19:18:23','2019-11-19 19:18:23',0,5,'png'),(9,'微信图片_20191030010235.mkm','/src/static/img/contract/1574162303294.mkm','2019-11-19 19:18:23','2019-11-19 19:18:23',0,5,'mkm'),(10,'QQ图片20190623101535.jpg','/src/static/img/contract/1574185837347.jpg','2019-11-20 01:50:30','2019-11-20 01:50:30',0,6,'jpg'),(11,'广源汇鑫-日照1911-2565吨.pdf','/src/static/img/contract/1574185833364.pdf','2019-11-20 01:50:30','2019-11-20 01:50:30',0,6,'pdf'),(12,'vue总结.txt','/src/static/img/contract/1574185830649.txt','2019-11-20 01:50:30','2019-11-20 01:50:30',0,6,'txt'),(13,'组件参数.txt','/src/static/img/contract/1574187143565.txt','2019-11-20 02:12:19','2019-11-20 02:12:19',0,7,'txt'),(15,'颜色.png','/src/static/img/contract/1574188393605.png','2019-11-20 02:33:12','2019-11-20 02:33:12',0,9,'png'),(17,'sql总结.txt','/src/static/img/contract/1574188434400.txt','2019-11-20 02:33:54','2019-11-20 02:33:54',0,10,'txt'),(18,'java总结.txt','/src/static/img/contract/1574188614335.txt','2019-11-20 02:36:50','2019-11-20 02:36:50',0,0,'txt'),(19,'idea.txt','/src/static/img/contract/1574188612287.txt','2019-11-20 02:36:50','2019-11-20 02:36:50',0,0,'txt'),(20,'idea.txt','/src/static/img/contract/1574188736738.txt','2019-11-20 02:38:48','2019-11-20 02:38:48',0,0,'txt'),(21,'css总结.txt','/src/static/img/contract/1574188734962.txt','2019-11-20 02:38:48','2019-11-20 02:38:48',0,0,'txt'),(22,'idea.txt','/src/static/img/contract/1574189029165.txt','2019-11-20 02:43:48','2019-11-20 02:43:48',0,1,'txt'),(23,'css总结.txt','/src/static/img/contract/1574189031733.txt','2019-11-20 02:43:48','2019-11-20 02:43:48',0,1,'txt'),(24,'idea.txt','/src/static/img/contract/1574189644718.txt','2019-11-20 02:53:56','2019-11-20 02:53:56',0,11,'txt');

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

INSERT INTO `first_process` VALUES (4,'概念性规划设计','2019-10-29 18:19:48'),(5,'总体规划设计','2019-10-29 18:19:57'),(6,'详细规划（方案）设计','2019-10-29 18:20:12'),(7,'初步设计','2019-10-29 18:20:26'),(8,'施工图设计','2019-10-29 18:20:43');

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

INSERT INTO `income_out_category` VALUES (9,'其他成本'),(10,'差旅费'),(11,'招待费'),(12,'人力成本'),(13,'公关费'),(14,'外包成本'),(15,'设计费'),(16,'招投标成本');

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

INSERT INTO `position_` VALUES (1,'财务',1),(2,'总经理',1),(3,'副总经理',1),(4,'所长',1),(5,'设计师',1);

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

INSERT INTO `project_property` VALUES (3,'集团内项目'),(4,'集团外项目');

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

INSERT INTO `project_type` VALUES (3,'景观'),(4,'建筑'),(5,'景观加建筑');

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

INSERT INTO `province` VALUES (2,'广西壮族自治区'),(4,'广东'),(5,'福建省'),(6,'贵州省');

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

INSERT INTO `city` VALUES (6,'广州',4),(7,'南宁市',2),(8,'佛山市',4),(9,'贵港市',2),(10,'柳州市',2),(11,'桂林市',2);

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

INSERT INTO `area` VALUES (4,'天河区',6),(5,'西乡塘区',7),(6,'高新区',7),(7,'桂平市',9),(8,'港南区',9),(9,'平南县',9),(10,'柳江区',10),(11,'七星区',11),(12,'阳朔县',11),(13,'雁山区',11),(14,'增城区',6),(15,'黄埔区',6),(16,'番禺区',6);

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

INSERT INTO `role` VALUES (1,'总经理','ceo','最高权限'),(2,'副总经理','vince','第二高权限'),(3,'项目负责人','project','拥有项目立项的权限'),(4,'所长','director','部门权限'),(5,'设计师','designer','任务权限'),(6,'财务','finance','财务方面权限'),(7,'系统管理员','admin','系统管理员');

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

INSERT INTO `second_process` VALUES (2,'总平图设计','2019-10-29 18:52:33',4),(4,'建筑设计','2019-10-29 18:56:45',4),(5,'景观设计','2019-10-29 18:56:53',4),(6,'后期制作','2019-10-29 18:57:05',4),(7,'文本编排','2019-10-29 18:57:14',4),(8,'动画设计','2019-10-29 18:57:21',4),(9,'可研编辑','2019-10-29 18:57:32',4),(10,'总平图设计','2019-10-29 18:57:55',5),(11,'建筑设计','2019-10-29 18:58:01',5),(12,'景观设计','2019-10-29 18:58:09',5),(13,'后期制作','2019-10-29 18:58:19',5),(14,'水电管网设计（设备）','2019-10-29 18:58:34',5),(15,'文本编排','2019-10-29 18:58:44',5),(16,'动画设计','2019-10-29 18:58:57',5),(17,'总图设计','2019-10-29 18:59:24',6),(18,'建筑详图设计','2019-10-29 18:59:34',6),(19,'景观详图设计','2019-10-29 18:59:49',6),(20,'绿化详图设计','2019-10-29 18:59:55',6),(21,'水电管网详图设计（设备）','2019-10-29 19:00:11',6),(22,'后期制作','2019-10-29 19:00:16',6),(23,'文本编排','2019-10-29 19:00:25',6),(24,'动画设计','2019-10-29 19:00:32',6),(25,'初步设计说明','2019-10-29 19:01:03',7),(26,'土建设计','2019-10-29 19:01:09',7),(27,'园建设计','2019-10-29 19:01:16',7),(28,'水电管网设计','2019-10-29 19:01:30',7),(29,'结构设计','2019-10-29 19:01:39',7),(30,'绿化设计','2019-10-29 19:01:43',7),(31,'节点设计','2019-10-29 19:01:51',7),(32,'设计概算','2019-10-29 19:02:00',7),(33,'施工图设计说明','2019-10-29 19:02:26',8),(34,'土建设计','2019-10-29 19:02:33',8),(35,'园建设计','2019-10-29 19:02:40',8),(36,'水电管网设计','2019-10-29 19:02:51',8),(37,'绿化设计','2019-10-29 19:03:03',8),(38,'节点设计','2019-10-29 19:03:10',8);

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

INSERT INTO `supplier_type` VALUES (7,'外包'),(8,'原材料');

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

INSERT INTO `tsupplier_info` VALUES (1,'name4','address4','EMAIL4','wechat4','phone4','remark14','remark24','2019-10-25 17:46:25','2019-10-28 17:20:41','code4',1,'contact4'),(2,'比亚迪电池1','广西壮族自治区南宁市西乡塘区不是道哪座广场1','121123213@qq.com','1232331','13671366182131','备注1灯火辉煌或或或或或或或或或或或或或或或或军1','备注2电焊机ad卡1','2019-10-28 16:45:47','2019-10-28 17:20:41','GS201910001',1,'mrs王1'),(3,'比亚迪电池','广西壮族自治区贵港市港南区狗大户圣诞节','53165361666@qq.com','12333333','13677283781','备注一','的回答是多多多多多多多多多多多扩','2019-10-28 17:21:48',NULL,'GS201910001',0,'打号机');

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
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门',
  `positionId` int(11) DEFAULT NULL COMMENT '职位',
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

INSERT INTO `user` VALUES (4,'21332232@qq.com','12345678','qweweq',NULL,NULL,NULL,3,32,2,0),(5,'123456@qq.com','123456','李团','had军军军军军','123','123',0,32,4,0),(6,'1233@qq.com','123','qewqwe','31223','qwe','weqwe',0,23,4,0),(7,'123122444@qq.com','123','dsfgsfg','1232131223132','31243','2144',0,29,2,0),(8,'123@qq.com','123','设计师1','123123','','',0,32,5,0),(9,'2456@qq.com','2456','12332','1232@qq','13223','3231',0,29,1,0),(10,'1234@qq.com','1234','设计师2','321','132','123123',0,31,5,0),(11,'111@qq.com','111','二所所长','321333','132','123123',0,38,4,0),(12,'1505012612@qq.com','123','李星辉','小白哥屁屁','1232123','231111111',0,32,2,0),(13,'3242342342@qq.com','123','ewqewq','234234','企鹅窝翁','ewqqwe',0,23,5,0),(14,'36712731@qq.com','123','qwewqewqeqwe','3121123','132','321123',0,29,5,0),(15,'2312332@qq.com','123','ewqewq','1232332','qwe1','`212',0,29,2,0),(16,'132231123@qq.com','123','而我却群翁群无','3121233','','',0,27,1,0),(17,'1232323@qq.com','123','恶趣味二群无','31223123','恶趣味','',0,29,5,0),(20,NULL,NULL,'dajkd',NULL,NULL,NULL,0,29,1,0),(21,NULL,NULL,'dajkd',NULL,NULL,NULL,0,29,1,0),(22,'123231@qq.com','123','热武器二','和大家看到','','',0,29,5,0),(23,'gdhah@qq.com','123','ewqqwewe','恶趣味群翁无','','',0,23,2,0),(24,'12213@qq.com','123','312reqr','312','','',0,27,4,0),(25,'qwe@qq.com','123','fasd','12312321321','','',0,23,4,1),(26,'150@qq.com','123','李星辉','小白哥屁屁他哥哥','123333333','2311111',0,38,2,1),(27,'qrewre@dd.com','123','rrr','qerwr','12332','33',0,23,4,1),(28,'12312312@qq.com','123','1323123321','电焊打开链接快来看看了','','150@qq.com',0,29,2,0);

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

INSERT INTO `project` VALUES (3,'寻旺卫生院1','GGS2019003','景观加建筑','集团外项目','2019-11-07 08:00:00','项目来源1','甲方单位名称','广西壮族自治区','贵港市','桂平市寻旺乡1',2000.00,3000.00,400000.00,'李星辉','代理','大很多时候回','项目概述','2019-11-07 08:00:00','2019-12-07 08:00:00',30,'approval','contract','2019-11-07 15:57:31','2019-11-19 03:10:21',0,26,'noPayment','企划部, 商务部, 室内部, 工程部, 建筑部','accept','2019-11-19 00:32:10'),(4,'广州塔防护工程林珠江地区1','GZ2019004','景观加建筑','集团内项目','2019-11-11 08:00:00','来源于广州市人民政府','星辉中心','广东','广州','天河区人民广场',2000.00,3000.00,1000000.00,'李星辉','代理','代理供应商','项目概述','2019-11-11 08:00:00','2019-12-11 08:00:00',30,'approval','contract','2019-11-07 16:16:11','2019-11-18 19:15:52',0,26,'noPayment','企划部, 工程部, 景观设计部一所, 景观设计部三所, 景观设计部二所, 景观设计部五所',NULL,NULL),(5,'广州塔防护工程林二期工程收尾阶段','GZ2019005','景观加建筑','集团内项目','2019-11-15 08:00:00','来源于广州市人民政府','星辉中心','广东','广州','天河区人民广场',2000.00,3000.00,1000000.00,'李星辉','代理','代理供应商','项目概述','2019-11-15 08:00:00','2019-12-15 08:00:00',30,'toApproval','noContract','2019-11-07 16:16:34','2019-12-01 03:23:50',0,26,'noPayment','工程部, 景观设计部一所, 景观设计部三所, 景观设计部二所, 景观设计部五所',NULL,NULL),(6,'广州塔防护工程林二期工程收尾阶段','GZ2019006','景观加建筑','集团内项目','2019-11-15 08:00:00','来源于广州市人民政府','星辉中心','广东','广州','天河区人民广场',2000.00,3000.00,1000000.00,'李星辉','代理','代理供应商','项目概述','2019-11-15 08:00:00','2019-12-15 08:00:00',30,'toReview','noContract','2019-11-07 16:16:38','2019-12-01 04:40:53',0,26,'noPayment','工程部, 景观设计部一所, 景观设计部三所, 景观设计部二所, 景观设计部五所',NULL,NULL),(7,'广州塔防护工程林二期工程收尾阶段','GZ2019007','景观加建筑','集团内项目','2019-11-15 08:00:00','来源于广州市人民政府','星辉中心','广东','广州','天河区人民广场',2000.00,3000.00,1000000.00,'李星辉','代理','代理供应商','项目概述','2019-11-15 08:00:00','2019-12-15 08:00:00',30,'toSave','noContract','2019-11-07 16:16:39','2019-11-07 16:16:39',0,26,'noPayment','景观设计部一所, 景观设计部三所, 景观设计部二所, 景观设计部五所, 工程部',NULL,NULL),(8,'天河车陂环形跑道建设工程1','FS2019008','建筑','集团外项目','2019-11-09 08:00:00','天河市人民政府，和车陂街道办1','星辉中心1','广东','佛山市','天河车陂',1000.00,1500.00,400000.00,'李星辉','自主','上海来生科技','这个项目很大，一定要注意安全措施1','2019-11-08 08:00:00','2019-11-30 08:00:00',22,'approval','noContract','2019-11-07 18:21:24','2019-11-15 23:56:27',0,26,'noPayment','企划部, 商务部, 室内部',NULL,NULL);

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

INSERT INTO `bill` VALUES (6,'其他资料在其他地方的其他资料的其他地123123123','野种的哈接受电话卡','2019-11-29 00:28:07','2019-11-29 01:00:20','星辉23672367128381123撒','中国银行52312723阿迪',3,NULL,'2019-11-30 08:00:00',123123.00,0.00,10000.00,'星辉开票公司123123','李星辉他滴滴123','广西师大132','电话238231293123的','351236716283123打算','圆通速23123','approval','专票','广州市112312938129123大','李星辉'),(7,'12312312321312还打架爱神的箭爱斯达克几十块大山里的卡拉是看到了的哈手机电话卡等级卡萨丁卡什么都快','3123123123123123','2019-11-29 00:30:01','2019-11-29 23:45:42','6273671738127313','国税351273713123',3,NULL,'2019-11-30 08:00:00',123123.00,10000.00,10000.00,'1开拍定金奥斯卡达拉斯','123123','1231','水电费地方','1322222222','123123','approval','普通发票','地址367126317283128','李星辉'),(8,'231222222222222','31222222','2019-11-29 23:51:20','2019-11-29 23:51:49','1231222222','132222222',3,NULL,'2019-11-30 08:00:00',123123.00,20000.00,10000.00,'但愿上帝','123','132','222312','132','32111','approval','普通发票','2123333','12332'),(9,'1231231323','3123123','2019-12-01 04:35:00','2019-12-01 04:35:00','132123','13212323',3,NULL,'2019-12-11 08:00:00',123123.00,30000.00,1000.00,'12333333333','1233','132','3123','13231','123123','toApproval','普通发票','123321','李星辉');

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

INSERT INTO `contract` VALUES (1,'001','客户名称','联系人',123123123.00,'2019-11-19 14:51:07','2019-11-20 02:44:05','备注1恶趣味','备注2132','备注3312132','备注4132','备注513232',8,'sale','2019-11-21 00:00:00'),(5,'GZ2019004-001','小米公司1','雷军额',2131.00,'2019-11-19 19:18:22','2019-11-19 19:18:22','1231','4111111111','412','12444444','124444444444',4,'sale','2019-11-20 00:00:00'),(7,'GZ2019006-001','oppo公司123321','雷军312',123132.00,'2019-11-20 02:12:19','2019-11-20 02:12:19','','','','','',6,'sale','2019-11-20 00:00:00'),(8,'GZ2019006-002','oppo公司123321','雷军312344',12313233.00,'2019-11-20 02:32:28','2019-11-20 02:32:28','134324','5424354','525','243535','254254',6,'sale','2019-11-20 00:00:00'),(9,'GZ2019006-003','oppo公司123321','雷军312344',12313233.00,'2019-11-20 02:33:12','2019-11-20 02:33:12','134324','5424354','525','243535','254254',6,'sale','2019-11-20 00:00:00'),(10,'GZ2019006-004','oppo公司123321','雷军312344',12313233.00,'2019-11-20 02:33:54','2019-11-20 02:33:54','134324','5424354','525','243535','254254',6,'sale','2019-11-20 00:00:00'),(11,'FS2019008-001','oppo公司123321','雷军312',123123.00,'2019-11-20 02:53:56','2019-11-20 02:54:18','1321323','13232','123','13232','1321323',8,'purchase','2019-11-12 00:00:00');

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

INSERT INTO `first_send` VALUES (1,'概念性规划设计','内部派遣','','2019-11-08 08:00:00','2019-11-11 08:00:00',0,'31223132131','finish',0,32,0,8,'2019-11-09 14:36:20','2019-11-18 01:17:18'),(2,'总体规划设计','内部派遣','','2019-11-11 08:00:00','2019-11-13 08:00:00',2,'312222222222',NULL,0,31,0,8,'2019-11-09 14:36:20','2019-11-15 15:19:13'),(4,'概念性规划设计','内部派遣','比亚迪电池','2019-11-14 08:00:00','2019-11-20 08:00:00',0,'132231231hdasjdda','send',0,38,0,8,'2019-11-09 14:49:42','2019-12-01 04:11:20'),(5,'初步设计','外包派遣','比亚迪电池','2019-11-15 08:00:00','2019-11-19 08:00:00',4,'1323212331','toSendSecond',0,0,1,8,'2019-11-09 14:54:23','2019-11-15 15:19:13'),(6,'施工图设计','外包派遣','比亚迪电池','2019-11-13 08:00:00','2019-11-16 08:00:00',3,'1323132','toSendSecond',0,0,1,8,'2019-11-09 14:55:03','2019-11-15 15:19:13'),(7,'施工图设计','内部派遣','','2019-11-20 08:00:00','2019-11-23 08:00:00',3,'13222222','toSendSecond',0,37,0,8,'2019-11-09 15:02:54','2019-11-15 15:19:13'),(8,'初步设计','外包派遣','比亚迪电池','2019-11-13 08:00:00','2019-11-18 08:00:00',0,'','toSendSecond',1,0,1,8,'2019-11-09 15:14:19','2019-11-15 14:36:08'),(9,'详细规划（方案）设计','外包派遣','比亚迪电池','2019-11-20 08:00:00','2019-11-25 08:00:00',0,'','toSendSecond',1,0,1,8,'2019-11-09 15:15:25','2019-11-15 14:37:21'),(10,'施工图设计','内部派遣','','2019-11-08 08:00:00','2019-11-11 08:00:00',0,'31223132131',NULL,1,32,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:34'),(11,'总体规划设计','内部派遣','','2019-11-11 08:00:00','2019-11-13 08:00:00',0,'312222222222',NULL,1,31,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:38'),(12,'详细规划（方案）设计','内部派遣','比亚迪电池','2019-11-13 08:00:00','2019-11-16 08:00:00',0,'132231231dgahshda','toSendSecond',1,38,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:40'),(13,'初步设计','外包派遣','比亚迪电池','2019-11-15 08:00:00','2019-11-19 08:00:00',0,'1323212331','toSendSecond',1,0,1,8,'2019-11-15 15:07:15','2019-11-15 15:10:41'),(14,'施工图设计','外包派遣','比亚迪电池','2019-11-13 08:00:00','2019-11-16 08:00:00',0,'1323132','toSendSecond',1,0,1,8,'2019-11-15 15:07:15','2019-11-15 15:10:43'),(15,'施工图设计','内部派遣','','2019-11-20 08:00:00','2019-11-23 08:00:00',0,'13222222','toSendSecond',1,37,0,8,'2019-11-15 15:07:15','2019-11-15 15:10:44'),(16,'详细规划（方案）设计','内部派遣','','2019-11-23 08:00:00','2019-11-26 08:00:00',3,'1232asfdasads','toSendSecond',0,29,0,8,'2019-11-15 15:18:27','2019-11-15 15:19:13'),(17,'概念性规划设计','内部派遣','','2019-11-15 08:00:00','2019-11-20 08:00:00',5,'132222222222222','invalid',0,32,0,4,'2019-11-15 16:44:19','2019-11-18 16:59:09'),(18,'总体规划设计','内部派遣','','2019-11-20 08:00:00','2019-11-25 08:00:00',5,'1233333333','toSendSecond',0,31,0,4,'2019-11-15 16:44:19','2019-11-18 16:59:09'),(19,'详细规划（方案）设计','外包派遣','比亚迪电池','2019-11-16 08:00:00','2019-11-21 08:00:00',5,'','toSendSecond',0,0,1,4,'2019-11-15 16:44:19','2019-11-18 16:59:09'),(20,'初步设计','内部派遣','','2019-11-15 08:00:00','2019-11-20 08:00:00',5,'','toSendSecond',0,26,0,3,'2019-11-15 16:46:57','2019-11-15 23:59:00'),(21,'施工图设计','内部派遣','','2019-11-21 08:00:00','2019-11-26 08:00:00',5,'','toSendSecond',0,40,0,3,'2019-11-15 16:46:57','2019-11-15 23:59:00'),(22,'概念性规划设计','内部派遣','','2019-12-04 08:00:00','2019-11-16 14:57:12',32,'31222222222','toSendSecond',0,26,0,5,'2019-12-01 02:47:48','2019-12-01 02:47:48'),(23,'概念性规划设计','内部派遣','','2019-12-04 08:00:00','2019-12-06 08:00:00',2,'','toSendSecond',0,32,0,6,'2019-12-01 04:40:53','2019-12-01 04:40:53'),(24,'总体规划设计','内部派遣','','2019-12-07 08:00:00','2019-12-09 08:00:00',2,'','toSendSecond',0,32,0,6,'2019-12-01 04:40:53','2019-12-01 04:40:53');

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

INSERT INTO `second_send` VALUES (1,'总平图设计','2019-11-14 08:00:00','2019-11-17 08:00:00',3,'12312132132qeqwe','finish',0,0,'2019-11-17 01:54:16','2019-11-18 00:15:18',8,1,'设计师1'),(2,'可研编辑','2019-11-18 08:00:00','2019-11-21 08:00:00',3,'1233333wqeww','finish',0,0,'2019-11-17 01:54:16','2019-11-18 00:20:34',8,1,'设计师1'),(3,'景观设计','2019-11-21 08:00:00','2019-11-24 08:00:00',3,'1231323ewq','finish',0,0,'2019-11-17 01:54:16','2019-11-18 00:16:40',8,1,'设计师1'),(4,'动画设计','2019-11-12 08:00:00','2019-11-18 08:00:00',6,'fsfsdfsdfsf','finish',0,1,'2019-11-17 02:31:03','2019-11-18 00:20:40',8,1,'设计师1'),(5,'总平图设计','2019-11-17 08:00:00','2019-11-20 08:00:00',3,'1322大大大','invalid',0,0,'2019-11-17 21:46:18','2019-11-18 16:55:58',8,17,'设计师1'),(6,'建筑设计','2019-11-20 08:00:00','2019-11-24 08:00:00',4,'12333333123213','invalid',0,0,'2019-11-17 21:46:18','2019-11-18 16:55:58',8,17,'设计师1'),(7,'景观设计','2019-11-17 08:00:00','2019-11-22 08:00:00',5,'132222222222','invalid',0,1,'2019-11-17 21:46:18','2019-11-18 16:55:58',10,17,'设计师2'),(8,'文本编排','2019-11-24 08:00:00','2019-11-28 08:00:00',4,'1322222222222222','invalid',0,0,'2019-11-17 21:46:18','2019-11-18 16:55:58',10,17,'设计师2'),(9,'总平图设计','2019-12-01 08:00:00','2019-12-04 08:00:00',3,'1321323','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'李团'),(10,'建筑设计','2019-12-04 08:00:00','2019-12-06 08:00:00',2,'12333333','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'李团'),(11,'景观设计','2019-12-06 08:00:00','2019-12-08 08:00:00',2,'','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'李团'),(12,'后期制作','2019-12-10 08:00:00','2019-12-12 08:00:00',2,'','send',0,0,'2019-12-01 04:11:20','2019-12-01 04:11:20',5,4,'李团');

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

INSERT INTO `income` VALUES (1,'备注','account','2019-11-27 18:41:33','2019-11-27 18:41:33',64127.00,213.00,73812.00,0,8,'设计费','2019-11-27 18:41:33'),(4,'的规划等哈哈','中国银行123123123','2019-11-27 21:55:56','2019-11-27 21:55:56',123213.00,123123.00,213123.00,0,3,'设计费','2019-11-22 08:00:00'),(5,'123333','13123123','2019-11-28 23:35:02','2019-11-28 23:35:02',12333.00,2133.00,123.00,0,8,'设计费','2019-11-28 08:00:00'),(6,'123123','36172318939','2019-11-29 23:48:46','2019-11-29 23:48:46',12312332.00,123321.00,123123.00,0,4,'设计费','2019-11-30 08:00:00'),(7,'351625371638123','123','2019-11-29 23:49:25','2019-11-29 23:49:25',10000.00,10000.00,1000.00,0,7,'设计费','2019-11-30 08:00:00'),(8,'31222222','123132','2019-11-29 23:52:25','2019-11-29 23:52:25',123123.00,10002.00,123.00,0,8,'设计费','2019-11-30 08:00:00'),(9,'132','1233123','2019-11-30 00:17:54','2019-11-30 00:17:54',13232.00,13223.00,312332.00,0,8,'设计费','2019-11-30 08:00:00');

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

INSERT INTO `outlay` VALUES (3,'备注','account','2019-11-27 18:43:49','2019-11-27 18:43:49',64127.00,1,8,'设计费','2019-11-27 18:43:49'),(4,'备注','account','2019-11-27 18:43:55','2019-11-27 18:43:55',64127.00,1,8,'设计费','2019-11-27 18:43:54'),(5,'123213123','中国银行的痕迹啊','2019-11-27 23:10:15','2019-11-27 23:10:15',12342523.00,0,6,'外包成本','2019-11-22 08:00:00'),(6,'123123333','中国建设银行','2019-11-27 23:13:33','2019-11-27 23:13:33',100000.00,0,8,'招待费','2019-11-14 08:00:00'),(7,'123333','3123','2019-11-29 23:49:45','2019-11-29 23:49:45',123213.00,0,8,'公关费','2019-11-30 08:00:00'),(8,'更好地感受到就','123','2019-11-29 23:50:00','2019-11-29 23:50:00',10002.00,0,7,'人力成本','2019-11-30 08:00:00'),(9,'3五黑23123就2框123','12390293','2019-11-29 23:50:22','2019-11-29 23:50:22',100232.00,0,3,'招待费','2019-11-30 08:00:00'),(10,'31233','12312','2019-11-29 23:52:48','2019-11-29 23:52:48',1322.00,0,4,'外包成本','2019-11-30 08:00:00'),(11,'123333333','124444444444','2019-11-30 00:08:52','2019-11-30 00:08:52',12323.00,0,4,'公关费','2019-11-30 08:00:00'),(12,'123132','312312','2019-11-30 00:18:34','2019-11-30 00:18:34',12333.00,0,8,'公关费','2019-11-30 08:00:00');

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

INSERT INTO `payment_node` VALUES (1,'概念性规划设计','2019-11-01 08:00:00','一期款项','noPayment',200000.00,'2019-11-18 19:15:52','2019-11-18 19:15:52',4),(2,'总体规划设计','2019-11-18 08:00:00','二期款项','payment',400000.00,'2019-11-18 19:15:52','2019-11-18 19:51:52',4),(3,'详细规划（方案）设计','2019-11-30 08:00:00','三期款项','payment',400000.00,'2019-11-18 19:15:52','2019-11-18 19:51:42',4),(4,'初步设计','2019-11-19 08:00:00','款项一','noPayment',200000.00,'2019-11-19 00:32:10','2019-11-19 00:32:10',3),(5,'施工图设计','2019-11-28 08:00:00','款项二','noPayment',200000.00,'2019-11-19 00:32:10','2019-11-19 00:32:10',3);

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

INSERT INTO `dynamic` VALUES (2,9,'新增了一笔项目收入','/inout/income/6','2019-11-29 23:48:46'),(3,9,'新增了一笔项目收入','/inout/income/7','2019-11-29 23:49:25'),(4,9,'新增了一笔项目支出','/inout/out/7','2019-11-29 23:49:45'),(5,9,'新增了一笔项目支出','/inout/out/8','2019-11-29 23:50:00'),(6,9,'新增了一笔项目支出','/inout/out/9','2019-11-29 23:50:22'),(7,9,'申请了新的开票信息','/bill/8','2019-11-29 23:51:21'),(8,9,'审核了一笔开票信息','/bill/8','2019-11-29 23:51:49'),(9,9,'新增了一笔项目收入','/inout/income/8','2019-11-29 23:52:25'),(10,9,'新增了一笔项目支出','/inout/out/10','2019-11-29 23:52:48'),(11,9,'新增了一笔项目支出','/inout/out/11','2019-11-30 00:08:52'),(12,26,'新增了一笔项目收入','/inout/income/9','2019-11-30 00:17:54'),(13,26,'新增了一笔项目支出','/inout/out/12','2019-11-30 00:18:34'),(14,26,'申请了新的开票信息','/bill/9','2019-12-01 04:35:00');

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

INSERT INTO `zsupplier_info` VALUES (1,'name1','type1','收费标准1','contact1','phone1','2019-10-25 17:55:12','2019-10-28 19:52:06',1),(2,'蝴蝶结案件的','原材料','','','','2019-10-28 20:02:54','2019-10-28 20:43:42',1),(3,'','原材料','','','','2019-10-28 20:04:46','2019-10-28 20:43:42',1),(4,'','外包','','','','2019-10-28 20:11:13','2019-10-28 20:43:42',1),(5,'燕京啤酒234234','外包','324元/桶','和大街上32','213333333333214344','2019-10-28 20:43:15','2019-10-28 21:30:54',0),(6,'燕京啤酒1','原材料','5元/桶','和大街上','21333333333321','2019-10-28 20:43:24','2019-10-28 20:43:52',1),(7,'燕京啤酒13123','原材料','5元/桶','和大街上','21333333333321','2019-10-28 20:43:31',NULL,0),(8,'13213','外包','123','123','12333','2019-10-28 20:44:06','2019-10-28 20:45:00',1),(9,'13213','外包','123','123','12333','2019-10-28 20:44:10','2019-10-28 20:45:00',1),(10,'12312','外包','13212','132','23123','2019-10-28 20:49:41','2019-10-28 21:31:11',1),(11,'12312','外包','13212','132','23123','2019-10-28 20:49:44','2019-10-28 20:49:53',1),(12,'12312','外包','13212','132','23123','2019-10-28 20:49:45','2019-10-28 20:49:53',1),(13,'哈达嘎哈','原材料','35712573','341265345','31233','2019-10-28 22:45:59',NULL,0),(14,'哈达嘎哈123','外包','35712573','341265345','31233','2019-10-28 22:46:04',NULL,0),(15,'12312','外包','32','123','13213','2019-10-28 22:46:48',NULL,0),(16,'12312','外包','32','123','13213','2019-10-28 22:46:49',NULL,0),(17,'12312','外包','32','123','13213','2019-10-28 22:46:50',NULL,0),(18,'1231eqe1232213','外包','32','123','13213','2019-10-28 22:46:57',NULL,0),(19,'1223qe1232213','外包','32','123','13213','2019-10-28 22:46:59',NULL,0),(20,'1223qe1232213213','外包','32','123','13213','2019-10-28 22:47:02','2019-10-28 22:58:01',1),(21,'1223qe1232213213','外包','32','123','13213','2019-10-28 22:47:03','2019-10-28 22:58:01',1),(22,'1223qe1232213213','外包','32','123','13213','2019-10-28 22:47:04',NULL,0),(23,'1223qe1232213213','外包','32','123','13213','2019-10-28 22:47:05',NULL,0);
