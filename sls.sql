/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : sls

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 17/03/2019 16:18:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for table_answer
-- ----------------------------
DROP TABLE IF EXISTS `table_answer`;
CREATE TABLE `table_answer`  (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '答卷编号',
  `answer_user_id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '答题人id',
  `paper_id` int(11) NOT NULL COMMENT '试卷编号',
  `answer_score` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答卷成绩',
  PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for table_answer_detail
-- ----------------------------
DROP TABLE IF EXISTS `table_answer_detail`;
CREATE TABLE `table_answer_detail`  (
  `answer_id` int(11) NOT NULL COMMENT '试卷编号',
  `question_id` int(11) NULL DEFAULT NULL COMMENT '题目编号',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作答情况'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for table_course
-- ----------------------------
DROP TABLE IF EXISTS `table_course`;
CREATE TABLE `table_course`  (
  `course_id` int(11) NOT NULL COMMENT '科目编号',
  `course_name` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科目名称',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for table_exercise_record
-- ----------------------------
DROP TABLE IF EXISTS `table_exercise_record`;
CREATE TABLE `table_exercise_record`  (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '刷题记录编号',
  `record_user_id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '刷题人ID',
  `quertion_id` int(11) NOT NULL COMMENT '题目编号',
  `record_answer` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作答情况',
  `record_type` int(11) NULL DEFAULT NULL COMMENT '1-练习题目 2-模拟考试',
  `record_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for table_paper
-- ----------------------------
DROP TABLE IF EXISTS `table_paper`;
CREATE TABLE `table_paper`  (
  `paper_id` int(11) NOT NULL COMMENT '试卷编号',
  `paper_user_id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组卷人ID',
  `course_id` int(11) NULL DEFAULT NULL COMMENT '科目编号',
  `paper_time` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答题时间',
  PRIMARY KEY (`paper_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for table_paper_detail
-- ----------------------------
DROP TABLE IF EXISTS `table_paper_detail`;
CREATE TABLE `table_paper_detail`  (
  `paper_id` int(11) NULL DEFAULT NULL COMMENT '试卷编号',
  `question_id` int(11) NULL DEFAULT NULL COMMENT '题目编号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for table_question
-- ----------------------------
DROP TABLE IF EXISTS `table_question`;
CREATE TABLE `table_question`  (
  `question_id` int(11) NOT NULL COMMENT '题目编号',
  `question_user_id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出题人ID',
  `course_id` int(11) NULL DEFAULT NULL COMMENT '科目编号',
  `question_info` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目内容',
  `question_choice_a` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项A',
  `question_choice_b` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项B',
  `question_choice_c` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项C',
  `question_choice_d` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项D',
  `question_answer` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案',
  `question_type` int(11) NULL DEFAULT NULL COMMENT '1-单选 2-多选',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for table_user
-- ----------------------------
DROP TABLE IF EXISTS `table_user`;
CREATE TABLE `table_user`  (
  `user_id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `user_password` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_name` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_type` int(11) NULL DEFAULT NULL COMMENT '用户身份(0：学生1：老师)',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of table_user
-- ----------------------------
INSERT INTO `table_user` VALUES ('111', '111', 'T1', 1);
INSERT INTO `table_user` VALUES ('123456', '123456', 'jason', 0);

SET FOREIGN_KEY_CHECKS = 1;
