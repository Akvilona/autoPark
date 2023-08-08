package io;

import io.dz.FileCrudRepository;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        File file = new File("users.csv");

        if (!file.exists()) {
            System.out.println(file.createNewFile());
        }

        URI uri = file.toURI();
        System.out.println("URI: " + uri);

//        String lineSeparator = System.lineSeparator();
//        Files.writeString(path, "2;Masha;30" + lineSeparator, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        Path path = Paths.get(uri);
        List<String> stringList = Files.readAllLines(path, Charset.forName(String.valueOf(StandardCharsets.UTF_8)));
        System.out.println(stringList);

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


        File file1 = new File("users.csv");
        FileCrudRepository fileCrudRepository = new FileCrudRepository(file1);
        fileCrudRepository.save(new User(1, "11", 1));
    }
}
