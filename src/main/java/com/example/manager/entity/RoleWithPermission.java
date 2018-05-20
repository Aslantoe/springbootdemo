package com.example.manager.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author jack
 * @date 2018/5/17 0017 09:39
 */
public class RoleWithPermission extends Role implements Serializable{
    private static final long serialVersionUID = -463919755211083818L;

    private Long menuId;

    private List<Long> menuIds;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "RoleWithPermission{" +
                "menuId=" + menuId +
                ", menuIds=" + menuIds +
                '}';
    }
}
