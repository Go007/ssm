package com.hong.ssm.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 基础项目
 * </p>
 *
 * @author wanghong
 * @since 2019-11-05
 */
public class CsciBaseProject extends Model<CsciBaseProject> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 主体评级
     */
    private String mbodyLevel;

    /**
     * 评级时间
     */
    private Date ratingDate;

    /**
     * 评级机构
     */
    private String ratingAgency;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型ID
     */
    private Long typeId;

    /**
     * 项目类型名称
     */
    private String typeName;

    /**
     * 产品类型ID
     */
    private Long ptypeId;

    /**
     * 产品类型名称
     */
    private String ptypeName;

    /**
     * 当前阶段ID
     */
    private String cstageIds;

    /**
     * 当前阶段名称
     */
    private String cstageNames;

    /**
     * 渠道ID
     */
    private Long channelId;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 承揽人姓名
     */
    private String contNames;

    /**
     * 负责人
     */
    private Long chief;

    /**
     * 项目成员，用逗号分割的人员姓名
     */
    private String memberNames;

    /**
     * 状态，参照com.linkstec.ib.project.constant.ProjectStatus
     */
    private String status;

    /**
     * 联动类型（0：无，1：主动，2：被动）
     */
    private Integer assoType;

    /**
     * 立项时间
     */
    private Date projSetTime;

    /**
     * 过会时间
     */
    private Date passedTime;

    /**
     * 过会金额类型(1、仅增信，2、仅投资，3、增信&投资)
     */
    private Long passedType;

    /**
     * 审批过会金额
     */
    private BigDecimal checkAmount;

    /**
     * 有效过会金额
     */
    private BigDecimal passedAmount;

    /**
     * 归档时间
     */
    private Date archiveTime;

    /**
     * 流程实例ID
     */
    private Long pinsId;

    /**
     * 项目描述
     */
    private String projDesc;

    /**
     * 是否正常（0：否，1：是）
     */
    private Boolean isNormal;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date recGenTime;

    /**
     * 更新人
     */
    private Long updater;

    /**
     * 更新时间
     */
    private Date recUpdTime;

    /**
     * 项目一级分类(详情见数据字典：proTypeId)
     */
    @TableField("proTypeId")
    private Long proTypeId;

    /**
     * 项目二级分类(详情见数据字典)
     */
    @TableField("sonProTypeId")
    private Long sonProTypeId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMbodyLevel() {
        return mbodyLevel;
    }

    public void setMbodyLevel(String mbodyLevel) {
        this.mbodyLevel = mbodyLevel;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getRatingAgency() {
        return ratingAgency;
    }

    public void setRatingAgency(String ratingAgency) {
        this.ratingAgency = ratingAgency;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getPtypeId() {
        return ptypeId;
    }

    public void setPtypeId(Long ptypeId) {
        this.ptypeId = ptypeId;
    }

    public String getPtypeName() {
        return ptypeName;
    }

    public void setPtypeName(String ptypeName) {
        this.ptypeName = ptypeName;
    }

    public String getCstageIds() {
        return cstageIds;
    }

    public void setCstageIds(String cstageIds) {
        this.cstageIds = cstageIds;
    }

    public String getCstageNames() {
        return cstageNames;
    }

    public void setCstageNames(String cstageNames) {
        this.cstageNames = cstageNames;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getContNames() {
        return contNames;
    }

    public void setContNames(String contNames) {
        this.contNames = contNames;
    }

    public Long getChief() {
        return chief;
    }

    public void setChief(Long chief) {
        this.chief = chief;
    }

    public String getMemberNames() {
        return memberNames;
    }

    public void setMemberNames(String memberNames) {
        this.memberNames = memberNames;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAssoType() {
        return assoType;
    }

    public void setAssoType(Integer assoType) {
        this.assoType = assoType;
    }

    public Date getProjSetTime() {
        return projSetTime;
    }

    public void setProjSetTime(Date projSetTime) {
        this.projSetTime = projSetTime;
    }

    public Long getPassedType() {
        return passedType;
    }

    public void setPassedType(Long passedType) {
        this.passedType = passedType;
    }

    public BigDecimal getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(BigDecimal checkAmount) {
        this.checkAmount = checkAmount;
    }

    public BigDecimal getPassedAmount() {
        return passedAmount;
    }

    public void setPassedAmount(BigDecimal passedAmount) {
        this.passedAmount = passedAmount;
    }

    public Long getPinsId() {
        return pinsId;
    }

    public void setPinsId(Long pinsId) {
        this.pinsId = pinsId;
    }

    public String getProjDesc() {
        return projDesc;
    }

    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
    }

    public Boolean getNormal() {
        return isNormal;
    }

    public void setNormal(Boolean isNormal) {
        this.isNormal = isNormal;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Long getProTypeId() {
        return proTypeId;
    }

    public void setProTypeId(Long proTypeId) {
        this.proTypeId = proTypeId;
    }

    public Long getSonProTypeId() {
        return sonProTypeId;
    }

    public void setSonProTypeId(Long sonProTypeId) {
        this.sonProTypeId = sonProTypeId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CsciBaseProject{" +
        "id=" + id +
        ", customerId=" + customerId +
        ", customerName=" + customerName +
        ", mbodyLevel=" + mbodyLevel +
        ", ratingDate=" + ratingDate +
        ", ratingAgency=" + ratingAgency +
        ", projectCode=" + projectCode +
        ", projectName=" + projectName +
        ", typeId=" + typeId +
        ", typeName=" + typeName +
        ", ptypeId=" + ptypeId +
        ", ptypeName=" + ptypeName +
        ", cstageIds=" + cstageIds +
        ", cstageNames=" + cstageNames +
        ", channelId=" + channelId +
        ", channelName=" + channelName +
        ", deptId=" + deptId +
        ", deptName=" + deptName +
        ", contNames=" + contNames +
        ", chief=" + chief +
        ", memberNames=" + memberNames +
        ", status=" + status +
        ", assoType=" + assoType +
        ", projSetTime=" + projSetTime +
        ", passedTime=" + passedTime +
        ", passedType=" + passedType +
        ", checkAmount=" + checkAmount +
        ", passedAmount=" + passedAmount +
        ", archiveTime=" + archiveTime +
        ", pinsId=" + pinsId +
        ", projDesc=" + projDesc +
        ", isNormal=" + isNormal +
        ", creator=" + creator +
        ", recGenTime=" + recGenTime +
        ", updater=" + updater +
        ", recUpdTime=" + recUpdTime +
        ", proTypeId=" + proTypeId +
        ", sonProTypeId=" + sonProTypeId +
        "}";
    }

    public Date getPassedTime() {
        return passedTime;
    }

    public void setPassedTime(Date passedTime) {
        this.passedTime = passedTime;
    }

    public Date getArchiveTime() {
        return archiveTime;
    }

    public void setArchiveTime(Date archiveTime) {
        this.archiveTime = archiveTime;
    }

    public Date getRecGenTime() {
        return recGenTime;
    }

    public void setRecGenTime(Date recGenTime) {
        this.recGenTime = recGenTime;
    }

    public Date getRecUpdTime() {
        return recUpdTime;
    }

    public void setRecUpdTime(Date recUpdTime) {
        this.recUpdTime = recUpdTime;
    }
}
