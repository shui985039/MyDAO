package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 本类负责数据库的连接操作，在进行本类对象实例化时自动进行数据库的连接处理
 * @author mldn
 */
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	private static final String DBUSER = "scott" ;
	private static final String PASSWORD = "tiger" ;
	private Connection conn = null ;
	/**
	 * 在构造方法调用时将进行数据库连接对象的取得
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER) ;	// 加载数据库驱动程序
			this.conn = DriverManager.getConnection(DBURL, DBUSER,PASSWORD) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 取得数据库连接对象
	 * @return 实例化的Connection对象，如果返回null，表示没有连接成功
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * 进行数据库的关闭操作
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
