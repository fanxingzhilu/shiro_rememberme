package com.shiro.service.impl;

import com.shiro.dao.UserDao;
import com.shiro.entity.User;
import com.shiro.service.UserService;
import com.shiro.util.PasswordHelper;

import java.util.Set;

public class UserServiceImpl implements UserService {
    private UserDao userDao ;
    private PasswordHelper passwordHelper;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public PasswordHelper getPasswordHelper() {
        return passwordHelper;
    }

    public void setPasswordHelper(PasswordHelper passwordHelper) {
        this.passwordHelper = passwordHelper;
    }

    public void createUser(User user) {
        passwordHelper.encryptPassword(user);
        userDao.createUser(user);
    }

    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId,roleIds);
    }

    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId,roleIds);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}
