package utilities;

import dataaccess.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IndexGetter {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;
        
    public IndexGetter(){
        databaseConnection = new DataBaseConnection();
    }
    
    public int getActivityID(String name){
        int id = 0;
        connection = databaseConnection.getConnection();
        String query = "Select id_activity from activity where name = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            preparedStatement.setString(1, name);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            id = resultSet.getInt("id_activity");             
        } 
        
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return id;
    }
    
    public int getDocumentID(String filepath){
        int id = 0;
        connection = databaseConnection.getConnection();
        String query = "Select id_document from document where file_path = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            preparedStatement.setString(1, filepath);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            id = resultSet.getInt("id_document");             
        } 
        
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return id;
    }
    
    public int getManagerID(String name){
        int id = 0;
        connection = databaseConnection.getConnection();
        String query = "Select id_manager from manager where name = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            preparedStatement.setString(1, name);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            id = resultSet.getInt("id_manager");             
        } 
        
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return id;
    }
    
    public int getOrganizationID(String name){
        int id = 0;
        connection = databaseConnection.getConnection();
        String query = "Select id_organization from organization where name = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            preparedStatement.setString(1, name);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            id = resultSet.getInt("id_organization");             
        } 
        
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return id;
    }
    
    public int getProjectID(String name){
        int id = 0;
        connection = databaseConnection.getConnection();
        String query = "Select id_project from project where project_name = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            preparedStatement.setString(1, name);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            id = resultSet.getInt("id_project");             
        } 
        
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return id;
    }
    
    public int getReportID(String filepath){
        int id = 0;
        connection = databaseConnection.getConnection();
        String query = "Select id_report from report where filepath = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);  
            preparedStatement.setString(1, filepath);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            id = resultSet.getInt("id_report");             
        } 
        
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return id;
    }
}
