package GodisButik.Commands;

public class State {

    Command redo;
    Command undo;

    public State(Command r, Command u) {
        this.redo = r;
        this.undo = u;
    }
}
