package com.DAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Model.AttendanceModel;
import com.Model.Model;

public class AttendanceDAO implements AMSInterface {
	boolean status = false;

	@Override
	public boolean insertStudent(Model m) {
		boolean status = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ams";
			String user = "root";
			String password = "root";
			String batch = m.getBatch();
			List<String> allowedTables = Arrays.asList("Batch62", "Batch63", "Batch64");
			if (!allowedTables.contains(batch)) {
				throw new IllegalArgumentException("Invalid batch name");
			}
			String query = "INSERT INTO " + batch
					+ " (Roll_No, Student_Name, Avg_Marks, Phone, Email) VALUES (?,?,?,?,?)";
			try (Connection con = DriverManager.getConnection(url, user, password);
					PreparedStatement ps = con.prepareStatement(query)) {
				ps.setInt(1, m.getRoll_No());
				ps.setString(2, m.getStudent_Name());
				ps.setInt(3, m.getAvg_Marks());
				ps.setLong(4, m.getPhone());
				ps.setString(5, m.getEmail());

				int n = ps.executeUpdate();
				if (n > 0) {
					status = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<AttendanceModel> GetAttendance(AttendanceModel m) {
		List<AttendanceModel> list = new ArrayList<>();
		File newFile = new File(
				"C:\\Users\\Mahesh Bonthu\\OneDrive\\Desktop\\Applications\\AMS\\src\\main\\databaseFiles\\"
						+ m.getBatch() + "\\" + m.getDate() + ".txt");
		String query = "SELECT Email FROM " + m.getBatch() + " WHERE Roll_No = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
					try (BufferedReader br = new BufferedReader(new FileReader(newFile));
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "root");
					PreparedStatement ps = con.prepareStatement(query)) {
				String line;
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if (line.isEmpty()) {
						System.out.println("Skipping empty line");
						continue;
					}
					String[] columns = line.split(",");
					for (String col : columns) {
						col = col.trim();
						if (col.isEmpty()) {
							System.out.println("Skipping empty column");
							continue;
						}
						try {
							String rollNo = (col);
							AttendanceModel model = new AttendanceModel();
							model.setRoll_No(rollNo);
							model.setBatch(m.getBatch());
							model.setDate(m.getDate());
							ps.setString(1, rollNo);
							try (ResultSet rs = ps.executeQuery()) {
								if (rs.next()) {
									model.setEmail(rs.getString("Email"));
								} else {
									model.setEmail("NOT FOUND");
								}
							}
							list.add(model);
						} catch (NumberFormatException e) {
							System.out.println("Invalid roll number: " + col);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<AttendanceModel> Attendance(AttendanceModel m) {
		List<AttendanceModel> list = new ArrayList<>();
		String filePath = "C:\\Users\\Mahesh Bonthu\\OneDrive\\Desktop\\Applications\\AMS\\src\\main\\databaseFiles\\"
				+ m.getBatch() + "\\" + m.getDate() + ".txt";
		File filee = new File(filePath);
		if (!filee.exists()) {
			try {
				if (filee.createNewFile()) {
					System.out.println("New file created: " + filee.getAbsolutePath());
					String Roll_No = m.getRoll_No();
					if (filee.canWrite()) {
						try (FileWriter writer = new FileWriter(filee)) {
							writer.write(Roll_No);
							System.out.println("Roll number written to file.");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("File is not writable.");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return list;
			}
		}
		return list;
	}

	@Override
	public boolean updateStudent(Model m) {
		status = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"UPDATE Batch62 SET Student_Name=?, Avg_Marks=?, Phone=?, Email=? WHERE Roll_No=?");
			ps.setString(1, m.getStudent_Name());
			ps.setInt(2, m.getAvg_Marks());
			ps.setLong(3, m.getPhone());
			ps.setString(4, m.getEmail());
			ps.setInt(5, m.getRoll_No());
			int n = ps.executeUpdate();
			if (n > 0) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Update Error: " + e);
		}
		return status;
	}

	@Override
	public boolean deleteStudent(Model m) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "root");
			PreparedStatement ps = con.prepareStatement("DELETE FROM Batch62 WHERE Roll_No = ?");
			ps.setInt(1, m.getRoll_No());

			int n = ps.executeUpdate();
			if (n > 0) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Delete Error: " + e);
		}
		return status;
	}

	@Override
	public List <Model> studentData(Model m) {
		List<Model> list = new ArrayList<>();
		Model mm = new Model();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "root");
			String query = "SELECT * FROM " + m.getBatch() + " WHERE Roll_No = ? AND Phone = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getUsername());
			ps.setLong(2, m.getPassword());
			ResultSet rs = ps.executeQuery();
			int c = 0;
			while (rs.next()) {
				int Roll_No = rs.getInt(1);
				String Srudent_Name = rs.getString(2);
				int Avg_Marks = rs.getInt(3);
				long Phone = rs.getLong(4);
				String Email = rs.getString(5);
				String Batch = m.getBatch();
				mm.setBatch(Batch);
				mm.setRoll_No(Roll_No);
				mm.setStudent_Name(Srudent_Name);
				mm.setAvg_Marks(Avg_Marks);
				mm.setPhone(Phone);
				mm.setEmail(Email);
				c++;
				list.add(mm);
			}
			if (c > 0) {
				status = true;

			} else {
				status = false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Model> Students_Data(Model mm) {
		List<Model> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "root");
			String query = "SELECT * FROM " + mm.getBatch();
			PreparedStatement ps = con.prepareStatement(query);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Model m = new Model();
					m.setRoll_No(rs.getInt(1));
					m.setStudent_Name(rs.getString(2));
					m.setAvg_Marks(rs.getInt(3));
					m.setPhone(rs.getLong(4));
					m.setEmail(rs.getString(5));
					list.add(m);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Model getStudentByRollNo(int rollNo, String Batch) {
		Model m = null; // declare once
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "root");
			String sql = "SELECT * FROM " + Batch + " WHERE Roll_No=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rollNo);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m = new Model();
				m.setRoll_No(rs.getInt("Roll_No"));
				m.setStudent_Name(rs.getString("Student_Name"));
				m.setAvg_Marks(rs.getInt("Avg_Marks"));
				m.setPhone(rs.getLong("Phone"));
				m.setEmail(rs.getString("Email"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<AttendanceModel> GetMarksData(AttendanceModel m) {
		List<AttendanceModel> list = new ArrayList<>();
		String filePath = "C:\\Users\\Mahesh Bonthu\\OneDrive\\Desktop\\Applications\\AMS\\src\\main\\databaseFiles\\"+m.getBatch()+"\\Marks\\"+m.getDate()+".txt";
		File filee = new File(filePath);
		if (!filee.exists()) {
			try {
				if (filee.createNewFile()) {
					System.out.println("New file created: " + filee.getAbsolutePath());
					String Marks = m.getMarks();
					if (filee.canWrite()) {
						try (FileWriter writer = new FileWriter(filee)) {
							writer.write(Marks);
							System.out.println("Roll number written to file.");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("File is not writable.");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			String query = "UPDATE " + m.getBatch() + " SET Avg_Marks = ? WHERE Roll_No = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (BufferedReader br = new BufferedReader(new FileReader(filee));
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "root");
					PreparedStatement ps = con.prepareStatement(query)) {
				String line;
				AttendanceModel model = new AttendanceModel();
				model.setBatch(m.getBatch());
				model.setDate(m.getDate());
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if (line.isEmpty()) {
						System.out.println("Skipping empty line");
						continue;
					}
					String[] columns = line.split(",");
					for (String col : columns) {
						String[] Roll_No = col.split("-");
						int count = 0;
						
						for(String RollNo: Roll_No) {
							count++;
							if(!(count==2)) {
								String RollNum = RollNo;
								System.out.println("__________________________________________");
								System.out.println("RollNo:"+RollNo);
								model.setRoll_No(RollNum);
							}
							else {
							String Marks = RollNo;
							model.setMarks(Marks);
							System.out.println("_____________________________________________________");
							System.out.println("Marks:"+Marks);
							}
						}
						
						String existedMarks = "SELECT Avg_Marks FROM " + model.getBatch() + " WHERE Roll_No = ?";
						PreparedStatement p = con.prepareStatement(existedMarks);
						p.setString(1, model.getRoll_No());
							try (ResultSet rs = p.executeQuery()) {
								if (rs.next()) {
									String Exist =(rs.getString("Avg_Marks"));
									int ex = Integer.parseInt(Exist);
									int avg = (ex+(Integer.parseInt(model.getMarks())))/2;
									String marksStr = Integer.toString(avg);
									model.setMarks(marksStr);
								} else {
									model.setEmail("NOT FOUND");
								}
							}
							list.add(model);
							ps.setString(1,model.getMarks());
							ps.setString(2,model.getRoll_No());
							ps.executeUpdate();
							}
				
							
							
						}}}catch(

	NumberFormatException e)
	{
		System.out.println("Invalid roll number: ");

	}catch(
	Exception e)
	{
			System.out.println("    ");
		}
}return list;}}