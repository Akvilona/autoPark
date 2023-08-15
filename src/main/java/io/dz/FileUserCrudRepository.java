package io.dz;

import io.User;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class FileUserCrudRepository implements CrudRepository<User> {

    private final File file;

    @Override
    public Optional<User> findById(final int id) throws IOException {
//        List<User> userList = findAll();
//
//        for (User user : userList) {
//            if (user.getId() == id) {
//                return Optional.of(user);
//            }
//        }
//        return Optional.empty();

        return findAll().stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<User> findByObject(final User user) throws IOException {
//        for (User u : findAll()) {
//            if (u.equals(user)) {
//                return Optional.of(user);
//            }
//        }
//        return Optional.empty();

        return findAll().stream()
                .filter(usr -> usr.equals(user))
                .findFirst();
    }

    @Override
    public void save(final User user) throws IOException {
        List<User> userList = findAll();

        int userIndex = userList.indexOf(user);
        if (userIndex != -1) {
            userList.set(userIndex, user);
            saveAll(userList);
        } else {
            String userString = UserMapper.formatUserLine(user);
            Files.writeString(getPath(), userString, StandardOpenOption.APPEND);
        }
    }

    @Override
    public void delete(final int id) throws IOException {
        // userList.removeIf(user -> user.getId() == id);
        List<User> userList = findAll().stream()
                .filter(user -> user.getId() != id)
                .toList();
        saveAll(userList);
    }

    @Override
    public List<User> findAll() throws IOException {
//        List<String> stringList = Files.readAllLines(getPath(), StandardCharsets.UTF_8);
//        List<User> list = new ArrayList<>();
//        for (int i = 1; i < stringList.size(); i++) {
//            String str = stringList.get(i);
//            User user = UserMapper.getUser(str);
//            list.add(user);
//        }
//        return list;

        try (Stream<String> fileLines = Files.lines(getPath())) {
            return fileLines
                    .skip(1)
                    .map(UserMapper::getUser)
                    .toList();
        }
    }

    private void calcAllSum() throws IOException {
        try (Stream<String> fileLines = Files.lines(getPath())) {
            BigDecimal sumAll = fileLines
                    .skip(1)
                    .map(UserMapper::getUser)
                    .map(user -> user.getSalary()
                            .add(BigDecimal.valueOf(user.getId()))
                            .add(BigDecimal.valueOf(user.getAge())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            System.out.println(sumAll);
        }
    }

    private Path getPath() {
        return Paths.get(file.toURI());
    }

    private void saveAll(List<User> userList) throws IOException {
        Files.writeString(getPath(), "id;name;age;salary" + System.lineSeparator(),
                StandardOpenOption.TRUNCATE_EXISTING);
        Files.writeString(getPath(), UserMapper.formatUserLine(userList), StandardOpenOption.APPEND);
    }
}
