import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase1 {

	public static Connection makeConnection() {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin@DESKTOP-5PMAV39:1521:XE";
		String id = "scott";
		String pwd = "tiger";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		}catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return con;
	}
	public static void main(String arg[]) throws SQLException{
		Connection con = makeConnection();
	}

}
