package com.c0821g1.sprint1.entity.floors;

import com.c0821g1.sprint1.entity.space.Spaces;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
//@Table("floors")
@Entity()
public class Floors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer floorId;
    private String floorCode;
    private String floorName;
    private Double floorArea;
    private Integer floorCapacity;

    private Integer floorDeleteFlag;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "floor_type",nullable = false)
    private FloorsType floorsType;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "floor_status",nullable = false)
    private FloorsStatus floorsStatus;

    @OneToMany(mappedBy = "floors")
    private List<Spaces> spacesList;

    public Floors() {
    }

    public Floors(Integer floorId, String floorCode, String floorName, Double floorArea, Integer floorCapacity, Integer floorDeleteFlag, FloorsType floorsType, FloorsStatus floorsStatus, List<Spaces> spacesList) {
        this.floorId = floorId;
        this.floorCode = floorCode;
        this.floorName = floorName;
        this.floorArea = floorArea;
        this.floorCapacity = floorCapacity;
        this.floorDeleteFlag = floorDeleteFlag;
        this.floorsType = floorsType;
        this.floorsStatus = floorsStatus;
        this.spacesList = spacesList;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getFloorCapacity() {
        return floorCapacity;
    }

    public void setFloorCapacity(Integer floorCapacity) {
        this.floorCapacity = floorCapacity;
    }

    public Integer getFloorDeleteFlag() {
        return floorDeleteFlag;
    }

    public void setFloorDeleteFlag(Integer floorDeleteFlag) {
        this.floorDeleteFlag = floorDeleteFlag;
    }

    public FloorsType getFloorsType() {
        return floorsType;
    }

    public void setFloorsType(FloorsType floorsType) {
        this.floorsType = floorsType;
    }

    public FloorsStatus getFloorsStatus() {
        return floorsStatus;
    }

    public void setFloorsStatus(FloorsStatus floorsStatus) {
        this.floorsStatus = floorsStatus;
    }

    public List<Spaces> getSpacesList() {
        return spacesList;
    }

    public void setSpacesList(List<Spaces> spacesList) {
        this.spacesList = spacesList;
    }
}
