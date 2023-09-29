package hibernate.repository;

import hibernate.entity.Book;
import nio.dz.CrudRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookHibernateRepository implements CrudRepository<Book, Long> {

    //TODO
    @Override
    public Book save(Book book) {
        return null;
    }

    //TODO
    @Override
    public List<Book> findAll() {
        return null;
    }

    //TODO
    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

    //TODO
    @Override
    public Optional<Book> findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public Book convert(ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException();
    }
}
