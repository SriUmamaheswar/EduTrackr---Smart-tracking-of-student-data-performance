package com.Model;

public class StudentModel {
	private int username;
	private String password;
	String Batch;
	public String getBatch() {
		return Batch;
	}
	public void setBatch(String batch) {
		Batch = batch;
	}
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		this.password = password;
		return password;
	}
}
