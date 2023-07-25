/**
 * Создал Андрей Антонов 18.07.2023 6:42
 **/
package generic;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {

/*
        // первое задание, меняем местами цифры в массиве
        final int a = 100;
        final int b = 10;
        final int c = 20;

        ArrayChange array = new ArrayChange();
        array.addElementArray(a);
        array.swapPlaces(b, c);
*/
// второе задание
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        orangeBox.printBox();
        appleBox.printBox();

        for (Orange orange: orangeBox.getBox()) {
            System.out.println(orange);
        }
        for (Apple apple: appleBox.getBox()) {
            System.out.println(apple);
        }
    }
}
