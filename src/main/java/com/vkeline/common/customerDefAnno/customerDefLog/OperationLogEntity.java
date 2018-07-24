package com.vkeline.common.customerDefAnno.customerDefLog;

import java.util.Date;

public class OperationLogEntity {

    private String id;      //id

    private String methodName;  //方法名

    private String argList;     //参数列表以“，”拼接

    private String path;    //路径

    private String currentUser;     //当前用户

    private String currentIp;   //当前ip地址

    private Date currentDate;   //当前日期

    /**
     *
     * 以下是需要在注解中定义的
     */

    private String operationName;   //操作名称（业务类型）

    private String moduleName;      //模块名称

    private String description;     //描述



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArgList() {
        return argList;
    }

    public void setArgList(String argList) {
        this.argList = argList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getCurrentIp() {
        return currentIp;
    }

    public void setCurrentIp(String currentIp) {
        this.currentIp = currentIp;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
