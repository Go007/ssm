package com.hong.ssm.schedule;

import com.alibaba.fastjson.JSON;
import com.hong.ssm.domain.YyBondYield;
import com.hong.ssm.mapper.DbMapper;
import com.hong.ssm.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghong
 * @date 2019/11/04 17:31
 *  YY增量数据同步任务
 **/
@Component
public class YyDataSyncTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String YY_BOND_YIELD_COMPANY = "https://api.ratingdog.cn/v1/YYBondYieldCompany";

    public static final String TOKEN = "E8B04A5106B0A0D495824625E8D14736";

    @Autowired
    private DbMapper dbMapper;

   @Scheduled(cron = "0 0 23 * * ?")
    //@Scheduled(fixedRate = 3000)
    public void yYBondYieldCompanySync(){
        logger.info("YyDataSyncTask.yYBondYieldCompanySync()开始同步数据");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", TOKEN);
        Map<String, Object> result = RequestUtil.doGet(YY_BOND_YIELD_COMPANY,paramMap);
        Object obj = result.get("rows");
        List<YyBondYield> list = JSON.parseArray(JSON.toJSONString(obj), YyBondYield.class);
        for (YyBondYield yyBondYield : list) {
            dbMapper.insertYyBondYield(yyBondYield);
        }
        logger.info("YyDataSyncTask.yYBondYieldCompanySync()结束同步数据");
    }

}
