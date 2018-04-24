package com.example.mapper;

import com.example.entity.UserRole;
import com.example.util.MyMapper;
import java.util.List;

/**
 * @author jack
 * @date 2018/4/24  20:42
 */
public interface UserRoleMapper extends MyMapper<UserRole> {
    /**
     * 根据角色Id查找用户ID集合
     * @param roleId 角色ID
     * @return 用户Id集合
     */
    List<Integer> findUserIdByRoleId(Integer roleId);
}
