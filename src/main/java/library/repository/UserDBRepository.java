package library.repository;

import library.model.User;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDBRepository implements CrudRepository<User, Long> {

    @Override
    public Optional<User> findById(final Long id) {
        return null;
    }

    @Override
    public void save(final User user) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users (name) VALUES (?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(final Long id) {
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
