package com.vkeline.modules.common.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "exceptionlog", schema = "cjyyxt", catalog = "")
public class ExceptionlogEntity {
    private String id;
    private String linkAddress;
    private String exception;
    private Date time;
    private String type;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "link_address")
    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    @Basic
    @Column(name = "exception")
    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
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
        ExceptionlogEntity that = (ExceptionlogEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(linkAddress, that.linkAddress) &&
                Objects.equals(exception, that.exception) &&
                Objects.equals(time, that.time) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, linkAddress, exception, time, type);
    }
}
