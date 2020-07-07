package controllers.utilities;

import domain.Manager;
import javafx.beans.property.SimpleStringProperty;

public class ObservableManager {
    private int idManager;
    private SimpleStringProperty managerName;
    private SimpleStringProperty organizationName;

    public ObservableManager(Manager manager){
        idManager = manager.getId();
        managerName = new SimpleStringProperty(manager.getName() + " "  + manager.getMiddlename() + " " + manager.getLastname());
        organizationName = new SimpleStringProperty(manager.getOrganizationName());
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public String getManagerName() {
        return managerName.get();
    }

    public SimpleStringProperty managerNameProperty() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName.set(managerName);
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

    @Override
    public String toString() {
        return managerName.get();
    }
}
