package org.example.course_manager.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String coursename;

    private String coursenum;

    private String courseteacher;

    private String coursedate;

    private String coursedesc;

    private String courseroom;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    public String getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(String coursenum) {
        this.coursenum = coursenum;
    }
    public String getCourseteacher() {
        return courseteacher;
    }

    public void setCourseteacher(String courseteacher) {
        this.courseteacher = courseteacher;
    }
    public String getCoursedate() {
        return coursedate;
    }

    public void setCoursedate(String coursedate) {
        this.coursedate = coursedate;
    }
    public String getCoursedesc() {
        return coursedesc;
    }

    public void setCoursedesc(String coursedesc) {
        this.coursedesc = coursedesc;
    }
    public String getCourseroom() {
        return courseroom;
    }

    public void setCourseroom(String courseroom) {
        this.courseroom = courseroom;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", coursename=" + coursename +
            ", coursenum=" + coursenum +
            ", courseteacher=" + courseteacher +
            ", coursedate=" + coursedate +
            ", coursedesc=" + coursedesc +
            ", courseroom=" + courseroom +
            ", status=" + status +
        "}";
    }
}
