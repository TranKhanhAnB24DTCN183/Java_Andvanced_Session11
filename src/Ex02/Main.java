package Ex02;

import Ex01.DBContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    static void main() {
        String sql ="SELECT medication_name, stock FORM Pharmacy";

        try(
                Connection con = DBContext.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        )

        {
            System.out.println("===== DANH MỤC THUỐC =====");

            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Thuốc: " + name + " | Tồn kho: " + stock);
            }

        } catch(
                Exception e)

        {
            e.printStackTrace();
        }
    }

    //if chỉ đọc 1 dòng
    // ResultSet.next() di chuyển con trở từng dòng
    // Muốn duyệt danh sách → phải dùng while
}
