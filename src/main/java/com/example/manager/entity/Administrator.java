package com.example.manager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jack
 * @date 2018/4/12  16:48
 */
public class Administrator implements Serializable {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private String adminEmail;
    private Date loginTime;
    private Date createTime;

    public Administrator() {
    }

    public Administrator(String adminName, String adminPassword, String adminEmail, Date loginTime, Date createTime) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
        this.loginTime = loginTime;
        this.createTime = createTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", loginTime=" + loginTime +
                ", createTime=" + createTime +
                '}';
    }
}
