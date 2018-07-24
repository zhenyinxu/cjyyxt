package com.vkeline.modules.sys.controller;

import com.vkeline.common.customerDefAnno.customerDefLog.CustomerDefAnnoLog;
import com.vkeline.modules.sys.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/toLoginPage")
    public String toLoginPage() {
        return "/login";
    }


    //此处在方法上加上一个日志记录，提供给用户定义的东西为“操作（业务类型）”、“模块（业务模块）”、“描述”

    @CustomerDefAnnoLog(operation = "login",module = "userModule",description = "用户登录操作")
    @RequestMapping("/login")
    public String login(Model model, UserEntity userEntity) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getPassport(), userEntity.getPassword());
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return "/index";

        } catch (AuthenticationException e) {
            model.addAttribute("error", "验证失败");
            return "/login";
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

  /*  @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }*/
}
