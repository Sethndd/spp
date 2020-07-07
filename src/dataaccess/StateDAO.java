package dataaccess;

import domain.Activity;
import domain.Organization;
import domain.State;
import utilities.ExceptionLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDAO {
    private final String className = this.getClass().getName();
    private final DataBaseConnection databaseConnection;
    private Connection connection;
    private ResultSet resultSet;

    public StateDAO(){
        databaseConnection = new DataBaseConnection();
    }

    public State getState(int stateID){

        connection = databaseConnection.getConnection();
        List<State> states = new ArrayList<>();
        State state = new State();

        String query = "Select * from state where id_state = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stateID);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            state = new State(
                    resultSet.getInt("id_state"),
                    resultSet.getString("state"));
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
        return state;
    }

    public List<State> getTable(){
        connection = databaseConnection.getConnection();
        List<State> states = new ArrayList<>();
        State state = new State();

        String query = "Select * from state";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                state = new State(
                        resultSet.getInt("id_state"),
                        resultSet.getString("state"));

                states.add(state);
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

        return states;
    }
}
