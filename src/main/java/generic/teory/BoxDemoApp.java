/**
 * Создал Андрей Антонов 24.07.2023 15:39
 **/
package generic.teory;

public final class BoxDemoApp {
    private BoxDemoApp() {

    }
    public static void main(final String[] args) {
        final int a = 20;
        final int b = 30;
        SimpleBox intBox1 = new SimpleBox(a); // создаем объект intBox1
        SimpleBox intBox2 = new SimpleBox(b); // создаем объект intBox2

//здесь делаем сложение: сначала проверяем, что геттер нам передает значение Integer

        if (intBox1.getObj() instanceof Integer && intBox2.getObj() instanceof Integer) {

        // здесь для сложения делаем приведение типов
            int sum = (Integer) intBox1.getObj() + (Integer) intBox2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The contents of the boxes differ by type");
        }

        // вызвали какой-нибудь метод, которому отдали intBox1
        // и этот метод кладет в коробку String
        intBox1.setObj("Java");

        if (intBox1.getObj() instanceof Integer && intBox2.getObj() instanceof Integer) {

        // здесь для сложения делаем приведение типов
            int sum = (Integer) intBox1.getObj() + (Integer) intBox2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The contents of the boxes differ by type");
        }

        // продолжаем наш код, и при выполнении получим ClassCastException
        //int secondSum = (Integer)intBox1.getObj() + (Integer)intBox2.getObj();
    }

}
