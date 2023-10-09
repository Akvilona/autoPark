/**
 * Создал Андрей Антонов 08.10.2023 18:39
 **/
package hibernate.habr.repository;

import hibernate.habr.entity.FPost;
import hibernate.habr.utils.FHibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class FPostRepository implements FCrudRepository<FPost, Long> {
    @Override
    public FPost save(final FPost fPost) {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(fPost);
            transaction.commit();
            return fPost;
        }
    }

    @Override
    public void delete(final Long id) {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(session.get(FPost.class, id));
            transaction.commit();
        }

    }

    @Override
    public List<FPost> findAll() {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from FPost", FPost.class).list();
        }
    }

    @Override
    public Optional<FPost> findById(final Long id) {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(FPost.class, id));
        }
    }
}
