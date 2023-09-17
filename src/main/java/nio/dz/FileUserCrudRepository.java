package nio.dz;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import nio.User;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class FileUserCrudRepository implements CrudRepository<User, Integer> {

    private final File file;

    @Override
    public Optional<User> findById(final Integer id) {
        return findAll().stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @SneakyThrows
    @Override
    public User save(final User user) {
        List<User> userList = findAll();

        int userIndex = userList.indexOf(user);
        if (userIndex != -1) {
            userList.set(userIndex, user);
            saveAll(userList);
            return user;
        } else {
            String userString = UserMapper.formatUserLine(user);
            Files.writeString(getPath(), userString, StandardOpenOption.APPEND);

        }
        throw new RuntimeException();
    }

    @Override
    public void delete(final Integer id) {
        List<User> userList = findAll().stream()
                .filter(user -> user.getId() != id)
                .toList();
        saveAll(userList);
    }

    @SneakyThrows
    @Override
    public List<User> findAll() {
        try (Stream<String> fileLines = Files.lines(getPath())) {
            return fileLines
                    .skip(1)
                    .map(UserMapper::getUser)
                    .toList();
        }
    }

    private Path getPath() {
        return Paths.get(file.toURI());
    }

    @SneakyThrows
    private void saveAll(final List<User> userList) {
        Files.writeString(getPath(), "id;name;age;salary" + System.lineSeparator(),
                StandardOpenOption.TRUNCATE_EXISTING);
        Files.writeString(getPath(), UserMapper.formatUserLine(userList), StandardOpenOption.APPEND);
    }
}
