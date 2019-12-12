package sqlconnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui.MusicList;
import net.JsonGeter;


public class SheetAdmin {
	
	public static Connection conn;
	public static Statement statement; 
	/**
	 * �������ݿ�
	 * @throws SQLException
	 */
	public static void creatDB() throws SQLException {
		
		conn=SqlConnector.connect();
		statement=(Statement) conn.createStatement();
		
		String sql="create table musicsheets("
				+ "listuuid varchar(20),"
				+ "listName varchar(20),"
				+ "creator  varchar(20),"
				+ "createDate varchar(20),"
				+ "songPictrue varchar(20))"; 

		statement.executeUpdate("drop table if exists musicsheets");
		statement.executeUpdate(sql); 
	}
	
	/**
	 * ��������
	 * @throws Exception 
	 */
	private static void insertdata() throws Exception {
		MusicList.a=JsonGeter.jsonToMap();
		
		for (int i = 0; i < MusicList.a.length; i++) {
			MusicList.a[i].getName().replace(' ', '\'');
			
			String insetString="insert into musicsheets values("
				+ "\'"+MusicList.a[i].getlistid()+"\',"
				//+ "\'"+MusicList.a[i].getName()+"\',"
				+ "\'"+MusicList.a[i].getCreatorId()+"\',"
				+ "\'"+MusicList.a[i].getCreator()+"\',"
				+ "\'"+MusicList.a[i].getDateCreated()+"\',"
				+ "\'"+MusicList.a[i].getPicture()+"\')";
			System.out.println(insetString);
			statement.executeUpdate(insetString);
		}
		
		
		
		ResultSet rSet=statement.executeQuery("select*from musicsheets");
		while (rSet.next()) {            
		          	 //������� Ҳ��������д rSet.getString(��name��)
			System.out.println(rSet.getString(1));
			System.out.println(rSet.getString(2));
		          	System.out.println(rSet.getString(3));
		          	System.out.println(rSet.getString(4));
		          	System.out.println(rSet.getString(5));
		          	
		           }
		
	}
	
	public static void main(String[] args) throws Exception {
		creatDB();
		insertdata();
	}
	
	/* 
           
           String sql="create table tables(name varchar(20),pwd varchar(20))"; 
           //�ж��Ƿ��б�tables�Ĵ��ڡ�����ɾ��
           statement.executeUpdate("drop table if exists tables");
           //�������ݿ�
           statement.executeUpdate(sql); 
           //�����ݿ��в�������
           statement.executeUpdate("insert into tables values('zhou','156546')");
           //�������ݿ⣬�������ķ������ݼ�ResultSet��
           ResultSet rSet=statement.executeQuery("select*from tables");
           //����������ݼ�
           while (rSet.next()) {            
          	 //������� Ҳ��������д rSet.getString(��name��)
          	 System.out.println("������"+rSet.getString(1));
          	 System.out.println("���룺"+rSet.getString("pwd"));
           }
           rSet.close();//�ر����ݼ�
           connection.close();//�ر����ݿ�����*/

}
