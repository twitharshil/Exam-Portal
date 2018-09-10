package com.onlineportal.model;

public class Settinginfo {

	private String CurrentPassword;
	private String NewPassword;
	private String ConfirmPassword;
	public String getCurrentPassword() {
		return CurrentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		CurrentPassword = currentPassword;
	}
	public String getNewPassword() {
		return NewPassword;
	}
	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
}
