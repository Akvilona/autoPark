package hibernate.library.repository;

import hibernate.library.entity.Book;
import hibernate.library.utils.HibernateUtils;
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
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.remove(session.get(Book.class, id));
        }
    }

    @Override
    public List<Book> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Book b JOIN FETCH b.bookUsers bUsers",
                                          Book.class).list();
        }
    }

    @Override
    public Optional<Book> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Book.class, id));
        }
    }
}
