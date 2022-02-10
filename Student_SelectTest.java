import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_SelectTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//connection리턴
		Connection conn = makeConnection();
		//statment 받음
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student");
		
//		ResultSet rs = stmt.executeQuery("select name, id from student");
		
		while (rs.next()) {
			System.out.println(rs.getString("sname"));
			System.out.println(rs.getString("sid"));
			System.out.println(rs.getString("did"));
		}
		conn.commit();
		rs.close();
	}
	public static Connection makeConnection() {
		String url = "jdbc:oracle:thin:@DESKTOP-5PMAV39:1521:XE";
		String id = "scott";
		String pw = "tiger";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재성공");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}

}
