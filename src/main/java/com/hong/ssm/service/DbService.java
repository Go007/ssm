package com.hong.ssm.service;

import com.alibaba.fastjson.JSON;
import com.hong.ssm.config.Restful;
import com.hong.ssm.domain.YyBondYield;
import com.hong.ssm.mapper.DbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public static final String TOKEN = "E8B04A5106B0A0D495824625E8D14736";

    public void flushYyBondYield(){
        String url = "https://api.ratingdog.cn/v1/YYBondYieldHistoricalCompany?token=E8B04A5106B0A0D495824625E8D14736&page=1&datetime=2019-10-29";
        Map<String, Object> result = new Restful().getForObject(url, Map.class);
        Object obj = result.get("rows");
        List<YyBondYield> list = JSON.parseArray(JSON.toJSONString(obj), YyBondYield.class);

       // JSONArray data = JSON.parseArray(JSON.toJSONString(obj));
      //  Iterator<Object> it = data.iterator();
       /* while (it.hasNext()){
            JSONObject o = (JSONObject) it.next();
            String assessDate = o.getString("AssessDate");
        }*/

       for (YyBondYield yyBondYield:list){
           dbMapper.insertYyBondYield(yyBondYield);
       }

    }

    public YyBondYield getYyBondYield() {
        return dbMapper.findOne();
    }
}
