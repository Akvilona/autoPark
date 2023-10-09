/**
 * Создал Андрей Антонов 03.10.2023 11:10
 **/
<<<<<<<< HEAD:src/main/java/hibernate/libraly/repository/BookUserRepository.java
package hibernate.libraly.repository;

import hibernate.libraly.entity.BookUser;
import hibernate.libraly.utils.HibernateUtils;
========
package hibernate.library.repository;

import hibernate.library.entity.BookUser;
import hibernate.library.utils.HibernateUtils;
>>>>>>>> origin/master:src/main/java/hibernate/library/repository/BookUserRepository.java
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
