package io;


import io.dz.FileUserCrudRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.Random;

public class App {
    public static void main(String[] args) throws IOException {
        File file = new File("users.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileUserCrudRepository fileUserCrudRepository = new FileUserCrudRepository(file);

        Optional<User> foundUser = fileUserCrudRepository.findById(967);
//        fileUserCrudRepository.save(generateUser());
//        fileUserCrudRepository.save(generateUser(1, "newName"));
//        fileUserCrudRepository.save(generateUser(2, "second-name"));
        fileUserCrudRepository.delete(2);
    }

    private static User generateUser() {
        Random random = new Random();
        return User.builder()
                .id(random.nextInt(1000))
                .age(random.nextInt(100))
                .name("name-" + random.nextInt(1000))
                .build();
    }

    private static User generateUser(final int id, final String name) {
        return User.builder()
                .id(id)
                .age(id)
                .name(name)
                .build();
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
