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
			System.out.println("데이터베이스 연결 성공");
		}catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}
	public static void main(String arg[]) throws SQLException{
		Connection con = makeConnection();
	}

}
