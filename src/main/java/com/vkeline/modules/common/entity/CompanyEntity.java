package com.vkeline.modules.common.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "cjyyxt", catalog = "")
public class CompanyEntity {
    private String companyId;
    private String companyName;
    private String type;
    private String profile;
    private String status;
    private String ownerwx;
    private String phone;
    private String address;
    private String coordinate;

    @Id
    @Column(name = "company_id")
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "profile")
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ownerwx")
    public String getOwnerwx() {
        return ownerwx;
    }

    public void setOwnerwx(String ownerwx) {
        this.ownerwx = ownerwx;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "coordinate")
    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(companyId, that.companyId) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(type, that.type) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(status, that.status) &&
                Objects.equals(ownerwx, that.ownerwx) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(coordinate, that.coordinate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(companyId, companyName, type, profile, status, ownerwx, phone, address, coordinate);
    }
}
