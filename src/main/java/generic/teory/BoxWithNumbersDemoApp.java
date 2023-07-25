/**
 * Создал Андрей Антонов 24.07.2023 17:10
 **/
package generic.teory;

public final class BoxWithNumbersDemoApp {
    private BoxWithNumbersDemoApp() {

    }
    public static void main(final String[] args) {
//создаем массивы чисел:
        final int a1 = 1;
        final int a2 = 2;
        final int a3 = 3;
        final int a4 = 4;
        final int a5 = 5;
        final double d1 = 1.0;
        final double d2 = 2.0;
        final double d3 = 3.0;
        final double d4 = 4.0;
        final double d5 = 5.0;
        BoxWithNumbers<Integer> int1 = new BoxWithNumbers<>(a1, a2, a3, a4, a5);
        BoxWithNumbers<Integer> int2 = new BoxWithNumbers<>(a2, a1, a3, a4, a5);
        BoxWithNumbers<Double> double1 = new BoxWithNumbers<>(d1, d2, d3, d4, d5);

// сравниваем:
        System.out.println(int1.sameAvg(int2)); // Так работает
        System.out.println(int1.sameAvg(double1)); // Ошибка
        // (T = Integer) != (T = Double)
    }
}
