package controllers.superclass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DeleteController implements ControllerInterface {
    @FXML
    protected Button btnAccept;
    @FXML
    protected Button btnCancel;

    protected int receivedID;

    public DeleteController(int receivedID) {
        this.receivedID = receivedID;
    }

    public void acceptByClick(MouseEvent mouseEvent) {
        accept();
    }

    public void cancelByClick(MouseEvent mouseEvent) {
        close();
    }

    public void acceptByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            accept();
        }
    }

    public void cancelByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            close();
        }
    }

    protected void accept() {

    }

    protected void close() {
        Stage currentStage = (Stage) btnCancel.getScene().getWindow();
        currentStage.close();
    }

}
