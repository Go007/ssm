package com.hong.ssm.mapper;

import com.hong.ssm.domain.YyBondYield;
import com.hong.ssm.domain.YyIssuerInfo;
import org.springframework.stereotype.Repository;

/**
 * @author wanghong
 * @date 2019/10/30 18:02
 **/
@Repository
public interface DbMapper {
    int insertYyBondYield(YyBondYield yyBondYield);
    YyBondYield findOne();

    int insertYyIssuerInfo(YyIssuerInfo yyIssuerInfo);
    YyIssuerInfo findByIssuerID(String issuerID);
}
