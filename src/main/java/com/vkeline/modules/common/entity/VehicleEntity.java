package com.vkeline.modules.common.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "vehicle", schema = "cjyyxt", catalog = "")
public class VehicleEntity {
    private String vehicleId;
    private String hphm;
    private String vin;
    private String vinlater;
    private String hpzl;
    private String qdlx;
    private String owner;
    private String phone;
    private String cllx;
    private String ownerwx;
    private String userId;
    private Date testTime;

    @Id
    @Column(name = "vehicle_id")
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "hphm")
    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    @Basic
    @Column(name = "vin")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Basic
    @Column(name = "vinlater")
    public String getVinlater() {
        return vinlater;
    }

    public void setVinlater(String vinlater) {
        this.vinlater = vinlater;
    }

    @Basic
    @Column(name = "hpzl")
    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }

    @Basic
    @Column(name = "qdlx")
    public String getQdlx() {
        return qdlx;
    }

    public void setQdlx(String qdlx) {
        this.qdlx = qdlx;
    }

    @Basic
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
    @Column(name = "cllx")
    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx;
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
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "test_time")
    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(hphm, that.hphm) &&
                Objects.equals(vin, that.vin) &&
                Objects.equals(vinlater, that.vinlater) &&
                Objects.equals(hpzl, that.hpzl) &&
                Objects.equals(qdlx, that.qdlx) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(cllx, that.cllx) &&
                Objects.equals(ownerwx, that.ownerwx) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(testTime, that.testTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vehicleId, hphm, vin, vinlater, hpzl, qdlx, owner, phone, cllx, ownerwx, userId, testTime);
    }
}
