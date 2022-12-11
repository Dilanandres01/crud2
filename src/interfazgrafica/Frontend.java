package interfazgrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Frontend extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JPanel contentPane;
	private JTextField cedula;
	private JTextField nombre;
	private JTextField sueldo;
	private JTextField apellido;

	/**
	 * Launch the application.
	 */
	Connection conexion = null;
	PreparedStatement  ps = null;
	ResultSet rs = null;
	private JTextField id;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frontend frame = new Frontend();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frontend() {
		
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(getBackground());
		conexion = Conexion.conectar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 500, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C.I");
		lblNewLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 128, 64));
		lblNewLabel.setBounds(61, 98, 34, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setBounds(186, 118, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("APELLIDO");
		lblNewLabel_1_1.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel_1_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1_1.setBounds(186, 179, 62, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SALARIO");
		lblNewLabel_1_1_1.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1_1_1.setBounds(49, 213, 46, 24);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CRUD PROGRAMACION:INFO PERSONAL");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Britannic Bold", Font.PLAIN, 22));
		lblNewLabel_1_1_2.setBounds(39, 11, 447, 24);
		panel.add(lblNewLabel_1_1_2);
		
		cedula = new JTextField();
		cedula.setBounds(10, 115, 121, 20);
		panel.add(cedula);
		cedula.setColumns(10);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(166, 143, 97, 24);
		panel.add(nombre);
		
		sueldo = new JTextField();
		sueldo.setColumns(10);
		sueldo.setBounds(10, 238, 121, 20);
		panel.add(sueldo);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(166, 195, 97, 24);
		panel.add(apellido);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarCasillas();
			}
		});
		btnNuevo.setBounds(322, 116, 72, 18);
		panel.add(btnNuevo);
		
		JButton btnActualizar = new JButton("personalizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datosactivos();
				LimpiarCasillas();
			}
		});
		btnActualizar.setBounds(310, 213, 91, 44);
		panel.add(btnActualizar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datosrecientes();
				LimpiarCasillas();
			}
		});
		btnGuardar.setBounds(322, 144, 72, 24);
		panel.add(btnGuardar);
		
		JButton btnBorrar = new JButton("Eliminar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datoseliminar();
				LimpiarCasillas();
			}
		});
		btnBorrar.setBounds(322, 179, 72, 24);
		panel.add(btnBorrar);
		
		id = new JTextField();
		id.setBounds(49, 63, 303, 20);
		panel.add(id);
		id.setColumns(10);
		
		JLabel ID = new JLabel("REGISTRO");
		ID.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		ID.setForeground(new Color(255, 128, 0));
		ID.setBounds(167, 46, 124, 14);
		panel.add(ID);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datosinvestigar();
			}
		});
		btnNewButton.setBounds(367, 62, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblElvisRamos = new JLabel("Dilan Mavarez");
		lblElvisRamos.setBackground(new Color(128, 128, 128));
		lblElvisRamos.setForeground(new Color(255, 255, 255));
		lblElvisRamos.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblElvisRamos.setBounds(336, 34, 109, 14);
		panel.add(lblElvisRamos);
	}
	
	public void LimpiarCasillas() {
		cedula.setText("");
		nombre.setText("");
		sueldo.setText("");
		apellido.setText("");
		id.setText("");
	}
	
	
	public void Datosrecientes() {
		try {
			ps = conexion.prepareStatement("Insert into datosdeinformacion (Cedula,Nombre,Apellido,Salario) values (?,?,?,?)");
			
			ps.setString(1, cedula.getText());
			ps.setString(2, nombre.getText());
			ps.setString(3, apellido.getText());
			ps.setDouble(4, Double.parseDouble(sueldo.getText()));
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Registro de datos Exitoso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Registro de datos Fallido, Error: "+e.getMessage());
		}
	}
	
	public void Datosinvestigar() {
		try {
			
			ps = conexion.prepareStatement("Select Cedula,Nombre,Apellido,Salario from datosdeinformacion where idDeRegistro=?");
			
			ps.setString(1, id.getText());
			
			rs= ps.executeQuery();
			
			if(rs.next()) {
				cedula.setText(rs.getString("Cedula"));
				nombre.setText(rs.getString("Nombre"));
				apellido.setText(rs.getString("Apellido"));
				sueldo.setText(rs.getString("Salario"));
			}else {
			
			JOptionPane.showMessageDialog(null, "Registro no encontrado");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al acceder a la base de datos, Error: "+e.getMessage());
		}
	}
	
	
	public void Datosactivos() {
		try {
			
			ps = conexion.prepareStatement("UPDATE datosdeinformacion SET Cedula=?,Nombre=?,Apellido=?,Salario=? where IdDeRegistro=?");
			
			
			ps.setString(1, cedula.getText());
			ps.setString(2, nombre.getText());
			ps.setString(3, apellido.getText());
			ps.setDouble(4, Double.parseDouble(sueldo.getText()));
			ps.setString(5, id.getText());
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Modificacion de datos Exitosa");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modificacion de datos Fallida, Error: "+e.getMessage());
		}
	}
	
	public void Datoseliminar() {
		try {
			
			ps = conexion.prepareStatement("Delete from datosdeinformacion where idDeRegistro=?");
			
			ps.setString(1, id.getText());
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro, Error: "+e.getMessage());
		}
	}
	
}