/**
 * Создал Андрей Антонов 03.10.2023 11:45
 **/
<<<<<<<< HEAD:src/main/java/hibernate/libraly/repository/ReviewRepository.java
package hibernate.libraly.repository;

import hibernate.libraly.entity.Review;
import hibernate.libraly.utils.HibernateUtils;
========
package hibernate.library.repository;

import hibernate.library.entity.Review;
import hibernate.library.utils.HibernateUtils;
>>>>>>>> origin/master:src/main/java/hibernate/library/repository/ReviewRepository.java
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ReviewRepository implements CrudRepository<Review, Long> {
    @Override
    public Review save(final Review review) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(review);
            transaction.commit();
        }
        return review;
    }


    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
<<<<<<<< HEAD:src/main/java/hibernate/libraly/repository/ReviewRepository.java
//            Query<Review> query = session.createQuery("delete Review r where r.id = :id", Review.class);
//            query.setParameter("id", id);
//            query.executeUpdate();
//            transaction.commit();

            session.remove(session.get(Review.class, id));
========
            Review review = session.get(Review.class, id);
            session.remove(review);
>>>>>>>> origin/master:src/main/java/hibernate/library/repository/ReviewRepository.java
            transaction.commit();
        }

    }

    @Override
    public List<Review> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Review r", Review.class).list();
        }
    }

    @Override
    public Optional<Review> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Review.class, id));
        }
    }
}
