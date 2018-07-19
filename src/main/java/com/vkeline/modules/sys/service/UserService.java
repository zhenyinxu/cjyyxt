package com.vkeline.modules.sys.service;

import com.vkeline.modules.sys.entity.UserEntity;

public interface UserService {

    UserEntity findUserEntityByPassport(String userName);

}
