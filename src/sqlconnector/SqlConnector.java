package sqlconnector;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnector {

public static Connection connection;
private static String Drivde="org.sqlite.JDBC";

public static Connection connect() {
	
    // TODO Auto-generated method stub
	try {
	 // ��������,����sqlite��jdbc
            Class.forName(Drivde);
            //�������ݿ�, �������򴴽�
            connection=DriverManager.getConnection("jdbc:sqlite:db/musicsheet.db");
            //�������Ӷ�����Java��һ���������ݿ����Ҫ�ӿ�
 
	} catch (Exception e) {
            // TODO Auto-generated catch block
	        e.printStackTrace();
	}
	return connection;
       }

}