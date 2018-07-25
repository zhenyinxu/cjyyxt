package com.vkeline.common.customerDefAnno.customerDataPaser;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPaser {

    String refProperty() default "";    // 指向的Entity属性
}
