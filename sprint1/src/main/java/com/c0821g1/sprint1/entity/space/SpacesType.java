package com.c0821g1.sprint1.entity.space;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "space_type")
public class SpacesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "space_type_id",nullable = false)
    private int spaceTypeId;
    @JoinColumn(name = "space_type_name",nullable = false)
    private String spaceTypeName;


    @OneToMany(mappedBy = "spacesType", cascade =  CascadeType.ALL)
    @JsonBackReference
    private List<Spaces> spacesList;

    public SpacesType() {
    }

    public int getSpaceTypeId() {
        return spaceTypeId;
    }

    public void setSpaceTypeId(int spaceTypeId) {
        this.spaceTypeId = spaceTypeId;
    }

    public String getSpaceTypeName() {
        return spaceTypeName;
    }

    public void setSpaceTypeName(String spaceTypeName) {
        this.spaceTypeName = spaceTypeName;
    }

    public List<Spaces> getSpacesList() {
        return spacesList;
    }

    public void setSpacesList(List<Spaces> spacesList) {
        this.spacesList = spacesList;
    }

}
