CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL COMMENT '计划名称',
  `content` varchar(2024) NOT NULL COMMENT '计划描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `begin_time` varchar(128) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(128) DEFAULT NULL COMMENT '完成时间',
  `money` int(11) DEFAULT '0' COMMENT '计划钱数',
  `status` tinyint(4) DEFAULT '0' COMMENT '0-未开始、1-已经开始、2-完成',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父节点，如果为0那么为根级任务',
  `user_name` tinyint(4) DEFAULT '1' COMMENT '1-晓满，2-大傻',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8