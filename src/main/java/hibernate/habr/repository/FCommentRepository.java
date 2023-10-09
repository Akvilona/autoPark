/**
 * Создал Андрей Антонов 08.10.2023 18:40
 **/
package hibernate.habr.repository;

import hibernate.habr.entity.FComment;
import hibernate.habr.entity.FPost;
import hibernate.habr.utils.FHibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class FCommentRepository implements FCrudRepository<FComment, Long> {
    @Override
    public FComment save(final FComment fComment) {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(fComment);
            transaction.commit();
        }
        return fComment;
    }

    @Override
    public void delete(final Long id) {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(session.get(FComment.class, id));
            transaction.commit();
        }

    }

    @Override
    public List<FComment> findAll() {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from FComment", FComment.class).list();
        }
    }

    @Override
    public Optional<FComment> findById(Long id) {
        try (Session session = FHibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(FComment.class, id));
        }
    }
}
