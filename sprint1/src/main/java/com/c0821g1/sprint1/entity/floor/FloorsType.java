package com.c0821g1.sprint1.entity.floor;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class FloorsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int floorTypeId;

    private String floorTypeName;

    @OneToMany(mappedBy = "floorsType")
    @JsonBackReference
    private List<Floors> floors;



    public int getFloorTypeId() {
        return floorTypeId;
    }

    public void setFloorTypeId(int floorTypeId) {
        this.floorTypeId = floorTypeId;
    }

    public String getFloorTypeName() {
        return floorTypeName;
    }

    public void setFloorTypeName(String floorTypeName) {
        this.floorTypeName = floorTypeName;
    }

    public List<Floors> getFloors() {
        return floors;
    }

    public void setFloors(List<Floors> floors) {
        this.floors = floors;
    }
}
