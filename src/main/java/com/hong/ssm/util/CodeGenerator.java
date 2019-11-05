package com.hong.ssm.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * MyBatis自动代码生成
 */
public class CodeGenerator {

	public static void main(String[] args) {
		System.out.println("======================start======================");
		Properties props = System.getProperties(); // 系统属性
		// 本机
		String author = props.getProperty("user.name");
		// 自定义包路径
		String parentPackageName = "com.hong.ssm";
		String entityChildPackageName = "domain";
		String servicePackageName = "";
		String mapperPackageName = "";
		// 设置需要生成的表名
		// 这里如果是MySql表,且没有设置不区分大小写,则表名在数据库中是小写就是小写,否则会报找不到表的错误
		String[] tableNames = new String[] { "csci_base_project"};

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert());
		dsc.setDriverName("com.mysql.jdbc.Driver");
		
		dsc.setUrl("jdbc:mysql://172.16.79.5:3306/zzxypm?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
		dsc.setUsername("root");
		dsc.setPassword("csxmgl2012");
		mapperPackageName = "mapper";
		servicePackageName = "service";

		// 代码生成
		generator(dsc, author, parentPackageName, servicePackageName,
				entityChildPackageName, mapperPackageName, tableNames);
	}

	/**
	 * @title： mybatis_plus代码生成器
	 */
	public static void generator(DataSourceConfig dsc, String author, String parentPackageName,
                                 String servicePackageName, String entityChildPackageName, String mapperPackageName, String[] tableNames) {
		AutoGenerator mpg = new AutoGenerator();
		// 项目绝对路径
		String PROJECT_DIR = System.getProperty("user.dir");
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(PROJECT_DIR + "/src/main/java");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);// 开启 activeRecord 模式
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor(author);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// 此处可以修改为您的表前缀
		// strategy.setTablePrefix(new String[] { "bmd_", "mp_" });
		// 表名生成策略
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setRestControllerStyle(true);
		// 字段名生成策略 生成全部表的话把这段禁用
		strategy.setInclude(tableNames);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		// 自定义包路径
		pc.setParent(parentPackageName);
		// 这里是控制器包名，默认 web
		pc.setController(null);
		pc.setEntity(entityChildPackageName);
		pc.setMapper(mapperPackageName);
		pc.setService(servicePackageName);
		pc.setServiceImpl(servicePackageName + ".impl");

		// 关闭默认 xml 生成，调整生成 至 根目录
		TemplateConfig tc = new TemplateConfig();
		tc.setXml(null);
		mpg.setTemplate(tc);

		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<>();
				this.setMap(map);
			}
		};
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				String mapperPath = PROJECT_DIR + "/src/main/resources/mapper/" + tableInfo.getEntityName()
						+ "Mapper.xml";
				return mapperPath;
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
		mpg.setPackageInfo(pc);

		// 执行生成
		mpg.execute();
		System.out.println("======================end======================");
	}
}