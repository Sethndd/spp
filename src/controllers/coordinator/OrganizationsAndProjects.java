package controllers.coordinator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import controllers.utilities.ViewUtilities;

public class OrganizationsAndProjects {
    @FXML
    public Button btnProjects;
    @FXML
    public Button btnOrganizations;
    @FXML
    public Button btnManagers;
    @FXML
    public Button btnBackward;


    public void openProjectsByClick(MouseEvent mouseEvent) {
        openProjects();
    }

    public void openOrganizationsByClick(MouseEvent mouseEvent) {
        openOrganizations();
    }

    public void openManagersByClick(MouseEvent mouseEvent) {
        openManagers();
    }

    public void backwardByClick(MouseEvent mouseEvent) {
        backward();
    }

    public void openProjectsByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            openProjects();
        }
    }

    public void openOrganizationsByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            openOrganizations();
        }
    }

    public void openManagersByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            openManagers();
        }
    }

    public void backwardByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            backward();
        }
    }

    private void openProjects() {
        Stage currentStage = (Stage) btnProjects.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/projects/MenuProject.fxml",
                "Sistema de gestión de prácticas profesionales", currentStage);
    }

    private void openOrganizations(){
        Stage currentStage = (Stage) btnProjects.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/organization/MenuOrganization.fxml",
                "Sistema de gestión de prácticas profesionales", currentStage);
    }
    private void openManagers(){
        Stage currentStage = (Stage) btnProjects.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/managers/MenuManagers.fxml",
                "Sistema de gestión de prácticas profesionales", currentStage);
    }
    private void backward() {
        Stage currentStage = (Stage) btnProjects.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/Menu.fxml",
                "Sistema de gestión de prácticas profesionales", currentStage);
    }

}
