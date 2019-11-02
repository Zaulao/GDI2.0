import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Server {
	
	public String url = "jdbc:oracle:thin:@oracle12c.cin.ufpe.br:1521:Instance01";
	public String user = "g192if685cc_eq04";
	public String password = "lrldhcck";
	
	public Connection connection;
	public Statement stmt;
	
	public Server() {
		openConnection();
		// closeConnection();
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
	
	public void select(String query) {
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			formateResultado(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String query) {
		try {
			stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String query) {
		try {
			stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void formateResultado(ResultSet resultado) throws SQLException{
		ResultSetMetaData metadata = resultado.getMetaData();
	    int columnCount = metadata.getColumnCount();    
	    String row = "";
	    int count = 0;
	    for (int i = 1; i <= columnCount-1; i++) {
	    	System.out.print(metadata.getColumnName(i) + "|");
	        row += (metadata.getColumnName(i));
	    }
	    
	    count++;
	    while (resultado.next()) {
	        for (int i = 1; i <= columnCount-1; i++) {
	            System.out.print(resultado.getString(i) + "|");          
	        }
	        Blob aaa = resultado.getBlob(3);
			int tamanho = (int) aaa.length();
			byte[] data = aaa.getBytes(1, tamanho);
			JFrame frame = new JFrame (resultado.getString(1));
			
		    frame.setLocationRelativeTo(null);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    Toolkit tk = Toolkit.getDefaultToolkit();
		    Image icon = tk.createImage(data);
		    ImageIcon im = new ImageIcon(icon);
		    JLabel fotop = new JLabel();
		    fotop.setSize(icon.getWidth(null), icon.getHeight(null));
		    frame.setSize(fotop.getSize());
		    fotop.setIcon(im);
		    frame.add(fotop);
		    frame.setVisible(true);
			
		    System.out.println();
	    }
	    
    }
	
	public void addAlbumMidia(String name, int ano, String path) {
		String query = "INSERT INTO Album (nome, ano_lancamento, capa) VALUES (?,?,?)";
				PreparedStatement ps;
				try {
					ps = connection.prepareStatement(query);
					ps.setString(1, name);
					ps.setString(2, ""+ano);
					FileInputStream file = new FileInputStream(path);
					ps.setBinaryStream(3, file);
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
