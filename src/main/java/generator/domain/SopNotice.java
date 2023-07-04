package generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName sop_notice
 */
public class SopNotice implements Serializable {
    /**
     * 主键id
     */
    private Long noticeId;

    /**
     * 通知标题
     */
    private String title;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 通知范围（0全部，1部分）
     */
    private String noticeRange;

    /**
     * 通知用户集合
     */
    private String userList;

    /**
     * 是否删除（0存在，2删除）
     */
    private String delFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public Long getNoticeId() {
        return noticeId;
    }

    /**
     * 主键id
     */
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * 通知标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 通知标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 通知内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 通知内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 通知范围（0全部，1部分）
     */
    public String getNoticeRange() {
        return noticeRange;
    }

    /**
     * 通知范围（0全部，1部分）
     */
    public void setNoticeRange(String noticeRange) {
        this.noticeRange = noticeRange;
    }

    /**
     * 通知用户集合
     */
    public String getUserList() {
        return userList;
    }

    /**
     * 通知用户集合
     */
    public void setUserList(String userList) {
        this.userList = userList;
    }

    /**
     * 是否删除（0存在，2删除）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 是否删除（0存在，2删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
     * 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
        SopNotice other = (SopNotice) that;
        return (this.getNoticeId() == null ? other.getNoticeId() == null : this.getNoticeId().equals(other.getNoticeId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getNoticeRange() == null ? other.getNoticeRange() == null : this.getNoticeRange().equals(other.getNoticeRange()))
            && (this.getUserList() == null ? other.getUserList() == null : this.getUserList().equals(other.getUserList()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoticeId() == null) ? 0 : getNoticeId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getNoticeRange() == null) ? 0 : getNoticeRange().hashCode());
        result = prime * result + ((getUserList() == null) ? 0 : getUserList().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noticeId=").append(noticeId);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", noticeRange=").append(noticeRange);
        sb.append(", userList=").append(userList);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}