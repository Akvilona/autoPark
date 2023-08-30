/**
 * Создал Андрей Антонов 29.08.2023 15:14
 **/
package library.model;

public class UserBook {
    private Integer userId;
    private Integer bookId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public UserBook(final Integer userId, final Integer bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(final Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserBook)) {
            return false;
        }

        UserBook userBook = (UserBook) o;

        if (!userId.equals(userBook.userId)) {
            return false;
        }
        return bookId.equals(userBook.bookId);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + bookId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserBook{"
                + "userId=" + userId
                + ", bookId=" + bookId
                + '}';
    }
}
