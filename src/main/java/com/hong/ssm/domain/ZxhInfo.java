package com.hong.ssm.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author wanghong
 * @date 2020/01/09 17:01
 **/
public class ZxhInfo {
    @ExcelProperty(value = {"letterId"},index = 0)
    private String letterId;
    @ExcelProperty(value = {"公司"},index = 1)
    private String companyName;
    @ExcelProperty(value = {"借款期限"},index = 2)
    private String jkqx;
    @ExcelProperty(value = {"借款金额"},index = 3)
    private String jkje;
    @ExcelProperty(value = {"身份证号"},index = 4)
    private String idno;
    @ExcelProperty(value = {"法人"},index = 5)
    private String fr;
    @ExcelProperty(value = {"业务编码"},index = 6)
    private String ywbm;
    @ExcelProperty(value = {"合同编码"},index = 7)
    private String htbm;
    @ExcelProperty(value = {"云快贷借款合同"},index = 8)
    private String ykd;
    @ExcelProperty(value = {"质押协议"},index = 9)
    private String zyxy;
    @ExcelProperty(value = {"保证协议"},index = 10)
    private String bzxy;
    @ExcelProperty(value = {"合作协议"},index = 11)
    private String hzxy;
    @ExcelProperty(value = {"贷款合同"},index = 12)
    private String dkht;
    @ExcelProperty(value = {"委托担保服务协议"},index = 13)
    private String wtdbxy;

    public String getLetterId() {
        return letterId;
    }

    public void setLetterId(String letterId) {
        this.letterId = letterId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJkqx() {
        return jkqx;
    }

    public void setJkqx(String jkqx) {
        this.jkqx = jkqx;
    }

    public String getJkje() {
        return jkje;
    }

    public void setJkje(String jkje) {
        this.jkje = jkje;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getYwbm() {
        return ywbm;
    }

    public void setYwbm(String ywbm) {
        this.ywbm = ywbm;
    }

    public String getHtbm() {
        return htbm;
    }

    public void setHtbm(String htbm) {
        this.htbm = htbm;
    }

    public String getYkd() {
        return ykd;
    }

    public void setYkd(String ykd) {
        this.ykd = ykd;
    }

    public String getZyxy() {
        return zyxy;
    }

    public void setZyxy(String zyxy) {
        this.zyxy = zyxy;
    }

    public String getBzxy() {
        return bzxy;
    }

    public void setBzxy(String bzxy) {
        this.bzxy = bzxy;
    }

    public String getHzxy() {
        return hzxy;
    }

    public void setHzxy(String hzxy) {
        this.hzxy = hzxy;
    }

    public String getDkht() {
        return dkht;
    }

    public void setDkht(String dkht) {
        this.dkht = dkht;
    }

    public String getWtdbxy() {
        return wtdbxy;
    }

    public void setWtdbxy(String wtdbxy) {
        this.wtdbxy = wtdbxy;
    }
}
