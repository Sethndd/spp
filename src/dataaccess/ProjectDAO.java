package dataaccess;

import domain.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilities.ExceptionLogger;


public class ProjectDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;

    public ProjectDAO() {
        databaseConnection = new DataBaseConnection();
    }   
    
    public int insertProject(Project project){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "insert into project(project_name, description, responsabilities, activities,"
                     + " duration, general_objective, metodology, resources, id_manager, id_organization)"
                     + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getResponsibilities());
            preparedStatement.setString(4, project.getActivities());
            preparedStatement.setInt(5, project.getDuration());
            preparedStatement.setString(6, project.getGeneralObjetive());
            preparedStatement.setString(7, project.getMetodology());
            preparedStatement.setString(8, project.getResources());
            preparedStatement.setInt(9, project.getIdManager());
            preparedStatement.setInt(10, project.getIdOrganization());
            
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

    public Project getProject(int id){
        connection = databaseConnection.getConnection();
        Project project = new Project();

        String query = "select project.*, organization.name as organization_name, manager.name as manager_name, " +
                "manager.middlename as manager_middlename, manager.lastname as manager_lastname " +
                "from project, organization, manager where project.id_organization = organization.id_organization " +
                "AND project.id_manager = manager.id_manager AND id_project = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            project = new Project(
                    resultSet.getInt("id_project"),
                    resultSet.getString("project_name"),
                    resultSet.getString("description"),
                    resultSet.getString("responsabilities"),
                    resultSet.getString("activities"),
                    resultSet.getInt("duration"),
                    resultSet.getString("general_objective"),
                    resultSet.getString("metodology"),
                    resultSet.getString("resources"),
                    resultSet.getInt("id_manager"),
                    resultSet.getString("manager_name"),
                    resultSet.getString("manager_middlename"),
                    resultSet.getString("manager_lastname"),
                    resultSet.getInt("id_organization"),
                    resultSet.getString("organization_name"));
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
        return project;
    }

    public int updateProject(Project project){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "update project set project_name = ?, description = ?, responsabilities = ?,"
                     + " activities = ?, duration = ?, general_objective = ?, metodology = ?,"
                     + " resources = ?, id_manager = ?, id_organization = ? where id_project = ?";
        
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
           
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getResponsibilities());
            preparedStatement.setString(4, project.getActivities());
            preparedStatement.setInt(5, project.getDuration());
            preparedStatement.setString(6, project.getGeneralObjetive());
            preparedStatement.setString(7, project.getMetodology());
            preparedStatement.setString(8, project.getResources());
            preparedStatement.setInt(9, project.getIdManager());
            preparedStatement.setInt(10, project.getIdOrganization());
            
            preparedStatement.setInt(11, project.getId());
            
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
    
    public int deleteProject(int id_project){
         int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "Delete from project where id_project = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_project);
            
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

    public List<Project> getTable(){
        connection = databaseConnection.getConnection();
        List<Project> projects = new ArrayList<>();
        Project project = new Project();

        String query = "select project.*, organization.name as organization_name, manager.name as manager_name, " +
                "manager.middlename as manager_middlename, manager.lastname as manager_lastname " +
                "from project, organization, manager where project.id_organization = organization.id_organization " +
                "AND project.id_manager = manager.id_manager";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                project = new Project(
                        resultSet.getInt("id_project"),
                        resultSet.getString("project_name"),
                        resultSet.getString("description"),
                        resultSet.getString("responsabilities"),
                        resultSet.getString("activities"),
                        resultSet.getInt("duration"),
                        resultSet.getString("general_objective"),
                        resultSet.getString("metodology"),
                        resultSet.getString("resources"),
                        resultSet.getInt("id_manager"),
                        resultSet.getString("manager_name"),
                        resultSet.getString("manager_middlename"),
                        resultSet.getString("manager_lastname"),
                        resultSet.getInt("id_organization"),
                        resultSet.getString("organization_name"));

                projects.add(project);
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

        return projects;
    }
}