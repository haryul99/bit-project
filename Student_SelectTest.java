import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_SelectTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//connection����
		Connection conn = makeConnection();
		//statment ����
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
