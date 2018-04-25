package com.example.mapper;

import com.example.entity.Role;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jack
 * @date 2018/4/20  16:45
 */
public interface RoleMapper extends MyMapper<Role>{
    @Select("SELECT * FROM role r WHERE r.role_id IN (" +
            "(SELECT ur.role_id FROM user_role ur WHERE ur.user_id = #{uid}) )")
    @Results({
            @Result(id = true,property = "roleId",column = "role_id"),
            @Result(property = "roleId",column = "role_id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "roleDesc",column = "role_desc"),
            @Result(property = "roleAvailable",column = "role_available")
    })
    List<Role> queryRoleListWithSelected(@Param("uid") Integer uid);
    

}
