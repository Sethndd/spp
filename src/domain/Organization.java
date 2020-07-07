package domain;

public class Organization {
    int id;
    private String name;
    private String sector;
    private String eMail;
    private String phoneNumber;
    private int idState;
    private String state;
    private String city;
    private String address;
    
    public Organization(String name, String sector, String eMail, String phoneNumber, int idState, String city, String address) {
        
        this.name = name;
        this.sector = sector;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.idState = idState;
        this.city = city;
        this.address = address;
    }

    public Organization(int id, String name, String sector, String eMail, String phoneNumber, int idState, String city, String address) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.idState = idState;
        this.city = city;
        this.address = address;
    }

    public Organization(int id, String name, String sector, String eMail, String phoneNumber, int idState, String state, String city, String address) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.idState = idState;
        this.state = state;
        this.city = city;
        this.address = address;
    }

    public Organization(){
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name=" + name + ", sector=" + sector + ", eMail=" + eMail + ", phoneNumber=" + phoneNumber + ", idState=" + idState + ", city=" + city + ", address=" + address + '}';
    }
    
}
