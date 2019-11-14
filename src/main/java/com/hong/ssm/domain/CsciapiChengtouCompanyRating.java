package com.hong.ssm.domain;

import java.math.BigDecimal;

public class CsciapiChengtouCompanyRating{
	private static final long serialVersionUID=1L;

    private Integer id;

    /**
     * 发行主体ID
     */
    private BigDecimal companyId;

    /**
     * 发行主体名称
     */
    private String companyName;

    /**
     * 地区编号
     */
    private BigDecimal region;

    /**
     * YY类型
     */
    private String category;

    /**
     * YY评级
     */
    private String yyRating;

    /**
     * YY评级日期
     */
    private String yyRatingDt;

    /**
     * YY同省排名
     */
    private String yyProvinceRank;

    /**
     * YY同省百分位
     */
    private BigDecimal yyProvincePercent;

    /**
     * YY白名单排名
     */
    private String yyWhiteRank;

    /**
     * YY白名单百分位
     */
    private BigDecimal yyWhitePercent;

    /**
     * YY外部排名
     */
    private String yyOutRank;

    /**
     * YY外部百分位
     */
    private BigDecimal yyOutPercent;

    /**
     * YY全国排名
     */
    private String yyCountryRank;

    /**
     * YY全国百分位
     */
    private BigDecimal yyCountryPercent;

    /**
     * cscs评级
     */
    private String cscsRating;

    /**
     * cscs评级日期
     */
    private String cscsRatingDt;

    /**
     * cscs同省排名
     */
    private String cscsProvinceRank;

    /**
     * cscs同省百分位
     */
    private BigDecimal cscsProvincePercent;

    /**
     * cscs白名单排名
     */
    private String cscsWhiteRank;

    /**
     * cscs白名单百分位
     */
    private BigDecimal cscsWhitePercent;

    /**
     * cscs外部排名
     */
    private String cscsOutRank;

    /**
     * cscs外部百分位
     */
    private BigDecimal cscsOutPercent;

    /**
     * cscs全国排名
     */
    private String cscsCountryRank;

    /**
     * cscs全国百分位
     */
    private BigDecimal cscsCountryPercent;

    /**
     * 外部评级
     */
    private String outRating;

    /**
     * 外部评级日期
     */
    private String outRatingDt;

    /**
     * 外部同省排名
     */
    private String outProvinceRank;

    /**
     * 外部同省百分位
     */
    private BigDecimal outProvincePercent;

    /**
     * 外部白名单排名
     */
    private String outWhiteRank;

    /**
     * 外部白名单百分位
     */
    private BigDecimal outWhitePercent;

    /**
     * 外部全国排名
     */
    private String outCountryRank;

    /**
     * 外部全国百分位
     */
    private BigDecimal outCountryPercent;

    /**
     * DM评分
     */
    private BigDecimal dmRating;

    /**
     * DM评分日期
     */
    private String dmRatingDt;

    /**
     * dm同省排名
     */
    private String dmProvinceRank;

    /**
     * dm同省百分位
     */
    private BigDecimal dmProvincePercent;

    /**
     * dm白名单排名
     */
    private String dmWhiteRank;

    /**
     * dm白名单百分位
     */
    private BigDecimal dmWhitePercent;

    /**
     * dm外部排名
     */
    private String dmOutRank;

    /**
     * dm外部百分位
     */
    private BigDecimal dmOutPercent;

    /**
     * dm全国排名
     */
    private String dmCountryRank;

    /**
     * dm全国百分位
     */
    private BigDecimal dmCountryPercent;

    private String updateDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCompanyId() {
        return companyId;
    }

