package hibernate;

import hibernate.entity.Book;
import hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Book book = Book.builder()
                .name("example")
                .dateOfIssue(LocalDate.now())
                .build();

        Transaction transaction = null;
        try (Session session1 = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session1.beginTransaction();

            session1.persist(book);
            transaction.commit();
        }
    }
}
