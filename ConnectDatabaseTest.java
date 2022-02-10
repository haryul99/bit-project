import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabaseTest {
	  public static Connection makeConnection() {

	      String url = "jdbc:oracle:thin:@DESKTOP-5PMAV39:1521:XE";
	      //listener.ora 에 있는 나의 host address
	      String id = "scott";
	      String pwd = "tiger";
	      Connection conn = null;

	      try {
	         conn = DriverManager.getConnection(url, id, pwd);
	         System.out.println("데이터베이스 연결 성공");
	      } catch (SQLException e) {
	         System.out.println("연결에 실패하였습니다.");
	      }
	      return conn;
	   }

	   public static void main(String[] args) throws SQLException{
	      Connection con = makeConnection();
	      //연결할 땐 sql exit; 상태여야함
	   }

	}
