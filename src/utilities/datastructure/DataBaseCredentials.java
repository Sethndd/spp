package utilities.datastructure;

import java.io.Serializable;

public class DataBaseCredentials implements Serializable {
    private final String address;
    private final  String port;
    private final String user;
    private final String password;

    public DataBaseCredentials(String address,String port, String user, String password){
        this.address = address;
        this.port = port;
        this.user = user; 
        this.password = password; 
    } 

    public String getAddress() {
        return address;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
}
