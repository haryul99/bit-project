import java.sql.SQLException;

public class DriverLoadTest {
	public static void makeConnerction() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� ����");
		}catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
			return;
		}
	}
	public static void main(String arg[]) throws SQLException{
		makeConnerction();
	}
}
