import java.sql.*;
import java.io.*;

import javax.swing.JOptionPane;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.cin.ufpe.br:1521:Instance01", "g192if685cc_eq04", "lrldhcck");
		if(!con.isClosed()) {
			System.out.println("Connection Stabilished");
		}
		Statement pst = con.createStatement();
		//pst.executeQuery("CREATE TABLE teste (teste VARCHAR2(30))");
		pst.executeUpdate("DROP TABLE teste");
		ResultSet rs = pst.executeQuery("SELECT * FROM teste");
		ResultSetMetaData rsm = rs.getMetaData();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		con.close();
		
		
		

	}

}
