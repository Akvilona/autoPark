/**
 * Создал Андрей Антонов 03.10.2023 11:45
 **/
package hibernate.repository;

import hibernate.utils.HibernateUtils;
import library.entity.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ReviewRopository implements CrudRepository<Review, Long> {
    @Override
    public Review save(final Review review) {

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(review);
            transaction.commit();
        }
        return review;
    }


    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.remove(session.get(Review.class, id));
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
