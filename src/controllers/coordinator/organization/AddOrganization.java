package controllers.coordinator.organization;

import dataaccess.OrganizationDAO;
import dataaccess.StateDAO;
import domain.Organization;
import domain.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilities.StringChecker;
import controllers.superclass.AddController;
import controllers.utilities.ObservableState;
import controllers.utilities.ViewUtilities;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class AddOrganization extends AddController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    public TextField txtSector;
    @FXML
    public TextField txtEMail;
    @FXML
    public TextField txtPhoneNumber;
    @FXML
    public ComboBox<ObservableState> cboxState;
    @FXML
    public TextField txtCity;
    @FXML
    public TextField txtAddress;

    ObservableList<ObservableState> stateObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stateObservableList = FXCollections.observableArrayList();

        StateDAO dao = new StateDAO();
        List<State> stateList = dao.getTable();

        for(State state: stateList){
            stateObservableList.add(new ObservableState(state));
        }

        stateObservableList.sort(Comparator.comparing(ObservableState::getStateName));
        cboxState.setItems(stateObservableList);
    }

    @Override
    protected void save() {
        resetStyle();

        if(checkInputs()){
            String name = txtName.getText();
            String sector = txtSector.getText();
            String eMail = txtEMail.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String city = txtCity.getText();
            String address = txtAddress.getText();
            int idState = cboxState.getSelectionModel().getSelectedItem().getIdState();

            Organization organization = new Organization(name, sector, eMail, phoneNumber, idState, city, address);

            ButtonBar.ButtonData answer = ViewUtilities.showConfirmationAlert("Confirmación", "¿Desea añadir esta organización al sistema?");
            if(answer.equals(ButtonBar.ButtonData.OK_DONE)){
                OrganizationDAO dao = new OrganizationDAO();
                dao.insertOrganization(organization);

                Stage currentStage = (Stage) btnSave.getScene().getWindow();
                currentStage.close();
            }
        }
        else{
            ViewUtilities.showErrorAlert("Error", "Error: Algunos campos están vacíos o no tienen el tipo de dato correcto.");
        }
    }

    private void resetStyle(){
        txtName.setStyle("");
        txtSector.setStyle("");
        txtEMail.setStyle("");
        txtPhoneNumber.setStyle("");
        txtCity.setStyle("");
        txtAddress.setStyle("");
        cboxState.setStyle("");
    }

    private boolean checkInputs(){
        boolean isValid = true;
        if(!StringChecker.isAlphanumeric(txtName.getText())){
            txtName.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtSector.getText())){
            txtSector.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isEMail(txtEMail.getText())){
            txtEMail.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isNumber(txtPhoneNumber.getText())){
            txtPhoneNumber.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtCity.getText())){
            txtCity.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtAddress.getText())){
            txtAddress.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(cboxState.getSelectionModel().getSelectedItem() == null){
            cboxState.setStyle("-fx-border-color: red; -fx-focus-color: red;");
            isValid = false;
        }

        return isValid;
    }
}
