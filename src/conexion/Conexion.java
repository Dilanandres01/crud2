package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	
	
	public static Connection conectar(){
		Connection conexion=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/informacion","root","");
			
			JOptionPane.showMessageDialog(null, "Conexion Exitosa");
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error de conexion "+ e.getMessage());
			
		}
		return conexion;
	}

}
