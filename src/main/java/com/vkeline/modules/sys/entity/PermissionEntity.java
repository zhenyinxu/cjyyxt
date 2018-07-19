package com.vkeline.modules.sys.entity;


import javax.persistence.*;
import java.util.List;

/**
 *
 * 权限实体类
 */
@Entity
@Table(name = "t_permission")
public class PermissionEntity {

    @Id
    private  String id;     // id

    @Column(length=200)
    private String name;    // 名称

    @Column(length = 2000)
    private String description;  // 描述

    private String url;     // 地址


    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "t_permission_role", joinColumns = { @JoinColumn(name = "permissionId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<RoleEntity> roleList;// 一个用户具有多个角色

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }
}
