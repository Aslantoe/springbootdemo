package com.example.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author jack
 * @date 2018/4/20 0020 15:07
 */
public class Permission implements Serializable {
    private Integer permsId;
    private String permsDesc;
    private String permsResType;
    private String permsResUrl;
    private String permsParaentId;
    private String permsParentIds;
    private Integer permsAvailable;
    /**
     * 权限--角色关系:多对多
     */
    private List<Role> roles;

    public Integer getPermsId() {
        return permsId;
    }

    public void setPermsId(Integer permsId) {
        this.permsId = permsId;
    }

    public String getPermsDesc() {
        return permsDesc;
    }

    public void setPermsDesc(String permsDesc) {
        this.permsDesc = permsDesc;
    }

    public String getPermsResType() {
        return permsResType;
    }

    public void setPermsResType(String permsResType) {
        this.permsResType = permsResType;
    }

    public String getPermsResUrl() {
        return permsResUrl;
    }

    public void setPermsResUrl(String permsResUrl) {
        this.permsResUrl = permsResUrl;
    }

    public String getPermsParaentId() {
        return permsParaentId;
    }

    public void setPermsParaentId(String permsParaentId) {
        this.permsParaentId = permsParaentId;
    }

    public String getPermsParentIds() {
        return permsParentIds;
    }

    public void setPermsParentIds(String permsParentIds) {
        this.permsParentIds = permsParentIds;
    }

    public Integer getPermsAvailable() {
        return permsAvailable;
    }

    public void setPermsAvailable(Integer permsAvailable) {
        this.permsAvailable = permsAvailable;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permsId=" + permsId +
                ", permsDesc='" + permsDesc + '\'' +
                ", permsResType='" + permsResType + '\'' +
                ", permsResUrl='" + permsResUrl + '\'' +
                ", permsParaentId='" + permsParaentId + '\'' +
                ", permsParentIds='" + permsParentIds + '\'' +
                ", permsAvailable=" + permsAvailable +
                ", roles=" + roles +
                '}';
    }
}
