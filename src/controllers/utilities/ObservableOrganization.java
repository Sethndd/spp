package controllers.utilities;

import domain.Organization;
import javafx.beans.property.SimpleStringProperty;

public class ObservableOrganization {
    private int idOrganization;
    private SimpleStringProperty organizationName;

    public ObservableOrganization(Organization organization){
        idOrganization = organization.getId();
        organizationName = new SimpleStringProperty(organization.getName());
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

    @Override
    public String toString() {
        return organizationName.get();
    }
}
