package controllers.coordinator.managers;

import dataaccess.ManagerDAO;
import domain.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import controllers.superclass.MenuController;
import controllers.utilities.ObservableManager;
import controllers.utilities.ViewUtilities;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class MenuManagers extends MenuController implements Initializable {
    @FXML
    public TableView<ObservableManager> managerTable;
    @FXML
    public TableColumn<ObservableManager, String> nameColumn;

    @FXML
    public TableColumn<ObservableManager, String> organizationColumn;
    @FXML
    public TextField txtName;

    ObservableList<ObservableManager> managerObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerObservableList = FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<ObservableManager, String>("managerName"));
        organizationColumn.setCellValueFactory(new PropertyValueFactory<ObservableManager, String>("organizationName"));

        managerTable.setItems(managerObservableList);
        loadManager();
    }

    @Override
    protected void open(){
        if (managerTable.getSelectionModel().getSelectedItem() != null){
            int idOrganization = managerTable.getSelectionModel().getSelectedItem().getIdManager();
//            ViewUtilities.openWithController("../coordinator/organization/OrganizationDetails.fxml",
//                    "Sistema de gestión de prácticas profesionales", new OrganizationDetailsController(idOrganization));
        }

    }

    @Override
    protected void add(){
//        ViewUtilities.openAndWait("../coordinator/organization/AddOrganization.fxml", "Sistema de gestión de prácticas profesionales");
        managerObservableList.clear();
        loadManager();
    }

    @Override
    protected void edit() {
        if (managerTable.getSelectionModel().getSelectedItem() != null){
            int idOrganization = managerTable.getSelectionModel().getSelectedItem().getIdManager();
//            ViewUtilities.openWithController("../coordinator/organization/EditOrganization.fxml",
//                    "Sistema de gestión de prácticas profesionales", new EditOrganizationController(idOrganization));
            managerObservableList.clear();
            loadManager();
        }
    }

    @Override
    protected void delete() {
        if (managerTable.getSelectionModel().getSelectedItem() != null){
            int idOrganization = managerTable.getSelectionModel().getSelectedItem().getIdManager();
//            ViewUtilities.openWithController("../coordinator/organization/DeleteOrganization.fxml",
//                    "Sistema de gestión de prácticas profesionales", new DeleteOrganizationController(idOrganization));
            managerObservableList.clear();
            loadManager();
        }
    }
    @Override
    protected void backward() {
        Stage currentStage = (Stage) btnBackward.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/OrganizationsAndProjects.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
    }

    private void loadManager(){
        ManagerDAO dao = new ManagerDAO();
        List<Manager> managers= dao.getTable();

        for (Manager manager: managers) {
            managerObservableList.add(new ObservableManager(manager));
        }
        managerObservableList.sort(Comparator.comparing(ObservableManager::getManagerName));
    }
}
