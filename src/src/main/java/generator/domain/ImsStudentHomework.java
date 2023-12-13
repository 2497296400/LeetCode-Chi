package generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName ims_student_homework
 */
public class ImsStudentHomework implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 作业id
     */
    private Long homeworkId;

    /**
     * 附件地址-学生端
     */
    private String annexUrl;

    /**
     * 文件大小
     */
    private String filesize;

    /**
     * 作业状态(1：待完成；2：已完成；3：未完成)
     */
    private String state;

    /**
     * 作业成绩
     */
    private Long score;

    /**
     * 作业提交时间
     */
    private Date submitTime;

    /**
     * 批阅时间
     */
    private Date correctTime;

    /**
     * 创建时间
     */
    private Date createTime;

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
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 学生id
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * 学生id
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * 作业id
     */
    public Long getHomeworkId() {
        return homeworkId;
    }

    /**
     * 作业id
     */
    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    /**
     * 附件地址-学生端
     */
    public String getAnnexUrl() {
        return annexUrl;
    }

    /**
     * 附件地址-学生端
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
     * 作业状态(1：待完成；2：已完成；3：未完成)
     */
    public String getState() {
        return state;
    }

    /**
     * 作业状态(1：待完成；2：已完成；3：未完成)
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 作业成绩
     */
    public Long getScore() {
        return score;
    }

    /**
     * 作业成绩
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * 作业提交时间
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    /**
     * 作业提交时间
     */
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    /**
     * 批阅时间
     */
    public Date getCorrectTime() {
        return correctTime;
    }

    /**
     * 批阅时间
     */
    public void setCorrectTime(Date correctTime) {
        this.correctTime = correctTime;
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
        ImsStudentHomework other = (ImsStudentHomework) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getHomeworkId() == null ? other.getHomeworkId() == null : this.getHomeworkId().equals(other.getHomeworkId()))
            && (this.getAnnexUrl() == null ? other.getAnnexUrl() == null : this.getAnnexUrl().equals(other.getAnnexUrl()))
            && (this.getFilesize() == null ? other.getFilesize() == null : this.getFilesize().equals(other.getFilesize()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getSubmitTime() == null ? other.getSubmitTime() == null : this.getSubmitTime().equals(other.getSubmitTime()))
            && (this.getCorrectTime() == null ? other.getCorrectTime() == null : this.getCorrectTime().equals(other.getCorrectTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getHomeworkId() == null) ? 0 : getHomeworkId().hashCode());
        result = prime * result + ((getAnnexUrl() == null) ? 0 : getAnnexUrl().hashCode());
        result = prime * result + ((getFilesize() == null) ? 0 : getFilesize().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getSubmitTime() == null) ? 0 : getSubmitTime().hashCode());
        result = prime * result + ((getCorrectTime() == null) ? 0 : getCorrectTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", studentId=").append(studentId);
        sb.append(", homeworkId=").append(homeworkId);
        sb.append(", annexUrl=").append(annexUrl);
        sb.append(", filesize=").append(filesize);
        sb.append(", state=").append(state);
        sb.append(", score=").append(score);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", correctTime=").append(correctTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}