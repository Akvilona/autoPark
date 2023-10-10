/**
 * Создал Андрей Антонов 24.07.2023 18:13
 **/

package generic.teory;

public final class WildcardDemoApp {
    private WildcardDemoApp() {

    }

    public static void main(final String[] args) {
        //создаем массивы
        final int a1 = 1;
        final int a2 = 2;
        final int a3 = 3;
        final int a4 = 4;
        final int a5 = 5;
        final double d1 = 1.1;
        final double d2 = 2.2;
        final double d3 = 3.3;
        final double d4 = 4.4;
        final double d5 = 5.5;
        final float f1 = 1.0f;
        final float f2 = 2.0f;
        final float f3 = 3.0f;
        final float f4 = 4.0f;
        final float f5 = 5.0f;

        BoxWithNumbers<Integer> intArr = new BoxWithNumbers<>(a1, a2, a3, a4, a5);
        System.out.println("Average iBoxWithNumbers = " + intArr.avg());

        BoxWithNumbers<Double> doubleArr = new BoxWithNumbers<>(d1, d2, d3, d4, d5);
        System.out.println("Average dBoxWithNumbers = " + doubleArr.avg());

        BoxWithNumbers<Float> floatArr = new BoxWithNumbers<>(f1, f2, f3, f4, f5);
        System.out.println("Average fBoxWithNumbers = " + floatArr.avg());

        System.out.print("Average iBoxWithNumbers and dBoxWithNumbers ");
        if (intArr.sameAvg(doubleArr)) {
            System.out.println("equal");
        } else {
            System.out.println("differ");
        }

        System.out.print("Medium iBoxWithNumbers and fBoxWithNumbers");
        if (intArr.sameAvg(floatArr)) {
            System.out.println("equal");
        } else {
            System.out.println("differ");
        }
    }
}
