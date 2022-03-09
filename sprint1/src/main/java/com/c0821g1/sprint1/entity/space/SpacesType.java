package com.c0821g1.sprint1.entity.space;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class SpacesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spaceTypeId;

    private String spaceTypeName;

    @OneToMany(mappedBy = "spacesType")
    @JsonBackReference
    private List<Spaces> spacesList;

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
