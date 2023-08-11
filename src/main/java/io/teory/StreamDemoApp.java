/**
 * Создал Андрей Антонов 09.08.2023 13:05
 **/
package io.teory;

import java.io.*;
import java.util.Arrays;

public class StreamDemoApp implements Serializable {
    private static class Cat implements Serializable {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat " + name;
        }
    }

    public static void main(String[] args) {
        byte[] byteCat = null;
        try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
             ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
            Cat catOut = new Cat("Barsik");
            objOut.writeObject(catOut);
            byteCat = barrOut.toByteArray();
            System.out.println("Befor serealisation: " + catOut);
            System.out.println("Bat print : " + Arrays.toString(byteCat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ByteArrayInputStream barrIn = new ByteArrayInputStream(byteCat);
             ObjectInputStream objIn = new ObjectInputStream(barrIn)) {
            Cat catIn = (Cat) objIn.readObject();
            System.out.println("Restore: " + catIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
