package Ex03;

import Ex01.DBContext;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public void updateBedStatus(int inputId) {
        String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = " + inputId;

        try (
                Connection con = DBContext.getConnection();
                Statement stmt = con.createStatement();
        ) {
            int result = stmt.executeUpdate(sql);

            if (result > 0) {
                System.out.println("Đã cập nhật giường bệnh thành công!");
            } else {
                System.out.println("Không tìm thấy giường với ID = " + inputId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //executeUpdate() trả về số dòng bị ảnh hưởng
    //= 0 → không có dữ liệu thay đổi
    //Phải kiểm tra để tránh báo sai
}
