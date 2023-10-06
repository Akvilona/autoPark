/**
 * Создал Андрей Антонов 03.10.2023 11:45
 **/
package hibernate.library.repository;

import hibernate.library.entity.Review;
import hibernate.library.utils.HibernateUtils;
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
            Review review = session.get(Review.class, id);
            session.remove(review);
            transaction.commit();
        }

    }

    @Override
    public List<Review> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Review r JOIN FETCH r.review bReview",
                    Review.class).list();
        }
    }

    @Override
    public Optional<Review> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Review.class, id));
        }
    }
}
