package controllers.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import controllers.superclass.ControllerInterface;

import java.io.IOException;

public class ViewUtilities {

    public static void open(String fxmlName, String title){
        FXMLLoader fxmlLoader;
        Parent root;

        try {
            fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource(fxmlName));
            root = (Parent) fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle(title);

            newStage.show();
        }
        catch (IOException e) {
            System.out.println(e);
            //TODO handle exception properly
        }
    }

    public static void open(String fxmlName, String title, Stage currentStage){
        open(fxmlName, title);
        currentStage.close();
    }

    public static void openAndWait(String fxmlName, String title){
        FXMLLoader fxmlLoader;
        Parent root;

        try {
            fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource(fxmlName));
            root = (Parent) fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle(title);
            newStage.initModality(Modality.APPLICATION_MODAL);

            newStage.showAndWait();
        }
        catch (IOException e) {
            System.out.println(e);
            //TODO handle exception properly
        }
    }

    public static void openWithController(String fxmlName, String title, ControllerInterface controller){
        FXMLLoader fxmlLoader;
        Parent root;

        try {
            fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource(fxmlName));
            fxmlLoader.setController(controller);
            root = (Parent) fxmlLoader.load();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle(title);
            newStage.initModality(Modality.APPLICATION_MODAL);

            newStage.showAndWait();
        }
        catch (IOException e) {
            System.out.println(e);
            //TODO handle exception properly
        }
    }
    //Alerts

    public static void showErrorAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showInformationAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static ButtonBar.ButtonData showConfirmationAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();

        return alert.getResult().getButtonData();
    }
}
