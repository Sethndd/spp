package controllers.coordinator;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import controllers.utilities.ViewUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Menu {
    @FXML
    private Button btnProjects;
    @FXML
    private Button btnIntern;
    @FXML
    private Button btnReport;

    //Main Menu
    public void openProjectsByClick(MouseEvent actionEvent) {
        openProject();
    }

    public void openInternsByClick(MouseEvent actionEvent) {
        openIntern();
    }

    public void openReportByClick(MouseEvent actionEvent) {
        openReport();
    }

    public void openProjectsByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            openProject();
        }
    }

    public void openInternsByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            openIntern();
        }
    }

    public void openReportByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            openReport();
        }
    }

    private void openProject() {
        Stage currentStage = (Stage) btnProjects.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/OrganizationsAndProjects.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
    }
    private void openIntern() {
        Stage currentStage = (Stage) btnIntern.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/interns/MenuInterns.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
    }

    private void openReport() {
        Stage currentStage = (Stage) btnReport.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/MenuReports.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
    }
}
