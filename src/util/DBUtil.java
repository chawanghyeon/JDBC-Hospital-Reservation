package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	static Properties sqlAll = new Properties();
	static Properties dbdriver = new Properties();
	
	static {
		try {
			sqlAll.load(new FileInputStream("allSql.properties"));
			dbdriver.load(new FileInputStream("dbinfo.properties"));
			Class.forName(dbdriver.getProperty("driver"));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(dbdriver.getProperty("url"),
											dbdriver.getProperty("id"), 
											dbdriver.getProperty("pw"));
	}
	
	public static Properties getSqlAll() {
		return sqlAll;
	}
	
	public static void close(Connection con, Statement stmt) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(rset != null) {
				rset.close();
				rset = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}



