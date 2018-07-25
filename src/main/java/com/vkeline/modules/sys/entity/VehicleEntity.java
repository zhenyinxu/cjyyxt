package com.vkeline.modules.sys.entity;

import com.vkeline.common.customerDefAnno.customerDataPaser.DataPaser;

import javax.persistence.*;

@Entity
@Table(name="t_vehicle")
public class VehicleEntity {

    @Id
    private String id;
    @Column
    private String city;
    @Column
    private String type;

    @DataPaser(refProperty = "type")
    @Transient
    private String convertType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConvertType() {
        return convertType;
    }

    public void setConvertType(String convertType) {
        this.convertType = convertType;
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", type='" + type + '\'' +
                ", convertType='" + convertType + '\'' +
                '}';
    }
}
