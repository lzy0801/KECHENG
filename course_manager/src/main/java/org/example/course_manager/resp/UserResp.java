package org.example.course_manager.resp;


import org.example.course_manager.entity.User;

public class UserResp extends User {
    private String token; //验证信息

    public String power; //给用户分级，分权限

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}