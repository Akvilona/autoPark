/**
 * Создал Андрей Антонов 31.07.2023 16:25
 **/
package generic.adapter;

import javax.xml.catalog.Catalog;

public class AbstractFactoryTutorial  {
    public static void main(String[] args) {
        AbstractFactory factoryChocolate = new ChocolateFactory();
        AbstractFactory factoryCreamy = new CreamyFactory();

        factoryChocolate.getCake().printName();
        factoryChocolate.getMilkCocktail().printName();

        System.out.println();
        factoryCreamy.getMilkCocktail().printName();
        factoryCreamy.getCake().printName();
    }
}

interface AbstractFactory {
    Cake getCake();
    MickCocktail getMilkCocktail();
}

class ChocolateFactory implements AbstractFactory {
    @Override
    public Cake getCake() {
        return new ChocolateCake();
    }

    @Override
    public MickCocktail getMilkCocktail() {
        return new ChocolateMilkCocktail();
    }
}

class CreamyFactory implements AbstractFactory{
    @Override
    public Cake getCake() {
        return new CreamyCake();
    }

    @Override
    public MickCocktail getMilkCocktail() {
        return new CreamyMilkCocktail();
    }
}

interface Cake {
    void printName();
    void printPrise();
}

class ChocolateCake implements Cake {
    @Override
    public void printName() {
        System.out.println("Chocolate cake");
    }

    @Override
    public void printPrise() {
        System.out.println("50");
    }
}

class CreamyCake implements Cake {
    @Override
    public void printName() {
        System.out.println("Creamy cake");
    }

    @Override
    public void printPrise() {
        System.out.println("34");
    }
}

// КОКТЕЛИ
interface MickCocktail  {
    void printName();
    void printPrise();
}

class ChocolateMilkCocktail implements MickCocktail {
    @Override
    public void printName() {
        System.out.println("Milk cocktail chocolate");
    }

    @Override
    public void printPrise() {
        System.out.println("87");
    }
}

class CreamyMilkCocktail implements MickCocktail {
    @Override
    public void printName() {
        System.out.println("Milk cocktail creamy");
    }

    @Override
    public void printPrise() {
        System.out.println("60");
    }
}

