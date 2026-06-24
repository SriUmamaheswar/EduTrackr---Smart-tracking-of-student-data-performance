package com.Model;

public class AttendanceModel {
	private String Batch;
	private String Roll_No;
	private String Marks;
	private String Email;
	private String Date;

	public String getDate() {
		return Date;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMarks() {
		return Marks;
	}

	public void setMarks(String marks) {
		Marks = marks;
	}

	public String getBatch() {
		return Batch;
	}

	public void setBatch(String batch) {
		Batch = batch;
	}

	public String getRoll_No() {
		return Roll_No;
	}

	public void setRoll_No(String roll_No2) {
		Roll_No = roll_No2;
	}



	public void setDate(String Date) {
		this.Date = Date;
	}


}
