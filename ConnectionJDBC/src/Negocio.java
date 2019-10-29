

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

	public String[] onSELECT(String[] attributes, String table, String[] selectBy, String[] values) {
		String query = "SELECT ";
		for (int i = 0; i < attributes.length - 1; i++) {
			query += attributes[i] + ", ";
		}
		query += attributes[attributes.length - 1] + " FROM " + table + " table";
		query += "WHERE "; 
		for (int i = 0; i < selectBy.length - 1; i++) {
			query += "table." + selectBy[i] + " = " + values[i] + ", ";
		}
		query += "table." + selectBy[selectBy.length - 1] + " = " + values[selectBy.length - 1]; 
		return server.select(query);
	}
	
	public void onINSERT(String table, String[] attributes, String[] values) {
		String query = "INSERT INTO " + table + " (";
		for (int i = 0; i < attributes.length - 1; i++) {
			query += attributes[i] + ", ";
		}
		query += attributes[attributes.length - 1] + ") VALUES (";
		for (int i = 0; i < attributes.length - 1; i++) {
			query += values[i] + ", ";
		}
		query += values[attributes.length - 1] + ")";
		server.insert(query);
	}
	
	public void onDELETE(String table, String[] attributes, String[] values) {
		String query = "DELETE FROM " + table + " WHERE ";
		query += attributes[0] + " = " + values[0];
		for(int i = 1; i < attributes.length; i++) {
			query += " AND " + attributes[i] + " = " + values[i];
		}
		server.delete(query);
	}
}
