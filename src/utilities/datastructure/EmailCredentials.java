package utilities.datastructure;

import java.io.Serializable;

public class EmailCredentials implements Serializable{
    private final String user;
    private final String password;
    
    public EmailCredentials(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
