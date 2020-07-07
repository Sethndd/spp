package utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

public class FileClient {
    
    String serverPath = "/FTP";
    String user = "upload";
    String server = "midguetg.ddns.net";
    String password = "Magt2208";

    
    String path = "/FTP";
    File file = null;
    
    
    
    FTPClient ftp = new FTPClient();
    
    
        

    public FileClient(){
        try {
            this.file = file;
            ftp.connect(server);
            
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public void choseFile(File file){
        this.file = file;
        
    }
    
    public boolean insertFile(){
        
        boolean b = false;
        
        try {
            
            ftp.login(user, password);
            
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory(path);
                
            b = ftp.storeFile(file.getName(),  new FileInputStream(file));
            
        } catch (IOException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return b;
        
    }
    
    public boolean getFile(File file){
        boolean b = false;
        this.file = file;
        
        OutputStream out;
        try {
                
            b = ftp.login(user, password);
            
            
            
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.changeWorkingDirectory(path);
            
            out = new BufferedOutputStream(new FileOutputStream(file));
            b = ftp.retrieveFile("PCS.txt", out);
            out.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        
        return b;
        
    }
    
    
}
