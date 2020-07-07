package controllers;

import dataaccess.UserDAO;
import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utilities.Encrypter;
import controllers.utilities.ViewUtilities;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private ImageView imageView = new ImageView();
    @FXML
    private TextField username = new TextField();
    @FXML
    private PasswordField password = new PasswordField();
    @FXML
    private Label alertLabel = new Label();
    @FXML
    private Button button = new Button ();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO Find another way to use this img?
        FileInputStream input = null;
        try{
            input = new FileInputStream("./icons/images.png");
            Image image = new Image(input);
            imageView.setImage(image);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            //TODO catch exceptions properly
        }
    }

    public void loginByClick(MouseEvent mouseEvent) {
        login();
    }

    public void loginByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            login();
        }
    }

    private void login() {
        String userLogin = username.getCharacters().toString();
        String accesskey = password.getCharacters().toString();
        String encryptedKey;

        alertLabel.setText("");

        if(!userLogin.equals("") && !accesskey.equals("")){
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUser(userLogin);

            if(!user.getIdUser().equals("Not found")){
                encryptedKey = user.getPassword();
                accesskey = Encrypter.hasher(accesskey);

                if(accesskey.equals(encryptedKey)){
                    openSystem(user.getUserType());
                }
                else{
                    alertLabel.setText("Los datos de acceso son incorrectos.");
                }
            }
            else{
                alertLabel.setText("Los datos de acceso son incorrectos.");
            }
        }
        else{
            alertLabel.setText("Los campos no pueden estar vacíos.");
        }
    }

    private void openSystem(String userType){
        Stage currentStage = (Stage) button.getScene().getWindow();
        //GUIGeneralController GUIGeneralController = new GUIGeneralController();

        if(userType.equals("Coordinador")) {
            ViewUtilities.open("../../view/coordinator/Menu.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
        }
        else if(userType.equals("Profesor")){
            ViewUtilities.open("Menu.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
        }
        else if(userType.equals("Practicante")){
            ViewUtilities.open("Menu.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
        }
        else{
            ViewUtilities.open("Menu.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
        }
    }
}
