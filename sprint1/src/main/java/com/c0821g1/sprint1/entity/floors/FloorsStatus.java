package com.c0821g1.sprint1.entity.floors;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = ("floor_status"))
public class FloorsStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "floor_status_id", nullable = false)
    private Integer floorStatusId;
    @JoinColumn(name = "floor_status_name", nullable = false)
    private String floorStatusName;

    @OneToMany(mappedBy = "floorsStatus")
    @JsonBackReference
    private List<Floors> floorsList;

    public FloorsStatus() {
    }

    public Integer getFloorStatusId() {
        return floorStatusId;
    }

    public void setFloorStatusId(Integer floorStatusId) {
        this.floorStatusId = floorStatusId;
    }

    public String getFloorStatusName() {
        return floorStatusName;
    }

    public void setFloorStatusName(String floorStatusName) {
        this.floorStatusName = floorStatusName;
    }

    public List<Floors> getFloorsList() {
        return floorsList;
    }

    public void setFloorsList(List<Floors> floorsList) {
        this.floorsList = floorsList;
    }
}
