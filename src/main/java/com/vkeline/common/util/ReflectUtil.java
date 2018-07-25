package com.vkeline.common.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * 反射工具
 */

public class ReflectUtil {

        /**
         * 入参：需要被操作的实体类以及需要被操作的字段
         *
         * @param entity
         * @param property
         * @return
         * @throws IntrospectionException
         */
        public static Object getFieldValue(Object entity,String property) throws IntrospectionException {
            Class<?> entityClass = entity.getClass();
            //获取这个字段
            PropertyDescriptor pd = new PropertyDescriptor(property, entityClass);
            Object value = null;
            //获取getter方法
            Method method = pd.getReadMethod();
            //如果是私有的字段，则需要将这个字段设置为可以反射操作的
            if(method.isAccessible()) {
                method.setAccessible(true);
            }
            //反射获取字段上的值
            if(Modifier.isPublic(method.getModifiers())){
                try {
                    value = method.invoke(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //TODO:如果getter方法没有获取到值，那么需要直接获取到值

            return value;
        }

    /**
     *
     * 入参：需要被修改的实体类、字段名、需修改成的值
     *
     * @param entity
     * @param field
     * @param value
     * @throws IntrospectionException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     */
        public static void setFieldValue(Object entity, Field field, Object value) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
            Class<?> entityClass = entity.getClass();
            //获取字段名
            String fieldName = field.getName();
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            //拼接出此字段值得setter方法并获取这个方法
            Method method = entityClass.getMethod("set" + fieldName,String.class);
            if(method.isAccessible()) {
                method.setAccessible(true);
            }
            //通过这个方法与入参修改这个字段的值
            method.invoke(entity, value);
        }

}
