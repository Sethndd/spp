package domain;

import java.sql.Date;

public class Document {
    private int id;
    private int documentType;
    private String filePath;
    private String idIntern;
    private Date uploadDate;

    public Document(String filePath, Date uploadDate, String idIntern, int documentType) {
        this.filePath = filePath;
        this.uploadDate = uploadDate;
        this.idIntern = idIntern;
        this.documentType = documentType;
    }
    
    public Document(int id, String filePath, Date uploadDate, String idIntern, int documentType) {
        this.id = id;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
        this.idIntern = idIntern;
        this.documentType = documentType;

    }

    public int getIdDocument() {
        return id;
    }

    public void setIdDocument(int id) {
        this.id = id;
    }

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
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
        return "Document{" + "id=" + id + ", documentType=" + documentType + ", filePath=" + filePath + ", idIntern=" + idIntern + ", uploadDate=" + uploadDate + '}';
    }
    
    
}
