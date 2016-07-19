package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ฺ�����ݿ�����Ӳ������ڽ��б������ʵ����ʱ�Զ��������ݿ�����Ӵ���
 * @author mldn
 */
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	private static final String DBUSER = "scott" ;
	private static final String PASSWORD = "tiger" ;
	private Connection conn = null ;
	/**
	 * �ڹ��췽������ʱ���������ݿ����Ӷ����ȡ��
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER) ;	// �������ݿ���������
			this.conn = DriverManager.getConnection(DBURL, DBUSER,PASSWORD) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ȡ�����ݿ����Ӷ���
	 * @return ʵ������Connection�����������null����ʾû�����ӳɹ�
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * �������ݿ�Ĺرղ���
	 */
	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
	}
}
