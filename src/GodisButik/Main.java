package GodisButik;

import GodisButik.Commands.UseCommands;
import GodisButik.Offers.Cart;
import GodisButik.Offers.CartItem;
import GodisButik.Offers.Cash;
import GodisButik.Offers.Godis;

public class Main {

    public static void main (String[] args){

        Cart cart = new Cart();
        Cash cash = new Cash();

        Godis chocolate = new Godis("Chocolate");
        Godis kandy = new Godis("Kandy");
        Godis glass = new Godis("Glass");
        Godis juice = new Godis("Juice");

        CartItem cartItem = new CartItem(chocolate , 15 , 3);
        CartItem cartItem2 = new CartItem(kandy , 10 , 4);
        CartItem cartItem3 = new CartItem(glass , 35 , 2);
        CartItem cartItem4 = new CartItem(juice , 25 , 1);

        cart.addItem(cartItem);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        cart.addItem(cartItem4);

        UseCommands.undo();
        System.out.println(cash.kvitto(cart));
        UseCommands.redo();
        System.out.println(cash.kvitto(cart));
        UseCommands.undo();
        System.out.println(cash.kvitto(cart));

    }
}
