package Sistem;

import java.sql.*;

public class SQL {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/galeri";
    private static final String USER = "root";
    private static final String PASS = "1234";

    private Connection conn;
    private Statement stmt;

    public SQL() {
        try {
            setConn(DriverManager.getConnection(DB_URL, USER, PASS));
            stmt = getConn().createStatement();
            System.out.println("Bağlantı başarılı!");
        } catch (Exception e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }

    // ---------- SELECT ----------
    public ResultSet select(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Select hatası: " + e.getMessage());
            return null;
        }
    }

    // ---------- INSERT / UPDATE / DELETE ----------
    public int update(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Güncelleme hatası: " + e.getMessage());
            return -1;
        }
    }

    // ---------- KAPAT ----------
    public void close() {
        try {
            getConn().close();
        } catch (Exception e) {
            System.out.println("Kapatma hatası: " + e.getMessage());
        }
    }
    public Connection getConnection() { return getConn(); }

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
    
}




