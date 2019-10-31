CREATE TABLE `yy_issuer_info` (
  `sid` int(16) NOT NULL AUTO_INCREMENT,
  `issuerID` varchar(200) DEFAULT NULL COMMENT '发行人ID',
  `issuerName` varchar(200) DEFAULT NULL COMMENT '发行人名称',
  `registerCode` varchar(200) DEFAULT NULL COMMENT '统一社会信用代码',
  `issuerType` varchar(200) DEFAULT NULL COMMENT '发行人类型',
  `yYRating` varchar(200) DEFAULT NULL COMMENT 'YY等级',
  `intrinsicRating` varchar(200) DEFAULT NULL COMMENT '隐含评级',
  `corporateRating` varchar(200) DEFAULT NULL COMMENT '外部评级及展望',
  `ratingAgency` varchar(200) DEFAULT NULL COMMENT '评级公司',
  `holder` varchar(200) DEFAULT NULL COMMENT '大股东及持股比例',
  `nature` varchar(200) DEFAULT NULL COMMENT '企业性质',
  `listed` varchar(200) DEFAULT NULL COMMENT '是否上市',
  `creditAnalysis` text COMMENT '信用分析',
  `ctExtendInfo` varchar(200) DEFAULT NULL COMMENT '城投扩展信息',
  `cyExtendInfo` text COMMENT '产业扩展信息',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='YY主体信息'

# YY估值表
CREATE TABLE yy_bond_yield (
sid INT(16) NOT NULL AUTO_INCREMENT,
bondCode VARCHAR(200) DEFAULT NULL COMMENT '债券代码',
shortName VARCHAR(200) DEFAULT NULL COMMENT '债券简称',
fullName VARCHAR(200) DEFAULT NULL COMMENT '债券全称',
bondType VARCHAR(200) DEFAULT NULL COMMENT '债券类型',
issueMethod VARCHAR(200) DEFAULT NULL COMMENT '发行方式',
issuerName VARCHAR(200) DEFAULT NULL COMMENT '发行人',
customType VARCHAR(200) DEFAULT NULL COMMENT '债券类型',
residualMaturity VARCHAR(200) DEFAULT NULL COMMENT '剩余期限',
bondYield DECIMAL(20,4) DEFAULT NULL COMMENT '估值',
defaultRate DECIMAL(20,4) DEFAULT NULL COMMENT '违约率',
assessDate VARCHAR(50) DEFAULT NULL COMMENT '估算日期',
update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (SID) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='YY债券估值';