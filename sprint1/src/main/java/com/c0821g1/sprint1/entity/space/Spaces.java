package com.c0821g1.sprint1.entity.space;


import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Spaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spaceId;
    private String spaceCode;
    private String spaceArea;
    private String spacePrice;
    private String spaceManagerFee;
    private String spaceNote;
    private String spaceImage;
    private Boolean spaceDeleteFlag;

    @ManyToOne
    @JoinColumn(name = "space_type_id",nullable = false)
    private SpacesType spacesType;

    @ManyToOne
    @JoinColumn(name = "space_status_id",nullable = false)
    private SpacesStatus spaceStatus;

    @ManyToOne
    @JoinColumn(name = "floor_id",nullable = false)
    private Floors floors;

    @OneToMany(mappedBy = "spaces")
    @JsonBackReference
    private List<Contract> contractList;


    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Floors getFloors() {
        return floors;
    }

    public void setFloors(Floors floors) {
        this.floors = floors;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(String spaceCode) {
        this.spaceCode = spaceCode;
    }

    public String getSpaceArea() {
        return spaceArea;
    }

    public void setSpaceArea(String spaceArea) {
        this.spaceArea = spaceArea;
    }

    public String getSpacePrice() {
        return spacePrice;
    }

    public void setSpacePrice(String spacePrice) {
        this.spacePrice = spacePrice;
    }

    public String getSpaceManagerFee() {
        return spaceManagerFee;
    }

    public void setSpaceManagerFee(String spaceManagerFee) {
        this.spaceManagerFee = spaceManagerFee;
    }

    public String getSpaceNote() {
        return spaceNote;
    }

    public void setSpaceNote(String spaceNote) {
        this.spaceNote = spaceNote;
    }

    public String getSpaceImage() {
        return spaceImage;
    }

    public void setSpaceImage(String spaceImage) {
        this.spaceImage = spaceImage;
    }

    public Boolean getSpaceDeleteFlag() {
        return spaceDeleteFlag;
    }

    public void setSpaceDeleteFlag(Boolean spaceDeleteFlag) {
        this.spaceDeleteFlag = spaceDeleteFlag;
    }

    public SpacesType getSpacesType() {
        return spacesType;
    }

    public void setSpacesType(SpacesType spacesType) {
        this.spacesType = spacesType;
    }

    public SpacesStatus getSpaceStatus() {
        return spaceStatus;
    }

    public void setSpaceStatus(SpacesStatus spaceStatus) {
        this.spaceStatus = spaceStatus;
    }
}
