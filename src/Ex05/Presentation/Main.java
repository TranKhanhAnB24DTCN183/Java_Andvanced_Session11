package Ex05.Presentation;
import Ex05.Business.DoctorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.showAll();
                    break;

                case 2:
                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Chuyên khoa: ");
                    String spec = sc.nextLine();

                    service.add(name, spec);
                    break;

                case 3:
                    service.stats();
                    break;

                case 4:
                    System.out.println("Thoát!");
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}