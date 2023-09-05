///**
// * Создал Андрей Антонов 29.08.2023 15:20
// **/
//package library.repository;
//
//import library.model.Book;
//import library.model.User;
//import library.model.UserBook;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserBookRepository {
//    private final List<UserBook> userBookList = new ArrayList<>();
//    private final BookRepository bookRepository;
//
//    public UserBookRepository(final BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public Boolean addUserBook(final UserBook userBook) {
//        if (userBook.getBookId() == findByBook(bookRepository.getBookById(userBook.getBookId()))) {
//            return false;
//        }
//
//        userBookList.add(userBook);
//        return true;
//    }
//
//    public Boolean removeUserBook(final UserBook userBook) {
//        for (UserBook userB : userBookList) {
//            if (userB.equals(userBook)) {
//                userBookList.remove(userBook);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Integer findByUser(final User user) {
//        for (UserBook userB : userBookList) {
//            if (userB.getUserId() == user.getId()) {
//                return userB.getUserId();
//            }
//        }
//        return null;
//    }
//
//    public Integer findByBook(final Book book) {
//        for (UserBook userB : userBookList) {
//            if (userB.getBookId() == book.getId()) {
//                return userB.getBookId();
//            }
//        }
//        return null;
//    }
//
//}
