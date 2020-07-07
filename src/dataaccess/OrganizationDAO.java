package dataaccess;

import domain.Organization;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilities.ExceptionLogger;

public class OrganizationDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;

    public OrganizationDAO(){
        databaseConnection = new DataBaseConnection();
    }
    
    public int insertOrganization(Organization organization){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "insert into organization(name, sector, email, phone_number, id_state, city, address)"
                     + " values(?, ?, ?, ?, ?, ?, ?);"; 
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, organization.getName());
            preparedStatement.setString(2, organization.getSector());
            preparedStatement.setString(3, organization.geteMail());
            preparedStatement.setString(4, organization.getPhoneNumber());
            preparedStatement.setInt(5, organization.getIdState());
            preparedStatement.setString(6, organization.getCity());
            preparedStatement.setString(7, organization.getAddress());
            
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
    public Organization getOrganization(int idOrganization){
        Organization organization = null;
        connection = databaseConnection.getConnection();
        String query = "select organization.*, state.state from organization, state where organization.id_state = state.id_state and id_organization = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);   
            preparedStatement.setInt(1, idOrganization);
            
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            organization = new Organization(
                resultSet.getInt("id_organization"), 
                resultSet.getString("name"),
                resultSet.getString("sector"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getInt("id_state"),
                resultSet.getString("state"),
                resultSet.getString("City"), 
                resultSet.getString("Address"));                
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
        return organization;
    }

    public int updateOrganization(Organization organization){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "UPDATE organization SET name = ?, sector = ?, email = ?, phone_number = ?,"
                     + " id_state = ?, city = ?, address = ? WHERE id_organization = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, organization.getName());
            preparedStatement.setString(2, organization.getSector());
            preparedStatement.setString(3, organization.geteMail());
            preparedStatement.setString(4, organization.getPhoneNumber());
            preparedStatement.setInt(5, organization.getIdState());
            preparedStatement.setString(6, organization.getCity());
            preparedStatement.setString(7, organization.getAddress());
            
            preparedStatement.setInt(8, organization.getId());
          
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

    public int deleteOrganization(int idOrganization){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "DELETE FROM organization WHERE id_organization = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idOrganization);
            
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

    public List<Organization> getTable(){
        connection = databaseConnection.getConnection();
        List<Organization> organizations = new ArrayList<>();
        Organization organization = new Organization();

        String query = "Select * from organization";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                organization = new Organization(
                        resultSet.getInt("id_organization"),
                        resultSet.getString("name"),
                        resultSet.getString("sector"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("id_state"),
                        resultSet.getString("City"),
                        resultSet.getString("Address"));

                organizations.add(organization);
            }
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

        return organizations;
    }
}
