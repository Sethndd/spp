package controllers.coordinator.organization;

import dataaccess.OrganizationDAO;
import domain.Organization;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import controllers.superclass.DetailsController;

import java.net.URL;
import java.util.ResourceBundle;

public class OrganizationDetails extends DetailsController implements Initializable {
    @FXML
    public Label lblName;
    @FXML
    public Label lblSector;
    @FXML
    public Label lblEMail;
    @FXML
    public Label lblPhoneNumber;
    @FXML
    public Label lblState;
    @FXML
    public Label lblCity;
    @FXML
    public Label lblAddress;

    public OrganizationDetails(int receivedID) {
        super(receivedID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrganizationDAO dao = new OrganizationDAO();
        Organization organization = dao.getOrganization(receivedID);

        lblName.setText(organization.getName());
        lblSector.setText(organization.getSector());
        lblEMail.setText(organization.geteMail());
        lblPhoneNumber.setText(organization.getPhoneNumber());
        lblState.setText(organization.getState());
        lblCity.setText(organization.getCity());
        lblAddress.setText(organization.getAddress());

    }
}
