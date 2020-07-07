package controllers.coordinator.organization;

import dataaccess.OrganizationDAO;
import controllers.superclass.DeleteController;
import controllers.utilities.ViewUtilities;

public class DeleteOrganization extends DeleteController {

    public DeleteOrganization(int receivedID) {
        super(receivedID);
    }

    @Override
    protected void accept() {
        OrganizationDAO dao = new OrganizationDAO();
        dao.deleteOrganization(receivedID);

        ViewUtilities.showInformationAlert("Organización eliminada", "Organización eliminada satisfactoriamente.");

        close();
    }
}
