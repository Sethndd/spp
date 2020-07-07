package domain;

import java.sql.Date;

public class Activity {
    private int id;
    private String name;
    private String description;
    private String value;
    private String idIntern;
    private Date uploadDate;
    
    public Activity(String name, String value, String description,  Date uploadDate, String idIntern) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.uploadDate = uploadDate;
        this.idIntern = idIntern;

    }

    public Activity(int id,String name, String value, String description,  Date uploadDate, String idIntern) {
        this.id = id;
        
        this.name = name;
        this.value = value;
        this.description = description;
        this.uploadDate = uploadDate;
        this.idIntern = idIntern;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        return "Activity{" + "id=" + id + ", name=" + name + ", description=" + description + ", value=" + value + ", idIntern=" + idIntern + ", uploadDate=" + uploadDate + '}';
    }
    
}
