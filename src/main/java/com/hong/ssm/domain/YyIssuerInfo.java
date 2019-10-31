package com.hong.ssm.domain;

/**
 * @author wanghong
 * @date 2019/10/31 14:36
 **/
public class YyIssuerInfo {
    private String issuerID;
    private String issuerName;
    private String registerCode;
    private String issuerType;
    private String yYRating;
    private String intrinsicRating;
    private String corporateRating;
    private String ratingAgency;
    private String holder;
    private String nature;
    private String listed;
    private String creditAnalysis;
    private CtExtendInfo ctExtendInfo;
    private CyExtendInfo cyExtendInfo;
    private String ctExtendInfoStr;
    private String cyExtendInfoStr;

    public String getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(String issuerID) {
        this.issuerID = issuerID;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    public String getIssuerType() {
        return issuerType;
    }

    public void setIssuerType(String issuerType) {
        this.issuerType = issuerType;
    }

    public String getyYRating() {
        return yYRating;
    }

    public void setyYRating(String yYRating) {
        this.yYRating = yYRating;
    }

    public String getIntrinsicRating() {
        return intrinsicRating;
    }

    public void setIntrinsicRating(String intrinsicRating) {
        this.intrinsicRating = intrinsicRating;
    }

    public String getCorporateRating() {
        return corporateRating;
    }

    public void setCorporateRating(String corporateRating) {
        this.corporateRating = corporateRating;
    }

    public String getRatingAgency() {
        return ratingAgency;
    }

    public void setRatingAgency(String ratingAgency) {
        this.ratingAgency = ratingAgency;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getListed() {
        return listed;
    }

    public void setListed(String listed) {
        this.listed = listed;
    }

    public String getCreditAnalysis() {
        return creditAnalysis;
    }

    public void setCreditAnalysis(String creditAnalysis) {
        this.creditAnalysis = creditAnalysis;
    }

    public String getCyExtendInfoStr() {
        return cyExtendInfoStr;
    }

    public void setCyExtendInfoStr(String cyExtendInfoStr) {
        this.cyExtendInfoStr = cyExtendInfoStr;
    }

    public CtExtendInfo getCtExtendInfo() {
        return ctExtendInfo;
    }

    public void setCtExtendInfo(CtExtendInfo ctExtendInfo) {
        this.ctExtendInfo = ctExtendInfo;
    }

    public CyExtendInfo getCyExtendInfo() {
        return cyExtendInfo;
    }

    public void setCyExtendInfo(CyExtendInfo cyExtendInfo) {
        this.cyExtendInfo = cyExtendInfo;
    }

    public String getCtExtendInfoStr() {
        return ctExtendInfoStr;
    }

    public void setCtExtendInfoStr(String ctExtendInfoStr) {
        this.ctExtendInfoStr = ctExtendInfoStr;
    }
}
