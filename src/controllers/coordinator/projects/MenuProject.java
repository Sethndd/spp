package controllers.coordinator.projects;

import dataaccess.ProjectDAO;
import domain.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import controllers.superclass.MenuController;
import controllers.utilities.ObservableProject;
import controllers.utilities.ViewUtilities;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class MenuProject extends MenuController implements Initializable {
    @FXML
    private TableView<ObservableProject> projectTable;
    @FXML
    private TableColumn<ObservableProject, String> nameColumn;
    @FXML
    private TableColumn<ObservableProject, String> organizationColumn;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtOrganization;
    @FXML
    private Button btnAssign;

    ObservableList<ObservableProject> projectObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectObservableList = FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<ObservableProject, String>("projectName"));
        organizationColumn.setCellValueFactory(new PropertyValueFactory<ObservableProject, String>("organizationName"));
        projectTable.setItems(projectObservableList);
        loadProjects();
    }

    public void assignByClick(MouseEvent mouseEvent) {
        assignProject();
    }

    public void assignByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            assignProject();
        }
    }

    @Override
    public void search(){
        //TODO Search method
    }

    @Override
    protected void open() {
        if (projectTable.getSelectionModel().getSelectedItem() != null){
            int idProject = projectTable.getSelectionModel().getSelectedItem().getIdProject();
            ViewUtilities.openWithController("../../view/coordinator/projects/ProjectDetails.fxml",
                    "Sistema de gestión de prácticas profesionales", new ProjectDetails(idProject));
        }
    }

    @Override
    protected void add() {
        ViewUtilities.openAndWait("../../view/coordinator/projects/AddProject.fxml",
                "Sistema de gestión de prácticas profesionales");
        projectObservableList.clear();
        loadProjects();
    }

    @Override
    protected void edit() {
        if (projectTable.getSelectionModel().getSelectedItem() != null){
            int idProject = projectTable.getSelectionModel().getSelectedItem().getIdProject();
            ViewUtilities.openWithController("../../view/coordinator/projects/EditProject.fxml",
                    "Sistema de gestión de prácticas profesionales", new EditProject(idProject));
            projectObservableList.clear();
            loadProjects();
        }
    }

    @Override
    protected void delete() {
        if (projectTable.getSelectionModel().getSelectedItem() != null){
            int idProject = projectTable.getSelectionModel().getSelectedItem().getIdProject();
            ViewUtilities.openWithController("../coordinator/projects/DeleteProject.fxml",
                    "Sistema de gestión de prácticas profesionales",new DeleteProject(idProject));
            projectObservableList.clear();
            loadProjects();
        }
    }

    @Override
    protected void backward() {
        Stage currentStage = (Stage) btnBackward.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/OrganizationsAndProjects.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
    }

    private void assignProject(){
        //TODO Assign Project
    }


    private void loadProjects(){
        ProjectDAO dao = new ProjectDAO();
        List<Project> projectList= dao.getTable();

        for(Project project : projectList) {
            projectObservableList.add(new ObservableProject(project));
        }
        projectObservableList.sort(Comparator.comparing(ObservableProject::getProjectName));
    }
}
