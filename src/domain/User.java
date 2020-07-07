package domain;

public class User {
    private String idUser;
    private String password;
    private String name;
    private String middlename;
    private String lastname;
    private String eMail;
    private String phoneNumber;
    private int userType;
    private String type;

    public User(String idUser, String name, String middlename, String lastname, String password, String eMail, String phoneNumber, int userType) {
        this.idUser = idUser;
        this.password = password;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        
    }
    
    public User(String idUser, String name, String middlename, String lastname, String password, String eMail, String phoneNumber, String type) {
        this.idUser = idUser;
        this.password = password;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public User(String idUser) {
        this.idUser = idUser;
    }
    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getUserIDType() {
        return userType;
    }

    public void setUserIDType(int userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return type;
    }

    public void setUserType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", password=" + password + ", name=" + name + ", middlename=" + middlename + ", lastname=" + lastname + ", eMail=" + eMail + ", phoneNumber=" + phoneNumber + ", userType=" + type + '}';
    }
        
}
