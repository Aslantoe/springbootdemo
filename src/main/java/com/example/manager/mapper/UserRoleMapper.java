package com.example.manager.mapper;

import com.example.manager.entity.UserRole;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jack
 */
public interface UserRoleMapper extends MyMapper<UserRole> {

}
