import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabaseTest {
	  public static Connection makeConnection() {

	      String url = "jdbc:oracle:thin:@DESKTOP-5PMAV39:1521:XE";
	      //listener.ora �� �ִ� ���� host address
	      String id = "scott";
	      String pwd = "tiger";
	      Connection conn = null;

	      try {
	         conn = DriverManager.getConnection(url, id, pwd);
	         System.out.println("�����ͺ��̽� ���� ����");
	      } catch (SQLException e) {
	         System.out.println("���ῡ �����Ͽ����ϴ�.");
	      }
	      return conn;
	   }

	   public static void main(String[] args) throws SQLException{
	      Connection con = makeConnection();
	      //������ �� sql exit; ���¿�����
	   }

	}
