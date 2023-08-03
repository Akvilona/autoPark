/**
 * Создал Андрей Антонов 01.08.2023 17:19
 **/
package generic.linkedList;

public class Main {
    public static void main(String[] args) {
        Linked<String> stringLinked = new LinkedContainer<String>();
        stringLinked.addLast("abc1");
        stringLinked.addLast("abc2");
        stringLinked.addLast("abc3");
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElementByIndex(0));
    }
}
