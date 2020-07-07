package domain;

public class Manager {
    private int id;
    private String name;
    private String middlename;
    private String lastname;
    private String position;
    private String eMail;
    private int idOrganization;
    private String organizationName;
    
    public Manager(String name, String middlename, String lastname, String position, String eMail, int idOrganization) {
        
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.position = position;
        this.eMail = eMail;
        this.idOrganization = idOrganization;
    }

    public Manager(int id, String name, String middlename, String lastname, String position, String eMail, int idOrganization) {
        this.id = id;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.position = position;
        this.eMail = eMail;
        this.idOrganization = idOrganization;
    }

    public Manager(int id, String name, String middlename, String lastname, String position, String eMail, int idOrganization, String organizationName) {
        this.id = id;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.position = position;
        this.eMail = eMail;
        this.idOrganization = idOrganization;
        this.organizationName = organizationName;
    }

    public Manager(){

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

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                ", eMail='" + eMail + '\'' +
                ", idOrganization=" + idOrganization +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
