package com.hong.ssm.domain;

import java.math.BigDecimal;

/**
 * @author wanghong
 * @date 2019/10/30 19:17
 **/
public class YyBondYield {
    private String assessDate;
    private String bondCode;
    private String bondType;
    private BigDecimal bondYield;
    private String customType;
    private BigDecimal defaultRate;
    private String fullName;
    private String issueMethod;
    private String issuerName;
    private String residualMaturity;
    private String shortName;

    public String getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(String assessDate) {
        this.assessDate = assessDate;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public BigDecimal getBondYield() {
        return bondYield;
    }

    public void setBondYield(BigDecimal bondYield) {
        this.bondYield = bondYield;
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public BigDecimal getDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(BigDecimal defaultRate) {
        this.defaultRate = defaultRate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIssueMethod() {
        return issueMethod;
    }

    public void setIssueMethod(String issueMethod) {
        this.issueMethod = issueMethod;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getResidualMaturity() {
        return residualMaturity;
    }

    public void setResidualMaturity(String residualMaturity) {
        this.residualMaturity = residualMaturity;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
