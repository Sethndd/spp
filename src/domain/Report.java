package domain;

import java.sql.Date;

public class Report {
    private int id;
    private String reportType;
    private String description;
    private int grade;
    private String filePath;
    private String idIntern;
    private Date uploadDate;

    public Report(String reportType, String description, String filePath, int grade, Date uploadDate, String idIntern) {
        
        this.reportType = reportType;
        this.description = description;
        this.grade = grade;
        this.filePath = filePath;
        this.idIntern = idIntern;
        this.uploadDate = uploadDate;
    }
    
    public Report(int id, String reportType, String description, String filePath, int grade, Date uploadDate, String idIntern) {
        this.id = id;
        this.reportType = reportType;
        this.description = description;
        this.grade = grade;
        this.filePath = filePath;
        this.idIntern = idIntern;
        this.uploadDate = uploadDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getIdIntern() {
        return idIntern;
    }

    public void setIdIntern(String idIntern) {
        this.idIntern = idIntern;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", reportType=" + reportType + ", description=" + description + ", grade=" + grade + ", filePath=" + filePath + ", idIntern=" + idIntern + ", uploadDate=" + uploadDate + '}';
    }
    
    
}
