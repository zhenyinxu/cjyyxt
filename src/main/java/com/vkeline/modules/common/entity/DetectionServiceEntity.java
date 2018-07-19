package com.vkeline.modules.common.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "detection_service", schema = "cjyyxt", catalog = "")
public class DetectionServiceEntity {
    private String id;
    private String companyId;
    private String companyName;
    private String serviceType;
    private Date startTime;
    private Date endTime;
    private String serviceTotal;
    private String status;
    private BigDecimal payment;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
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
    @Column(name = "service_type")
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "service_total")
    public String getServiceTotal() {
        return serviceTotal;
    }

    public void setServiceTotal(String serviceTotal) {
        this.serviceTotal = serviceTotal;
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
    @Column(name = "payment")
    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetectionServiceEntity that = (DetectionServiceEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(serviceType, that.serviceType) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(serviceTotal, that.serviceTotal) &&
                Objects.equals(status, that.status) &&
                Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, companyId, companyName, serviceType, startTime, endTime, serviceTotal, status, payment);
    }
}
