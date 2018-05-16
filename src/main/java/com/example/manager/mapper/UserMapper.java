package com.example.manager.mapper;


import com.example.manager.entity.User;
import com.example.manager.entity.UserWithRole;
import com.example.util.MyMapper;


import java.util.List;


/**
 * 用户mapper
 * @author jack
 */
public interface UserMapper extends MyMapper<User> {

    List<UserWithRole> findUserWithRole(Long userId);

    User findUserProfile(User user);

  /*  *//**
     * 根据姓名查找用户信息
     * 没有用到，用了tk.mybatis封装好的方法。---可以通过写sql语句来扩展复杂的操作
     * @param name 姓名
     * @return 用户信息
     *//*
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
    User getUserInfoByUserName(@Param("name") String name);

    *//**
     * 根据邮箱查找用户信息
     * @param email 邮箱
     * @return 用户信息
     *//*
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
    User getUserInfoByUserEmail(@Param("email") String email);


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
                    many = @Many(select = "RoleMapper.getAllRolesByUid",fetchType = FetchType.LAZY))
    })
    User getUserInfoById(@Param("uid") Integer uid);*/

}
