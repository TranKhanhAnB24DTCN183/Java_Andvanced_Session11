package Ex04;

import Ex01.DBContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public void searchPatient(String inputName) {
        // Loại bỏ ký tự nguy hiểm
        inputName = inputName.replace("'", "");
        inputName = inputName.replace("\"", "");
        inputName = inputName.replace(";", "");

        String sql = "SELECT * FROM Patients WHERE full_name = '" + inputName + "'";

        try (
                Connection con = DBContext.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("full_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Nối chuỗi → tạo SQL sai
    //'1'='1' luôn đúng → trả về toàn bộ dữ liệu
}
