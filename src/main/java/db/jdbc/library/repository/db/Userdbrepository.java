package db.jdbc.library.repository.db;

import db.jdbc.library.constant.SqlTable;
import db.jdbc.library.entity.User;
import db.jdbc.library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static db.jdbc.library.constant.SqlQuery.USER_INSERT_USER_SQL;
import static db.jdbc.library.constant.SqlQuery.USER_SELECT_ALL_USER_SQL;
import static db.jdbc.library.constant.SqlQuery.USER_SELECT_BY_ID_SQL;

public class Userdbrepository implements CrudRepository<User, Long> {
    @Override
    public User convert(final ResultSet resultSet) throws SQLException {
        long idUser = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new User(idUser, name);
    }

    @Override
    public String getTableName() {
        return SqlTable.USER.getTableName();
    }

    @Override
    public Optional<User> findById(final Long id) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement(USER_SELECT_BY_ID_SQL.getValue())) {
            ResultSet resultSet = getresultsetsql(id, preparedStatement);
            while (resultSet.next()) {
                return Optional.ofNullable(convert(resultSet));
            }
            return Optional.empty();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public User save(final User user) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(USER_INSERT_USER_SQL.getValue(), Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();
            user.setId(getGeneratedKeys(preparedStatement));
            connection.commit();
            return user;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    /*
    @Override
    public void delete(final Long id) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_DELETE_BY_ID_SQL.getValue())) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }
    */

    @Override
    public List<User> findAll() {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(USER_SELECT_ALL_USER_SQL.getValue());
            List<User> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(convert(resultSet));
            }
            return result;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

}
