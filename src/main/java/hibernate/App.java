package hibernate;

import hibernate.entity.Book;
import hibernate.entity.BookUser;
import hibernate.entity.User;
import hibernate.repository.BookRepository;
import hibernate.utils.ComponentFactory;
import hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class App {
    public static void main(String[] args) {
//        BookRepository bookRepository = ComponentFactory.createRepository(BookRepository.class);

        Book book = Book.builder()
                .name(String.valueOf(new Random().nextInt()))
                .dateOfIssue(LocalDate.now())
                .build();
        User user = User.builder()
                .age(20)
                .name(String.valueOf(new Random().nextInt()))
                .build();

        BookUser bookUser = BookUser.builder()
                .user(user)
                .book(book)
                .dateFrom(LocalDateTime.now())
                .dateTo(LocalDateTime.now())
                .build();

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(bookUser);

            transaction.commit();
        }

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("from Book b JOIN FETCH b.bookUsers bUsers", Book.class);
            List<Book> list = query.list();
            System.out.println(list);
        }
    }
}
