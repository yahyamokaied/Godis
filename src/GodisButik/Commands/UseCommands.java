package GodisButik.Commands;

import java.util.Stack;

public class UseCommands {

    static Stack<State> redoStack = new Stack<State>();
    static Stack<State> undoStack = new Stack<State>();

    public static void undo(){
        if (undoStack.size() > 0) {
            int index = undoStack.size() - 1;
            undoStack.get(index).undo.force();
            redoStack.push(undoStack.peek());
            undoStack.pop();
        }
    }

    public static void redo() {
        if (redoStack.size() > 0) {
            undoStack.push(redoStack.peek());
            redoStack.pop().redo.force();
        }
    }

    public static void addHistoryState(State state) {
        undoStack.push(state);
        redoStack.clear();
    }
}
