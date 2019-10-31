package com.hong.ssm.service;

import com.alibaba.fastjson.JSON;
import com.hong.ssm.domain.YyBondYield;
import com.hong.ssm.domain.YyIssuerInfo;
import com.hong.ssm.mapper.DbMapper;
import com.hong.ssm.util.DateUtil;
import com.hong.ssm.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghong
 * @date 2019/10/30 18:27
 **/
@Service
public class DbService {

    @Autowired
    private DbMapper dbMapper;

    // YY估值（历史数据）, 参数token、page、datetime
    public static final String YY_BOND_YIELD_HISTORICAL_COMPANY = "https://api.ratingdog.cn/v1/YYBondYieldHistoricalCompany";

    public static final String GET_ISSUERS_LIST_COMPANY = "https://api.ratingdog.cn/v1/GetIssuersListCompany";

    public static final String TOKEN = "E8B04A5106B0A0D495824625E8D14736";

    public void flushYyBondYield() {
        long days = 6 * 30;
        long count = 1;
        while (count <= days) {
            String dateTime = DateUtil.getMinusDays(count);
            int total = writeToYyBondYield(1,dateTime);
            if (total > 0) {
                int pageCount = total % 1000 == 0 ? total / 1000 : total / 1000 + 1;
                if (pageCount > 1){
                    int page = 2;
                    while (page <= pageCount){
                        writeToYyBondYield(page,dateTime);
                        page++;
                    }
                }
            }
            count++;
        }
        // JSONArray data = JSON.parseArray(JSON.toJSONString(obj));
        // Iterator<Object> it = data.iterator();
       /* while (it.hasNext()){
            JSONObject o = (JSONObject) it.next();
            String assessDate = o.getString("AssessDate");
        }*/
    }

    public YyBondYield getYyBondYield() {
        return dbMapper.findOne();
    }

    private int writeToYyBondYield(long page,String dateTime){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", TOKEN);
        paramMap.put("page", page);
        paramMap.put("dateTime", dateTime);
        Map<String, Object> result = RequestUtil.doGet(YY_BOND_YIELD_HISTORICAL_COMPANY, paramMap);
        Object obj = result.get("rows");
        List<YyBondYield> list = JSON.parseArray(JSON.toJSONString(obj), YyBondYield.class);
        for (YyBondYield yyBondYield : list) {
            dbMapper.insertYyBondYield(yyBondYield);
        }
        return (int) result.get("total");
    }

    public void flushYyIssuerInfo() {
        int total = writeToYyIssuerInfo(1);
        if (total > 0) {
            int pageCount = total % 1000 == 0 ? total / 1000 : total / 1000 + 1;
            if (pageCount > 1){
                int page = 2;
                while (page <= pageCount){
                    writeToYyIssuerInfo(page);
                    page++;
                }
            }
        }
    }

    private int writeToYyIssuerInfo(long page){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", TOKEN);
        paramMap.put("page", page);
        Map<String, Object> result = RequestUtil.doGet(GET_ISSUERS_LIST_COMPANY, paramMap);
        Object obj = result.get("rows");
        List<YyIssuerInfo> list = JSON.parseArray(JSON.toJSONString(obj), YyIssuerInfo.class);
        for (YyIssuerInfo yyIssuerInfo : list) {
            yyIssuerInfo.setCyExtendInfoStr(JSON.toJSONString(yyIssuerInfo.getCyExtendInfo()));
            yyIssuerInfo.setCtExtendInfoStr(JSON.toJSONString(yyIssuerInfo.getCtExtendInfo()));
            dbMapper.insertYyIssuerInfo(yyIssuerInfo);
        }
        return  (int)result.get("total");
    }

    public YyIssuerInfo getIssuerById(String issuerId) {
        return dbMapper.findByIssuerID(issuerId);
    }
}

