package conexion;

import com.ibm.as400.access.AS400JDBCDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class clConexion {
    public static Connection conectar(String server, String user, String password) {
        Connection conn = null;
        String ServerString = server;
        String UserString = user;
        String PassString = password;

        try {
            // Inicializacion del driver
            AS400JDBCDriver driver = new com.ibm.as400.access.AS400JDBCDriver();
            DriverManager.registerDriver(driver);

            // Conexion JDBC URL
            String url = "jdbc:as400://" +ServerString+ ";promt=true"; // Deshabilitar el GUI de la libreria jt400
            conn = DriverManager.getConnection(url, UserString, PassString);

            if (conn != null){
                System.out.println("Conectado a la base de datos "+ServerString);
            } else{
                System.out.println("Fallo la conexion al servidor "+ServerString);
            }

        } catch (SQLException e) {
            System.out.println("Fallo la conexion a la base de datos "+ServerString);
            e.printStackTrace();
        }

        return conn;
    }

}
