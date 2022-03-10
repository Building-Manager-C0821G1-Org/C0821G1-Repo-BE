package com.c0821g1.sprint1.entity.floors;

import com.c0821g1.sprint1.entity.space.Spaces;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


@Entity(name = "floors")
public class Floors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "floor_id", nullable = false)
    private Integer floorId;
    @JoinColumn(name = "floor_code", nullable = false)
    private String floorCode;
    @JoinColumn(name = "floor_name", nullable = false)
    private String floorName;
    @JoinColumn(name = "floor_area", nullable = false)
    private Double floorArea;
    @JoinColumn(name = "floor_delete_flag", nullable = false)
    private Integer floorDeleteFlag;
    @JoinColumn(name = "floor_capacity", nullable = false)
    private Integer floorCapacity;


    @ManyToOne(targetEntity = FloorsType.class)
    @JoinColumn(name = "floor_type", nullable = false)
    private FloorsType floorsType;


    @ManyToOne(targetEntity = FloorsStatus.class)
    @JoinColumn(name = "floor_status", nullable = false)
    private FloorsStatus floorsStatus;


    @OneToMany(mappedBy = "floors", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<Spaces> spacesList;

    public Floors() {
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
