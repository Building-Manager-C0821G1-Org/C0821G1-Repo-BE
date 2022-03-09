package com.c0821g1.sprint1.entity.space;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class SpacesType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spaceTypeId;

    private String spaceTypeName;

    @OneToMany(mappedBy = "spacesType")
    @JsonBackReference
    private List<Spaces> spacesList;

    public SpacesType() {
        //contructor
    }

    public Integer getSpaceTypeId() {
        return spaceTypeId;
    }

    public void setSpaceTypeId(Integer spaceTypeId) {
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
