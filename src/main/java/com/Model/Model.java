package com.Model;

public class Model {
	private String Batch;
	private int Roll_No;
	private String Student_Name;
	private int Avg_Marks;
	private long Phone;
	private String Date;
	private int username;
	private Long password;

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public Long getPassword() {
		return password;
	}

	public void setPassword(Long password2) {
		password = password2;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		Phone = phone;
	}

	private String Email;

	public String getBatch() {
		return Batch;
	}

	public void setBatch(String batch) {
		Batch = batch;
	}

	public int getRoll_No() {
		return Roll_No;
	}

	public void setRoll_No(int roll_No) {
		Roll_No = roll_No;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}

	public int getAvg_Marks() {
		return Avg_Marks;
	}

	public void setAvg_Marks(int avg_Marks) {
		Avg_Marks = avg_Marks;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
}
