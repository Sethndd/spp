package controllers.utilities;

import domain.Project;
import javafx.beans.property.SimpleStringProperty;

public class ObservableProject {
    private int idProject;
    private SimpleStringProperty projectName;
    private int idOrganization;
    private SimpleStringProperty organizationName;

    public  ObservableProject(Project project){
        idProject = project.getId();
        idOrganization = project.getIdOrganization();

        projectName = new SimpleStringProperty(project.getName());
        organizationName = new SimpleStringProperty(project.getOrganizationName());
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName.get();
    }

    public SimpleStringProperty projectNameProperty() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName.set(projectName);
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getOrganizationName() {
        return organizationName.get();
    }

    public SimpleStringProperty organizationNameProperty() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName.set(organizationName);
    }
}
