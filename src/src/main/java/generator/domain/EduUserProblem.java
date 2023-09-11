package generator.domain;

import java.io.Serializable;

/**
 * 
 * @TableName edu_user_problem
 */
public class EduUserProblem implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 问题id
     */
    private Long problemId;

    /**
     * 是否解决有帮助（0是，1否）
     */
    private String solve;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 问题id
     */
    public Long getProblemId() {
        return problemId;
    }

    /**
     * 问题id
     */
    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    /**
     * 是否解决有帮助（0是，1否）
     */
    public String getSolve() {
        return solve;
    }

    /**
     * 是否解决有帮助（0是，1否）
     */
    public void setSolve(String solve) {
        this.solve = solve;
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
        EduUserProblem other = (EduUserProblem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProblemId() == null ? other.getProblemId() == null : this.getProblemId().equals(other.getProblemId()))
            && (this.getSolve() == null ? other.getSolve() == null : this.getSolve().equals(other.getSolve()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProblemId() == null) ? 0 : getProblemId().hashCode());
        result = prime * result + ((getSolve() == null) ? 0 : getSolve().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", problemId=").append(problemId);
        sb.append(", solve=").append(solve);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}