package hibernate.repository;

import hibernate.entity.Book;
import hibernate.utils.HibernateUtils;
import library.utils.DbUtils;
import nio.dz.CrudRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static library.constant.SqlQuery.BOOK_SELECT_FROM_BOOK;

public class BookHibernateRepository implements CrudRepository<Book, Long> {

    //TODO
    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        try (Session session1 = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session1.beginTransaction();
            session1.persist(book);
            transaction.commit();
        }
        return book;
    }

    //TODO
    @Override
    public List<Book> findAll() {
        Transaction transaction = null;
        try (Session session1 = HibernateUtils.getSessionFactory().openSession()) {
//            ResultSet resultSet = statement.executeQuery(BOOK_SELECT_FROM_BOOK.getValue());
//            List<library.entity.Book> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                result.add(convert(resultSet));
//            }
//            return result;

            transaction = session1.beginTransaction();
//            session1.persist(book);
            transaction.commit();
        }
//         catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


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
