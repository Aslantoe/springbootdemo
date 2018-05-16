package com.example.manager.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author jack
 */
@Table(name = "t_user_role")
public class UserRole implements Serializable{
    private static final long serialVersionUID = 1945885123687610802L;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ROLE_ID")
    private Long roleId;

    /**
     * @return USER_ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return ROLE_ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
