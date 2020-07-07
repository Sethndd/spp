package controllers.coordinator.organization;

import dataaccess.OrganizationDAO;
import domain.Organization;
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
import controllers.utilities.ObservableOrganization;
import controllers.utilities.ViewUtilities;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class MenuOrganization extends MenuController implements Initializable {
    @FXML
    public TableView<ObservableOrganization> organizationTable;
    @FXML
    public TableColumn<ObservableOrganization, String> nameColumn;
    @FXML
    public TextField txtName;

    ObservableList<ObservableOrganization> organizationObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        organizationObservableList = FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<ObservableOrganization, String>("organizationName"));
        organizationTable.setItems(organizationObservableList);

        loadOrganization();
    }

    @Override
    protected void open(){
        if (organizationTable.getSelectionModel().getSelectedItem() != null){
            int idOrganization = organizationTable.getSelectionModel().getSelectedItem().getIdOrganization();
            ViewUtilities.openWithController("../../view/coordinator/organization/OrganizationDetails.fxml",
                    "Sistema de gestión de prácticas profesionales", new OrganizationDetails(idOrganization));
        }

    }

    @Override
    protected void add(){
        ViewUtilities.openAndWait("../../view/coordinator/organization/AddOrganization.fxml", "Sistema de gestión de prácticas profesionales");
        organizationObservableList.clear();
        loadOrganization();
    }

    @Override
    protected void edit() {
        if (organizationTable.getSelectionModel().getSelectedItem() != null){
            int idOrganization = organizationTable.getSelectionModel().getSelectedItem().getIdOrganization();
            ViewUtilities.openWithController("../../view/coordinator/organization/EditOrganization.fxml",
                    "Sistema de gestión de prácticas profesionales", new EditOrganization(idOrganization));
            organizationObservableList.clear();
            loadOrganization();
        }
    }

    @Override
    protected void delete() {
        if (organizationTable.getSelectionModel().getSelectedItem() != null){
            int idOrganization = organizationTable.getSelectionModel().getSelectedItem().getIdOrganization();
            ViewUtilities.openWithController("../../view/coordinator/organization/DeleteOrganization.fxml",
                    "Sistema de gestión de prácticas profesionales", new DeleteOrganization(idOrganization));
            organizationObservableList.clear();
            loadOrganization();
        }
    }
    @Override
    protected void backward() {
        Stage currentStage = (Stage) btnBackward.getScene().getWindow();
        ViewUtilities.open("../../view/coordinator/OrganizationsAndProjects.fxml", "Sistema de gestión de prácticas profesionales", currentStage);
    }

    private void loadOrganization(){
        OrganizationDAO dao = new OrganizationDAO();
        List<Organization> organizations= dao.getTable();

        for (Organization organization: organizations) {
            organizationObservableList.add(new ObservableOrganization(organization));
        }
        organizationObservableList.sort(Comparator.comparing(ObservableOrganization::getOrganizationName));
    }
}