    public void setCompanyId(BigDecimal companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getRegion() {
        return region;
    }

    public void setRegion(BigDecimal region) {
        this.region = region;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYyRating() {
        return yyRating;
    }

    public void setYyRating(String yyRating) {
        this.yyRating = yyRating;
    }

    public String getYyProvinceRank() {
        return yyProvinceRank;
    }

    public void setYyProvinceRank(String yyProvinceRank) {
        this.yyProvinceRank = yyProvinceRank;
    }

    public BigDecimal getYyProvincePercent() {
        return yyProvincePercent;
    }

    public void setYyProvincePercent(BigDecimal yyProvincePercent) {
        this.yyProvincePercent = yyProvincePercent;
    }

    public String getYyWhiteRank() {
        return yyWhiteRank;
    }

    public void setYyWhiteRank(String yyWhiteRank) {
        this.yyWhiteRank = yyWhiteRank;
    }

    public BigDecimal getYyWhitePercent() {
        return yyWhitePercent;
    }

    public void setYyWhitePercent(BigDecimal yyWhitePercent) {
        this.yyWhitePercent = yyWhitePercent;
    }

    public String getYyOutRank() {
        return yyOutRank;
    }

    public void setYyOutRank(String yyOutRank) {
        this.yyOutRank = yyOutRank;
    }

    public BigDecimal getYyOutPercent() {
        return yyOutPercent;
    }

    public void setYyOutPercent(BigDecimal yyOutPercent) {
        this.yyOutPercent = yyOutPercent;
    }

    public String getYyCountryRank() {
        return yyCountryRank;
    }

    public void setYyCountryRank(String yyCountryRank) {
        this.yyCountryRank = yyCountryRank;
    }

    public BigDecimal getYyCountryPercent() {
        return yyCountryPercent;
    }

    public void setYyCountryPercent(BigDecimal yyCountryPercent) {
        this.yyCountryPercent = yyCountryPercent;
    }

    public String getCscsRating() {
        return cscsRating;
    }

    public void setCscsRating(String cscsRating) {
        this.cscsRating = cscsRating;
    }


    public String getCscsProvinceRank() {
        return cscsProvinceRank;
    }

    public void setCscsProvinceRank(String cscsProvinceRank) {
        this.cscsProvinceRank = cscsProvinceRank;
    }

    public BigDecimal getCscsProvincePercent() {
        return cscsProvincePercent;
    }

    public void setCscsProvincePercent(BigDecimal cscsProvincePercent) {
        this.cscsProvincePercent = cscsProvincePercent;
    }

    public String getCscsWhiteRank() {
        return cscsWhiteRank;
    }

    public void setCscsWhiteRank(String cscsWhiteRank) {
        this.cscsWhiteRank = cscsWhiteRank;
    }

    public BigDecimal getCscsWhitePercent() {
        return cscsWhitePercent;
    }

    public void setCscsWhitePercent(BigDecimal cscsWhitePercent) {
        this.cscsWhitePercent = cscsWhitePercent;
    }

    public String getCscsOutRank() {
        return cscsOutRank;
    }

    public void setCscsOutRank(String cscsOutRank) {
        this.cscsOutRank = cscsOutRank;
    }

    public BigDecimal getCscsOutPercent() {
        return cscsOutPercent;
    }

    public void setCscsOutPercent(BigDecimal cscsOutPercent) {
        this.cscsOutPercent = cscsOutPercent;
    }

    public String getCscsCountryRank() {
        return cscsCountryRank;
    }

    public void setCscsCountryRank(String cscsCountryRank) {
        this.cscsCountryRank = cscsCountryRank;
    }

    public BigDecimal getCscsCountryPercent() {
        return cscsCountryPercent;
    }

    public void setCscsCountryPercent(BigDecimal cscsCountryPercent) {
        this.cscsCountryPercent = cscsCountryPercent;
    }

    public String getOutRating() {
        return outRating;
    }

    public void setOutRating(String outRating) {
        this.outRating = outRating;
    }

   
	public String getOutProvinceRank() {
        return outProvinceRank;
    }

    public void setOutProvinceRank(String outProvinceRank) {
        this.outProvinceRank = outProvinceRank;
    }

    public BigDecimal getOutProvincePercent() {
        return outProvincePercent;
    }

    public void setOutProvincePercent(BigDecimal outProvincePercent) {
        this.outProvincePercent = outProvincePercent;
    }

    public String getOutWhiteRank() {
        return outWhiteRank;
    }

    public void setOutWhiteRank(String outWhiteRank) {
        this.outWhiteRank = outWhiteRank;
    }

    public BigDecimal getOutWhitePercent() {
        return outWhitePercent;
    }

    public void setOutWhitePercent(BigDecimal outWhitePercent) {
        this.outWhitePercent = outWhitePercent;
    }

    public String getOutCountryRank() {
        return outCountryRank;
    }

    public void setOutCountryRank(String outCountryRank) {
        this.outCountryRank = outCountryRank;
    }

    public BigDecimal getOutCountryPercent() {
        return outCountryPercent;
    }

    public void setOutCountryPercent(BigDecimal outCountryPercent) {
        this.outCountryPercent = outCountryPercent;
    }

    public BigDecimal getDmRating() {
        return dmRating;
    }

    public void setDmRating(BigDecimal dmRating) {
        this.dmRating = dmRating;
    }


    public String getDmProvinceRank() {
        return dmProvinceRank;
    }

    public void setDmProvinceRank(String dmProvinceRank) {
        this.dmProvinceRank = dmProvinceRank;
    }

    public BigDecimal getDmProvincePercent() {
        return dmProvincePercent;
    }

    public void setDmProvincePercent(BigDecimal dmProvincePercent) {
        this.dmProvincePercent = dmProvincePercent;
    }

    public String getDmWhiteRank() {
        return dmWhiteRank;
    }

    public void setDmWhiteRank(String dmWhiteRank) {
        this.dmWhiteRank = dmWhiteRank;
    }

    public BigDecimal getDmWhitePercent() {
        return dmWhitePercent;
    }

    public void setDmWhitePercent(BigDecimal dmWhitePercent) {
        this.dmWhitePercent = dmWhitePercent;
    }

    public String getDmOutRank() {
        return dmOutRank;
    }

    public void setDmOutRank(String dmOutRank) {
        this.dmOutRank = dmOutRank;
    }

    public BigDecimal getDmOutPercent() {
        return dmOutPercent;
    }

    public void setDmOutPercent(BigDecimal dmOutPercent) {
        this.dmOutPercent = dmOutPercent;
    }

    public String getDmCountryRank() {
        return dmCountryRank;
    }

    public void setDmCountryRank(String dmCountryRank) {
        this.dmCountryRank = dmCountryRank;
    }

    public BigDecimal getDmCountryPercent() {
        return dmCountryPercent;
    }

    public void setDmCountryPercent(BigDecimal dmCountryPercent) {
        this.dmCountryPercent = dmCountryPercent;
    }

    
    
    

	public String getYyRatingDt() {
		return yyRatingDt;
	}

	public void setYyRatingDt(String yyRatingDt) {
		this.yyRatingDt = yyRatingDt;
	}

	public String getCscsRatingDt() {
		return cscsRatingDt;
	}

	public void setCscsRatingDt(String cscsRatingDt) {
		this.cscsRatingDt = cscsRatingDt;
	}

	public String getOutRatingDt() {
		return outRatingDt;
	}

	public void setOutRatingDt(String outRatingDt) {
		this.outRatingDt = outRatingDt;
	}

	public String getDmRatingDt() {
		return dmRatingDt;
	}

	public void setDmRatingDt(String dmRatingDt) {
		this.dmRatingDt = dmRatingDt;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
    public String toString() {
        return "CsciapiChengtouCompanyRating{" +
        "id=" + id +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", region=" + region +
        ", category=" + category +
        ", yyRating=" + yyRating +
        ", yyRatingDt=" + yyRatingDt +
        ", yyProvinceRank=" + yyProvinceRank +
        ", yyProvincePercent=" + yyProvincePercent +
        ", yyWhiteRank=" + yyWhiteRank +
        ", yyWhitePercent=" + yyWhitePercent +
        ", yyOutRank=" + yyOutRank +
        ", yyOutPercent=" + yyOutPercent +
        ", yyCountryRank=" + yyCountryRank +
        ", yyCountryPercent=" + yyCountryPercent +
        ", cscsRating=" + cscsRating +
        ", cscsRatingDt=" + cscsRatingDt +
        ", cscsProvinceRank=" + cscsProvinceRank +
        ", cscsProvincePercent=" + cscsProvincePercent +
        ", cscsWhiteRank=" + cscsWhiteRank +
        ", cscsWhitePercent=" + cscsWhitePercent +
        ", cscsOutRank=" + cscsOutRank +
        ", cscsOutPercent=" + cscsOutPercent +
        ", cscsCountryRank=" + cscsCountryRank +
        ", cscsCountryPercent=" + cscsCountryPercent +
        ", outRating=" + outRating +
        ", outRatingDt=" + outRatingDt +
        ", outProvinceRank=" + outProvinceRank +
        ", outProvincePercent=" + outProvincePercent +
        ", outWhiteRank=" + outWhiteRank +
        ", outWhitePercent=" + outWhitePercent +
        ", outCountryRank=" + outCountryRank +
        ", outCountryPercent=" + outCountryPercent +
        ", dmRating=" + dmRating +
        ", dmRatingDt=" + dmRatingDt +
        ", dmProvinceRank=" + dmProvinceRank +
        ", dmProvincePercent=" + dmProvincePercent +
        ", dmWhiteRank=" + dmWhiteRank +
        ", dmWhitePercent=" + dmWhitePercent +
        ", dmOutRank=" + dmOutRank +
        ", dmOutPercent=" + dmOutPercent +
        ", dmCountryRank=" + dmCountryRank +
        ", dmCountryPercent=" + dmCountryPercent +
        ", updateDate=" + updateDate +
        "}";
    }
}
