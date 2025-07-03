package org.example.course_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程统计信息
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public class Crcount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 教师名称
     */
    private String teacherName;

    /**
     * 听课次数
     */
    private String tkCount;

    /**
     * 被听课次数
     */
    private String btCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getTkCount() {
        return tkCount;
    }

    public void setTkCount(String tkCount) {
        this.tkCount = tkCount;
    }
    public String getBtCount() {
        return btCount;
    }

    public void setBtCount(String btCount) {
        this.btCount = btCount;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Crcount{" +
            "id=" + id +
            ", teacherName=" + teacherName +
            ", tkCount=" + tkCount +
            ", btCount=" + btCount +
            ", createTime=" + createTime +
            ", updatetime=" + updatetime +
        "}";
    }
}
