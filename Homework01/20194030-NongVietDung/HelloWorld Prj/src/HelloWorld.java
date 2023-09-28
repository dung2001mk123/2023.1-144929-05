import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        // Tạo một đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập tên
        System.out.print("Nhập tên của bạn: ");
        String name = scanner.nextLine();

        // Đưa ra lời chào dựa trên tên
        System.out.println("Xin chào, " + name + "!");

        // Đóng đối tượng Scanner
        scanner.close();
    }
}
