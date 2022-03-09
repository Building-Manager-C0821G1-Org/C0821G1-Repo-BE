package com.c0821g1.sprint1.entity.space;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SpacesStatus  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spaceStatusId;

    private String spacerStatusName;

    @OneToMany(mappedBy = "spaceStatus")
    @JsonBackReference
    private List<Spaces> spacesList;


    public SpacesStatus() {
        //contructor
    }

    public Integer getSpaceStatusId() {
        return spaceStatusId;
    }

    public void setSpaceStatusId(Integer spaceStatusId) {
        this.spaceStatusId = spaceStatusId;
    }

    public String getSpacerStatusName() {
        return spacerStatusName;
    }

    public void setSpacerStatusName(String spacerStatusName) {
        this.spacerStatusName = spacerStatusName;
    }

    public List<Spaces> getSpacesList() {
        return spacesList;
    }

    public void setSpacesList(List<Spaces> spacesList) {
        this.spacesList = spacesList;
    }
}
