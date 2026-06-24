package com.DAO;

import java.util.List;

import com.Model.AttendanceModel;
import com.Model.Model;

public interface AMSInterface {
	public boolean insertStudent(Model m);
	public boolean updateStudent(Model m);
	public boolean deleteStudent(Model m);
	List<Model> Students_Data(Model m);
	List<Model> studentData(Model m);
	List<AttendanceModel> GetAttendance(AttendanceModel m);
	Model getStudentByRollNo(int rollNo, String Batch);
	List<AttendanceModel> Attendance(AttendanceModel m);
	List<AttendanceModel> GetMarksData(AttendanceModel m);
}
