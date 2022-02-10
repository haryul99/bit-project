import java.sql.SQLException;

public class DriverLoadTest {
	public static void makeConnerction() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			return;
		}
	}
	public static void main(String arg[]) throws SQLException{
		makeConnerction();
	}
}
