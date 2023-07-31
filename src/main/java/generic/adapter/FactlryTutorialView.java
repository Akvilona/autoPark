 /**
 * Создал Андрей Антонов 31.07.2023 15:25
  * https://youtu.be/fC83ITS_NHQ
 **/
package generic.adapter;

import java.util.ArrayList;
import java.util.List;

public class FactlryTutorialView {
    public static void main(String[] args) {
        List<Chocolate> chocolateList = new ArrayList<>();

        Factory factory  = new CreatorFactory(1);
        Chocolate chocolate = factory.create();
        chocolate.printPrice();

        chocolateList.add(chocolate);
        chocolateList.get(0).printPrice();
    }
}
/**
 * Существует интерфейс Chocolate и у него есть метод printPrice() и было у него две реализации
 * WhiteChocolate и BlackChocolate у одного int price = 15 а у другого int price = 10
 * и нам понадобилось создать экземпляры этих классов. Для этого
 * создали class CreatorFactory и метод Chocolate() который
 * в зависимости от флага создает тот или иной класс с соответствующей ценой.
 * */
interface Chocolate {
    void printPrice();
}

class WhiteChocolate implements Chocolate {
    private final int price = 15;
    @Override
    public void printPrice() {
        System.out.println(price);
    }
}
class BlackChocolate implements Chocolate {
    private final int price = 10;
    @Override
    public void printPrice() {
        System.out.println(price);
    }
}

abstract class Factory {
    public int flag;
    abstract Chocolate create();

    public Factory(int flag) {
        this.flag = flag;
    }
}

class CreatorFactory extends Factory {
    public CreatorFactory(int flag) {
        super(flag);
    }

    @Override
    Chocolate create() {
        if (flag == 0) {
            return new WhiteChocolate();
        }
        if (flag == 1) {
            return new BlackChocolate();
        }
        throw new IllegalArgumentException();
    }
}
