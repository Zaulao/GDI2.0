import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;

public class Server {
	
	public String url = "jdbc:oracle:thin:@oracle12c.cin.ufpe.br:1521:Instance01";
	public String user = "g192if685cc_eq04";
	public String password = "lrldhcck";
	
	public Connection connection;
	public Statement stmt;
	
	public Server() {
		openConnection();
		closeConnection();
	}
	
	public void openConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
			stmt = connection.createStatement();
			if(!connection.isClosed()) {
				System.out.println("Connection Stabilished");
			}
			
		} catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addAlbumMidia(String name, String path) {
		String query = "INSERT INTO Album (nome, capa) VALUES (?,?)";
				PreparedStatement ps;
				try {
					ps = connection.prepareStatement(query);
					ps.setString(1, name);
					FileInputStream file = new FileInputStream(path);
					ps.setBinaryStream(2, file);
					ps.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

		//pst.executeUpdate("DROP TABLE teste");
		//pst.executeQuery("CREATE TABLE teste (teste VARCHAR2(30), image BLOB)");
		
		//String query = "INSERT INTO teste (teste, image) VALUES (?,?)";
		//PreparedStatement pp = con.prepareStatement(query);
		//pp.setString(1, "to testanooooo");
		//FileInputStream fin = new FileInputStream("C:\\Users\\sgfl\\Downloads\\image.jpg");
		//pp.setBinaryStream(2, fin);
		//pp.execute();
//		ResultSet rs = pst.executeQuery("SELECT * FROM teste");
//		ResultSetMetaData rsm = rs.getMetaData();
//		while(rs.next()) {
//			System.out.println(rs.getString(1));
//			Blob aaa = rs.getBlob(2);
//			int tamanho = (int) aaa.length();
//			byte[] baites = aaa.getBytes(1, tamanho);
//			
//			BufferedImage image = ImageIO.read(new ByteArrayInputStream(baites));
//			ImageIO.write(image, "JPEG", new File("C:\\Users\\sgfl\\Downloads\\oiiii.jpg"));
//			System.out.println(aaa);
//		}

}
