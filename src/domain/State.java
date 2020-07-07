package domain;

public class State {
    private int idState;
    private String name;

    public State() {
    }

    public State(int idState, String name) {
        this.idState = idState;
        this.name = name;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" +
                "idState=" + idState +
                ", name='" + name + '\'' +
                '}';
    }
}
