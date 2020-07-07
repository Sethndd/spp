package controllers.superclass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DetailsController implements ControllerInterface {
    @FXML
    protected Button btnBackward;

    protected int receivedID;

    public DetailsController(int receivedID) {
        this.receivedID = receivedID;
    }


    public void backwardByClick(MouseEvent mouseEvent) {
        backward();
    }

    private void backward() {
        Stage currentStage = (Stage) btnBackward.getScene().getWindow();
        currentStage.close();
    }

    public void backwardByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            backward();
        }
    }
}
