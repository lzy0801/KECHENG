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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleid;

    private String powerid;

    private String rolename;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
    public String getPowerid() {
        return powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid;
    }
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role{" +
            "roleid=" + roleid +
            ", powerid=" + powerid +
            ", rolename=" + rolename +
        "}";
    }
}
