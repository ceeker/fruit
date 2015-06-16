/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : fruit

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2014-10-10 09:34:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ADMINID` varchar(255) NOT NULL,
  `ADMINNAME` varchar(255) DEFAULT NULL,
  `ADMINPASSWORD` varchar(255) DEFAULT NULL,
  `ADMINSEX` varchar(255) DEFAULT NULL,
  `ADMINBIRTH` datetime DEFAULT NULL,
  `ADMINRIGHT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ADMINID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123', 'songliang', '123456', 'man', '2014-09-03 15:03:26', '0');
INSERT INTO `admin` VALUES ('456', 'heyu', '456', 'female', '2014-09-02 15:03:28', '0');

-- ----------------------------
-- Table structure for `advertisement`
-- ----------------------------
DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `ADVERTISEMENTID` varchar(255) NOT NULL,
  `ADVERTISEMENTTITLE` varchar(255) DEFAULT NULL,
  `ADVERTISEMENTINFO` varchar(255) DEFAULT NULL,
  `ADVERTISEMENTPICADDR` varchar(255) DEFAULT NULL,
  `ADVERTISEMENTHREF` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ADVERTISEMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advertisement
-- ----------------------------
INSERT INTO `advertisement` VALUES ('1', 'abc', '																								爱的撒大事大\r\n						\r\n						\r\n						\r\n						', '/fruit/adPic/3.jpg', 'www.sina.com.cn');
INSERT INTO `advertisement` VALUES ('2', 'bcd', '						agagfa\r\n						', '/fruit/adPic/3.jpg', '');
INSERT INTO `advertisement` VALUES ('3', 'def', 'afafafa', '/fruit/adPic/3.jpg', null);
INSERT INTO `advertisement` VALUES ('4', '风格化', '倒萨倒萨 ', '/fruit/adPic/4.jpg', 'http://www.baidu.com');
INSERT INTO `advertisement` VALUES ('5', 'adjsab', 'dasdas', '/fruit/adPic/5.jpg', null);
INSERT INTO `advertisement` VALUES ('6', 'dsfafa', 'fasfad', '/fruit/adPic/6.jpg', null);
INSERT INTO `advertisement` VALUES ('7', 'dfadasd', 'sdsadas', '/fruit/adPic/7.jpg', null);
INSERT INTO `advertisement` VALUES ('8', 'dfdfadf', 'sdadass', '/fruit/adPic/8.jpg', null);

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `BOOKID` varchar(255) NOT NULL,
  `BOOKUSER` varchar(255) DEFAULT NULL,
  `BOOKDATE` datetime DEFAULT NULL,
  `ISCONFIRM` int(11) DEFAULT NULL,
  `ISVISIBLE` int(11) DEFAULT '1',
  `BOOKVEGETABLE` varchar(255) DEFAULT NULL,
  `BOOKQUANTITY` int(11) DEFAULT NULL,
  `BOOKADDR` varchar(255) DEFAULT NULL,
  `BOOKPHONE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BOOKID`),
  KEY `FK_owx29sckc08y7dp2llu070jtk` (`BOOKVEGETABLE`),
  KEY `FK_l8qpjhg4e2kp3sfpp6qwtfgn7` (`BOOKUSER`),
  CONSTRAINT `FK_l8qpjhg4e2kp3sfpp6qwtfgn7` FOREIGN KEY (`BOOKUSER`) REFERENCES `user` (`USERID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_owx29sckc08y7dp2llu070jtk` FOREIGN KEY (`BOOKVEGETABLE`) REFERENCES `vegetable` (`VEGETABLEID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('001', '001', '2014-08-24 11:11:44', '3', '1', '001', '10', null, null);
INSERT INTO `book` VALUES ('002', '001', '2014-08-12 11:12:09', '3', '1', '003', '5', null, null);
INSERT INTO `book` VALUES ('003', '001', '2014-08-24 11:12:33', '1', '1', '006', '2', null, null);
INSERT INTO `book` VALUES ('004', '001', '2014-08-19 11:12:51', '3', '1', '003', '4', null, null);
INSERT INTO `book` VALUES ('005', '001', '2014-08-19 16:09:43', '0', '1', '001', '5', null, null);
INSERT INTO `book` VALUES ('006', '001', '2014-08-24 16:10:13', '3', '1', '007', '2', null, null);
INSERT INTO `book` VALUES ('007', '001', '2014-08-24 16:12:10', '0', '1', '001', '8', null, null);

-- ----------------------------
-- Table structure for `bookvegetable`
-- ----------------------------
DROP TABLE IF EXISTS `bookvegetable`;
CREATE TABLE `bookvegetable` (
  `BOOKID` varchar(255) NOT NULL,
  `BOOKQUANTITY` int(11) DEFAULT NULL,
  `VEGETABLE` varchar(255) NOT NULL,
  PRIMARY KEY (`BOOKID`,`VEGETABLE`),
  KEY `FK_p7unpednjneoirsrd9xqnyh4d` (`BOOKID`),
  CONSTRAINT `FK_p7unpednjneoirsrd9xqnyh4d` FOREIGN KEY (`BOOKID`) REFERENCES `book` (`BOOKID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookvegetable
-- ----------------------------

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `CARTID` varchar(255) NOT NULL,
  `CARTVEGETABLE` varchar(255) DEFAULT NULL,
  `VEGETABLEMOUNT` int(11) DEFAULT NULL,
  `USER` varchar(255) DEFAULT NULL,
  `CARTDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`CARTID`),
  KEY `FK_hvj9xba8fh7bsua9ogeobklyj` (`CARTVEGETABLE`),
  KEY `FK_5wochxv1j2ss5e3rktwfchpnb` (`USER`),
  CONSTRAINT `FK_5wochxv1j2ss5e3rktwfchpnb` FOREIGN KEY (`USER`) REFERENCES `user` (`USERID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_hvj9xba8fh7bsua9ogeobklyj` FOREIGN KEY (`CARTVEGETABLE`) REFERENCES `vegetable` (`VEGETABLEID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('00111120140904162820', '006', '1', '001111', '2014-09-04 16:28:20');
INSERT INTO `cart` VALUES ('00120140822153955', '005', '1', '001', '2014-08-22 15:39:56');
INSERT INTO `cart` VALUES ('00120140822154051', '005', '1', '001', '2014-08-22 15:40:51');
INSERT INTO `cart` VALUES ('00120140822155405', '005', '1', '001', '2014-08-22 15:54:05');
INSERT INTO `cart` VALUES ('00120140822155412', '006', '4', '001', '2014-08-22 15:54:13');
INSERT INTO `cart` VALUES ('00120140822161120', '006', '3', '001', '2014-08-22 16:11:20');
INSERT INTO `cart` VALUES ('00120140822161350', '002', '1', '001', '2014-08-22 16:13:50');
INSERT INTO `cart` VALUES ('00120140822161430', '005', '1', '001', '2014-08-22 16:14:30');
INSERT INTO `cart` VALUES ('00120140822161439', '003', '1', '001', '2014-08-22 16:14:40');
INSERT INTO `cart` VALUES ('00120140822170744', '006', '8', '001', '2014-08-22 17:07:45');
INSERT INTO `cart` VALUES ('00120140822171456', '007', '3', '001', '2014-08-22 17:14:57');
INSERT INTO `cart` VALUES ('00120140824203149', '010', '3', '001', '2014-08-24 20:31:50');
INSERT INTO `cart` VALUES ('00120140902114529', '003', '1', '001', '2014-09-02 11:45:29');
INSERT INTO `cart` VALUES ('00120140902114535', '004', '1', '001', '2014-09-02 11:45:35');
INSERT INTO `cart` VALUES ('00120140904161354', '002', '1', '001', '2014-09-04 16:13:55');
INSERT INTO `cart` VALUES ('00120140904161528', '003', '1', '001', '2014-09-04 16:15:28');
INSERT INTO `cart` VALUES ('00120140904161535', '005', '1', '001', '2014-09-04 16:15:35');
INSERT INTO `cart` VALUES ('00120140904161647', '006', '1', '001', '2014-09-04 16:16:47');
INSERT INTO `cart` VALUES ('00120140904162615', '006', '1', '001', '2014-09-04 16:26:16');
INSERT INTO `cart` VALUES ('00120140923151302', '009', '4', '001', '2014-09-23 15:13:03');
INSERT INTO `cart` VALUES ('00120140923151306', '005', '1', '001', '2014-09-23 15:13:07');
INSERT INTO `cart` VALUES ('00120140924141012', '007', '1', '001', '2014-09-24 14:10:13');
INSERT INTO `cart` VALUES ('00120140926102712', '004', '4', '001', '2014-09-26 10:27:13');
INSERT INTO `cart` VALUES ('00120140926151527', '001', '3', '001', '2014-09-26 15:15:27');
INSERT INTO `cart` VALUES ('002', '002', '4', '001', '2014-08-08 16:37:29');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `COMMENTID` varchar(255) NOT NULL,
  `COMMENTVEG` varchar(255) DEFAULT NULL,
  `COMMENTUSER` varchar(255) DEFAULT NULL,
  `COMMENTINFO` varchar(255) DEFAULT NULL,
  `COMMENTSCORE` float DEFAULT NULL,
  `VISIBLE` int(11) DEFAULT '1',
  `COMMENTDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`COMMENTID`),
  KEY `FK_t5rc83jiw7cfaqrr87a8954tj` (`COMMENTVEG`),
  KEY `FK_obbm2xshrsw8utxwpdldhqngk` (`COMMENTUSER`),
  CONSTRAINT `FK_obbm2xshrsw8utxwpdldhqngk` FOREIGN KEY (`COMMENTUSER`) REFERENCES `user` (`USERID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_t5rc83jiw7cfaqrr87a8954tj` FOREIGN KEY (`COMMENTVEG`) REFERENCES `vegetable` (`VEGETABLEID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('00120140824200228', '003', '001', 'sddadsa', '5', '0', '2014-08-24 20:02:28');
INSERT INTO `comment` VALUES ('00120140824200401', '001', '001', 'dasdasda', '4', '0', '2014-08-24 20:04:02');
INSERT INTO `comment` VALUES ('00120140824200534', '001', '001', 'dadasda', '5', '0', '2014-08-24 20:05:34');
INSERT INTO `comment` VALUES ('00120140824202311', '001', '001', 'sdadasda', '4.5', '0', '2014-08-24 20:23:12');
INSERT INTO `comment` VALUES ('00120140824202508', '006', '001', 'dadadadasdada', '4.5', '0', '2014-08-24 20:25:09');
INSERT INTO `comment` VALUES ('00120140824202824', '003', '001', 'sdasdasd', '4', '0', '2014-08-24 20:28:25');
INSERT INTO `comment` VALUES ('00120140909162335', '001', '001', 'ghrtghrghrt', '4.5', '0', '2014-09-09 16:23:36');
INSERT INTO `comment` VALUES ('00120140909192155', '003', '001', 'å±±ä¸åå¬å¸å¸å½æ¶ä»£åçç', '5', '0', '2014-09-09 19:21:55');
INSERT INTO `comment` VALUES ('1', '001', '001', '这个东西太好吃拉', '5', '0', '2014-08-16 15:57:11');
INSERT INTO `comment` VALUES ('2', '001', '12012', '还行吧', '4.5', '0', '2014-08-16 15:57:38');
INSERT INTO `comment` VALUES ('3', '001', '001111', '一般般', '3.5', '0', '2014-08-16 16:48:05');
INSERT INTO `comment` VALUES ('4', '001', '12012', 'so好吃', '5', '0', '2014-08-16 16:48:47');
INSERT INTO `comment` VALUES ('5', '001', '456123', 'cnm', '3.5', '1', '2014-08-15 17:03:33');
INSERT INTO `comment` VALUES ('6', '001', '78945', '不好吃', '2', '1', '2014-08-16 16:49:10');
INSERT INTO `comment` VALUES ('7', '004', '001', '必须差评！这是太难吃了，蔬菜一点都不新鲜，价格还死啦贵，快递员送货还很慢，蔬菜的质量一点都不好', '1', '1', '2014-08-23 20:33:12');

-- ----------------------------
-- Table structure for `gallerypic`
-- ----------------------------
DROP TABLE IF EXISTS `gallerypic`;
CREATE TABLE `gallerypic` (
  `GALLERYPICID` varchar(255) NOT NULL,
  `GALLERYPICTITLE` varchar(255) DEFAULT NULL,
  `GALLERYPICINFO` varchar(255) DEFAULT NULL,
  `GALLERYPICADDR` varchar(255) DEFAULT NULL,
  `GALLERYPICHREF` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`GALLERYPICID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gallerypic
-- ----------------------------
INSERT INTO `gallerypic` VALUES ('001', '最新上线猕猴桃', '						sdadsadsadasd\r\n						', '/fruit/GalleryPicUpload/zhongqiu.jpg', 'http://www.baidu.com');
INSERT INTO `gallerypic` VALUES ('002', '螃蟹', '水产与蔬菜的融合', '/fruit/GalleryPicUpload/panxie.jpg', null);
INSERT INTO `gallerypic` VALUES ('003', '樱桃', '新鲜水果', '/fruit/GalleryPicUpload/yingtao.jpg', null);
INSERT INTO `gallerypic` VALUES ('004', '中秋', '中秋晚会家宴', '/fruit/GalleryPicUpload/zhongqiu.jpg', null);

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `MESSAGEID` varchar(255) NOT NULL,
  `MESSAGETITLE` varchar(255) DEFAULT NULL,
  `MESSAGEADMIN` varchar(255) DEFAULT NULL,
  `MESSAGECONTENT` varchar(255) DEFAULT NULL,
  `MESSAGEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`MESSAGEID`),
  KEY `FK_7l34kwxn27frmm8fmjytx2fb7` (`MESSAGEADMIN`),
  CONSTRAINT `FK_7l34kwxn27frmm8fmjytx2fb7` FOREIGN KEY (`MESSAGEADMIN`) REFERENCES `admin` (`ADMINID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('002', '领导开会', '456', '						最新通知：黑龙江大学校长要莅临我公司进行采访活动，欢迎大家\r\n						', '2014-09-03 19:14:37');
INSERT INTO `message` VALUES ('003', '俄罗斯大列巴', '123', '优秀的面包现在出锅了', '2014-08-23 12:23:41');
INSERT INTO `message` VALUES ('004', '啊是的撒的撒旦', '123', '啊法师法师发誓', '2014-08-23 12:25:11');
INSERT INTO `message` VALUES ('005', '啊发的发大时代', '123', '挨个发发是的撒的', '2014-08-23 12:24:24');
INSERT INTO `message` VALUES ('006', '啊发发生大', '456', '罚打扫打扫打扫', '2014-08-23 12:24:10');
INSERT INTO `message` VALUES ('20140903191522', '绿活强势上线', '123', '			绿活黑大首秀			', '2014-09-03 19:15:22');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USERID` varchar(255) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `USERSEX` varchar(255) DEFAULT NULL,
  `USERPASSWORD` varchar(255) DEFAULT NULL,
  `USERPHONE` varchar(255) DEFAULT NULL,
  `USERBIRTH` datetime DEFAULT NULL,
  `USERMAIL` varchar(255) DEFAULT NULL,
  `USERADDR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', 'songliang', '男', '987654', '12345678998', '2014-08-01 17:01:10', '263693587@qq.com', '河南焦作市沁阳市');
INSERT INTO `user` VALUES ('001111', '123456', null, '123456', null, null, null, null);
INSERT INTO `user` VALUES ('01234', null, null, '123456', null, '2014-08-06 00:00:00', '48125@qq.com', null);
INSERT INTO `user` VALUES ('1021502', null, 'female', '123456', null, '2014-09-02 00:00:00', '13425415251@qq.com', null);
INSERT INTO `user` VALUES ('12012', null, null, '123123', null, '2014-08-06 00:00:00', '12542@qq.com', null);
INSERT INTO `user` VALUES ('12345', null, null, '123456', null, '2014-08-07 00:00:00', '807858227@qq.com', null);
INSERT INTO `user` VALUES ('123456', null, null, '123456', null, '2014-08-01 00:00:00', '12453@163.com', null);
INSERT INTO `user` VALUES ('123456789', null, null, '123123', null, '2014-08-07 00:00:00', '124526@qq.com', null);
INSERT INTO `user` VALUES ('4454528545', null, null, 'sl123456', null, null, '807858227121@qq.com', null);
INSERT INTO `user` VALUES ('456123', null, 'female', '123456', null, '2014-08-06 00:00:00', '123457@qq.com', null);
INSERT INTO `user` VALUES ('78945', null, null, '123456', null, '2014-08-06 00:00:00', '12452656@qq.com', null);
INSERT INTO `user` VALUES ('abcd', null, 'male', '123456', null, '2014-08-07 00:00:00', '56452@qq.com', null);
INSERT INTO `user` VALUES ('linan', null, null, null, null, null, '45614728741@qq.com', null);
INSERT INTO `user` VALUES ('nvnnvnv', null, 'male', '123456', null, '2014-08-08 00:00:00', 'ansndd@qq.com', null);
INSERT INTO `user` VALUES ('snjdaasd', null, 'male', '123456', null, '2014-08-07 00:00:00', '12452@qq.com', null);
INSERT INTO `user` VALUES ('wang', null, null, '123456', null, null, '12352452@qq.com', null);

-- ----------------------------
-- Table structure for `usermessage`
-- ----------------------------
DROP TABLE IF EXISTS `usermessage`;
CREATE TABLE `usermessage` (
  `USERMESSAGEID` varchar(255) NOT NULL,
  `USERMESSAGETITLE` varchar(255) DEFAULT NULL,
  `USERMESSAGECONTENT` varchar(255) DEFAULT NULL,
  `USERMESSAGEAUTHOR` varchar(255) DEFAULT NULL,
  `ISCONFIRM` int(11) DEFAULT NULL,
  `USERMESSAGEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`USERMESSAGEID`),
  KEY `FK_fgxxp5b6cyo1hqsivwd729rfv` (`USERMESSAGEAUTHOR`),
  CONSTRAINT `FK_fgxxp5b6cyo1hqsivwd729rfv` FOREIGN KEY (`USERMESSAGEAUTHOR`) REFERENCES `user` (`USERID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermessage
-- ----------------------------
INSERT INTO `usermessage` VALUES ('00120140818115426', '为氛围 方位服务', '啊说的是大', '001', '1', '2014-08-18 11:54:27');
INSERT INTO `usermessage` VALUES ('00120140818120111', '范文芳废物废物 ', 'adsasadasdada', '001', '1', '2014-08-18 12:01:11');
INSERT INTO `usermessage` VALUES ('00120140818120117', null, 'adsasadasdada', '001', '0', '2014-08-18 12:01:18');
INSERT INTO `usermessage` VALUES ('00120140818120157', null, 'adsasadasdada', '001', '0', '2014-08-18 12:01:57');
INSERT INTO `usermessage` VALUES ('00120140818120501', null, '啊试试打打', '001', '0', '2014-08-18 12:05:01');
INSERT INTO `usermessage` VALUES ('00120140818121459', null, 'asdasad', '001', '0', '2014-08-18 12:15:00');
INSERT INTO `usermessage` VALUES ('00120140818121510', null, 'dasdasdasd ', '001', '0', '2014-08-18 12:15:10');
INSERT INTO `usermessage` VALUES ('00120140818121815', null, 'dasdasdasd ', '001', '0', '2014-08-18 12:18:15');
INSERT INTO `usermessage` VALUES ('00120140818121842', null, 'asdsadsa', '001', '0', '2014-08-18 12:18:43');
INSERT INTO `usermessage` VALUES ('00120140818122220', null, '撒旦撒大事', '001', '0', '2014-08-18 12:22:20');
INSERT INTO `usermessage` VALUES ('00120140818122257', null, '啊盛大盛大', '001', '0', '2014-08-18 12:22:57');
INSERT INTO `usermessage` VALUES ('00120140818122447', null, 'dtrdgtf', '001', '0', '2014-08-18 12:24:47');
INSERT INTO `usermessage` VALUES ('00120140818122739', null, 'asddasa', '001', '0', '2014-08-18 12:27:40');
INSERT INTO `usermessage` VALUES ('00120140818122917', null, 'dadssddsa', '001', '0', '2014-08-18 12:29:17');
INSERT INTO `usermessage` VALUES ('00120140818123150', null, 'sdadasdas', '001', '0', '2014-08-18 12:31:51');
INSERT INTO `usermessage` VALUES ('00120140818123313', null, 'dadas', '001', '0', '2014-08-18 12:33:14');
INSERT INTO `usermessage` VALUES ('00120140818123638', null, 'safasfaa', '001', '0', '2014-08-18 12:36:38');
INSERT INTO `usermessage` VALUES ('00120140818123956', null, '我打算打撒的', '001', '0', '2014-08-18 12:39:57');
INSERT INTO `usermessage` VALUES ('00120140818124116', null, 'sdasdada', '001', '0', '2014-08-18 12:41:17');
INSERT INTO `usermessage` VALUES ('00120140818124151', null, 'weqwqw', '001', '0', '2014-08-18 12:41:51');
INSERT INTO `usermessage` VALUES ('00120140818124237', null, 'ewqweqq', '001', '0', '2014-08-18 12:42:38');
INSERT INTO `usermessage` VALUES ('00120140819103206', null, '把时间都不撒娇的好吧记得', '001', '0', '2014-08-19 10:32:06');
INSERT INTO `usermessage` VALUES ('00120140909155931', null, null, '001', '0', '2014-09-09 15:59:31');
INSERT INTO `usermessage` VALUES ('00120140909155935', null, 'ewqeqeqweqewqeq', '001', '0', '2014-09-09 15:59:36');
INSERT INTO `usermessage` VALUES ('00120140909160037', null, null, '001', '0', '2014-09-09 16:00:38');
INSERT INTO `usermessage` VALUES ('00120140909160105', null, 'aaaaaaaaaaaaaaaaa', '001', '0', '2014-09-09 16:01:06');
INSERT INTO `usermessage` VALUES ('00120140909160113', null, 'aaaaaaaaaaaaaaaaa', '001', '0', '2014-09-09 16:01:13');
INSERT INTO `usermessage` VALUES ('00120140909160314', null, 'abcabc', '001', '0', '2014-09-09 16:03:14');
INSERT INTO `usermessage` VALUES ('00120140909160353', null, 'bbbbbbbb', '001', '0', '2014-09-09 16:03:54');
INSERT INTO `usermessage` VALUES ('00120140909160510', null, 'bbbbbbbb', '001', '0', '2014-09-09 16:05:10');
INSERT INTO `usermessage` VALUES ('00120140909160539', null, 'dddddddddddddddddddddddd', '001', '0', '2014-09-09 16:05:39');
INSERT INTO `usermessage` VALUES ('00120140909160740', null, 'wwwwwwwwwwwww', '001', '0', '2014-09-09 16:07:40');
INSERT INTO `usermessage` VALUES ('00120140909161008', null, 'qqqqqqq', '001', '0', '2014-09-09 16:10:09');
INSERT INTO `usermessage` VALUES ('00120140909161036', null, 'qqqqqqq', '001', '0', '2014-09-09 16:10:37');
INSERT INTO `usermessage` VALUES ('00120140909161234', null, 'M<', '001', '0', '2014-09-09 16:12:35');
INSERT INTO `usermessage` VALUES ('00120140909161342', null, '<a href=\'javascript:alert(123)\'>123</a>', '001', '0', '2014-09-09 16:13:42');
INSERT INTO `usermessage` VALUES ('00120140909162452', null, 'rfgre', '001', '0', '2014-09-09 16:24:53');
INSERT INTO `usermessage` VALUES ('00120140909162511', null, 'rfgre', '001', '0', '2014-09-09 16:25:11');
INSERT INTO `usermessage` VALUES ('00120140909162606', null, 'efrwefwewerwerwerwerwe', '001', '0', '2014-09-09 16:26:06');
INSERT INTO `usermessage` VALUES ('00120140909163315', null, 'seresdgvhb', '001', '0', '2014-09-09 16:33:16');
INSERT INTO `usermessage` VALUES ('00120140909191650', null, 'qwertyuiop', '001', '0', '2014-09-09 19:16:51');
INSERT INTO `usermessage` VALUES ('00120140909191656', null, 'qwertyuiop', '001', '0', '2014-09-09 19:16:57');
INSERT INTO `usermessage` VALUES ('00120140909191714', null, 'qwertyuiop', '001', '0', '2014-09-09 19:17:14');
INSERT INTO `usermessage` VALUES ('00120140909191748', null, 'å¸åå', '001', '0', '2014-09-09 19:17:49');
INSERT INTO `usermessage` VALUES ('00120140909192017', null, 'å¸åå', '001', '0', '2014-09-09 19:20:18');
INSERT INTO `usermessage` VALUES ('00120140909192029', null, '热天热天', '001', '0', '2014-09-09 19:20:30');
INSERT INTO `usermessage` VALUES ('0123420140817103324', null, 'asdasdasdas', '01234', '0', '2014-08-17 10:33:24');
INSERT INTO `usermessage` VALUES ('0123420140817103403', null, '仅仅是懂啊时间都I啊圣诞节啊 啊是的可怕基督教啊是大神', '01234', '0', '2014-08-17 10:34:03');
INSERT INTO `usermessage` VALUES ('0123420140818114049', null, 'andjkasnandas', '01234', '0', '2014-08-18 11:40:50');
INSERT INTO `usermessage` VALUES ('0123420140818114349', null, '这是可以插入成功的', '01234', '0', '2014-08-18 11:43:50');
INSERT INTO `usermessage` VALUES ('0123420140818124549', null, '盛大的撒', '01234', '0', '2014-08-18 12:45:49');
INSERT INTO `usermessage` VALUES ('0123420140818124733', null, 'sdasdsada', '01234', '0', '2014-08-18 12:47:33');
INSERT INTO `usermessage` VALUES ('0123420140818124830', null, 'dasd ', '01234', '0', '2014-08-18 12:48:30');
INSERT INTO `usermessage` VALUES ('0123420140818125410', null, '大三大大事', '01234', '0', '2014-08-18 12:54:11');
INSERT INTO `usermessage` VALUES ('0123420140818125818', null, '实打实的', '01234', '0', '2014-08-18 12:58:18');
INSERT INTO `usermessage` VALUES ('0123420140818125949', null, '打撒打撒', '01234', '0', '2014-08-18 12:59:50');
INSERT INTO `usermessage` VALUES ('0123420140818130133', null, '速度大大', '01234', '0', '2014-08-18 13:01:34');
INSERT INTO `usermessage` VALUES ('0123420140818130951', null, 'sad ', '01234', '0', '2014-08-18 13:09:52');
INSERT INTO `usermessage` VALUES ('0123420140818131137', null, 'sad', '01234', '0', '2014-08-18 13:11:38');
INSERT INTO `usermessage` VALUES ('0123420140818131334', null, 'weqe  weq', '01234', '0', '2014-08-18 13:13:34');
INSERT INTO `usermessage` VALUES ('0123420140818131600', null, 'adasa', '01234', '0', '2014-08-18 13:16:00');
INSERT INTO `usermessage` VALUES ('0123420140818131611', null, 'adsadasdas', '01234', '0', '2014-08-18 13:16:11');
INSERT INTO `usermessage` VALUES ('0123420140818131702', null, 'dadasa', '01234', '0', '2014-08-18 13:17:03');
INSERT INTO `usermessage` VALUES ('0123420140818131838', null, '爱的撒大', '01234', '0', '2014-08-18 13:18:39');
INSERT INTO `usermessage` VALUES ('0123420140818132035', null, 'dsadas ', '01234', '0', '2014-08-18 13:20:36');
INSERT INTO `usermessage` VALUES ('0123420140818132116', null, 'sadasa', '01234', '0', '2014-08-18 13:21:17');
INSERT INTO `usermessage` VALUES ('0123420140818132156', null, 'asadfas', '01234', '0', '2014-08-18 13:21:56');
INSERT INTO `usermessage` VALUES ('0123420140818132247', null, 'qwrqrq', '01234', '0', '2014-08-18 13:22:47');
INSERT INTO `usermessage` VALUES ('0123420140818132343', null, 'asdasa', '01234', '0', '2014-08-18 13:23:44');
INSERT INTO `usermessage` VALUES ('0123420140818133254', null, '415123', '01234', '0', '2014-08-18 13:32:54');
INSERT INTO `usermessage` VALUES ('0123420140818133450', null, 'daasdas', '01234', '0', '2014-08-18 13:34:50');
INSERT INTO `usermessage` VALUES ('0123420140818133518', null, 'qweqeq', '01234', '0', '2014-08-18 13:35:18');
INSERT INTO `usermessage` VALUES ('0123420140818134005', null, '啊盛大盛大是', '01234', '0', '2014-08-18 13:40:06');
INSERT INTO `usermessage` VALUES ('0123420140818134726', null, '的方式地方大学官方', '01234', '0', '2014-08-18 13:47:27');
INSERT INTO `usermessage` VALUES ('0123420140818134925', null, '12313', '01234', '0', '2014-08-18 13:49:25');
INSERT INTO `usermessage` VALUES ('0123420140818135235', null, '12312', '01234', '0', '2014-08-18 13:52:35');
INSERT INTO `usermessage` VALUES ('0123420140818135325', null, '41132', '01234', '0', '2014-08-18 13:53:26');
INSERT INTO `usermessage` VALUES ('0123420140818135406', null, '12312', '01234', '0', '2014-08-18 13:54:06');
INSERT INTO `usermessage` VALUES ('0123420140818140633', null, 'sdadas', '01234', '0', '2014-08-18 14:06:34');
INSERT INTO `usermessage` VALUES ('0123420140818140937', null, 'eqweqwew', '01234', '0', '2014-08-18 14:09:37');
INSERT INTO `usermessage` VALUES ('0123420140818141416', null, 'rwqerqrq', '01234', '0', '2014-08-18 14:14:16');
INSERT INTO `usermessage` VALUES ('0123420140818141701', null, '三大大事', '01234', '0', '2014-08-18 14:17:02');
INSERT INTO `usermessage` VALUES ('0123420140818141815', null, 'xczczx', '01234', '0', '2014-08-18 14:18:15');
INSERT INTO `usermessage` VALUES ('0123420140818141935', null, 'sdasda', '01234', '0', '2014-08-18 14:19:35');
INSERT INTO `usermessage` VALUES ('0123420140818142213', null, '大苏打', '01234', '0', '2014-08-18 14:22:14');
INSERT INTO `usermessage` VALUES ('0123420140818143044', null, '帅哒哒', '01234', '0', '2014-08-18 14:30:44');
INSERT INTO `usermessage` VALUES ('0123420140818143052', null, '帅哒哒', '01234', '0', '2014-08-18 14:30:52');
INSERT INTO `usermessage` VALUES ('0123420140818143119', null, '', '01234', '0', '2014-08-18 14:31:20');

-- ----------------------------
-- Table structure for `vegetable`
-- ----------------------------
DROP TABLE IF EXISTS `vegetable`;
CREATE TABLE `vegetable` (
  `VEGETABLEID` varchar(255) NOT NULL,
  `VEGETABLENAME` varchar(255) DEFAULT NULL,
  `VEGETABLEPRICE` varchar(255) DEFAULT NULL,
  `VEGETABLEINFO` varchar(255) DEFAULT NULL,
  `VEGETABLEQUANTITY` varchar(255) DEFAULT NULL,
  `VEGETABLEDISCOUNT` float DEFAULT NULL,
  `VEGETABLECATAGORY` varchar(255) DEFAULT NULL,
  `ISRECOMMEND` int(11) DEFAULT '0',
  `VEGETABLEKEYWORDS` varchar(255) DEFAULT NULL,
  `VEGETABLEUNIT` varchar(255) DEFAULT NULL,
  `VEGETABLECOMMENTCOUNT` bigint(20) DEFAULT NULL,
  `VEGETABLESALECOUNT` bigint(20) DEFAULT '0',
  PRIMARY KEY (`VEGETABLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vegetable
-- ----------------------------
INSERT INTO `vegetable` VALUES ('001', '胡萝卜', '12.3', '这是来自小江南的胡萝卜', '200', '8', '蔬菜', '0', '蔬菜,萝卜,胡萝卜，甜萝卜', 'kg', '49', '128');
INSERT INTO `vegetable` VALUES ('002', '西瓜', '8.8', '纯天然无公害', '400', '7', '水果', '1', '水果,夏季,解渴', 'kg', '56', '165');
INSERT INTO `vegetable` VALUES ('003', '西红柿', '23.2', '墨西哥大西红柿', '356', '6', '蔬菜', '1', '蔬菜,西红柿,番茄', 'kg', '26', '452');
INSERT INTO `vegetable` VALUES ('004', '茄子', '12.5', '产自黑龙江大茄子', '10235', '5', '蔬菜', '1', '蔬菜,茄子', 'kg', '12', '125');
INSERT INTO `vegetable` VALUES ('005', '猕猴桃', '23.6', '澳大利亚纯天然水果', '234', '7.5', '水果', '1', '水果,澳大利亚,猕猴桃', 'kg', '56', '26');
INSERT INTO `vegetable` VALUES ('006', '苹果', '23.6', '爱妃苹果', '563', '9', '水果', '1', '水果,苹果', 'kg', '24', '147');
INSERT INTO `vegetable` VALUES ('007', '蟠桃', '8.8', '金山', '456', '3.5', '水果', '1', '水果,金山,蟠桃', 'kg', '126', '562');
INSERT INTO `vegetable` VALUES ('008', '柠檬', '56', '新西兰大柠檬', '126', '4', '水果', '1', '水果,柠檬', 'kg', '265', '782');
INSERT INTO `vegetable` VALUES ('009', '葡萄', '45', '金兽葡萄', '562', '6', '水果', '0', '水果,葡萄', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('010', '甜枣', '23.6', '新疆甜枣', '125', '4.8', '水果', '0', '水果,甜枣,枣', 'kg', '475', '569');
INSERT INTO `vegetable` VALUES ('011', '无花果', '25.4', '澳大利亚甜美无花果', '125', '4.8', '水果', '0', '水果,无花果', 'kg', '568', '568');
INSERT INTO `vegetable` VALUES ('012', '无花果', '25.4', '澳大利亚甜美无花果', '125', '4.8', '水果', '0', '水果,无花果', 'kg', '568', '127');
INSERT INTO `vegetable` VALUES ('013', '无花果', '25.4', '澳大利亚甜美无花果', '125', '4.8', '水果', '1', '水果,无花果', 'kg', '568', '127');
INSERT INTO `vegetable` VALUES ('014', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('015', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('016', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('017', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('018', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('019', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('020', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');
INSERT INTO `vegetable` VALUES ('021', '无花果', '25.5', '澳大利亚甜美无花果', '125', '4.5', '水果', '0', '水果,无花果', 'kg', '452', '127');

-- ----------------------------
-- Table structure for `vegetable_info_pic`
-- ----------------------------
DROP TABLE IF EXISTS `vegetable_info_pic`;
CREATE TABLE `vegetable_info_pic` (
  `VEGETABLEID` varchar(255) NOT NULL,
  `VEGETABLEINFOPICADDR` varchar(255) DEFAULT NULL,
  `idx` int(11) NOT NULL,
  PRIMARY KEY (`VEGETABLEID`,`idx`),
  KEY `FK_3dvqvs1fwfo82a9nrtgt3qs5d` (`VEGETABLEID`),
  CONSTRAINT `FK_3dvqvs1fwfo82a9nrtgt3qs5d` FOREIGN KEY (`VEGETABLEID`) REFERENCES `vegetable` (`VEGETABLEID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vegetable_info_pic
-- ----------------------------
INSERT INTO `vegetable_info_pic` VALUES ('001', '/vegetableInfoPicUpload/vegetableInfoPicAddr1a.jpg', '0');
INSERT INTO `vegetable_info_pic` VALUES ('001', '/vegetableInfoPicUpload/vegetableInfoPicAddr2b.jpg', '1');
INSERT INTO `vegetable_info_pic` VALUES ('001', '/vegetableInfoPicUpload/vegetableInfoPicAddr3c.jpg', '2');
INSERT INTO `vegetable_info_pic` VALUES ('001', '/vegetableInfoPicUpload/vegetableInfoPicAddr4d.jpg', '3');

-- ----------------------------
-- Table structure for `vegetable_pic`
-- ----------------------------
DROP TABLE IF EXISTS `vegetable_pic`;
CREATE TABLE `vegetable_pic` (
  `VEGETABLEID` varchar(255) NOT NULL,
  `VEGETABLEPICADDR` varchar(255) DEFAULT NULL,
  `idx` int(11) NOT NULL,
  PRIMARY KEY (`VEGETABLEID`,`idx`),
  KEY `FK_ntc5j4p05v13i0rtxloksbf1w` (`VEGETABLEID`),
  CONSTRAINT `FK_ntc5j4p05v13i0rtxloksbf1w` FOREIGN KEY (`VEGETABLEID`) REFERENCES `vegetable` (`VEGETABLEID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vegetable_pic
-- ----------------------------
INSERT INTO `vegetable_pic` VALUES ('001', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('001', '/fruit/vegetableUpload/1.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('001', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('001', '/fruit/vegetableUpload/vegetablePic4a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('001', '/fruit/vegetableUpload/vegetablePic5a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('001', '/fruit/vegetableUpload/vegetablePic6a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('002', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('002', '/fruit/vegetableUpload/3.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('002', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('002', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('002', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('002', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('003', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('003', '/fruit/vegetableUpload/5.gif', '1');
INSERT INTO `vegetable_pic` VALUES ('003', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('003', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('003', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('003', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('004', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('004', '/fruit/vegetableUpload/7.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('004', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('004', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('004', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('004', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('005', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('005', '/fruit/vegetableUpload/8.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('005', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('005', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('005', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('005', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('006', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('006', '/fruit/vegetableUpload/1.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('006', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('006', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('006', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('006', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('007', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('007', '/fruit/vegetableUpload/vegetablePic3a.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('007', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('007', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('007', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('007', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('008', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('008', '/fruit/vegetableUpload/3.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('008', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('008', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('008', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('008', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('009', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('009', '/fruit/vegetableUpload/vegetablePic3a.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('009', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('009', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('009', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('009', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('010', '/fruit/vegetableUpload/vegetablePic3a.jpg', '0');
INSERT INTO `vegetable_pic` VALUES ('010', '/fruit/vegetableUpload/vegetablePic3a.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('010', '/fruit/vegetableUpload/vegetablePic3a.jpg', '2');
INSERT INTO `vegetable_pic` VALUES ('010', '/fruit/vegetableUpload/vegetablePic3a.jpg', '3');
INSERT INTO `vegetable_pic` VALUES ('010', '/fruit/vegetableUpload/vegetablePic3a.jpg', '4');
INSERT INTO `vegetable_pic` VALUES ('010', '/fruit/vegetableUpload/vegetablePic3a.jpg', '5');
INSERT INTO `vegetable_pic` VALUES ('011', '/fruit/vegetableUpload/1.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('012', '/fruit/vegetableUpload/1.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('013', '/fruit/vegetableUpload/1.jpg', '1');
INSERT INTO `vegetable_pic` VALUES ('021', '/fruit/vegetableUpload/1.jpg', '1');
