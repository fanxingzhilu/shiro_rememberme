package com.shiro.service.impl;

import com.shiro.dao.PermissionDao;
import com.shiro.entity.Permission;
import com.shiro.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao;

    public PermissionDao getPermissionDao() {
        return permissionDao;
    }

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
