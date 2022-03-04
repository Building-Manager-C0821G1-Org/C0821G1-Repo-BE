package com.c0821g1.sprint1.dto;

public class ChangePasswordDTO {
    private  int targetUserId;
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

    public ChangePasswordDTO(int targetUserId,String currentPassword, String newPassword, String confirmPassword) {
        this.targetUserId =targetUserId;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public ChangePasswordDTO() {
    }

    public int getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
