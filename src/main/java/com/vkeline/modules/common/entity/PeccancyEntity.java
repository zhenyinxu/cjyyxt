package com.vkeline.modules.common.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "peccancy", schema = "cjyyxt", catalog = "")
public class PeccancyEntity {
    private String id;
    private String vehicleId;
    private Date time;
    private String address;
    private String score;
    private String count;
    private BigDecimal fines;
    private String description;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vehicle_id")
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
    @Column(name = "score")
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Basic
    @Column(name = "count")
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Basic
    @Column(name = "fines")
    public BigDecimal getFines() {
        return fines;
    }

    public void setFines(BigDecimal fines) {
        this.fines = fines;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeccancyEntity that = (PeccancyEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(time, that.time) &&
                Objects.equals(address, that.address) &&
                Objects.equals(score, that.score) &&
                Objects.equals(count, that.count) &&
                Objects.equals(fines, that.fines) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, vehicleId, time, address, score, count, fines, description);
    }
}
