package controllers.coordinator.projects;

import dataaccess.ManagerDAO;
import dataaccess.OrganizationDAO;
import dataaccess.ProjectDAO;
import domain.Manager;
import domain.Organization;
import domain.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilities.StringChecker;
import controllers.superclass.EditController;
import controllers.utilities.ObservableManager;
import controllers.utilities.ObservableOrganization;
import controllers.utilities.ViewUtilities;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class EditProject extends EditController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtResponsibilities;
    @FXML
    private TextField txtActivities;
    @FXML
    private TextField txtDuration;
    @FXML
    private TextField txtObjective;
    @FXML
    private TextField txtMethodology;
    @FXML
    private TextField txtResource;
    @FXML
    private ComboBox<ObservableManager> cboxManager;
    @FXML
    private ComboBox<ObservableOrganization> cboxOrganization;

    ObservableList<ObservableManager> managerObservableList;
    ObservableList<ObservableOrganization> organizationObservableList;

    public EditProject(int receivedID) {
        super(receivedID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerObservableList = FXCollections.observableArrayList();
        organizationObservableList = FXCollections.observableArrayList();

        //TODO only charge managers that are working in these organization
        ManagerDAO managerDAO = new ManagerDAO();
        OrganizationDAO organizationDAO = new OrganizationDAO();

        List<Manager> managerList = managerDAO.getTable();
        List<Organization> organizationList = organizationDAO.getTable();

        for(Manager manager: managerList){
            managerObservableList.add(new ObservableManager(manager));
        }

        for(Organization organization: organizationList){
            organizationObservableList.add(new ObservableOrganization(organization));
        }

        ProjectDAO projectDAO = new ProjectDAO();
        Project project = projectDAO.getProject(receivedID);

        managerObservableList.sort(Comparator.comparing(ObservableManager::getManagerName));
        cboxManager.setItems(managerObservableList);

        organizationObservableList.sort(Comparator.comparing(ObservableOrganization::getOrganizationName));
        cboxOrganization.setItems(organizationObservableList);

        txtName.setText(project.getName());
        txtDescription.setText(project.getDescription());
        txtResponsibilities.setText(project.getResponsibilities());
        txtActivities.setText(project.getActivities());
        txtDuration.setText(String.valueOf(project.getDuration()));
        txtObjective.setText(project.getGeneralObjetive());
        txtMethodology.setText(project.getMetodology());
        txtResource.setText(project.getResources());

        cboxManager.setValue(new ObservableManager(managerDAO.getManager(project.getIdManager())));
        cboxOrganization.setValue(new ObservableOrganization(organizationDAO.getOrganization(project.getIdOrganization())));
    }

    @Override
    protected void save() {
        resetStyle();

        if(checkInputs()){
            String name = txtName.getText();
            String descriptions = txtDescription.getText();
            String responsibilities = txtResponsibilities.getText();
            String activities = txtActivities.getText();
            int duration = Integer.parseInt(txtDuration.getText());
            String objective = txtActivities.getText();
            String methodology = txtMethodology.getText();
            String resources = txtResource.getText();
            int idManager = cboxManager.getSelectionModel().getSelectedItem().getIdManager();
            int idOrganization = cboxOrganization.getSelectionModel().getSelectedItem().getIdOrganization();

            Project project = new Project(receivedID, name, descriptions, responsibilities, activities, duration, objective,
                    methodology, resources, idManager, idOrganization);

            ButtonBar.ButtonData answer = ViewUtilities.showConfirmationAlert("Confirmación", "¿Desea editar este proyecto? Los cambios son irreversibles");
            if(answer.equals(ButtonBar.ButtonData.OK_DONE)){
                ProjectDAO dao = new ProjectDAO();
                dao.updateProject(project);

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
        txtDescription.setStyle("");
        txtResponsibilities.setStyle("");
        txtActivities.setStyle("");
        txtDuration.setStyle("");
        txtObjective.setStyle("");
        txtMethodology.setStyle("");
        txtResource.setStyle("");
        cboxOrganization.setStyle("");
        cboxManager.setStyle("");
    }

    private boolean checkInputs(){
        boolean isValid = true;
        if(!StringChecker.isAlphanumeric(txtName.getText())){
            txtName.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtDescription.getText())){
            txtDescription.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtResponsibilities.getText())){
            txtResponsibilities.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtActivities.getText())){
            txtActivities.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isNumber(txtDuration.getText())){
            txtDuration.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtObjective.getText())){
            txtObjective.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtMethodology.getText())){
            txtMethodology.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(!StringChecker.isAlphanumeric(txtResource.getText())){
            txtResource.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(cboxManager.getSelectionModel().getSelectedItem() == null){
            cboxManager.setStyle("-fx-border-color: red; -fx-focus-color: red;");
            isValid = false;
        }

        if(cboxOrganization.getSelectionModel().getSelectedItem() == null){
            cboxOrganization.setStyle("-fx-border-color: red; -fx-focus-color: red;");
            isValid = false;
        }

        return isValid;
    }
}
