package GodisButik.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import GodisButik.Offers.CartItem;

public interface Offer {

    BigDecimal apply (ArrayList<CartItem> items);

}
