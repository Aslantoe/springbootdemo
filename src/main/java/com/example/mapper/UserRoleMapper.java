package com.example.mapper;

import com.example.entity.UserRole;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
    @Select("SELECT * FROM user_role ur WHERE ur.role_id = #{roleId}")
    @Results({
            @Result(property = "roleId",column = "role_id"),
            @Result(property = "userId",column = "user_id")
    })
    List<Integer> findUserIdByRoleId(@Param("roleId") Integer roleId);
}
