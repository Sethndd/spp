package dataaccess;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class UserDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;
        
    public UserDAO(){
        databaseConnection = new DataBaseConnection();
    }
    
    public int insertUser(User user){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "insert into user values(?, ?, ?, ?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getIdUser());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getMiddlename());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.geteMail());
            preparedStatement.setString(7, user.getPhoneNumber());
            preparedStatement.setInt(8, user.getUserIDType());
            
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
    public User getUser(String idUser){
        User user = new User("Not found");
        connection = databaseConnection.getConnection();     
        String query = "Select * from user LEFT JOIN user_type ON user.id_type = user_type.id_type where id_user = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idUser);            
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            
            user = new User(
                resultSet.getString("id_user"), 
                resultSet.getString("name"),
                resultSet.getString("middlename"),
                resultSet.getString("lastname"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getString("type"));
                
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
        return user;
    }

    public int updateUser(User user){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "UPDATE user SET id_user = ?, name = ?, middlename = ?, lastname  = ?, password = ?, email = ?, phone_number = ?, id_type = ? WHERE id_user = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getIdUser());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getMiddlename());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.geteMail());
            preparedStatement.setString(7, user.getPhoneNumber());
            preparedStatement.setInt(8, user.getUserIDType());
            
            preparedStatement.setString(9, user.getIdUser());
          
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

    public int deleteUser(String idUser){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "DELETE FROM user WHERE id_user = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idUser);
            
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
