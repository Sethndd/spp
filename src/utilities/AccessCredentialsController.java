//TODO Tratar excepciones
package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import utilities.datastructure.DataBaseCredentials;
import utilities.datastructure.EmailCredentials;

public class AccessCredentialsController {
    public static DataBaseCredentials readDataBaseCredentials(){
        String file = "db.conf";
        DataBaseCredentials db = null;
        try{
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileIn);
            
            db = (DataBaseCredentials)reader.readObject();
            
            
        } catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return db;   
    }
    
    public static void writeDataBaseCredentials(DataBaseCredentials credentials){
        String file = "db.conf";
        
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileOut);
            
            writer.writeObject(credentials); 
            fileOut.close();
            writer.close();    
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }        
    }
    
    public static void writeEmailCredentials(EmailCredentials credentials){
        String file = "email.conf";
        
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileOut);
            
            writer.writeObject(credentials); 
            fileOut.close();
            writer.close();
 
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static EmailCredentials readEmailCredentials(){
        String file = "email.conf";
        EmailCredentials email = null;
        try{
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileIn);
            
            email = (EmailCredentials)reader.readObject();
  
        } catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return email;
        
    }
}
