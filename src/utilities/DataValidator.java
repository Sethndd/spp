//TO DO
//Completar validadores de datos.
package utilities;

import domain.*;

public class DataValidator {
    public static boolean isValid(Activity activity){
        boolean valid = true;
        if(!StringChecker.isName(activity.getName())){
            valid = false;
        }
        else if(!StringChecker.isAlphanumeric(activity.getDescription())){
            valid = false;
        }
        else if(!StringChecker.isIDIntern(activity.getIdIntern())){
            valid = false;
        }
        return valid;
    }
    public static boolean isValid(Document document){
        boolean valid = true;
        
        return valid;
    }
    public static boolean isValid(Intern intern){
        boolean valid = true;
        
        return valid;
    }
    public static boolean isValid(Manager manager){
        boolean valid = true;
        
        return valid;
    }
    public static boolean isValid(Organization organization){
        boolean valid = true;
        
        return valid;
    }
    public static boolean isValid(Project project){
        boolean valid = true;
        
        return valid;
    }
    public static boolean isValid(Report report){
        boolean valid = true;
        
        return valid;
    }
    public static boolean isValid(User user){
        boolean valid = true;
        
        return valid;
    }
}
