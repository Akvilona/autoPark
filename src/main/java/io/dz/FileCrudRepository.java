package io.dz;

import io.User;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.ls.LSException;

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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static javax.swing.UIManager.get;

public class FileCrudRepository implements CrudRepository<User> {
    private final static String fileName = "users.csv";
    private final static String poleSeparator = ";";
    @Override
    public Optional<User> findById(long id) throws IOException {
        Path path = getPath();

        List<String> string = Files.readAllLines(path, Charset.forName(String.valueOf(StandardCharsets.UTF_8)));

        User user = new User();
        for (String str : string) {
            List<String> myList = new ArrayList<String>(Arrays.asList(str.split(poleSeparator)));
            if (myList.get(0).equals(String.valueOf(id))) {
                user.setId(Integer.valueOf(myList.get(0)));
                user.setName(myList.get(1));
                user.setAge(Integer.valueOf(myList.get(2)));
                break;
            }
        }

        return Optional.of(user);
    }

    @Override
    public Optional<User> findByObject(User user) throws IOException {
        Path path = getPath();
        List<String> string = Files.readAllLines(path, Charset.forName(String.valueOf(StandardCharsets.UTF_8)));

        User user1 = new User();
        for (String str : string) {
            List<String> myList = new ArrayList<String>(Arrays.asList(str.split(poleSeparator)));
            if (myList.get(0).equals(String.valueOf(user.getId())) &&
                myList.get(1).equals(String.valueOf(user.getName())) &&
                myList.get(2).equals(String.valueOf(user.getAge()))) {
                user1 = user;
                break;
            }
        }

        return Optional.of(user1);
    }

    @Override
    public void save(User user) throws IOException {
        Path path = getPath();

        String lineSeparator = System.lineSeparator();

        Files.writeString(path, String.valueOf(user.getId())        + poleSeparator
                                    + String.valueOf(user.getName())    + poleSeparator
                                    + user.getAge()                     + lineSeparator,
                StandardOpenOption.APPEND);

    }

    @NotNull
    private Path getPath() throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        Path path = Paths.get(file.toURI());
        return path;
    }
    private Void deleteFile(Path path) {

        File file = path.toFile();

        file.deleteOnExit();
        return null;
    }


    @Override
    public void delete(long id) throws IOException {
        Path path = getPath();
        List<String> string = Files.readAllLines(path, Charset.forName(String.valueOf(StandardCharsets.UTF_8)));
        deleteFile(path);

        for (String str : string) {
            List<String> myList = new ArrayList<>(Arrays.asList(str.split(poleSeparator)));

            if (!(Long.valueOf(myList.get(0)) == id)) {
                User user = new User(Integer.valueOf(myList.get(0)), myList.get(1), Integer.valueOf(myList.get(2)));
                save(user);
            }
        }
    }

    @Override
    public List<User> findAll() throws IOException {
        Path path = getPath();
        List<String> string = Files.readAllLines(path, Charset.forName(String.valueOf(StandardCharsets.UTF_8)));

        List<User> list = new ArrayList<>();
        for (String str : string) {
            List<String> myList = new ArrayList<>(Arrays.asList(str.split(poleSeparator)));
            User user = new User( Integer.valueOf(myList.get(0)), myList.get(1), Integer.valueOf(myList.get(2)));
            list.add(user);
        }
        return list;
    }
}
