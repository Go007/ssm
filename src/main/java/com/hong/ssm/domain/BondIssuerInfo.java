package com.hong.ssm.domain;

import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * @author wanghong
 * @date 2019/11/06 14:52
 *  债券发行产品信息
 **/
public class BondIssuerInfo {

    @ExcelProperty(value = {"债券基本信息","债券代码"},index = 0)
    private String bondCode;

    @ExcelProperty(value = {"债券基本信息","债券简称"},index = 1)
    private String shortName;

    @ExcelProperty(value = {"债券基本信息","剩余期限(年)"},index = 2)
    private String residualMaturity;

    @ExcelProperty(value = {"YY数据(2019-11-05更新)","YY估值"},index = 3)
    private BigDecimal bondYield;

    @ExcelProperty(value = {"YY数据(2019-11-05更新)","YY违约率"},index = 4)
    private BigDecimal defaultRate;

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getResidualMaturity() {
        return residualMaturity;
    }

    public void setResidualMaturity(String residualMaturity) {
        this.residualMaturity = residualMaturity;
    }

    public BigDecimal getBondYield() {
        return bondYield;
    }

    public void setBondYield(BigDecimal bondYield) {
        this.bondYield = bondYield;
    }

    public BigDecimal getDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(BigDecimal defaultRate) {
        this.defaultRate = defaultRate;
    }
}
