package com.c0821g1.sprint1.dto.space;


import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.entity.space.SpacesStatus;
import com.c0821g1.sprint1.entity.space.SpacesType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


public class SpacesDTO {

    private int spaceId;

    @NotBlank (message = "Mã mặt bằng không được để trống")
    private String spaceCode;

    @NotBlank (message = "Diện tích không được để trống")
    private String spaceArea;
    private String spacePrice;
    private String spaceManagerFee;
    private String spaceNote;
    private String spaceImage;
    private boolean spaceDeleteFlag;

//    @NotBlank (message = "Tầng không được để trống")
    private int floorId;

//    @NotBlank (message = "Loại mặt bằng không được để trống")
    private int spaceTypeId;

//    @NotBlank (message = "Trạng thái không được để trống")
    private int spaceStatusId;

    public SpacesDTO() {
    }

    public SpacesDTO(int spaceId, String spaceCode, String spaceArea, String spacePrice, String spaceManagerFee, String spaceNote, String spaceImage, boolean spaceDeleteFlag, int floorId, int spaceTypeId, int spaceStatusId) {
        this.spaceId = spaceId;
        this.spaceCode = spaceCode;
        this.spaceArea = spaceArea;
        this.spacePrice = spacePrice;
        this.spaceManagerFee = spaceManagerFee;
        this.spaceNote = spaceNote;
        this.spaceImage = spaceImage;
        this.spaceDeleteFlag = spaceDeleteFlag;
        this.floorId = floorId;
        this.spaceTypeId = spaceTypeId;
        this.spaceStatusId = spaceStatusId;
    }

    public boolean getSpaceDeleteFlag() {
        return spaceDeleteFlag;
    }

    public void setSpaceDeleteFlag(boolean spaceDeleteFlag) {
        this.spaceDeleteFlag = spaceDeleteFlag;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getSpaceTypeId() {
        return spaceTypeId;
    }

    public void setSpaceTypeId(int spaceTypeId) {
        this.spaceTypeId = spaceTypeId;
    }

    public int getSpaceStatusId() {
        return spaceStatusId;
    }

    public void setSpaceStatusId(int spaceStatusId) {
        this.spaceStatusId = spaceStatusId;
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
