package com.vkeline.modules.sys.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="t_user")
public class UserEntity {
    @Id
    private String ID;
    @Column(length = 200)
    private String name;    //用户名
    @Column(length = 200)
    private String passport;    //通行证
    @Column(length = 200)
    private String password;    //口令
    @Column(length = 50)
    private String type;    //人员类别
    @Column(length = 200)
    private String salt;    // 盐
    private Boolean deleteFlag;     //  用户是否被禁用

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "t_role_user", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<RoleEntity> roleList;// 一个用户具有多个角色


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }
}
