package hibernate.repository;

import hibernate.entity.Book;
import hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BookRepository implements CrudRepository<Book, Long> {
    @Override
    public Book save(final Book book) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(book);

            transaction.commit();
            return book;
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Book.class, id));
        }
    }
}
