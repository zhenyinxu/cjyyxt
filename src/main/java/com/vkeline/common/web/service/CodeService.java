package com.vkeline.common.web.service;

import com.vkeline.common.web.entity.CodeEntity;

public interface CodeService {

    CodeEntity findCodeEntityByCodekey(String codeKey);
}
