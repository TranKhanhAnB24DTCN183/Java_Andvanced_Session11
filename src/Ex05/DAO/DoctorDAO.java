package Ex05.DAO;
import Ex05.model.Doctor;
import Ex05.utils.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM Doctors";

        try (
                Connection con = DBContext.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("doctor_id"));
                d.setName(rs.getString("full_name"));
                d.setSpecialty(rs.getString("specialty"));
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 2. Thêm bác sĩ
    public void addDoctor(Doctor d) {
        String sql = "INSERT INTO Doctors(full_name, specialty) VALUES (?, ?)";

        try (
                Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, d.getName());
            ps.setString(2, d.getSpecialty());

            ps.executeUpdate();
            System.out.println("Thêm bác sĩ thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Thống kê chuyên khoa
    public void countBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) as total FROM Doctors GROUP BY specialty";

        try (
                Connection con = DBContext.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                System.out.println(
                        rs.getString("specialty") + " : " + rs.getInt("total")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}