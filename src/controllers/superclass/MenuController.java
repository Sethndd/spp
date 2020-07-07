package controllers.superclass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MenuController {
    @FXML
    protected Button btnSearch;
    @FXML
    protected Button btnOpen;
    @FXML
    protected Button btnEdit;
    @FXML
    protected Button btnDelete;
    @FXML
    protected Button btnAdd;
    @FXML
    protected Button btnBackward;

    public void selectFromTableByClick(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 2){
                open();
            }
        }
    }

    public void selectFromTableByIntro(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            open();
        }
    }

    public void searchByClick(MouseEvent mouseEvent) {
        search();
    }

    public void searchByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            search();
        }
    }

    public void openByClick(MouseEvent mouseEvent) {
        open();
    }

    public void openByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            open();
        }
    }

    public void addByClick(MouseEvent mouseEvent) {
        add();
    }


    public void addByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            add();
        }
    }

    public void editByClick(MouseEvent mouseEvent) {
        edit();
    }

    public void editByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            edit();
        }
    }

    public void deleteByClick(MouseEvent mouseEvent) {
        delete();
    }

    public void deleteProjectByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            delete();
        }
    }

    public void backwardByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            backward();
        }
    }

    public void backwardByClick(MouseEvent mouseEvent) {
        backward();
    }

    protected void search(){

    }

    protected void open(){

    }

    protected void add(){

    }

    protected void edit(){

    }

    protected void delete(){

    }

    protected void backward(){

    }
}
