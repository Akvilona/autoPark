/**
 * Создал Андрей Антонов 08.09.2023 15:04
 **/
package library.model;

public class Review {
    private Long id;
    private Long bookId;
    private Long userId;
    private String comment;

    public Review(final Long bookId, final Long userId, final String comment) {
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
    }

    public Review(Long id, Long bookId, Long userId, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(final Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{"
                + "id=" + id
                + ", bookId=" + bookId
                + ", userId=" + userId
                + ", comment='" + comment + '\''
                + '}';
    }
}
