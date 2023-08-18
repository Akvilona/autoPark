package nio.dz;

import lombok.RequiredArgsConstructor;
import nio.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class FileUserCrudRepository implements CrudRepository<User> {

    private final File file;

    @Override
    public Optional<User> findById(final int id) throws IOException {
        return findAll().stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<User> findByObject(final User user) throws IOException {
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
        List<User> userList = findAll().stream()
                .filter(user -> user.getId() != id)
                .toList();
        saveAll(userList);
    }

    @Override
    public List<User> findAll() throws IOException {
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

    private void saveAll(final List<User> userList) throws IOException {
        Files.writeString(getPath(), "id;name;age;salary" + System.lineSeparator(),
                StandardOpenOption.TRUNCATE_EXISTING);
        Files.writeString(getPath(), UserMapper.formatUserLine(userList), StandardOpenOption.APPEND);
    }
}
