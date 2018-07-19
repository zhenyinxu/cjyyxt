package com.vkeline.modules.common.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permission", schema = "cjyyxt", catalog = "")
public class PermissionEntity {
    private String permissionsId;
    private String identification;
    private String link;
    private String type;

    @Id
    @Column(name = "permissions_id")
    public String getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(String permissionsId) {
        this.permissionsId = permissionsId;
    }

    @Basic
    @Column(name = "identification")
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return Objects.equals(permissionsId, that.permissionsId) &&
                Objects.equals(identification, that.identification) &&
                Objects.equals(link, that.link) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(permissionsId, identification, link, type);
    }
}
