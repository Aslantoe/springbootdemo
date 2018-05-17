package com.example.manager.mapper;

import com.example.manager.entity.Role;
import com.example.manager.entity.RoleWithPermission;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jack
 */
public interface RoleMapper extends MyMapper<Role>{
    List<Role> findUserRole(String userName);

    List<RoleWithPermission> findById(Long roleId);

}
