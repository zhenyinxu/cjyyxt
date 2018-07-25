package com.vkeline.common.web.dao;

import com.vkeline.common.web.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeDao extends JpaRepository<CodeEntity, String> {
    CodeEntity findCodeEntityByCodeKey(String codeKey);
}
