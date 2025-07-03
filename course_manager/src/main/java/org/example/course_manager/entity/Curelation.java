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
public class Curelation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String courseid;

    private String userid;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Curelation{" +
            "id=" + id +
            ", courseid=" + courseid +
            ", userid=" + userid +
            ", type=" + type +
        "}";
    }
}
