package domain;

public class Intern{ 
    private String idIntern;
    private String period;
    private int grade;
    private int idProject = 1;
    
    public Intern(String idIntern, String period, int grade) {
        this.idIntern = idIntern;
        this.period = period;
        this.grade = grade;
        
    }
   

    public Intern(String idIntern, String period, int grade, int idProject) {
        this.idIntern = idIntern;   
        this.period = period;
        this.grade = grade;
        this.idProject = idProject;
    }

    public String getIdIntern() {
        return idIntern;
    }

    public void setIdIntern(String idIntern) {
        this.idIntern = idIntern;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Override
    public String toString() {
        return "Intern{" + "idIntern=" + idIntern + ", period=" + period + ", grade=" + grade + ", idProject=" + idProject + '}';
    }
    
    
}