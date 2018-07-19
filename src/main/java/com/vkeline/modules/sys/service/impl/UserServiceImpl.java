package com.vkeline.modules.sys.service.impl;

import com.vkeline.modules.sys.entity.UserEntity;
import com.vkeline.modules.sys.dao.UserDao;
import com.vkeline.modules.sys.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserEntity findUserEntityByPassport(String userName) {
        return userDao.findUserEntityByPassport(userName);
    }

}
