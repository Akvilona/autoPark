/**
 * Создал Андрей Антонов 03.10.2023 11:10
 **/
package hibernate.libraly.repository;

import hibernate.libraly.entity.BookUser;
import hibernate.libraly.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BookUserRepository implements CrudRepository<BookUser, Long> {
    @Override
    public BookUser save(final BookUser bookUser) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(bookUser);
            transaction.commit();
        }
        return bookUser;
    }

    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.remove(session.get(BookUser.class, id));
        }
    }

    @Override
    public List<BookUser> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from BookUser b JOIN FETCH b.book book",
                    BookUser.class).list();
        }
    }

    @Override
    public Optional<BookUser> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(BookUser.class, id));
        }
    }
}
