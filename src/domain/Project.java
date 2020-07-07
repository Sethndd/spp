package domain;

import java.security.PublicKey;

public class Project {
    private int id;
    private String name;
    private String description;
    private String responsibilities;
    private String activities;
    private int duration;
    private String generalObjetive;
    private String metodology;
    private String resources;
    private int idManager;
    private String managerFirstName;
    private String managerMiddleName;
    private String managerLastName;
    private int idOrganization;
    private String organizationName;
    
    public Project(String name, String description, String responsibilities, String activities, int duration, String generalObjetive, String metodology, String resources, int idManager, int idOrganization) {
        
        this.name = name;
        this.description = description;
        this.responsibilities = responsibilities;
        this.activities = activities;
        this.duration = duration;
        this.generalObjetive = generalObjetive;
        this.metodology = metodology;
        this.resources = resources;
        this.idManager = idManager;
        this.idOrganization = idOrganization;
    }

    public Project(int id, String name, String description, String responsibilities, String activities, int duration, String generalObjetive, String metodology, String resources, int idManager, String managerFirstName, String managerMiddleName, String managerLastName, int idOrganization, String organizationName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.responsibilities = responsibilities;
        this.activities = activities;
        this.duration = duration;
        this.generalObjetive = generalObjetive;
        this.metodology = metodology;
        this.resources = resources;
        this.idManager = idManager;
        this.managerFirstName = managerFirstName;
        this.managerMiddleName = managerMiddleName;
        this.managerLastName = managerLastName;
        this.idOrganization = idOrganization;
        this.organizationName = organizationName;
    }

    public Project(int id, String name, String description, String responsibilities, String activities, int duration, String generalObjetive, String metodology, String resources, int idManager, int idOrganization) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.responsibilities = responsibilities;
        this.activities = activities;
        this.duration = duration;
        this.generalObjetive = generalObjetive;
        this.metodology = metodology;
        this.resources = resources;
        this.idManager = idManager;
        this.idOrganization = idOrganization;
    }

    public Project(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGeneralObjetive() {
        return generalObjetive;
    }

    public void setGeneralObjetive(String generalObjetive) {
        this.generalObjetive = generalObjetive;
    }

    public String getMetodology() {
        return metodology;
    }

    public void setMetodology(String metodologie) {
        this.metodology = metodologie;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerMiddleName() {
        return managerMiddleName;
    }

    public void setManagerMiddleName(String managerMiddleName) {
        this.managerMiddleName = managerMiddleName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }


    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", responsabilities='" + responsibilities + '\'' +
                ", activities='" + activities + '\'' +
                ", duration=" + duration +
                ", generalObjetive='" + generalObjetive + '\'' +
                ", metodology='" + metodology + '\'' +
                ", resources='" + resources + '\'' +
                ", idManager=" + idManager +
                ", managerFirstName='" + managerFirstName + '\'' +
                ", managerMiddleName='" + managerMiddleName + '\'' +
                ", managerLastName='" + managerLastName + '\'' +
                ", idOrganization=" + idOrganization +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
