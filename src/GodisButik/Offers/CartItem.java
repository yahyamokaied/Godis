package GodisButik.Offers;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class CartItem {

    private final BigDecimal itemPrice;
    private final Godis godis;
    private final int quantity;

    public BigDecimal itemPrice() {
        return itemPrice;
    }

    public Godis godis() {
        return godis;
    }

    public int quantity() {
        return quantity;
    }

    public CartItem(@NotNull Godis godis , double itemPrice, int quantity) {

        this.itemPrice = BigDecimal.valueOf(itemPrice);
        this.godis = godis;
        this.quantity = quantity;


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem DefItem = (CartItem) o;

        if (quantity != DefItem.quantity) return false;
        if (!itemPrice.equals(DefItem.itemPrice)) return false;
        return godis.equals(DefItem.godis);
    }


    @Override
    public int hashCode() {
        int finalResult = itemPrice.hashCode();
        finalResult = 31 * finalResult + godis.hashCode();
        finalResult = 31 * finalResult + quantity;
        return finalResult;
    }

}
