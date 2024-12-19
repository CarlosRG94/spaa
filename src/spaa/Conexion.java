package spaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Conexion {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/dbspa";
	final String usuario = "root";
    final String contraseña = "1234";
    Connection dbConnection = null;
    PreparedStatement preparedStatement= null;
    
	
	public void insertar(ClienteModel cliente) throws SQLException {
		String insertSQL = "INSERT INTO clientes (nombre, correo, num_telefono, fecha_cita, hora, num_invitados) "
                + "VALUES (?, ?, ?, ?, ?, ?)"; // Usamos '?' como parámetros en lugar de valores literales

        try {
            // Cargar el driver de MySQL
            Class.forName(DRIVER);
            
            // Establecer la conexión
            dbConnection = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa");
            
            // Preparar la consulta para insertar datos
            preparedStatement = dbConnection.prepareStatement(insertSQL);
            
            // Establecer los parámetros de la consulta con los valores del objeto cliente
            preparedStatement.setString(1, cliente.getNombre()); // Primer parámetro es el nombre
            preparedStatement.setString(2, cliente.getCorreo()); // Segundo parámetro es el correo
            preparedStatement.setInt(3, cliente.getNum_telefono()); // Tercer parámetro es el número de teléfono
            preparedStatement.setString(4, cliente.getFecha_cita()); // Cuarto parámetro es la fecha de la cita
            preparedStatement.setString(5, cliente.getHora()); // Quinto parámetro es la hora de la cita
            preparedStatement.setInt(6, cliente.getNum_invitados()); // Sexto parámetro es el número de invitados
            
            // Ejecutar la actualización
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Filas insertadas: " + rowsAffected);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el driver de MySQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: Problema al conectar a la base de datos o insertar datos");
            e.printStackTrace();
        } finally {
            try {
                // Cerrar los recursos
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
	}



