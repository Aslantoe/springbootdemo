package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author jack
 * @date 2018/4/20  15:07
 */
@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perms_id")
    private Integer permsId;
    @Column(name = "perms_desc")
    private String permsDesc;
    @Column(name = "perms_res_type")
    private String permsResType;
    @Column(name = "perms_res_url")
    private String permsResUrl;
    @Column(name = "perms_parent_id")
    private String permsParentId;
    @Column(name = "perms_parent_ids")
    private String permsParentIds;
    @Column(name = "perms_available")
    private Integer permsAvailable;


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
        return permsParentId;
    }

    public void setPermsParaentId(String permsParaentId) {
        this.permsParentId = permsParaentId;
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


    @Override
    public String toString() {
        return "Permission{" +
                "permsId=" + permsId +
                ", permsDesc='" + permsDesc + '\'' +
                ", permsResType='" + permsResType + '\'' +
                ", permsResUrl='" + permsResUrl + '\'' +
                ", permsParentId='" + permsParentId + '\'' +
                ", permsParentIds='" + permsParentIds + '\'' +
                ", permsAvailable=" + permsAvailable +
                '}';
    }
}
