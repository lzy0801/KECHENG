package org.example.course_manager.req;

public class RoleReq {
    private String roleid;
    private String rolename;
    private String power;
    private String powerid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPowerid() {
        return powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid;
    }
}
