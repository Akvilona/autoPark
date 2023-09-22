package library.repository.db;

import library.model.User;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDBRepository implements CrudRepository<User, Long> {

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM users WHERE id = ?";

    private static final String SELECT_ALL_USER_SQL = "select * from users";

    private static final String INSERT_USER_SQL = "insert into users (name) VALUES (?)";

    private static final String DELETE_BY_ID_SQL = "DELETE FROM users WHERE id = ?";

    @Override
    public void delete(final Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public Optional<User> findById(final Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            ResultSet resultSet = getResultSetSQL(id, preparedStatement);
            if (resultSet.next()) {
                long idUser = resultSet.getLong("id");
                String name = resultSet.getString("name");

                User user = new User(idUser, name);
                return Optional.of(user);
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public User save(final User user) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();
            user.setId(getGeneratedKeys(preparedStatement));
            connection.commit();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USER_SQL);
            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");

                User user = new User(id, name);
                result.add(user);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
