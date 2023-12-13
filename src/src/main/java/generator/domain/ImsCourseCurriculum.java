package generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 课表
 * @TableName ims_course_curriculum
 */
public class ImsCourseCurriculum implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 上课时间
     */
    private String classTime;

    /**
     * 上课时段
     */
    private String periodOfTime;

    /**
     * 课程节次
     */
    private String section;

    /**
     * 关联的老师开课id
     */
    private Long imsCourseId;

    /**
     * 关联的培养方案课程id
     */
    private Long trainCourseId;

    /**
     * 教学模式（字典）
     */
    private String teachingModel;

    /**
     * 教室
     */
    private String classroom;

    /**
     * 讲师id
     */
    private Long teacherId;

    /**
     * 助教id
     */
    private Long assistantId;

    /**
     * 0:无作业  1：有作业
     */
    private String isHomework;

    /**
     * 授课内容
     */
    private String content;

    /**
     * 0:正常   2：删除
     */
    private String delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

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
     * 上课时间
     */
    public String getClassTime() {
        return classTime;
    }

    /**
     * 上课时间
     */
    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    /**
     * 上课时段
     */
    public String getPeriodOfTime() {
        return periodOfTime;
    }

    /**
     * 上课时段
     */
    public void setPeriodOfTime(String periodOfTime) {
        this.periodOfTime = periodOfTime;
    }

    /**
     * 课程节次
     */
    public String getSection() {
        return section;
    }

    /**
     * 课程节次
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * 关联的老师开课id
     */
    public Long getImsCourseId() {
        return imsCourseId;
    }

    /**
     * 关联的老师开课id
     */
    public void setImsCourseId(Long imsCourseId) {
        this.imsCourseId = imsCourseId;
    }

    /**
     * 关联的培养方案课程id
     */
    public Long getTrainCourseId() {
        return trainCourseId;
    }

    /**
     * 关联的培养方案课程id
     */
    public void setTrainCourseId(Long trainCourseId) {
        this.trainCourseId = trainCourseId;
    }

    /**
     * 教学模式（字典）
     */
    public String getTeachingModel() {
        return teachingModel;
    }

    /**
     * 教学模式（字典）
     */
    public void setTeachingModel(String teachingModel) {
        this.teachingModel = teachingModel;
    }

    /**
     * 教室
     */
    public String getClassroom() {
        return classroom;
    }

    /**
     * 教室
     */
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    /**
     * 讲师id
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * 讲师id
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 助教id
     */
    public Long getAssistantId() {
        return assistantId;
    }

    /**
     * 助教id
     */
    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    /**
     * 0:无作业  1：有作业
     */
    public String getIsHomework() {
        return isHomework;
    }

    /**
     * 0:无作业  1：有作业
     */
    public void setIsHomework(String isHomework) {
        this.isHomework = isHomework;
    }

    /**
     * 授课内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 授课内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 0:正常   2：删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 0:正常   2：删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
     * 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新人
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
}