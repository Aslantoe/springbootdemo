package com.example.mapper;


import com.example.entity.UserInfo;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


/**
 * 用户mapper
 * @author jack
 * @date 2018/4/20  16:28
 */
public interface UserMapper extends MyMapper<UserInfo> {

    /**
     * 根据姓名查找用户信息
     * @param name 姓名
     * @return 用户信息
     */
    @Select("SELECT * FROM userinfo u WHERE u.user_name = #{name}")
    @Results({
            @Result(id = true,property = "userId",column = "user_id"),
            @Result(property = "userNickName",column = "user_nickname"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPassword",column = "user_password"),
            @Result(property = "userSalt",column = "user_salt"),
            @Result(property = "userGender",column = "user_gender"),
            @Result(property = "userBirthday",column = "user_birthday"),
            @Result(property = "userCity",column = "user_city"),
            @Result(property = "userEmail",column = "user_email"),
            @Result(property = "userAvatar",column = "user_avatar"),
            @Result(property = "userState",column = "user_state")
    })
    UserInfo getUserInfoByUserName(@Param("name") String name);

    /**
     * 根据邮箱查找用户信息
     * @param email 邮箱
     * @return 用户信息
     */
    @Select("SELECT * FROM userinfo u WHERE u.user_email = #{email}")
    @Results({
            @Result(id = true,property = "userId",column = "user_id"),
            @Result(property = "userNickName",column = "user_nickname"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPassword",column = "user_password"),
            @Result(property = "userSalt",column = "user_salt"),
            @Result(property = "userGender",column = "user_gender"),
            @Result(property = "userBirthday",column = "user_birthday"),
            @Result(property = "userCity",column = "user_city"),
            @Result(property = "userEmail",column = "user_email"),
            @Result(property = "userAvatar",column = "user_avatar"),
            @Result(property = "userState",column = "user_state")
    })
    UserInfo getUserInfoByUserEmail(@Param("email") String email);


    @Select("SELECT * FROM userinfo u WHERE u.user_id = #{uid}")
    @Results({
            @Result(id = true,property = "userID",column = "user_id"),
            @Result(property = "userNickName",column = "user_nickname"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPassword",column = "user_password"),
            @Result(property = "userSalt",column = "user_salt"),
            @Result(property = "userGender",column = "user_gender"),
            @Result(property = "userBirthday",column = "user_birthday"),
            @Result(property = "userCity",column = "user_city"),
            @Result(property = "userEmail",column = "user_email"),
            @Result(property = "userAvatar",column = "user_avatar"),
            @Result(property = "userState",column = "user_state"),
            @Result(property = "roleList",column = "user_id",
                    many = @Many(select = "com.example.mapper.RoleMapper.getAllRolesByUid",fetchType = FetchType.LAZY))
    })
    UserInfo getUserInfoById(@Param("uid") Integer uid);

}
