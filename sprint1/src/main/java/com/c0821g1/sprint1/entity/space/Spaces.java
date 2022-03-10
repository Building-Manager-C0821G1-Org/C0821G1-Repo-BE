package com.c0821g1.sprint1.entity.space;


//import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.floors.Floors;

import javax.persistence.*;
import java.util.List;

@Entity(name = "spaces")
public class Spaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "spaces_id",nullable = false)
    private int spaceId;
    @JoinColumn(name = "space_code",nullable = false)
    private String spaceCode;
    @JoinColumn(name = "space_area",nullable = false)
    private String spaceArea;
    @JoinColumn(name = "space_price",nullable = false)
    private String spacePrice;
    @JoinColumn(name = "space_manager_fee",nullable = false)
    private String spaceManagerFee;
    @JoinColumn(name = "space_note",nullable = false)
    private String spaceNote;
    @JoinColumn(name = "space_image",nullable = false)
    private String spaceImage;
    @JoinColumn(name = "delete_flag",nullable = false)
    private Boolean spaceDeleteFlag;

    @ManyToOne
    @JoinColumn(name = "space_type",nullable = false)
    private SpacesType spacesType;

    @ManyToOne
    @JoinColumn(name = "space_status",nullable = false)
    private SpacesStatus spaceStatus;

    @ManyToOne
    @JoinColumn(name = "floors",nullable = false)
    private Floors floors;

//    @OneToMany(mappedBy = "spaces")
//    private List<Contract> contractList;

    public Spaces() {
    }



//    public List<Contract> getContractList() {
//        return contractList;
//    }
//
//    public void setContractList(List<Contract> contractList) {
//        this.contractList = contractList;
//    }

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
