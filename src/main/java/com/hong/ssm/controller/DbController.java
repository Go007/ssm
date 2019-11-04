package com.hong.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.hong.ssm.domain.CtExtendInfo;
import com.hong.ssm.domain.CyExtendInfo;
import com.hong.ssm.domain.YyBondYield;
import com.hong.ssm.domain.YyIssuerInfo;
import com.hong.ssm.service.DbService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghong
 * @date 2019/10/30 17:54
 **/
@RestController
@RequestMapping(value = "/db")
public class DbController {

    @Autowired
    private DbService dbService;

    @RequestMapping(value = "/flush", produces = { "application/json;charset=UTF-8" })
    public String flush( )  {
        dbService.flushYyBondYield();
        return "success";
    }

    @RequestMapping(value = "/find", produces = { "application/json;charset=UTF-8" })
    public YyBondYield find( )  {
        YyBondYield yyBondYield = dbService.getYyBondYield();
        return yyBondYield;
    }

    @RequestMapping(value = "/flushIssuer", produces = { "application/json;charset=UTF-8" })
    public String flushIssuer( )  {
        dbService.flushYyIssuerInfo();
        return "success";
    }

    @RequestMapping(value = "/findIssuer", produces = { "application/json;charset=UTF-8" })
    public YyIssuerInfo findIssuer(){
        YyIssuerInfo yyIssuerInfo = dbService.getIssuerById("4f64690cef154ad1bfec15c928926486");
        if (yyIssuerInfo != null){
            if (StringUtils.isNotEmpty(yyIssuerInfo.getCtExtendInfoStr())){
                yyIssuerInfo.setCtExtendInfo(JSON.parseObject(yyIssuerInfo.getCtExtendInfoStr(), CtExtendInfo.class));
            }
            if (StringUtils.isNotEmpty(yyIssuerInfo.getCyExtendInfoStr())){
                yyIssuerInfo.setCyExtendInfo(JSON.parseObject(yyIssuerInfo.getCyExtendInfoStr(), CyExtendInfo.class));
            }
        }
        return yyIssuerInfo;
    }
}
