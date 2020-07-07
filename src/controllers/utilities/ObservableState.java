package controllers.utilities;

import domain.State;
import javafx.beans.property.SimpleStringProperty;

public class ObservableState {

    private int idState;
    private SimpleStringProperty stateName;

    public ObservableState(State state){
        this.idState = state.getIdState();
        this.stateName = new SimpleStringProperty(state.getName());
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getStateName() {
        return stateName.get();
    }

    public SimpleStringProperty stateNameProperty() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName.set(stateName);
    }

    @Override
    public String toString() {
        return stateName.get();
    }
}
