import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = makeConnection();
	}
	public static Connection makeConnection() {
		String url = "jdbc:oracle:thin:@DESKTOP-5PMAV39:1521:XE";
		String id = "scott";
		String pw = "tiger";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���缺��");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("�����ͺ��̽� ���� ����");
		}catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		}catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return con;
	}

}
