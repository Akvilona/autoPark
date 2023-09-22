package library.repository.list;

import library.model.BookUser;
import nio.dz.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookUserRepository implements CrudRepository<BookUser, Long> {
    private final List<BookUser> bookUserList = new ArrayList<>();

    @Override
    public Optional<BookUser> findById(final Long id) {
        for (BookUser bookUser : bookUserList) {
            if (bookUser.getBookId().equals(id)) {
                return Optional.of(bookUser);
            }
        }
        return Optional.empty();
    }

    @Override
    public BookUser save(final BookUser bookUser)  {
        bookUserList.add(bookUser);
        return bookUser;
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public List<BookUser> findAll() {
        return bookUserList;
    }

    public Optional<BookUser> findByBookId(final Long bookId) {
        for (BookUser bookUser : bookUserList) {
            if (bookUser.getBookId().equals(bookId)) {
                return Optional.of(bookUser);
            }
        }
        return Optional.empty();
    }

    public Optional<BookUser> findByBookIdAndReturnDateTimeIsNull(final Long bookId) {
        return bookUserList.stream()
                .filter(bookUser -> bookUser.getBookId().equals(bookId))
                .filter(bookUser -> bookUser.getReturnDateTime() == null)
                .findFirst();
    }

    public Optional<BookUser> findByBookIdAndUserId(final Long bookId, final Long userId) {
        return bookUserList.stream()
                .filter(bookUser -> bookUser.getBookId().equals(bookId)
                    && bookUser.getUserId().equals(userId))
                .findFirst();
    }

}
