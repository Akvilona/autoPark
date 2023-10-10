/**
 * Создал Андрей Антонов 08.10.2023 18:40
 **/
package db.hibernate.habr.repository;

import db.hibernate.habr.entity.Comment;
import db.hibernate.repository.CrudRepository;
import db.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CommentRepository implements CrudRepository<Comment, Long> {
    @Override
    public Comment save(final Comment comment) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(comment);
            transaction.commit();
        }
        return comment;
    }

    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(session.get(Comment.class, id));
            transaction.commit();
        }

    }

    @Override
    public List<Comment> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Comment", Comment.class).list();
        }
    }

    @Override
    public Optional<Comment> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Comment.class, id));
        }
    }
}
