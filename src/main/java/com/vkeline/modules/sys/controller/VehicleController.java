package com.vkeline.modules.sys.controller;

import com.vkeline.common.customerDefAnno.customerDataPaser.DataPaserHandler;
import com.vkeline.common.customerDefAnno.customerDefLog.CustomerDefAnnoLog;
import com.vkeline.modules.sys.dao.VehicleDao;
import com.vkeline.modules.sys.entity.UserEntity;
import com.vkeline.modules.sys.entity.VehicleEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    DataPaserHandler<VehicleEntity> handler;

    @RequestMapping("/index")
    public void index() {

        VehicleEntity entity = vehicleDao.findVehicleEntityById("0101");
        System.out.println(entity);

        handler.handle(entity);

        System.out.println(entity);
    }
}
