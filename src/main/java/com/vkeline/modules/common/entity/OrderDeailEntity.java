package com.vkeline.modules.common.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_deail", schema = "cjyyxt", catalog = "")
public class OrderDeailEntity {
    private String id;
    private String orderId;
    private String serviceId;
    private String bespokeTime;
    private String vehicleId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "service_id")
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "bespoke_time")
    public String getBespokeTime() {
        return bespokeTime;
    }

    public void setBespokeTime(String bespokeTime) {
        this.bespokeTime = bespokeTime;
    }

    @Basic
    @Column(name = "vehicle_id")
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDeailEntity that = (OrderDeailEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(bespokeTime, that.bespokeTime) &&
                Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderId, serviceId, bespokeTime, vehicleId);
    }
}
