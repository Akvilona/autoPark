/**
 * Создал Андрей Антонов 08.10.2023 18:39
 **/

package db.hibernate.habr.repository;

import db.hibernate.habr.entity.Post;
import db.hibernate.repository.CrudRepository;
import db.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PostRepository implements CrudRepository<Post, Long> {
    @Override
    public Post save(final Post fPost) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(fPost);
            transaction.commit();
            return fPost;
        }
    }

    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(session.get(Post.class, id));
            transaction.commit();
        }

    }

    @Override
    public List<Post> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Post", Post.class).list();
        }
    }

    @Override
    public Optional<Post> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Post.class, id));
        }
    }
}
