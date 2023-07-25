/**
 * Создал Андрей Антонов 24.07.2023 16:25
 **/
package generic.teory;

public final class GenericsDemoApp {
    private GenericsDemoApp() {

    }

    public static void main(final String[] args) {

// создаю объект класса GenericBox, который содержит объект типа String
        GenericBox<String> genStr = new GenericBox<>("Hello");
// вызываю ему метод showType показать тип
        genStr.showType();
        System.out.println("genStr.getObject(): " + genStr.getObj());

// аналогично
        final int fi = 140;
// создаю объект класса GenericBox, который содержит объект типа int
        GenericBox<Integer> genInt = new GenericBox<>(fi);
// вызываю ему метод showType показать тип
        genInt.showType();
        System.out.println("genInt.getObject(): " + genInt.getObj());

// создаем переменную int a и в нее записываем значение genInt
        int a = genInt.getObj();
// создаем переменную String b и в нее записываем значение getStr
        String b = genStr.getObj();

// пробуем передать в переменную genInt строку - ОШИБКА
        // genInt.setObj("Java"); // Ошибка компиляции !!!

    }
}
