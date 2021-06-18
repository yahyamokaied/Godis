package GodisButik.Offers;

import GodisButik.strategy.SaleCheapest;
import GodisButik.strategy.SaleThreeForFour;
import GodisButik.strategy.SaleWithAll;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Cash {
    SaleWithAll saleWithAll = new SaleWithAll();
    SaleCheapest saleCheapest = new SaleCheapest();
    SaleThreeForFour saleThreeForFour = new SaleThreeForFour();

    public BigDecimal calculatePris (Cart cart){
        var sum  = BigDecimal.ZERO;
        for (var item: cart.items){
            sum = item.itemPrice().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        sum.subtract(calculateOffers(cart));
        return sum;

    }

    public BigDecimal calculateOffers(Cart cart) {
        var threeForFour = saleThreeForFour.apply(cart.items);
        var withAll = saleWithAll.apply(cart.items);
        var cheapest = saleCheapest.apply(cart.items);

        int[] newNum = {threeForFour.intValue(),withAll.intValue(),cheapest.intValue()};
        Arrays.sort(newNum);

        var total = newNum[newNum.length-1];
        return BigDecimal.valueOf(total);
    }

    public String kvitto(Cart cart){
        String startLine = "- - - - - - - - - - - - - - - - - - - -\n";
        String endLine = "- - - - - - - - - - - - - - - - - - - -\n";
        StringBuilder sb = new StringBuilder();
        sb.append(startLine);

        var order = cart.items.stream()
                .sorted(Comparator.comparing(item -> item.godis().name()))
                .collect(Collectors.toList());
        for (var each : order){
            sb.append(String.format("%-24s % 7.2f\n" , each.godis().name(),each.itemPrice()));
        }
        sb.append(endLine);
        sb.append(String.format("%24s% 8.2f" , "Summan:" , calculatePris(cart)));
        return sb.toString();

    }
}
