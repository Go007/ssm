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
CREATE TABLE `yy_bond_yield` (
  `sid` int(16) NOT NULL AUTO_INCREMENT,
  `bondCode` varchar(200) DEFAULT NULL COMMENT '债券代码',
  `shortName` varchar(200) DEFAULT NULL COMMENT '债券简称',
  `fullName` varchar(200) DEFAULT NULL COMMENT '债券全称',
  `bondType` varchar(200) DEFAULT NULL COMMENT '债券类型',
  `issueMethod` varchar(200) DEFAULT NULL COMMENT '发行方式',
  `issuerName` varchar(200) DEFAULT NULL COMMENT '发行人',
  `customType` varchar(200) DEFAULT NULL COMMENT '债券类型',
  `residualMaturity` varchar(200) DEFAULT NULL COMMENT '剩余期限',
  `bondYield` decimal(20,4) DEFAULT NULL COMMENT '估值',
  `defaultRate` decimal(20,4) DEFAULT NULL COMMENT '违约率',
  `assessDate` varchar(50) DEFAULT NULL COMMENT '估算日期',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`sid`) USING BTREE,
  KEY `i1` (`issuerName`) USING BTREE,
  KEY `i2` (`bondCode`)
) ENGINE=InnoDB AUTO_INCREMENT=2169311 DEFAULT CHARSET=utf8 COMMENT='YY债券估值';

ALTER TABLE yy_bond_yield ADD INDEX index_issuerName(issuerName);

