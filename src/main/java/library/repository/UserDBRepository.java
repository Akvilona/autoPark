package library.repository;

import library.model.User;
import library.utils.DbUtils;
import nio.dz.CrudRepository;
import org.jetbrains.annotations.NotNull;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDBRepository implements CrudRepository<User, Long> {

    @Override
    public void delete(final Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteByIdSQL())) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public Optional<User> findById(final Long id) {
        String selectByIdSQL = getSelectByIdSQL();
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(selectByIdSQL)) {
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
                     connection.prepareStatement(insertUser(), Statement.RETURN_GENERATED_KEYS)) {
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
        String selectAllUsersSQL = getSelectAllUsersSQL();
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAllUsersSQL);
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

    @NotNull
    private String getSelectByIdSQL() {
        return "SELECT * FROM users WHERE id = ?";
    }

    @NotNull
    private String getSelectAllUsersSQL() {
        return "select * from users";
    }

    @NotNull
    private String insertUser() {
        return "insert into users (name) VALUES (?)";
    }

    private String deleteByIdSQL() {
        return  "DELETE FROM users WHERE id = ?";
    }

    private ResultSet getResultSetSQL(Long id, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeQuery();
    }

    private Long getGeneratedKeys(final PreparedStatement preparedStatement) {
        try {
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
