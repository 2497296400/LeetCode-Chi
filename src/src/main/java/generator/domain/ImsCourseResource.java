package generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName ims_course_resource
 */
public class ImsCourseResource implements Serializable {
    /**
     * 主键
     */
    private Long resourceId;

    /**
     * ims_开课id
     */
    private Long imsCourseId;

    /**
     * 文件名
     */
    private String resourceName;

    /**
     * 对应url
     */
    private String url;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 文件大小
     */
    private String filesize;

    /**
     * 视频时长
     */
    private String videolength;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 主键
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
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
     * 文件名
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 文件名
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 对应url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 对应url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 资源类型
     */
    public String getType() {
        return type;
    }

    /**
     * 资源类型
     */
    public void setType(String type) {
        this.type = type;
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
     * 视频时长
     */
    public String getVideolength() {
        return videolength;
    }

    /**
     * 视频时长
     */
    public void setVideolength(String videolength) {
        this.videolength = videolength;
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
        ImsCourseResource other = (ImsCourseResource) that;
        return (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
            && (this.getImsCourseId() == null ? other.getImsCourseId() == null : this.getImsCourseId().equals(other.getImsCourseId()))
            && (this.getResourceName() == null ? other.getResourceName() == null : this.getResourceName().equals(other.getResourceName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFilesize() == null ? other.getFilesize() == null : this.getFilesize().equals(other.getFilesize()))
            && (this.getVideolength() == null ? other.getVideolength() == null : this.getVideolength().equals(other.getVideolength()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        result = prime * result + ((getImsCourseId() == null) ? 0 : getImsCourseId().hashCode());
        result = prime * result + ((getResourceName() == null) ? 0 : getResourceName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFilesize() == null) ? 0 : getFilesize().hashCode());
        result = prime * result + ((getVideolength() == null) ? 0 : getVideolength().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourceId=").append(resourceId);
        sb.append(", imsCourseId=").append(imsCourseId);
        sb.append(", resourceName=").append(resourceName);
        sb.append(", url=").append(url);
        sb.append(", type=").append(type);
        sb.append(", filesize=").append(filesize);
        sb.append(", videolength=").append(videolength);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}