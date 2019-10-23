import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.cin.ufpe.br:1521:Instance01", "g192if685cc_eq04", "lrldhcck");
		if(!con.isClosed()) {
			System.out.println("Connection Stabilished");
		}
		Statement pst = con.createStatement();
		//pst.executeUpdate("DROP TABLE teste");
		//pst.executeQuery("CREATE TABLE teste (teste VARCHAR2(30), image BLOB)");
		
		//String query = "INSERT INTO teste (teste, image) VALUES (?,?)";
		//PreparedStatement pp = con.prepareStatement(query);
		//pp.setString(1, "to testanooooo");
		//FileInputStream fin = new FileInputStream("C:\\Users\\sgfl\\Downloads\\image.jpg");
		//pp.setBinaryStream(2, fin);
		//pp.execute();
		ResultSet rs = pst.executeQuery("SELECT * FROM teste");
		ResultSetMetaData rsm = rs.getMetaData();
		while(rs.next()) {
			System.out.println(rs.getString(1));
			Blob aaa = rs.getBlob(2);
			int tamanho = (int) aaa.length();
			byte[] baites = aaa.getBytes(1, tamanho);
			
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(baites));
			ImageIO.write(image, "JPEG", new File("C:\\Users\\sgfl\\Downloads\\oiiii.jpg"));
			System.out.println(aaa);
		}
		
		con.close();

	}

}
