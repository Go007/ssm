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
    @ExcelProperty(value = {"三方协议编号"},index = 14)
    private String sfxybh;
    @ExcelProperty(value = {"信用增进服务协议编号"},index = 15)
    private String xyzjxybh;
    @ExcelProperty(value = {"借款人名称"},index = 16)
    private String jkrmc;
    @ExcelProperty(value = {"借款人法定代表人"},index = 17)
    private String jkrfddbr;
    @ExcelProperty(value = {"借款到期日"},index = 18)
    private String jkdqr;
    @ExcelProperty(value = {"差额补足协议编号"},index = 19)
    private String cebzxybh;
    @ExcelProperty(value = {"本期借款借款利率"},index = 20)
    private String bqjklv;
    @ExcelProperty(value = {"本期借款借款金额"},index = 21)
    private String bqjkje;
    @ExcelProperty(value = {"流动资金贷款合同编号"},index = 22)
    private String ldzjdkbh;
    @ExcelProperty(value = {"用印时间"},index = 23)
    private String yysj;
    @ExcelProperty(value = {"电票到期日"},index = 24)
    private String dpdqr;
    @ExcelProperty(value = {"电票承兑方"},index = 25)
    private String dpcdf;
    @ExcelProperty(value = {"电票票号"},index = 26)
    private String dpph;
    @ExcelProperty(value = {"电票质押合同编号"},index = 27)
    private String dpzyhtbh;

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

    public String getSfxybh() {
        return sfxybh;
    }

    public void setSfxybh(String sfxybh) {
        this.sfxybh = sfxybh;
    }

    public String getXyzjxybh() {
        return xyzjxybh;
    }

    public void setXyzjxybh(String xyzjxybh) {
        this.xyzjxybh = xyzjxybh;
    }

    public String getJkrmc() {
        return jkrmc;
    }

    public void setJkrmc(String jkrmc) {
        this.jkrmc = jkrmc;
    }

    public String getJkrfddbr() {
        return jkrfddbr;
    }

    public void setJkrfddbr(String jkrfddbr) {
        this.jkrfddbr = jkrfddbr;
    }

    public String getJkdqr() {
        return jkdqr;
    }

    public void setJkdqr(String jkdqr) {
        this.jkdqr = jkdqr;
    }

    public String getCebzxybh() {
        return cebzxybh;
    }

    public void setCebzxybh(String cebzxybh) {
        this.cebzxybh = cebzxybh;
    }

    public String getBqjklv() {
        return bqjklv;
    }

    public void setBqjklv(String bqjklv) {
        this.bqjklv = bqjklv;
    }

    public String getBqjkje() {
        return bqjkje;
    }

    public void setBqjkje(String bqjkje) {
        this.bqjkje = bqjkje;
    }

    public String getLdzjdkbh() {
        return ldzjdkbh;
    }

    public void setLdzjdkbh(String ldzjdkbh) {
        this.ldzjdkbh = ldzjdkbh;
    }

    public String getYysj() {
        return yysj;
    }

    public void setYysj(String yysj) {
        this.yysj = yysj;
    }

    public String getDpdqr() {
        return dpdqr;
    }

    public void setDpdqr(String dpdqr) {
        this.dpdqr = dpdqr;
    }

    public String getDpcdf() {
        return dpcdf;
    }

    public void setDpcdf(String dpcdf) {
        this.dpcdf = dpcdf;
    }

    public String getDpph() {
        return dpph;
    }

    public void setDpph(String dpph) {
        this.dpph = dpph;
    }

    public String getDpzyhtbh() {
        return dpzyhtbh;
    }

    public void setDpzyhtbh(String dpzyhtbh) {
        this.dpzyhtbh = dpzyhtbh;
    }
}
