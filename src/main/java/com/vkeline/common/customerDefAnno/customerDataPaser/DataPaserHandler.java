package com.vkeline.common.customerDefAnno.customerDataPaser;

import com.vkeline.common.util.ReflectUtil;
import com.vkeline.common.web.entity.CodeEntity;
import com.vkeline.common.web.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Component
public class DataPaserHandler<E> {

    @Autowired
    private CodeService codeService;

    public void handle(E e){

        if(e != null){
                //获取到此类型的每一个字段
                Field[] fields = e.getClass().getDeclaredFields();
                if(fields != null && fields.length > 0){
                    for (Field field : fields){
                        //此字段上存在指定注解接口中的注解
                        if(field.isAnnotationPresent(DataPaser.class)){
                            //得到此指定注解上的注解内容
                            DataPaser annotation = field.getAnnotation(DataPaser.class);
                            //注解指向的属性
                            String ref = annotation.refProperty();
                            try {
                                //注解指向属性的值
                                String fieldValue = (String) ReflectUtil.getFieldValue(e, ref);

                                //通过这个值去字典表中查出字典码对应的信息
                                CodeEntity codeEntity = codeService.findCodeEntityByCodekey(fieldValue);
                                //将db中得到的信息作为此注解着的值
                                ReflectUtil.setFieldValue(e,field,codeEntity.getCodeName());

                            } catch (IntrospectionException e1) {
                                e1.printStackTrace();
                            } catch (IllegalAccessException e1) {
                                e1.printStackTrace();
                            } catch (InvocationTargetException e1) {
                                e1.printStackTrace();
                            } catch (NoSuchMethodException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }
                }
            }
    }
}
