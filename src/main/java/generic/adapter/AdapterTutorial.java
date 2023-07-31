/**
 * Создал Андрей Антонов 31.07.2023 12:41
 * https://youtu.be/XXHoFG3acdA
 **/
package generic.adapter;

import java.util.ArrayList;

public class AdapterTutorial {
    ArrayList<PrintInterface> printInterfaces = new ArrayList<>();
    public void p() {
        for (PrintInterface printInterface : printInterfaces) {
            printInterface.consolePrint();
        }
    }
}

/**
 * Первый способ основанный на наследование
 * Что я сделал, у нас был класс Client, который очень хочет вызвать
 * у класса Print метод print() и он это хочет сделать через интерфейс PrintInterface
 * я создал наследника от Pinter -> PrinterSecond и имплементировал в нем PrintInterface
 * и в методе, который был определен в PrintInterface потому что список методов по типу указателя
 * соответственно мы вызвали этот принт this.print() в методе consolePrint()
 *
 * Второй способ метод композиции
 * У нас есть класс Printer с методом void print()
 * мы создаем классclass PrinterComp implements PrintInterface в конструкторе объект
 * нового принтера передаем и потом у объекта нового принтера вызываем новый printer.print()
 * */
class Client {
    public static void main(String[] args) {
        PrintInterface printInterface = new PrinterSecond();
        printInterface.consolePrint();
        PrintInterface printInterface1 = new PrinterComp(new Printer());
        printInterface1.consolePrint();

    }
}
/***************** Первый способ основанный на наследование ************************/
interface PrintInterface {
    void consolePrint();
}
class PrinterSecond extends Printer implements PrintInterface {

    @Override
    public void consolePrint() {
        this.print();
    }
}
class Printer {
    void print() {
        System.out.println("Hello");
    }
}
/*************************** Второй способ это метод композиции ************************/
class PrinterComp implements PrintInterface{

    private Printer printer = new Printer();
    PrinterComp(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void consolePrint() {
        printer.print();
    }
}
