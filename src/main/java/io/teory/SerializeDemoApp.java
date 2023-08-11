/**
 * Создал Андрей Антонов 09.08.2023 13:53
 **/
package io.teory;

import java.io.*;

public class SerializeDemoApp {
    private static class Book implements Serializable {
        private String title;

        public Book(String title) {
            this.title = title;
        }
    }

    private static class Student implements Serializable {
        private int id;
        private String name;
        private int score;
        private Book book;

        public Student(int id, String name, int score) {
            System.out.println("Конструктор класса Student");
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public void info() {
            System.out.println(id + " " + name + " " + score);
        }
    }

    public static void main(String[] args) {
        Student studentOneOut = new Student(1, "Боб", 80);
        Student studentTwoOut = new Student(2, "Билл", 70);
        Book jungleBook = new Book("Jungle Book");
        studentOneOut.book = jungleBook;
        studentTwoOut.book = jungleBook;
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            objOut.writeObject(studentOneOut);
            objOut.writeObject(studentTwoOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student studentOneIn = null;
        Student studentTwoIn = null;
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("students.ser"))) {
            studentOneIn = (Student) objIn.readObject();
            studentTwoIn = (Student) objIn.readObject();
            studentOneIn.info();
            studentTwoIn.info();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(studentOneIn.book);
        System.out.println(studentTwoIn.book);
    }

}
