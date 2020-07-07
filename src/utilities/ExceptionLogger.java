package utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ExceptionLogger{
    
    public static void writeException(Exception ex, String errorFileName){
        FileWriter logFile = null;
        PrintWriter writeLog;
        LocalDateTime timeNow;

        try{
            logFile = new FileWriter("error.log", true);
            writeLog = new PrintWriter(logFile);
            
            timeNow = LocalDateTime.now();
            writeLog.println(timeNow + " - " + errorFileName + ": " + ex.toString());
        } 
        catch (IOException exeption) {
             System.out.println(exeption.getMessage());
        } 
        finally {
            try {
                if (null != logFile){
                    logFile.close();
                }
            } 
            catch (IOException exeption) {
                System.out.println(exeption.getMessage());
            } 
        }
    }

    public static void notify(Exception ex, String errorFileName){
        LocalDateTime timeNow = LocalDateTime.now();
        
        writeException(ex, errorFileName);
        MailSender.sendEMail("Something went wrong at " + errorFileName, "File: " + errorFileName + "\n" + timeNow + "\n" +  ex.toString());
        System.out.println(ex.getMessage());
    }
}