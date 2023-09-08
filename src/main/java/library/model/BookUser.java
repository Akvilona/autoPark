package library.model;

import java.time.LocalDateTime;
import java.util.Random;

public class BookUser {
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDateTime from;
    private LocalDateTime to;
    private LocalDateTime returnDateTime;

    public BookUser(Long bookId, Long userId, LocalDateTime from, LocalDateTime to) {
        this.id = new Random().nextLong();
        this.bookId = bookId;
        this.userId = userId;
        this.from = from;
        this.to = to;
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

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    @Override
    public String toString() {
        return "BookUser{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", from=" + from +
                ", to=" + to +
                ", returnDateTime=" + returnDateTime +
                '}';
    }
}
