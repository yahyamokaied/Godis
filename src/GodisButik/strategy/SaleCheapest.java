package GodisButik.strategy;

import GodisButik.Offers.CartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SaleCheapest implements Offer {
    @Override
    public BigDecimal apply(ArrayList<CartItem> items) {
        var sum = BigDecimal.ZERO;
        var finalAmount = BigDecimal.ZERO;
        var sortedList = items.stream()
                .sorted(Comparator.comparing(item -> item.itemPrice()))
                .collect(Collectors.toList());
        var cheapestItem = sortedList.get(0).itemPrice();

        for (var item: items) {
            sum = item.itemPrice().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
            if(item.quantity() > 1 || items.size() > 1) {
                finalAmount = sum.subtract(cheapestItem);
            }
        }
        return finalAmount;
    }
}
