package com.vkeline.modules.sys.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "t_role")
public class RoleEntity {

    @Id
    private String id;  // id

    @Column(length  = 200)
    private String name;    // 名称

    @Column(length = 2000)
    private String description; // 描述


    //角色-权限对应关系
    @ManyToMany(fetch = FetchType.EAGER)    //立即从数据库加载数据
    @JoinTable(name = "t_role_permission",joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name="permissionId")})
    private List<PermissionEntity> permissionEntityList;

    @ManyToMany
    @JoinTable(name="t_role_user",joinColumns={@JoinColumn(name="roleId")},
            inverseJoinColumns={@JoinColumn(name="userId")})
    private List<UserEntity> UserEntityList;


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

    public List<PermissionEntity> getPermissionEntityList() {
        return permissionEntityList;
    }

    public void setPermissionEntityList(List<PermissionEntity> permissionEntityList) {
        this.permissionEntityList = permissionEntityList;
    }

    public List<UserEntity> getUserEntityList() {
        return UserEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        UserEntityList = userEntityList;
    }
}
