/**
 * Создал Андрей Антонов 18.07.2023 6:42
 **/
package generic;

import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        Box<Banana> bananaBox = new Box<>();
        Box<Apple>  appleBox  = new Box<>();

        bananaBox.add(new Banana());
        appleBox.addAllVarArgs(new Apple(), new Apple());

        System.out.println(bananaBox.compare(appleBox));

        System.out.println(bananaBox.pourOver((ArrayList<Banana>) bananaBox.getBox()));
    }
}
