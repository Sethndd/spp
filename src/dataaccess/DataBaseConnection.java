package dataaccess;

import utilities.datastructure.DataBaseCredentials;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilities.AccessCredentialsController;
import utilities.ExceptionLogger;

public class DataBaseConnection {
    private Connection connection = null;    
    private DataBaseCredentials credentials = null;

    public void startConnection(){ 
        credentials = AccessCredentialsController.readDataBaseCredentials();
        try{
            connection = DriverManager.getConnection("jdbc:mysql://" + credentials.getAddress()
                        + ":" + credentials.getPort() +"/spp?useUnicode=yes&characterEncoding=UTF-8",
                        credentials.getUser(), credentials.getPassword());
        }
        catch(SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
    }
    
    public Connection getConnection(){
        startConnection();
        return connection;
    }
    
    public void closeConnection(){ 
        if (connection != null) {
            try{
                if(!connection.isClosed()){
                    connection.close();
                }
            }
            catch(SQLException ex){
                ExceptionLogger.notify(ex, this.getClass().getName());
            }
        }
    }  
}