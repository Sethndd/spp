package controllers.coordinator.projects;

import dataaccess.ProjectDAO;

import controllers.superclass.DeleteController;
import controllers.utilities.ViewUtilities;

public class DeleteProject extends DeleteController {

    public DeleteProject(int receivedID) {
        super(receivedID);
    }

    @Override
    protected void accept() {
        ProjectDAO dao = new ProjectDAO();
        dao.deleteProject(receivedID);

        ViewUtilities.showInformationAlert("Proyecto eliminado", "Proyecto eliminado satisfactoriamente.");

        close();
    }
}
