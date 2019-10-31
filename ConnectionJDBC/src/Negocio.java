

public class Negocio {
	private Server server;
	
	public Negocio() {
		server = new Server();
	}
	
	public void createConnection() {
		server.openConnection();
	}

	public void closeConnection() {
		server.closeConnection();
	}

	public void onSELECT(String table, String[] names) {
		String query = "SELECT * FROM " + table;
		if (names.length > 0) {
			query += " WHERE ";
			for (int i = 0; i < names.length - 1; i++) {
				query += "nome = '" + names[i] + "' OR ";
			}
			query += "nome = '" + names[names.length - 1] + "'";
		}
		System.out.println(query);
		server.select(query);
	}
	
	public void onINSERT(String[] values) {
		String path = "../FilesToInsert" + values[2];
//		server.addAlbumMidia(values[0], values[1], path);
	}
	
	public void onDELETE(String table, String attribute, String value) {
		String query = "DELETE FROM " + table + " WHERE " + attribute + " = '" + value + "'";
		System.out.println(query);
//		server.delete(query);
	}
}
