# Host: 127.0.0.1  (Version 5.7.22-log)
# Date: 2018-05-27 08:53:05
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1,'admin','admin','蒲雪');

#
# Structure for table "flyway_schema_history"
#

DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_bin NOT NULL,
  `type` varchar(20) COLLATE utf8_bin NOT NULL,
  `script` varchar(1000) COLLATE utf8_bin NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) COLLATE utf8_bin NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#
# Data for table "flyway_schema_history"
#

INSERT INTO `flyway_schema_history` VALUES (1,'1.0','20180425','SQL','V1.0__20180425.sql',1329521316,'root','2018-05-24 21:27:39',315,1);

#
# Structure for table "info"
#

DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '标题',
  `content` text CHARACTER SET utf8 COMMENT '内容',
  `pic` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片路径',
  `time` datetime DEFAULT NULL COMMENT '发表时间',
  `type` int(11) DEFAULT NULL COMMENT '1:公司简介;2:企业资讯;',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='餐厅介绍表';

#
# Data for table "info"
#

INSERT INTO `info` VALUES (1,'【一千零一夜餐厅】介绍','<p style=\"margin: 0px; padding: 0px; font-family: &quot;microsoft yahei&quot;, 微软雅黑, &quot;Helvetica Neue&quot;, Helvetica, Arial, &quot;Hiragino Sans GB&quot;, 华文细黑, STHeiti, &quot;Microsoft YaHei&quot;, SimHei, sans-serif; font-size: 14px;\">&nbsp; &nbsp; 在远古，遥远的阿拉伯国度有一千零一夜的美丽传说，在今天， 繁华的上海滩有个一千零一夜餐厅, 远古的1001夜传说不但留给人们无 限的遐想和对未来生活的美好憧憬，还筑就了丝绸之路的文明，使人类文明不断繁衍，今天的一千零一夜餐厅不仅延续了丝绸之路的文明而且带来了 阿拉伯美食文化及风土人情.一千零一夜餐厅无论从整体,还是从局部来看，都完全是阿拉伯文明的再现.源自中东的悠远文化和创意灵感，一系列叹 为观止的杰作，大到装璜设计,小到物品的摆放：古朴的石雕，壮观的壁画，角落里的阿拉伯神灯，每一处都独具匠心，使你不知不觉中就进入了阿拉伯的神话世界。宏伟的19世 纪古阿建筑不经意的显示出气派，透过宽敞明亮的玻璃窗，品着浓浓的阿拉伯咖啡，细细回味着人生，欣赏着林荫 小道上街景，惬意之情不必言明，有谁会说这不是人间一道亮丽的风景线呢？优美，舒适的环境中享受着阿拉伯名厨的手艺，又是一番什么景象？论你有多么过人的毅力也禁不住美食的诱惑.</p>\r\n\r\n<p style=\"margin: 0px; padding: 0px; font-family: &quot;microsoft yahei&quot;, 微软雅黑, &quot;Helvetica Neue&quot;, Helvetica, Arial, &quot;Hiragino Sans GB&quot;, 华文细黑, STHeiti, &quot;Microsoft YaHei&quot;, SimHei, sans-serif; font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;1001夜综合烧烤汇璀各种美味卡巴，鸡肉卡巴，羊肉卡巴，牛肉卡巴，蔬菜卡巴，一道菜能让你同时品尝到好几种不同的口味，非人间好味道，几个好友围坐在一起，在焱焱的火炎中畅谈着心事，听着热情扬溢的阿拉伯歌手现场演唱，欣赏着阿拉伯肚皮舞蹈 ，您还乞求什么呢？一千零一夜餐厅还为喜欢吃素的朋友准备了各式美味素食，20多种沙拉 ，40多种阿拉伯风味炖菜，胡木思酱，巴巴橄努茄，塔布里，发杜斯，配上阿拉伯雪松饼，风味特色美食大饱口福。喜欢西餐的朋友在这里同样可以品尝到正宗的牛羊排及多个国家名菜。饭后品着香浓的土尔其咖啡，吃着甜酥松软的阿拉伯甜品,欣赏着肚皮舞，在欢乐的气氛下度过一个个难忘的良宵。 民俗，民风，民情，美酒加咖啡，特色加美食历史和文化共同构建了一千零一夜餐厅。　</p>\r\n','img10.jpg','2018-05-27 08:07:53',1),(2,'一千零一夜餐厅最新活动标题','    在远古，遥远的阿拉伯国度有一千零一夜的美丽传说，在今天， 繁华的上海滩有个一千零一夜餐厅, 远古的1001夜传说不但留给人们无 限的遐想和对未来生活的美好憧憬，还筑就了丝绸之路的文明，使人类文明不断繁衍，今天的一千零一夜餐厅不仅延续了丝绸之路的文明而且带来了 阿拉伯美食文化及风土人情.一千零一夜餐厅无论从整体,还是从局部来看，都完全是阿拉伯文明的再现.源自中东的悠远文化和创意灵感，一系列叹 为观止的杰作，大到装璜设计,小到物品的摆放：古朴的石雕，壮观的壁画，角落里的阿拉','img10.jpg','2018-05-27 08:10:41',2);

#
# Structure for table "menu"
#

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '菜名',
  `describe` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `price` double DEFAULT NULL COMMENT '价格',
  `pic` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='菜单表';

#
# Data for table "menu"
#

INSERT INTO `menu` VALUES (1,'玉米','        玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米玉米',15,'img5.jpg'),(2,' 蛋糕','蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕',99,'img53.jpg'),(3,' 灯泡','灯泡灯泡灯泡灯泡灯泡灯泡灯泡灯泡',550,'img52.jpg'),(4,' 炒肉','炒肉炒肉炒肉炒肉炒肉炒肉炒肉炒肉',55,'img51.jpg'),(5,'酒','酒酒酒',99,'menu-bg.jpg');

#
# Structure for table "reserve"
#

DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `use_time` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '预定使用时间',
  `num` int(11) DEFAULT NULL COMMENT '就餐人数',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `phone` int(11) DEFAULT NULL COMMENT '手机号码',
  `emial` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `add_time` datetime DEFAULT NULL COMMENT '提交时间',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '处理状态，false未处理，true已处理',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

#
# Data for table "reserve"
#

INSERT INTO `reserve` VALUES (1,'2018年5月28日 20：00',5,'韩擒虎',NULL,'13923085@qq.com','2018-05-27 08:38:42',b'0'),(2,'2018年5月28日 20：00',5,'韩擒虎',NULL,'13923085@qq.com','2018-05-27 08:38:42',b'1'),(3,'今天 18点',8,'王八',NULL,'2072955910@qq.com','2018-05-27 08:41:30',b'0');
