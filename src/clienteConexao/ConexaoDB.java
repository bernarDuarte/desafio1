package clienteConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDB {
    static final String URL = "jdbc:mysql://localhost:3306/cliente";
    static final String USER ="root";
    static final String PASS ="";
    
    public static Connection conectaDB(){
        Connection connection = null;
        
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
        }catch(SQLException e){
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE,null,e);
        }
        return connection;
    }
}

