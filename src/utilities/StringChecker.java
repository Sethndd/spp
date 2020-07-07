//TODO Revisar acentos y signos de puntuación
package utilities;

import java.util.regex.Pattern;

public class StringChecker {
    public static boolean isNumber(String string){
        boolean evaluation; 
        String pattern = "\\d+";        
        evaluation = Pattern.matches(pattern, string);
        
        return evaluation;
    }
    public static boolean isName(String string){
        boolean evaluation; 
        String pattern = "[A-Z][a-z]*";        
        evaluation = Pattern.matches(pattern, string);
        
        return evaluation;
    }
    public static boolean isEMail(String string){
        boolean evaluation; 
        String pattern = "[-\\w\\.]+@\\w+\\.\\w+";        
        evaluation = Pattern.matches(pattern, string);
        
        return evaluation;
    }
    public static boolean isIDIntern(String string){
        boolean evaluation; 
        String pattern = "S\\d{8}";        
        evaluation = Pattern.matches(pattern, string);
        
        return evaluation;
    }
    public static boolean isAlphanumeric(String string){
        boolean evaluation; 
        String pattern = "[\\w|\\s]+";
        evaluation = Pattern.matches(pattern, string);
        
        return evaluation;
    }
}
