package com.vkeline.common.customerDefAnno.customerDefLog;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomerDefAnnoLog {


    String operation() default "";     //操作（业务类型）

    String module() default "";     //模块

    String description() default "";    //描述
}
