package controllers.coordinator.projects;

import dataaccess.ProjectDAO;
import domain.Project;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import controllers.superclass.DetailsController;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectDetails extends DetailsController implements Initializable{
    @FXML
    public Label lblName;
    @FXML
    public Label lblDescription;
    @FXML
    public Label lblResponsibilities;
    @FXML
    public Label lblActivities;
    @FXML
    public Label lblDuration;
    @FXML
    public Label lblObjective;
    @FXML
    public Label lblMethodology;
    @FXML
    public Label lblResource;
    @FXML
    public Label lblManager;
    @FXML
    public Label lblOrganization;

    public ProjectDetails(int receivedID) {
        super(receivedID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProjectDAO dao = new ProjectDAO();
        Project project = dao.getProject(receivedID);

        lblName.setText(project.getName());
        lblDescription.setText(project.getDescription());
        lblResponsibilities.setText(project.getResponsibilities());
        lblActivities.setText(project.getActivities());
        lblDuration.setText(String.valueOf(project.getDuration()));
        lblObjective.setText(project.getGeneralObjetive());
        lblMethodology.setText(project.getMetodology());
        lblResource.setText(project.getResources());
        lblManager.setText(project.getManagerFirstName() + " " + project.getManagerMiddleName() + " " + project.getManagerLastName());
        lblOrganization.setText(project.getOrganizationName());
    }

}
