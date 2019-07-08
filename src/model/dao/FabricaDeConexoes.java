package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	public static Connection getConnection() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//dbc:mysql://localhost:3306/
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/CompreCertoEstoque?useTimezone=true&serverTimezone=UTC", "root", "Viadao01");			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
