package nio.dz;

import library.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static library.constant.SqlQuery.FIND_BY_ID;

public interface CrudRepository<T, K> {

    T save(T t);

    void delete(K id);

    List<T> findAll();

    T convert(ResultSet resultSet) throws SQLException;

    String getTableName();

    default Optional<T> findById(final Long id) {
        Connection connection = DbUtils.getConnection();
        var findBySqlQuery = FIND_BY_ID.getValue().formatted(getTableName());
        try (var preparedStatement = connection.prepareStatement(findBySqlQuery)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(convert(resultSet));
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    default Long getGeneratedKeys(final PreparedStatement preparedStatement) {
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

    default ResultSet getResultSetSQL(final Long id, final PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeQuery();
    }

}
