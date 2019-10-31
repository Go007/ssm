package com.hong.ssm.controller;

import com.hong.ssm.domain.YyBondYield;
import com.hong.ssm.service.DbService;
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

}
