package hibernate.library.repository;

import hibernate.library.entity.User;
import hibernate.library.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserRepository implements CrudRepository<User, Long> {
    @Override
    public User save(final User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
        return user;
    }

    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.remove(session.get(User.class, id));
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from User u JOIN FETCH u.bookUsers bUsers",
                    User.class).list();
        }
    }

    @Override
    public Optional<User> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession())  {
            return Optional.ofNullable(session.get(User.class, id));
        }
    }
}
