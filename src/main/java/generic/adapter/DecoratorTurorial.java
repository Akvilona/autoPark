/**
 * Создал Андрей Антонов 31.07.2023 14:55
 * https://youtu.be/5CfXk62siuE
 **/
package generic.adapter;

public class DecoratorTurorial {
}
interface Product {
    int getPrise();
}

class  Milk implements Product {
    private final int prise;

    Milk(int prise) {
        this.prise = prise;
    }

    @Override
    public int getPrise() {
        return prise;
    }
}

abstract class Decorator implements Product {
    final Product product;

    public Decorator(Product product) {
        this.product = product;
    }
}

class MilkDiscount extends Decorator {

    public MilkDiscount(Product product) {
        super(product);
    }

    @Override
    public int getPrise() {
        return this.product.getPrise() - 15;
    }
}

class Shop {
    public static void main(String[] args) {
        Product milk = new Milk(50);

        Product milkDiscount = new MilkDiscount(milk);

        System.out.println(milkDiscount.getPrise());
    }
}