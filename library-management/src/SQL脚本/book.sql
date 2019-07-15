/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           :
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 15/07/2019 22:26:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book_info
-- ----------------------------
DROP TABLE IF EXISTS `t_book_info`;
CREATE TABLE `t_book_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书id',
  `book_serial` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书编号',
  `book_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `book_author` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书作者',
  `book_publish` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书出版社',
  `book_price` decimal(10, 0) NULL DEFAULT NULL COMMENT '图书价格',
  `book_state` int(2) NULL DEFAULT NULL COMMENT '图书状态：0-正常;1-借出;',
  `book_type` int(11) NULL DEFAULT NULL COMMENT '图书类型',
  `book_introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图书简介',
  `book_shelf` int(11) NULL DEFAULT NULL COMMENT '所在书架',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book_info
-- ----------------------------
INSERT INTO `t_book_info` VALUES (1, '9787302519287', 'Excel企业经营数据分析实战', '张倩', '清华大学出版社', 79, 0, 31, '本书是一本介绍Excel 2016企业经营数据实用操作的书籍，全面系统地介绍了Excel 2016的技术特点和企业数据实战应用知识。本书通过大量的实用案例，帮助读者快速掌握Excel的应用技巧，这些案例也适合读者直接在工作中借鉴使用。 本书共分11章，内容涉及企业数据高效录入、数据的整理和规范、数据的初步处理、数据的常规分析、公式和函数的应用、图表的应用、数据分析工具的应用及Excel的应用综合。 本书既可作为Excel初学者的入门指南，也可作为中、高级用户的实用参考手册，还可作为各类办公人员的培训教材', 1, '2019-04-16 10:12:03', '2019-07-03 23:24:14');
INSERT INTO `t_book_info` VALUES (2, '9787302515807', '零基础学WordPress', '老王经销商', '清华大学出版社', 79, 1, 31, '本书通过对安装使用WordPress搭建自媒体站点的前期、中期、后期进行详细讲解，使读者全面了解和掌握作为一个自媒体网站站长应掌握的域名、服务器、WordPress等方面的基础知识，同时通过实例站点与图书社区为读者提供了相关资源与服务，是一本绝无仅有、不可多得的技术书籍。\n全书分为3大部分，共21章节。第1～9章着重介绍域名的基础知识、购买域名的支付方式、购买域名的基本流程、域名备案的常规流程以及域名解析的常用方法；第10～17章着重介绍Linux的简单概念、相关社区的提问方法、使用服务器的基础知识、服务器安全的基础知识、权限管理的基础知识、使用防火墙的基础知识、操作数据库的基础知识、WordPress加速的基础知识以及管理账号密码的基础知识；第18～21章着重介绍安装使用WordPress过程中的基础知识、实例站点的建设流程。\n\n本书适合有志于成为优秀自媒体人的入门读者，也适合作为高等院校的选修计算机教材，还可供对搭建独立个人博客有兴趣的人士以及对建设独立企业官网有需求的中小企业参考。', 1, '2019-04-16 10:18:58', '2019-04-19 14:15:30');
INSERT INTO `t_book_info` VALUES (3, '9787302505945', '零基础入门学习C语言——带你学C带你飞（微课视频版）', '小甲鱼', '清华大学出版社', 79, 0, 23, '《零基础入门学习C语言——带你学C带你飞（微课视频版）》提倡“理解为主，应用为王”，通过列举一些有趣的例子，让读者在实践中理解概念。《零基础入门学习C语言——带你学C带你飞（微课视频版）》从变量、数据类型、取值范围等基本知识开始讲解，深入介绍分支与循环，讲到指针的时候，分散难点，依次讲解数组与指针、函数与指针、结构体与指针，每个知识点结合恰当的实例进行演示，环环相扣，内容详尽。\n编程知识深似海，小甲鱼没办法仅通过一《零基础入门学习C语言——带你学C带你飞（微课视频版）》将所有的知识都灌输给读者，但能够做到的是培养读者对编程的兴趣，提高编写代码的水平，锻炼自学的能力。\n\n《零基础入门学习C语言——带你学C带你飞（微课视频版）》贯彻的核心理念是：实用、好玩、参与。\n\n《零基础入门学习C语言——带你学C带你飞（微课视频版）》适合学习C语言的入门读者，也适用于对编程一无所知，但渴望用编程改变世界的朋友。', 2, '2019-04-16 10:21:15', '2019-04-19 14:06:25');
INSERT INTO `t_book_info` VALUES (4, '9787302523352', 'JSP Servlet Tomcat应用开发从零开始学（第2版）', '林龙 刘华贞', '清华大学出版社', 79, 0, 23, '本书全面介绍了JSP开发中涉及的相关技术要点和实战技巧。全书结构清晰，难度循序渐进，结合丰富的示例使零基础的读者能够熟练掌握JSP的开发、部署以及优化。\n本书分为3篇：第1篇为Java Web基础开发，内容包括搭建Java Web开发环境、JSP基础语法、JSP内置对象、Servlet技术、请求与响应、会话管理、Servlet进阶API、过滤器、监听器等；第2篇为Java Web高级开发，内容包括MySQL 8数据库开发、JSP与Java Bean、EL标签、JSTL标签库、自定义标签、JDBC详解、XML概述、资源国际化等；第3篇为Java Web实战，内容包括两个典型的系统，即家校通门户网站（JSP HTML CSS）、在线购物系统（JSP Java Bean MySQL）。\n\n本书内容精练、结构清晰、注重实战，适合广大Java Web初学人员学习，同时也非常适合大中专院校师生学习阅读，还可作为高等院校计算机及相关专业的教材使用。', 2, '2019-04-16 10:23:01', '2019-04-19 14:10:09');
INSERT INTO `t_book_info` VALUES (6, '9787302517559', 'Android 7应用程序开发教程', '李波', '清华大学出版社', 89, 0, 23, 'Android系统是目前最为流行的智能手机操作系统之一，面向Android系统的应用开发是目前的技术热点。本书针对Android SDK 7，结合全新的Android Studio开发环境，对Android应用编程基础知识进行讲解，易于读者理论联系实践，尽快掌握Android系统编程知识。\n本书分为14章，使用Java开发语言，内容主要包括Android 系统的发展历史、系统架构、应用程序框架、界面开发、网络访问、多媒体应用程序开发、数据存储等。本书每一章都给出实例，使读者进一步巩固所学的知识，提高综合实战能力。\n\n本书既适合熟悉Java编程的Android初学者和具有一定Android编程经验的用户，也可供广大计算机工作者和软件开发者参考。', 2, '2019-04-16 10:28:32', '2019-04-19 14:11:21');
INSERT INTO `t_book_info` VALUES (8, '9787302518082', 'AutoCAD 2018中文版入门与提高——土木工程设计', 'CAD/CAM/CAE技术联盟', '清华大学出版社', 90, 0, 23, '本书共分为3个部分15章，第1～5章为AutoCAD基础篇，包括AutoCAD2018基础入门，绘图基础与控制，图形的绘制与编辑，图形的尺寸、文字标注与表格，使用块、外部参照和设计中心等；第6～11章为建筑施工图篇，包括建筑施工图制图标准（2010版），建筑总平面图、平面图、立面图、剖面图、详图等的概述与绘制方法；第12～15章为结构施工图篇，包括建筑结构图制图标准（2010版），基础平面图与详图的概述与绘制方法，楼层结构平面图的概述与绘制方法，楼梯结构详图的概述与绘制方法。', 3, '2019-04-16 10:32:09', '2019-04-16 10:32:09');
INSERT INTO `t_book_info` VALUES (9, '9787302515654', 'Oracle 12c数据库入门与应用', '靳智良、冯海燕', '清华大学出版社', 66, 0, 23, 'Oracle数据库系统是数据库领域最优秀的数据库之一，《Oracle 12c数据库入门与应用》以Oracle最新版本12c为蓝本，系统地讲述了Oracle数据库的概念、管理和应用开发等内容。全书结构合理、内容翔实、示例丰富、语言简洁。从实际角度出发，系统地介绍了数据库和Oracle的相关概念和原理、数据维护(查询、更新和删除)、Oracle数据库管理(如安装与启动、用户权限)以及Oracle的应用开发基础，并在最后通过设计医院预约挂号系统数据库讲解开发的详细过程。\n《Oracle 12c数据库入门与应用》面向数据库管理人员和数据库开发人员，是初学者很好的入门教程，对Oracle管理员和应用程序开发员也有很好的学习和参考价值，也可以作为各大、中专院校相关专业的参考用书和相关培训机构的培训教材。', 3, '2019-04-16 10:34:42', '2019-04-16 10:34:42');
INSERT INTO `t_book_info` VALUES (10, '9787302524281', 'MySQL 5.7从入门到精通（视频教学版）（第2版）', '张工厂', '清华大学出版社', 138, 0, 23, '本书主要包括MySQL的安装与配置、数据库的创建、数据表的创建、数据类型和运算符、MySQL函数、查询数据、数据表的操作（插入、更新与删除数据）、索引、存储过程和函数、视图、触发器、用户管理、数据备份与还原、日志以及性能优化。最后通过3个综合案例的数据库设计，进一步讲述MySQL在实际工作中的应用。重点介绍MySQL安装与配置、数据类型和运算符以及数据表的操作。本书注重实战操作，帮助读者循序渐进地掌握MySQL中的各项技术。\n本书共有480个实例和19个综合案例，还有大量的经典习题。随书赠送了近20小时培训班形式的视频教学录像，详细讲解了书中每一个知识点和每一个数据库操作的方法和技巧。同时光盘中还提供了本书所有例子的源代码，读者可以直接查看和调用。\n\n本书适合MySQL数据库初学者、MySQL数据库开发人员和MySQL数据库管理员，同时也能作为高等院校和培训学校相关专业师生的教学用书。', 3, '2019-04-16 10:41:25', '2019-04-16 10:41:25');
INSERT INTO `t_book_info` VALUES (11, '9787302513223', 'SPSS实战与统计思维', '武松', '清华大学出版社', 99, 0, 23, '本书从统计学思维开始，由浅入深，全面系统地讲解了SPSS实战应用。本书涉及面广，从软件基本操作到高级统计分析技术，涉及SPSS目前绝大部分的应用范畴。本书涵盖SPSS概述、数据管理、统计描述分析、基本统计分析的报表制作、t检验、方差分析、Logistic回归、中介效应与调节效应分析以及大量的专项统计方法。本书以案例式教学为特色，书中提供了大量的应用案例，供读者实战演练。\n本书不仅适合有一定统计基础的人员阅读，也适合SPSS初学者。通信、金融、制造、医药、教育科研、市场调研、连锁零售和电子商务等行业的数据分析人员，可将本书作为一本易学易练的案头参考书。信息技术、心理学、经济管理等专业的大中专院校的学生和教师，可将本书作为一本教材使用。', 3, '2019-04-16 10:42:50', '2019-04-16 10:42:50');
INSERT INTO `t_book_info` VALUES (13, '9787302494881', '工业产品形态创新设计与评价方法', '高瞩', '清华大学出版社', 59, 0, 23, '本书提出产品形态原型和形态“传承度”的思想，通过对产品形态风格的描述与分析，建立形态原型的参数与产品形态风格的关系，构建了工业产品形态创新设计与评价的理论和方法，对工业产品的形态创新、分析评价及指导企业的设计实践具有重要的理论和实际意义。\n利用产品照片反求其形态3D模型，以形态分体的最适包围盒为单元，基于拓扑关系构建形态原型；提出基于产品形态原型的递进式形态语意获取方法，以及形态的风格空间和玫瑰图，面向风格的产品形态创新设计框架及软件开发思路；基于遗传算法对产品形态设计方案进行风格定位，构建了基于风格要求的产品形态创新设计方法。基于产品形态“传承度”，建立基于形态传承的设计评价方法及工业产品形态设计与评价（FD', 4, '2019-04-16 10:50:31', '2019-04-16 10:50:31');
INSERT INTO `t_book_info` VALUES (14, '9787302511083', '敏捷软件开发：用户故事实战', '迈克·科恩（Mike Cohn）著　王凌宇　译', '清华大学出版社', 70, 0, 23, '<p><img alt=\"\" src=\"/uploads/2019/04/16/13/13/e45d5c9b-8d16-4ab7-b60a-c430a0802ce8.jpg\" style=\"height:500px; width:369px\" /></p>\n\n<p>作为敏捷社区的经典名作，《敏捷软件开发：用户故事实战》不负众望，为软件行业提供了一种高效的需求过程，通过用户故事来节省时间、消除重复工作和开发更优秀的软件。要想构建可以满足用户需求的软件，最好的方法是从&ldquo;用户故事&rdquo;开始，用简明扼要的语言清楚明确地描述对实际用户有价值的功能。在本书中，敏捷实干家提供了一个详尽的蓝图来指导读者如何编写用户故事，如何在软件开发生命周期中实际运用用户故事。</p>\n\n<p>《敏捷软件开发：用户故事实战》共5部分21章，介绍了如何写出理想的用户故事，造成用户故事不理想的因素有哪些，如何在无法直接接触到用户的情况下有效搜集用户故事，如何对写好的用户故事进行整理、排优先级并在此基础上进行计划、管理和测试。</p>\n\n<p>《敏捷软件开发：用户故事实战》适合采用XP、Scrum甚至其他自主敏捷方法的所有开发、测试、分析师和项目负责人阅读和参考，可以帮助他们以更少的人手在更短的时间内开发出更符合用户需求的产品或服务。</p>\n', 3, '2019-04-16 17:10:54', '2019-04-16 17:10:54');
INSERT INTO `t_book_info` VALUES (15, '9787302489764', '软件之美', '申艳光、申思', '清华大学出版社', 39, 0, 23, '<p><img alt=\"\" src=\"/uploads/2019/04/16/15/5/fedec9fe-4d91-4ce3-93f0-5078d44d2eac.jpg\" style=\"height:500px; width:370px\" /></p><p>行走在红尘里，每个人都会遇见暴风骤雨和诗情画意。&ldquo;忧者见之而忧，喜者见之而喜&rdquo;。一路上，我们会听见花开的声音，会看见花绽的容颜，也会感受花落花谢的怜惜，如果我们能时时拥有温暖愉悦的心境，一路经历着、感悟着、感恩着，我们的生命就会开出美丽的花朵，永绽不败。</p>\n\n<p>一提到软件工程师，你是不是就会自动脑补一个对着计算机或者设备不停调试的呆板形象，而且会想到&ldquo;IT男&rdquo;&ldquo;码农&rdquo;这些词语？确实，在很多人心中，软件工程师是和呆板、机械、无趣画上等号的。</p>\n\n<p>请跟我们走进《软件之美》，本书将带你走进一个充满人文艺术气息的软件工程中，和我们一起发现、解读、领悟和体会软件之美和生活之美，敞开心扉、提升心境，体悟生活，感悟人生。</p>\n\n<p>本书共8章，内容包括软件中的思维、软件需求获取与分析、软件用户界面设计、邂逅编码、软件测试的心境、软件项目团队管理、软件文档写作的艺术和以道驭术等。</p>\n\n<p>本书可供从事计算机科学与技术学科和软件工程学科的相关工作者阅读、参考。</p>\n\n<p>行走在红尘里，每个人都会遇见暴风骤雨和诗情画意。&ldquo;忧者见之而忧，喜者见之而喜&rdquo;。一路上，我们会听见花开的声音，会看见花绽的容颜，也会感受花落花谢的怜惜，如果我们能时时拥有温暖愉悦的心境，一路经历着、感悟着、感恩着，我们的生命就会开出美丽的花朵，永绽不败。</p>\n\n<p>一提到软件工程师，你是不是就会自动脑补一个对着计算机或者设备不停调试的呆板形象，而且会想到&ldquo;IT男&rdquo;&ldquo;码农&rdquo;这些词语？确实，在很多人心中，软件工程师是和呆板、机械、无趣画上等号的。</p>\n\n<p>请跟我们走进《软件之美》，本书将带你走进一个充满人文艺术气息的软件工程中，和我们一起发现、解读、领悟和体会软件之美和生活之美，敞开心扉、提升心境，体悟生活，感悟人生。</p>\n\n<p>本书共8章，内容包括软件中的思维、软件需求获取与分析、软件用户界面设计、邂逅编码、软件测试的心境、软件项目团队管理、软件文档写作的艺术和以道驭术等。</p>\n\n<p>本书可供从事计算机科学与技术学科和软件工程学科的相关工作者阅读、参考。</p>\n', 3, '2019-04-16 17:18:43', '2019-04-16 17:18:43');
INSERT INTO `t_book_info` VALUES (16, '9787302511809', '大话软件测试——性能、自动化及团队管理', '赵强', '清华大学出版社', 79, 0, 27, '<p>本书并不是一本纯技术书籍，更像是一本系统性的参考书，能帮助读者深入理解性能测试和自动化测试的意义，也能帮助有多年工作经验正处于迷茫阶段的朋友排忧解难，还能给那些刚刚步入管理岗位的&ldquo;菜鸟们&rdquo;提供指导，尤其是其中的团队建设、绩效管理等是很多读者深感困惑的问题，可以说是测试工程师必读的一本书籍。</p>\n\n<p>本书分为两大部分：</p>\n\n<p>1~11章：&nbsp;以全新的角度来解释什么是性能测试和自动化测试，不仅以实际案例讲解了LoadRunner、JMeter、Soapui、Appium、移动端APP测试、前端性能、接口测试、安全测试、性能测试、自动化测试等内容，也讲解了大家最为头疼的两大难题&mdash;&mdash;性能测试通用分析思路和报告编写，同时也介绍了如何设计和开发轻量级自动化测试框架。</p>\n\n<p>12~14章：&nbsp;目前市面上缺少测试管理方面的图书，而本部分内容以作者本人的亲身经历来分享对测试行业的看法以及如何进行测试团队的建设、管理、绩效考核等，通俗易懂，是管理者的必读内容。</p>\n\n<p><img alt=\"\" src=\"/uploads/2019/04/16/5/7/b40b71a5-8426-47e1-92ee-e58a62cd538f.jpg\" style=\"float:left; height:300px; width:225px\" /></p>\n', 3, '2019-04-16 17:31:04', '2019-07-03 22:20:35');
INSERT INTO `t_book_info` VALUES (17, '9787302511810', '你的孤独虽败犹荣', '刘同', '中信出版社', 39, 0, 12, '<p>心灵鸡汤</p>', 2, '2019-06-29 21:53:28', '2019-07-03 23:15:13');
INSERT INTO `t_book_info` VALUES (19, '9787302511813', 'JAVA编程思想', 'Bruce Eckel', '机械工业出版社', 108, 0, 9, '<p>Java编程思想</p>', 3, '2019-06-29 22:03:34', '2019-06-29 22:30:00');

-- ----------------------------
-- Table structure for t_book_type
-- ----------------------------
DROP TABLE IF EXISTS `t_book_type`;
CREATE TABLE `t_book_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书类型id',
  `type_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书类型名称',
  `type_parent_id` int(11) NULL DEFAULT NULL COMMENT '类型父级id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `type_note` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book_type
-- ----------------------------
INSERT INTO `t_book_type` VALUES (1, '所有分类', NULL, '2019-06-29 10:20:55', NULL, '所有分类');
INSERT INTO `t_book_type` VALUES (2, '小说', 1, '2019-06-29 10:20:58', NULL, '小说');
INSERT INTO `t_book_type` VALUES (3, '科幻小说', 2, '2019-06-29 10:21:00', NULL, '科幻小说');
INSERT INTO `t_book_type` VALUES (4, '玄幻小说', 2, '2019-06-29 10:21:04', NULL, '玄幻小说');
INSERT INTO `t_book_type` VALUES (5, '军事', 1, '2019-06-29 10:21:08', NULL, '军事书籍');
INSERT INTO `t_book_type` VALUES (6, '政治', 1, '2019-06-29 10:21:11', NULL, '政治书籍');
INSERT INTO `t_book_type` VALUES (7, '经济', 1, '2019-06-29 10:21:13', NULL, '经济书籍');
INSERT INTO `t_book_type` VALUES (8, '文化、科学', 1, '2019-06-29 10:21:17', NULL, '文化科学');
INSERT INTO `t_book_type` VALUES (9, '语言、文字', 1, '2019-06-29 10:21:21', NULL, '语言书籍');
INSERT INTO `t_book_type` VALUES (10, '文学', 1, '2019-06-29 10:21:24', NULL, '文学书籍');
INSERT INTO `t_book_type` VALUES (11, '艺术', 1, '2019-06-29 10:21:27', NULL, '艺术书籍');
INSERT INTO `t_book_type` VALUES (12, '哲学', 1, '2019-06-29 10:21:30', NULL, '哲学书籍');
INSERT INTO `t_book_type` VALUES (13, '社会科学', 1, '2019-06-29 10:21:32', NULL, '社会科学');
INSERT INTO `t_book_type` VALUES (14, '历史', 1, '2019-06-29 10:21:35', NULL, '历史书籍');
INSERT INTO `t_book_type` VALUES (15, '地理', 1, '2019-06-29 10:21:39', NULL, '地理书籍');
INSERT INTO `t_book_type` VALUES (16, '自然科学', 1, '2019-06-29 10:21:42', NULL, '自然科学书籍');
INSERT INTO `t_book_type` VALUES (17, '医药', 1, '2019-06-29 10:21:44', NULL, '医药书籍');
INSERT INTO `t_book_type` VALUES (18, '卫生', 1, '2019-06-29 10:21:48', NULL, '卫生书籍');
INSERT INTO `t_book_type` VALUES (19, '法律', 1, '2019-06-29 10:21:49', NULL, '法律书籍');
INSERT INTO `t_book_type` VALUES (20, '数学', 1, '2019-06-29 10:21:53', NULL, '数学书籍');
INSERT INTO `t_book_type` VALUES (21, '语文', 1, '2019-06-29 10:21:56', NULL, '语文书籍');
INSERT INTO `t_book_type` VALUES (22, '农业', 1, '2019-06-29 10:21:59', NULL, '农业书籍');
INSERT INTO `t_book_type` VALUES (23, '建筑', 1, '2019-06-29 10:22:03', NULL, '建筑书籍');
INSERT INTO `t_book_type` VALUES (24, '交通运输', 1, '2019-06-29 10:22:05', NULL, '交通运输书籍');
INSERT INTO `t_book_type` VALUES (25, '航空、航天', 1, '2019-06-29 10:22:08', NULL, '航空航天书籍');
INSERT INTO `t_book_type` VALUES (26, '环境科学', 1, '2019-06-29 10:22:10', NULL, '环境科学');
INSERT INTO `t_book_type` VALUES (27, '工业科学', 1, '2019-06-29 10:22:13', NULL, '工业科学');
INSERT INTO `t_book_type` VALUES (28, '体育', 1, '2019-06-29 10:22:16', NULL, '体育书籍');
INSERT INTO `t_book_type` VALUES (29, '生物科学', 1, '2019-06-29 10:22:19', NULL, '生物科学');
INSERT INTO `t_book_type` VALUES (30, '物理科学', 1, '2019-06-29 10:22:23', NULL, '生物科学');
INSERT INTO `t_book_type` VALUES (31, '化学', 1, '2019-06-29 10:22:25', NULL, '化学');
INSERT INTO `t_book_type` VALUES (32, '影视', 1, '2019-06-29 10:22:28', NULL, '影视');
INSERT INTO `t_book_type` VALUES (33, '传说', 1, NULL, NULL, '');

-- ----------------------------
-- Table structure for t_lend_back
-- ----------------------------
DROP TABLE IF EXISTS `t_lend_back`;
CREATE TABLE `t_lend_back`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '借出归还id',
  `book_id` int(11) NULL DEFAULT NULL COMMENT '图书id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `lend_date` date NULL DEFAULT NULL COMMENT '借出日期',
  `should_lend_days` int(11) NULL DEFAULT NULL COMMENT '应借天数',
  `should_return_date` date NULL DEFAULT NULL COMMENT '应归还日期',
  `return_date` date NULL DEFAULT NULL COMMENT '归还日期',
  `is_damage` int(11) NULL DEFAULT NULL COMMENT '是否损毁：\r\n              0-未损毁\r\n              1-已损毁',
  `damage_degree` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '损毁等级：\r\n            0-未损毁\r\n            1-轻微损毁\r\n            2-中度损毁\r\n            3-严重损毁',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_lend_back
-- ----------------------------
INSERT INTO `t_lend_back` VALUES (1, 17, 155479343253180, '2019-07-02', 20, '2019-07-22', '2019-07-03', 0, '', '');
INSERT INTO `t_lend_back` VALUES (2, 16, 155479496654441, '2019-07-03', 30, '2019-08-02', '2019-07-03', 1, '严重损毁', '损毁严重需要赔款');
INSERT INTO `t_lend_back` VALUES (3, 17, 155479343250980, '2019-07-03', 30, '2019-08-02', '2019-07-03', 0, NULL, NULL);
INSERT INTO `t_lend_back` VALUES (4, 1, 155479343250980, '2019-07-03', 10, '2019-07-13', '2019-07-14', 0, '', '');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `permission_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `permission_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源对应url',
  `permission_parent_id` int(11) NULL DEFAULT NULL COMMENT '资源父级id',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源图标',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, '系统菜单', NULL, NULL, 'fa fa-desktop', '2019-03-26 00:00:00', '2019-03-26 00:00:00');
INSERT INTO `t_permission` VALUES (2, '系统管理', '', 1, 'fa fa-cog', '2019-03-26 00:00:00', '2019-03-26 00:00:00');
INSERT INTO `t_permission` VALUES (3, '用户管理', '/admin/user', 2, 'fa fa-user', '2019-03-26 00:00:00', '2019-03-26 00:00:00');
INSERT INTO `t_permission` VALUES (4, '角色管理', '/admin/role', 2, 'fa fa-list', '2019-03-28 00:00:00', '2019-03-28 00:00:00');
INSERT INTO `t_permission` VALUES (5, '图书管理', NULL, 1, 'fa fa-book', '2019-04-09 00:00:00', '2019-04-09 00:00:00');
INSERT INTO `t_permission` VALUES (6, '图书分类管理', '/admin/booktype', 5, 'fa fa-file-text', '2019-04-09 15:50:00', '2019-04-09 15:50:00');
INSERT INTO `t_permission` VALUES (7, '应用管理', '/admin/permission', 2, 'fa fa-tasks', '2019-04-10 18:37:00', '2019-04-10 18:37:00');
INSERT INTO `t_permission` VALUES (9, '图书信息管理', '/admin/bookinfo', 5, 'fa fa-book', '2019-04-15 00:00:00', '2019-04-15 00:00:00');
INSERT INTO `t_permission` VALUES (10, '借书管理', '/admin/booklend', 5, 'fa fa-edit', '2019-04-17 00:00:00', '2019-04-17 00:00:00');
INSERT INTO `t_permission` VALUES (11, '还书管理', '/admin/bookreturn', 5, 'fa fa-pencil', '2019-04-18 00:00:00', '2019-04-18 00:00:00');
INSERT INTO `t_permission` VALUES (12, '借阅者', NULL, 1, 'fa fa-user', '2019-04-19 00:00:00', '2019-04-19 00:00:00');
INSERT INTO `t_permission` VALUES (13, '图书检索', '/admin/booksearch', 12, 'fa fa-book', '2019-04-19 00:00:00', '2019-04-19 00:00:00');
INSERT INTO `t_permission` VALUES (14, '借还记录', '/admin/lendrecord', 12, 'fa fa-file-text-o', '2019-04-19 00:00:00', '2019-04-19 00:00:00');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '系统管理员', '2019-03-28 00:00:00', '2019-03-28 00:00:00');
INSERT INTO `t_role` VALUES (2, '借阅者', '2019-03-28 20:31:02', '2019-03-28 20:33:17');
INSERT INTO `t_role` VALUES (4, '图书管理员', '2019-03-29 16:03:45', '2019-03-29 19:13:34');
INSERT INTO `t_role` VALUES (5, '馆长', '2019-03-29 16:03:52', '2019-04-10 14:50:20');
INSERT INTO `t_role` VALUES (7, '全部权限', '2019-06-27 21:29:18', '2019-06-28 15:05:26');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) NULL DEFAULT NULL COMMENT '资源id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (2, 1);
INSERT INTO `t_role_permission` VALUES (2, 12);
INSERT INTO `t_role_permission` VALUES (2, 13);
INSERT INTO `t_role_permission` VALUES (2, 14);
INSERT INTO `t_role_permission` VALUES (1, 1);
INSERT INTO `t_role_permission` VALUES (1, 2);
INSERT INTO `t_role_permission` VALUES (1, 3);
INSERT INTO `t_role_permission` VALUES (1, 4);
INSERT INTO `t_role_permission` VALUES (1, 7);
INSERT INTO `t_role_permission` VALUES (4, 1);
INSERT INTO `t_role_permission` VALUES (4, 5);
INSERT INTO `t_role_permission` VALUES (4, 6);
INSERT INTO `t_role_permission` VALUES (4, 9);
INSERT INTO `t_role_permission` VALUES (4, 10);
INSERT INTO `t_role_permission` VALUES (4, 11);
INSERT INTO `t_role_permission` VALUES (7, 1);
INSERT INTO `t_role_permission` VALUES (7, 2);
INSERT INTO `t_role_permission` VALUES (7, 3);
INSERT INTO `t_role_permission` VALUES (7, 4);
INSERT INTO `t_role_permission` VALUES (7, 7);
INSERT INTO `t_role_permission` VALUES (7, 5);
INSERT INTO `t_role_permission` VALUES (7, 6);
INSERT INTO `t_role_permission` VALUES (7, 9);
INSERT INTO `t_role_permission` VALUES (7, 10);
INSERT INTO `t_role_permission` VALUES (7, 11);
INSERT INTO `t_role_permission` VALUES (7, 12);
INSERT INTO `t_role_permission` VALUES (7, 13);
INSERT INTO `t_role_permission` VALUES (7, 14);

-- ----------------------------
-- Table structure for t_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user`  (
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_user
-- ----------------------------
INSERT INTO `t_role_user` VALUES (155479343253180, 2);
INSERT INTO `t_role_user` VALUES (155479496654441, 2);
INSERT INTO `t_role_user` VALUES (156099892114370, 4);
INSERT INTO `t_role_user` VALUES (155479343250980, 1);
INSERT INTO `t_role_user` VALUES (155479343250980, 2);
INSERT INTO `t_role_user` VALUES (155479343250980, 4);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `real_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户Email',
  `user_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `state` int(2) NULL DEFAULT NULL COMMENT '用户状态：0-启用;1-禁用;2-删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (155479343250980, 'admin', 'ba3873f74a5b46a4f93816721dad7345', '超级管理员', '1176239106@qq.com', '13515107277', 1, '2019-06-03 11:10:58', '2019-06-12 15:56:22');
INSERT INTO `t_user` VALUES (155479343253180, 'wangwu', 'ba3873f74a5b46a4f93816721dad7345', '王五', '1571428@qq.com', '17600291890', 1, '2019-06-03 11:13:22', '2019-06-03 11:13:26');
INSERT INTO `t_user` VALUES (155479496654441, 'kuli', 'ba3873f74a5b46a4f93816721dad7345', '库里', '157142823@163.com', '13245671234', 1, '2019-06-03 11:13:58', '2019-06-19 21:56:35');
INSERT INTO `t_user` VALUES (156099892114370, 'zhanmusi', 'ba3873f74a5b46a4f93816721dad7345', '詹姆斯', '1425@qq.com', '13823145621', 1, '2019-06-20 10:48:43', '2019-06-28 15:11:26');

SET FOREIGN_KEY_CHECKS = 1;
