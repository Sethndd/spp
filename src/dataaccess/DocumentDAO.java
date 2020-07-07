package dataaccess;

import domain.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class DocumentDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;
      
    public DocumentDAO(){
        databaseConnection = new DataBaseConnection();
    }
    
    public int insertDocument(Document document){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "insert into document(file_path, upload_date, id_intern, id_type)"
                     + " values(?, ?, ?, ?);"; 
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, document.getFilePath());
            preparedStatement.setDate(2, document.getUploadDate());
            preparedStatement.setString(3, document.getIdIntern());
            preparedStatement.setInt(4, document.getDocumentType());

            affectedRows = preparedStatement.executeUpdate();
        }
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (NullPointerException ex){
            ExceptionLogger.notify(ex, className);
            System.out.println("Base de datos no disponible, contacte a administrador");
        }
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return affectedRows;
    }
    public Document getDocument(int idDocument){
        Document document = null;
        connection = databaseConnection.getConnection();
        String query = "Select * from document where id_document = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);    
            preparedStatement.setInt(1, idDocument);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            document = new Document(
                resultSet.getInt("id_document"), 
                resultSet.getString("file_path"),
                resultSet.getDate("upload_date"),
                resultSet.getString("id_intern"),
                resultSet.getInt("id_type"));                
        } 
        catch (SQLException ex){
            ExceptionLogger.notify(ex, this.getClass().getName());
        }
        finally{
            databaseConnection.closeConnection();
        }
        return document;
    }

    public int updateDocument(Document document){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "UPDATE document SET file_path = ?, upload_date = ?, id_intern = ?,"
                     + " id_type = ? WHERE id_document = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, document.getFilePath());
            preparedStatement.setDate(2, document.getUploadDate());
            preparedStatement.setString(3, document.getIdIntern());
            preparedStatement.setInt(4, document.getDocumentType());
            
            preparedStatement.setInt(5, document.getIdDocument());
          
            affectedRows = preparedStatement.executeUpdate();
        }
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (NullPointerException ex){
            ExceptionLogger.notify(ex, className);
            System.out.println("Base de datos no disponible, contacte a administrador");
        }
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return affectedRows;
    }
            
    public int deleteDocument(int idDocument){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "DELETE FROM document WHERE id_document = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idDocument);
            
            affectedRows = preparedStatement.executeUpdate();
        }
        catch (SQLException ex){    
            ExceptionLogger.notify(ex, className);
        } 
        catch (NullPointerException ex){
            ExceptionLogger.notify(ex, className);
            System.out.println("Base de datos no disponible, contacte a administrador");
        }
        catch (Exception ex){
            System.out.println("Algo salio mal, intente mas tarde");
            ExceptionLogger.notify(ex, className);
        }
        finally{
            databaseConnection.closeConnection();
        }
        return affectedRows;
    }   
}