CREATE TABLE `csci_base_project` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `mbody_level` varchar(20) DEFAULT NULL COMMENT '主体评级',
  `rating_date` date DEFAULT NULL COMMENT '评级时间',
  `rating_agency` varchar(50) DEFAULT NULL COMMENT '评级机构',
  `project_code` varchar(30) DEFAULT NULL COMMENT '项目编号',
  `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `type_id` bigint(20) DEFAULT NULL COMMENT '项目类型ID',
  `type_name` varchar(50) DEFAULT NULL COMMENT '项目类型名称',
  `ptype_id` bigint(20) DEFAULT NULL COMMENT '产品类型ID',
  `ptype_name` varchar(50) DEFAULT NULL COMMENT '产品类型名称',
  `cstage_ids` varchar(50) DEFAULT NULL COMMENT '当前阶段ID',
  `cstage_names` varchar(50) DEFAULT NULL COMMENT '当前阶段名称',
  `channel_id` bigint(20) DEFAULT NULL COMMENT '渠道ID',
  `channel_name` varchar(50) DEFAULT NULL COMMENT '渠道名称',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  `dept_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `cont_names` varchar(255) DEFAULT NULL COMMENT '承揽人姓名',
  `chief` bigint(20) DEFAULT NULL COMMENT '负责人',
  `member_names` varchar(255) DEFAULT NULL COMMENT '项目成员，用逗号分割的人员姓名',
  `status` varchar(20) NOT NULL COMMENT '状态，参照com.linkstec.ib.project.constant.ProjectStatus',
  `asso_type` tinyint(4) DEFAULT NULL COMMENT '联动类型（0：无，1：主动，2：被动）',
  `proj_set_time` datetime DEFAULT NULL COMMENT '立项时间',
  `passed_time` datetime DEFAULT NULL COMMENT '过会时间',
  `passed_type` bigint(20) DEFAULT NULL COMMENT '过会金额类型(1、仅增信，2、仅投资，3、增信&投资)',
  `check_amount` decimal(17,4) DEFAULT NULL COMMENT '审批过会金额',
  `passed_amount` decimal(17,4) DEFAULT NULL COMMENT '有效过会金额',
  `archive_time` datetime DEFAULT NULL COMMENT '归档时间',
  `pins_id` bigint(20) DEFAULT NULL COMMENT '流程实例ID',
  `proj_desc` varchar(5000) DEFAULT NULL COMMENT '项目描述',
  `is_normal` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否正常（0：否，1：是）',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `rec_gen_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT '1' COMMENT '更新人',
  `rec_upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `proTypeId` bigint(20) DEFAULT NULL COMMENT '项目一级分类(详情见数据字典：proTypeId)',
  `sonProTypeId` bigint(20) DEFAULT NULL COMMENT '项目二级分类(详情见数据字典)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础项目'

#主体信用评估表
CREATE TABLE `csciapi_chengtou_company_rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` decimal(16,0) DEFAULT NULL COMMENT '发行主体ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '发行主体名称',
  `region` decimal(38,0) DEFAULT NULL COMMENT '地区编号',
  `category` varchar(100) DEFAULT NULL COMMENT 'YY类型',
  `yy_rating` varchar(16) DEFAULT NULL COMMENT 'YY评级',
  `yy_rating_dt` datetime DEFAULT NULL COMMENT 'YY评级日期',
  `yy_province_rank` varchar(16) DEFAULT NULL COMMENT 'YY同省排名',
  `yy_province_percent` decimal(10,2) DEFAULT NULL COMMENT 'YY同省百分位',
  `yy_white_rank` varchar(16) DEFAULT NULL COMMENT 'YY白名单排名',
  `yy_white_percent` decimal(10,2) DEFAULT NULL COMMENT 'YY白名单百分位',
  `yy_out_rank` varchar(16) DEFAULT NULL COMMENT 'YY外部排名',
  `yy_out_percent` decimal(10,2) DEFAULT NULL COMMENT 'YY外部百分位',
  `yy_country_rank` varchar(16) DEFAULT NULL COMMENT 'YY全国排名',
  `yy_country_percent` decimal(10,2) DEFAULT NULL COMMENT 'YY全国百分位',
  `cscs_rating` varchar(16) DEFAULT NULL COMMENT 'cscs评级',
  `cscs_rating_dt` datetime DEFAULT NULL COMMENT 'cscs评级日期',
  `cscs_province_rank` varchar(16) DEFAULT NULL COMMENT 'cscs同省排名',
  `cscs_province_percent` decimal(10,2) DEFAULT NULL COMMENT 'cscs同省百分位',
  `cscs_white_rank` varchar(16) DEFAULT NULL COMMENT 'cscs白名单排名',
  `cscs_white_percent` decimal(10,2) DEFAULT NULL COMMENT 'cscs白名单百分位',
  `cscs_out_rank` varchar(16) DEFAULT NULL COMMENT 'cscs外部排名',
  `cscs_out_percent` decimal(10,2) DEFAULT NULL COMMENT 'cscs外部百分位',
  `cscs_country_rank` varchar(16) DEFAULT NULL COMMENT 'cscs全国排名',
  `cscs_country_percent` decimal(10,2) DEFAULT NULL COMMENT 'cscs全国百分位',
  `out_rating` varchar(16) DEFAULT NULL COMMENT '外部评级',
  `out_rating_dt` datetime DEFAULT NULL COMMENT '外部评级日期',
  `out_province_rank` varchar(16) DEFAULT NULL COMMENT '外部同省排名',
  `out_province_percent` decimal(10,2) DEFAULT NULL COMMENT '外部同省百分位',
  `out_white_rank` varchar(16) DEFAULT NULL COMMENT '外部白名单排名',
  `out_white_percent` decimal(10,2) DEFAULT NULL COMMENT '外部白名单百分位',
  `out_country_rank` varchar(16) DEFAULT NULL COMMENT '外部全国排名',
  `out_country_percent` decimal(10,2) DEFAULT NULL COMMENT '外部全国百分位',
  `dm_rating` decimal(8,2) DEFAULT NULL COMMENT 'DM评分',
  `dm_rating_dt` datetime DEFAULT NULL COMMENT 'DM评分日期',
  `dm_province_rank` varchar(16) DEFAULT NULL COMMENT 'dm同省排名',
  `dm_province_percent` decimal(10,2) DEFAULT NULL COMMENT 'dm同省百分位',
  `dm_white_rank` varchar(16) DEFAULT NULL COMMENT 'dm白名单排名',
  `dm_white_percent` decimal(10,2) DEFAULT NULL COMMENT 'dm白名单百分位',
  `dm_out_rank` varchar(16) DEFAULT NULL COMMENT 'dm外部排名',
  `dm_out_percent` decimal(10,2) DEFAULT NULL COMMENT 'dm外部百分位',
  `dm_country_rank` varchar(16) DEFAULT NULL COMMENT 'dm全国排名',
  `dm_country_percent` decimal(10,2) DEFAULT NULL COMMENT 'dm全国百分位',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i1` (`company_id`),
  KEY `i2` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8192 DEFAULT CHARSET=utf8 COMMENT='主体信用评估';

