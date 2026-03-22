package Ex01;

import java.sql.*;

public class DBContext {
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASS = "trankhanhan8506";

    // Lấy connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Đóng connection an toàn
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayPatients() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBContext.getConnection();
            stmt = con.createStatement();

            String sql = "SELECT * FROM Patients";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("patient_id") + " - " +
                                rs.getString("full_name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                DBContext.closeConnection(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Không đóng connection -> leak -> quá tải -> timeout -> lỗi Communication link failure
    //Ảnh hướng nghiêm trọng đến hệ thống

}