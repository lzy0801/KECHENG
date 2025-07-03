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
public class Power implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String roleid;

    private String power;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Power{" +
            "id=" + id +
            ", roleid=" + roleid +
            ", power=" + power +
        "}";
    }
}
