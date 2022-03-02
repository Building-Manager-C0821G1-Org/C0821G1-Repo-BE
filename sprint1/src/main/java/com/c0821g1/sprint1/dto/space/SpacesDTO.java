package com.c0821g1.sprint1.dto.space;


import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.entity.space.SpacesStatus;
import com.c0821g1.sprint1.entity.space.SpacesType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


public class SpacesDTO {

    private int spaceId;
    private String spaceCode;
    private String spaceArea;
    private String spacePrice;
    private String spaceManagerFee;
    private String spaceNote;
    private String spaceImage;


    public SpacesDTO() {
    }

    public SpacesDTO(int spaceId, String spaceCode, String spaceArea, String spacePrice, String spaceManagerFee, String spaceNote, String spaceImage) {
        this.spaceId = spaceId;
        this.spaceCode = spaceCode;
        this.spaceArea = spaceArea;
        this.spacePrice = spacePrice;
        this.spaceManagerFee = spaceManagerFee;
        this.spaceNote = spaceNote;
        this.spaceImage = spaceImage;

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

}
