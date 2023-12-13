package generator.domain;

import java.io.Serializable;

/**
 * 
 * @TableName ims_course_student
 */
public class ImsCourseStudent implements Serializable {
    /**
     * ims_开课id
     */
    private Long imsCourseId;

    /**
     * 用户id
     */
    private Long sysUserId;

    private static final long serialVersionUID = 1L;

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
     * 用户id
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 用户id
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
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
        ImsCourseStudent other = (ImsCourseStudent) that;
        return (this.getImsCourseId() == null ? other.getImsCourseId() == null : this.getImsCourseId().equals(other.getImsCourseId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImsCourseId() == null) ? 0 : getImsCourseId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imsCourseId=").append(imsCourseId);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}