package generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName ims_homework
 */
public class ImsHomework implements Serializable {
    /**
     * 主键
     */
    private Long homeworkId;

    /**
     * ims_开课id
     */
    private Long imsCourseId;

    /**
     * 作业名称
     */
    private String homeworkName;

    /**
     * 作业类型(1：作业；2：实验报告；3：项目报告；4：暂定，自定义)
     */
    private String homeworkType;

    /**
     * 发布范围(1：当前班；2：指定学生)
     */
    private String homeworkScope;

    /**
     * 批阅老师
     */
    private String reviewedTeacher;

    /**
     * 学生提交截止时间
     */
    private Date submitTime;

    /**
     * 批阅截止时间
     */
    private Date correctDeadline;

    /**
     * 作业说明
     */
    private String description;

    /**
     * 附件地址-老师端
     */
    private String annexUrl;

    /**
     * 文件大小
     */
    private String filesize;

    /**
     * 作业评分体系（百分制、AB五分制、优良五分制）
     */
    private String scoreSystem;

    /**
     * 状态(1：暂存；2：进行中；3：已结束；4：定时发布)
     */
    private String state;

    /**
     * 删除标志（0存在  2删除）
     */
    private String delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getHomeworkId() {
        return homeworkId;
    }

    /**
     * 主键
     */
    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    /**
     * ims_开课id
     */
    public Long getImsCourseId() {
        return imsCourseId;
    }

    /**
     * ims_开课id
     */
    public void setImsCourseId(Long imsCourseId) {
        this.imsCourseId = imsCourseId;
    }

    /**
     * 作业名称
     */
    public String getHomeworkName() {
        return homeworkName;
    }

    /**
     * 作业名称
     */
    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    /**
     * 作业类型(1：作业；2：实验报告；3：项目报告；4：暂定，自定义)
     */
    public String getHomeworkType() {
        return homeworkType;
    }

    /**
     * 作业类型(1：作业；2：实验报告；3：项目报告；4：暂定，自定义)
     */
    public void setHomeworkType(String homeworkType) {
        this.homeworkType = homeworkType;
    }

    /**
     * 发布范围(1：当前班；2：指定学生)
     */
    public String getHomeworkScope() {
        return homeworkScope;
    }

    /**
     * 发布范围(1：当前班；2：指定学生)
     */
    public void setHomeworkScope(String homeworkScope) {
        this.homeworkScope = homeworkScope;
    }

    /**
     * 批阅老师
     */
    public String getReviewedTeacher() {
        return reviewedTeacher;
    }

    /**
     * 批阅老师
     */
    public void setReviewedTeacher(String reviewedTeacher) {
        this.reviewedTeacher = reviewedTeacher;
    }

    /**
     * 学生提交截止时间
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    /**
     * 学生提交截止时间
     */
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    /**
     * 批阅截止时间
     */
    public Date getCorrectDeadline() {
        return correctDeadline;
    }

    /**
     * 批阅截止时间
     */
    public void setCorrectDeadline(Date correctDeadline) {
        this.correctDeadline = correctDeadline;
    }

    /**
     * 作业说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 作业说明
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 附件地址-老师端
     */
    public String getAnnexUrl() {
        return annexUrl;
    }

    /**
     * 附件地址-老师端
     */
    public void setAnnexUrl(String annexUrl) {
        this.annexUrl = annexUrl;
    }

    /**
     * 文件大小
     */
    public String getFilesize() {
        return filesize;
    }

    /**
     * 文件大小
     */
    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    /**
     * 作业评分体系（百分制、AB五分制、优良五分制）
     */
    public String getScoreSystem() {
        return scoreSystem;
    }

    /**
     * 作业评分体系（百分制、AB五分制、优良五分制）
     */
    public void setScoreSystem(String scoreSystem) {
        this.scoreSystem = scoreSystem;
    }

    /**
     * 状态(1：暂存；2：进行中；3：已结束；4：定时发布)
     */
    public String getState() {
        return state;
    }

    /**
     * 状态(1：暂存；2：进行中；3：已结束；4：定时发布)
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 删除标志（0存在  2删除）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标志（0存在  2删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ImsHomework other = (ImsHomework) that;
        return (this.getHomeworkId() == null ? other.getHomeworkId() == null : this.getHomeworkId().equals(other.getHomeworkId()))
            && (this.getImsCourseId() == null ? other.getImsCourseId() == null : this.getImsCourseId().equals(other.getImsCourseId()))
            && (this.getHomeworkName() == null ? other.getHomeworkName() == null : this.getHomeworkName().equals(other.getHomeworkName()))
            && (this.getHomeworkType() == null ? other.getHomeworkType() == null : this.getHomeworkType().equals(other.getHomeworkType()))
            && (this.getHomeworkScope() == null ? other.getHomeworkScope() == null : this.getHomeworkScope().equals(other.getHomeworkScope()))
            && (this.getReviewedTeacher() == null ? other.getReviewedTeacher() == null : this.getReviewedTeacher().equals(other.getReviewedTeacher()))
            && (this.getSubmitTime() == null ? other.getSubmitTime() == null : this.getSubmitTime().equals(other.getSubmitTime()))
            && (this.getCorrectDeadline() == null ? other.getCorrectDeadline() == null : this.getCorrectDeadline().equals(other.getCorrectDeadline()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAnnexUrl() == null ? other.getAnnexUrl() == null : this.getAnnexUrl().equals(other.getAnnexUrl()))
            && (this.getFilesize() == null ? other.getFilesize() == null : this.getFilesize().equals(other.getFilesize()))
            && (this.getScoreSystem() == null ? other.getScoreSystem() == null : this.getScoreSystem().equals(other.getScoreSystem()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHomeworkId() == null) ? 0 : getHomeworkId().hashCode());
        result = prime * result + ((getImsCourseId() == null) ? 0 : getImsCourseId().hashCode());
        result = prime * result + ((getHomeworkName() == null) ? 0 : getHomeworkName().hashCode());
        result = prime * result + ((getHomeworkType() == null) ? 0 : getHomeworkType().hashCode());
        result = prime * result + ((getHomeworkScope() == null) ? 0 : getHomeworkScope().hashCode());
        result = prime * result + ((getReviewedTeacher() == null) ? 0 : getReviewedTeacher().hashCode());
        result = prime * result + ((getSubmitTime() == null) ? 0 : getSubmitTime().hashCode());
        result = prime * result + ((getCorrectDeadline() == null) ? 0 : getCorrectDeadline().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAnnexUrl() == null) ? 0 : getAnnexUrl().hashCode());
        result = prime * result + ((getFilesize() == null) ? 0 : getFilesize().hashCode());
        result = prime * result + ((getScoreSystem() == null) ? 0 : getScoreSystem().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", homeworkId=").append(homeworkId);
        sb.append(", imsCourseId=").append(imsCourseId);
        sb.append(", homeworkName=").append(homeworkName);
        sb.append(", homeworkType=").append(homeworkType);
        sb.append(", homeworkScope=").append(homeworkScope);
        sb.append(", reviewedTeacher=").append(reviewedTeacher);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", correctDeadline=").append(correctDeadline);
        sb.append(", description=").append(description);
        sb.append(", annexUrl=").append(annexUrl);
        sb.append(", filesize=").append(filesize);
        sb.append(", scoreSystem=").append(scoreSystem);
        sb.append(", state=").append(state);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}