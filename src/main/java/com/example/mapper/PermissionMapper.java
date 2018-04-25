package com.example.mapper;

import com.example.entity.Permission;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018/4/24 0024 20:37
 */
public interface PermissionMapper extends MyMapper<Permission> {
    @Select("<script>" +
            "SELECT * " +
            "FROM permission p LEFT JOIN role_permission rp " +
            "ON p.perms_id = rp.perms_id " +
            "LEFT JOIN user_role ur " +
            "ON rp.role_id = ur.role_id " +
            "<where>"+
            "<if test=\"uid != null \">ur.user_id = #{uid}</if> " +
            "<if test=\"type != null \"> AND p.perms_res_type = #{type}</if> " +
            "GROUP BY  p.perms_id"+
            "</where>"+
            "</script>")
    @Results({
            @Result(property = "permsId",column = "perms_id"),
            @Result(property = "permsDesc",column = "perms_desc"),
            @Result(property = "permsResType",column = "perms_res_type"),
            @Result(property = "permsResUrl",column = "perms_res_url"),
            @Result(property = "permsParentId",column = "perms_parent_id"),
            @Result(property = "permsParentIds",column = "perms_parent_ids"),
            @Result(property = "permsAvailable",column = "perms_available")
    })
    List<Permission> loadUserPermissions(Map<String,Object> map);


    @Select("SELECT *  " +
            "FROM permission p  " +
            "WHERE p.perms_id IN " +
            "(SELECT rp.perms_id " +
            " FROM role_permission rp " +
            " WHERE rp.role_id = #{rid} )")
    @Results({
            @Result(property = "permsId",column = "perms_id"),
            @Result(property = "permsDesc",column = "perms_desc"),
            @Result(property = "permsResType",column = "perms_res_type"),
            @Result(property = "permsResUrl",column = "perms_res_url"),
            @Result(property = "permsParentId",column = "perms_parent_id"),
            @Result(property = "permsParentIds",column = "perms_parent_ids"),
            @Result(property = "permsAvailable",column = "perms_available")
    })
    List<Permission> queryPermissionsListWithSelected(@Param("rid") Integer rid);
}
