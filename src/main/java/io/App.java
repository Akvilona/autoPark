package io;


import io.dz.FileCrudRepository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws IOException {
//        serializeUserExample();
//        File file = new File("users.csv");
//
//        if (!file.exists()) {
//            System.out.println(file.createNewFile());
//        }
//
//        /* Получение полного пути к файлу */
//        String srt1 = file.getAbsolutePath();
//        System.out.println(srt1);
//
//        String srt = String.valueOf(Path.of(file.toURI()));
//        System.out.println(srt);
//
//        String srt2 = String.valueOf(Paths.get(file.toURI()));
//        System.out.println(srt2);
//
//        URI uri = file.toURI();
//
//        Path path = Paths.get(uri);
//        Files.writeString(path,"2;Igor;26", StandardOpenOption.APPEND );
//
//        String strings = Files.readString(path);
//        System.out.println(strings);

/*        Path path = Path.get(file.toURI());

        URI uri = file.toURI();
        System.out.println("URI: " + uri);

        String lineSeparator = System.lineSeparator();
        Files.writeString(path, "2;Masha;30" + lineSeparator, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        Path path = Paths.get(uri);
        List<String> stringList = Files.readAllLines(path, Charset.forName(String.valueOf(StandardCharsets.UTF_8)));
        System.out.println(stringList);

 */
/*
        List<User> userList = new ArrayList<>();

        for (String str : stringList) {
            String[] split = str.split(";");

            int id = Integer.parseInt(split[0]);
            String name = split[1];
            int age = Integer.parseInt(split[2]);

            User user = new User(id, name, age);
            userList.add(user);
        }

        System.out.println(userList);

        User user1 = new User(1, "Example1", 11);
        User user2 = new User(2, "Example2", 22);
        List<User> list = List.of(user1, user2);

        for (User u : list) {
            String str = u.getId() + ";" + u.getName() + ";" + u.getAge() + System.lineSeparator();
            Files.writeString(path, str, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }

        String string = Files.readString(path);
        System.out.println(string);
*/
//        File file = new File("users.csv");
        FileCrudRepository fileCrudRepository = new FileCrudRepository();
//        fileCrudRepository.save(new User(7, "Ivanov", 71));
//        Optional<User> user = fileCrudRepository.findById(2);
//        List<User> user = fileCrudRepository.findAll();
       fileCrudRepository.delete(3);

    }

    public static void serializeUserExample() {
        var user = User.builder()
                .id(1)
                .name("Igor")
                .age(12)
                .build();
        var user2 = User.builder()
                .id(2)
                .name("Igor2")
                .age(22)
                .build();

        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream("users.ser"))) {
            objectOutputStream.writeObject(user);
            objectOutputStream.writeObject(user2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var objectInputStream = new ObjectInputStream(new FileInputStream("users.ser"))) {
            var readUser1 = (User) objectInputStream.readObject();
            var readUser2 = (User) objectInputStream.readObject();
            System.out.println(readUser1);
            System.out.println(readUser2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