CREATE TABLE `csciapi_chengtou_china_bond_info` (
  `sid` int(16) NOT NULL AUTO_INCREMENT,
  `bond_code` varchar(20) DEFAULT NULL COMMENT '债券代码',
  `bond_name` varchar(200) DEFAULT NULL COMMENT '债券简称',
  `net_price` decimal(20,4) DEFAULT NULL COMMENT '估值净价（元）',
  `yield_rate` decimal(20,4) DEFAULT NULL COMMENT '估值收益率(%)',
  `assess_date` datetime DEFAULT NULL COMMENT '估值日期',
  `implied_rating` varchar(20) DEFAULT NULL COMMENT '隐含评级',
  `rating_date` datetime DEFAULT NULL COMMENT '评级日期',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`sid`) USING BTREE,
  KEY `i1` (`bond_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=131071 DEFAULT CHARSET=utf8 COMMENT='中债估值级评级';


# 近期公开债券发行产品信息
SELECT
d.sid,
d.`bondCode`,
d.`shortName`,
d.`residualMaturity`,
d.`bondYield`,
d.`defaultRate`,
b.`implied_rating`,
b.`net_price`,
b.`yield_rate`,
d.`assessDate`,
b.`assess_date`
FROM
(SELECT a.* FROM yy_bond_yield a,
(SELECT shortName,MAX(update_date) max_date FROM yy_bond_yield GROUP BY shortName) c
WHERE a.`shortName`=c.shortName AND a.`update_date`=c.max_date
AND a.`issuerName`='重庆九龙园高新产业集团有限公司') d
LEFT JOIN csciapi_chengtou_china_bond_info b
ON d.bondCode=CONCAT(b.bond_code,".IB")
ORDER BY d.`assessDate` DESC,d.`shortName` DESC
LIMIT 0,5;

SELECT
a.sid,
a.bondCode,
a.shortName,
a.residualMaturity,
a.bondYield,
a.defaultRate,
c.implied_rating,
c.net_price,
c.yield_rate,
a.assessDate,
c.assess_date
FROM yy_bond_yield a
LEFT JOIN (SELECT bondCode,MAX(update_date) max_date FROM yy_bond_yield WHERE issuerName='重庆九龙园高新产业集团有限公司' GROUP BY shortName)b
ON a.bondCode=b.bondCode AND a.update_date=b.max_date
LEFT JOIN (SELECT bond_code,MAX(implied_rating) implied_rating,MAX(net_price) net_price,MAX(yield_rate) yield_rate,MAX(assess_date) assess_date
FROM csciapi_chengtou_china_bond_info GROUP BY 1) c
ON CAST(SUBSTRING_INDEX(b.bondCode,'.',1) AS DECIMAL)=CAST(c.bond_code AS DECIMAL)
WHERE b.bondCode<>''
LIMIT 0,5;

UPDATE csci_base_customer c,(
SELECT b.`company_id` AS company_id,b.`company_name_new` AS company_name FROM csci_base_customer a
LEFT JOIN csci_chengtou_customer_list b
ON a.`id`=b.`customer_id`
WHERE b.`company_id` IS NOT NULL
) d SET c.company_id=d.company_id,c.customer_name=d.company_name;

insert into csci_project_area(project_id,project_code,idno6)
select a.id,a.`project_code`,c.`idno6` from csci_base_project a
left join csci_base_customer b
ON b.`id`=a.`customer_id`
left join csci_chengtou_customer_list c
on c.`customer_id`=b.`id`
where c.`idno6` is not null;
