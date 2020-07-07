package dataaccess;

import domain.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ExceptionLogger;

public class ReportDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;
        
    public ReportDAO(){
        databaseConnection = new DataBaseConnection();
    }
    
    public int insertReport(Report report){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "insert into report(id_type, description, filepath, grade, upload_date, id_intern)"
                     + " values(?, ?, ?, ?, ?, ?);"; //Consulta
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, report.getReportType());
            preparedStatement.setString(2, report.getDescription());
            preparedStatement.setString(3, report.getFilePath());
            preparedStatement.setInt(4, report.getGrade());
            preparedStatement.setDate(5, report.getUploadDate());
            preparedStatement.setString(6, report.getIdIntern());

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
    public Report getReport(int idReport){
        Report report = null;
        connection = databaseConnection.getConnection();
        String query = "Select * from report where id_report = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReport);
            resultSet = preparedStatement.executeQuery(); 
            resultSet.next();
            
            report = new Report(
                resultSet.getInt("id_report"), 
                resultSet.getString("id_type"),
                resultSet.getString("description"),
                resultSet.getString("filepath"),
                resultSet.getInt("grade"),
                resultSet.getDate("upload_date"),
                resultSet.getString("id_intern"));
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
        return report;
    }

    public int updateReport(Report report){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "UPDATE report SET id_type = ?, description = ?, filepath = ?, grade = ?,"
                     + " upload_date = ?, id_intern = ? WHERE id_report = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, report.getReportType());
            preparedStatement.setString(2, report.getDescription());
            preparedStatement.setString(3, report.getFilePath());
            preparedStatement.setInt(4, report.getGrade());
            preparedStatement.setDate(5, report.getUploadDate());
            preparedStatement.setString(6, report.getIdIntern());
            
            preparedStatement.setInt(7, report.getId());
          
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

    public int deleteReport(int idReport){
        int affectedRows = 0;
        connection = databaseConnection.getConnection();
        String query = "DELETE FROM report WHERE id_report = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReport);
            
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
