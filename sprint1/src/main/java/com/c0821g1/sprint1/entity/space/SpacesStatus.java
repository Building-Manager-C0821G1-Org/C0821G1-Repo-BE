package com.c0821g1.sprint1.entity.space;


import javax.persistence.*;
import java.util.List;

@Entity
public class SpacesStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spaceStatusId;

    private String spacerStatusName;

    @OneToMany(mappedBy = "spaceStatus")
    private List<Spaces> spacesList;


    public SpacesStatus() {
    }


    public int getSpaceStatusId() {
        return spaceStatusId;
    }

    public void setSpaceStatusId(int spaceStatusId) {
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
