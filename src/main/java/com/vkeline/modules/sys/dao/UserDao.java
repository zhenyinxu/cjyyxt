package com.vkeline.modules.sys.dao;

import com.vkeline.modules.sys.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String>{
    UserEntity findUserEntityByPassport(String name);
}
