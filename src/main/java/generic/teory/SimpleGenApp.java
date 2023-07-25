/**
 * Создал Андрей Антонов 24.07.2023 16:54
 **/
package generic.teory;

public final class SimpleGenApp {
    private SimpleGenApp() {

    }
    public static void main(final String[] args) {

// создаем объект twoGenObj класса с двумя параметрами T=Integer, V=String
        final int fi = 555;
        final String fs = "Hello";

        TwoGen<Integer, String> twoGenObj = new TwoGen<Integer, String>(fi, fs);
        twoGenObj.showTypes(); // печатаем через метод showTypes()

        int a = twoGenObj.getObj1();
        String b = twoGenObj.getObj2();
        System.out.println(a);
        System.out.println(b);
    }
}
