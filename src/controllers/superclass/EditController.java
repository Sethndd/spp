package controllers.superclass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import controllers.utilities.ViewUtilities;

public class EditController implements ControllerInterface {
    @FXML
    protected Button btnBackward;
    @FXML
    protected Button btnSave;

    protected int receivedID;

    public EditController(int receivedID) {
        this.receivedID = receivedID;
    }

    public void backwardByClick(MouseEvent mouseEvent) {
        backward();
    }

    public void backwardByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            backward();
        }
    }

    public void saveByClick(MouseEvent mouseEvent) {
        save();
    }

    public void saveByIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            save();
        }
    }

    protected void backward() {
        ButtonBar.ButtonData answer = ViewUtilities.showConfirmationAlert("Confirmación", "Si abandona no se registrarán los cambios. ¿Desea continuar?");
        if(answer.equals(ButtonBar.ButtonData.OK_DONE)) {
            Stage currentStage = (Stage) btnBackward.getScene().getWindow();
            currentStage.close();
        }
    }

    protected void save() {

    }
}
