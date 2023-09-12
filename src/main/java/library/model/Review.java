/**
 * Создал Андрей Антонов 08.09.2023 15:04
 **/
package library.model;

public class Review {
    private Long id;
    private Long bookId;
    private Long userId;
    private String comment;

    public Review(Long bookId, Long userId, String comment) {
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
