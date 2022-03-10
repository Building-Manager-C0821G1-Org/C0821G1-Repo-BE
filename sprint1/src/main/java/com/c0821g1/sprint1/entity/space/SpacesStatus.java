package com.c0821g1.sprint1.entity.space;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "space_status")
public class SpacesStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "space_status_id",nullable = false)
    private int spaceStatusId;
    @JoinColumn(name = "space_status_name",nullable = false)
    private String spaceStatusName;


    @OneToMany(mappedBy = "spaceStatus")
    @JsonBackReference(value = "spaceStatus")
    private List<Spaces> spacesList;


    public SpacesStatus() {
    }


    public int getSpaceStatusId() {
        return spaceStatusId;
    }

    public void setSpaceStatusId(int spaceStatusId) {
        this.spaceStatusId = spaceStatusId;
    }

    public String getSpaceStatusName() {
        return spaceStatusName;
    }

    public void setSpaceStatusName(String spaceStatusName) {
        this.spaceStatusName = spaceStatusName;
    }

    public List<Spaces> getSpacesList() {
        return spacesList;
    }

    public void setSpacesList(List<Spaces> spacesList) {
        this.spacesList = spacesList;
    }
}
