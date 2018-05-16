package com.example.manager.service;

import com.example.common.service.IService;
import com.example.manager.entity.User;
import com.example.manager.entity.UserWithRole;

import java.util.List;

/**
 * @author jack
 */
public interface UserService extends IService<User> {

    UserWithRole findById(Long userId);

    User findByName(String userName);

    List<User> findUserWithDept(User user);

    void registUser(User user);

    void updateTheme(String theme, String userName);

    void addUser(User user, Long[] roles);

    void updateUser(User user, Long[] roles);

    void deleteUsers(String userIds);

    void updateLoginTime(String userName);

    void updatePassword(String password);

    User findUserProfile(User user);

    void updateUserProfile(User user);

}
