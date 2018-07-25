package com.vkeline.common.web.service.impl;

import com.vkeline.common.web.dao.CodeDao;
import com.vkeline.common.web.entity.CodeEntity;
import com.vkeline.common.web.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("codeService")
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeDao codeDao;

    @Override
    public CodeEntity findCodeEntityByCodekey(String codeKey) {
        return codeDao.findCodeEntityByCodeKey(codeKey);
    }
}
