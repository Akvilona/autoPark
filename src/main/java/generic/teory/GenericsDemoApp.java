/**
 * Создал Андрей Антонов 24.07.2023 16:25
 **/

package generic.teory;

public final class GenericsDemoApp {
    private GenericsDemoApp() {

    }

    public static void main(final String[] args) {
        GenericBox<String> genStr = new GenericBox<>("Hello");
        genStr.showType();
        System.out.println("genStr.getObject(): " + genStr.getObj());

        final int fi = 140;
        GenericBox<Integer> genInt = new GenericBox<>(fi);
        genInt.showType();
        System.out.println("genInt.getObject(): " + genInt.getObj());
    }
}
