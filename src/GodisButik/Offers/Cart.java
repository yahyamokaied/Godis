package GodisButik.Offers;

import GodisButik.Commands.Command;
import GodisButik.Commands.State;
import GodisButik.Commands.UseCommands;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

public class Cart {

    final ArrayList<CartItem> items = new ArrayList<>();
    final Stack<Command> undoStack = new Stack<>();


    public void addItem (CartItem item){
        UseCommands.addHistoryState(new State(() -> {
            System.out.println("Deleted successfully:" + item.godis().name());
            items.remove(item);
        }, () -> {
            System.out.println("Add it again: " + item.godis().name());
            items.add(item);
        }));
        items.add(item);
    }
    public Stream<CartItem> stream(){return items.stream();}
}

