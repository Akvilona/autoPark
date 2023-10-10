/**
 * Создал Андрей Антонов 24.07.2023 17:01
 **/

package generic.teory;

public class BoxWithNumbers<T extends Number> { //пишем класс
    private T[] nums;

    //    public BoxWithNumbers(final T[] nums) { // конструктор
    //        this.nums = nums;
    //    }

    public BoxWithNumbers(final T... nums) { // создаем конструктор, который на вход принимает набор объектов без явного создания массива
        this.nums = nums;
    }

    // Без этих двух конструкторов у меня программа не работает, а почему не знаю
    //public BoxWithNumbers(final int a1, final int a2, final int a3, final int a4, final int a5) {    }
    // Без этих двух конструкторов у меня программа не работает, а почему не знаю
    //public BoxWithNumbers(final double d1, final double d2, final double d3, final double d4, final double d5) {    }

    public double avg() { // вычисление среднего значения
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue(); //преобразовываем в double
        }
        return sum / nums.length;
    }

    // сравниваем тот массив, для которого вызываем метод, с тем, который передаем в пераметре:
    public boolean sameAvg(final BoxWithNumbers<?> another) {
        final double a = 0.0001;
        return Math.abs(this.avg() - another.avg()) < a;
    }
}

