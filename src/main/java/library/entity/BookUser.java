package library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//TODO: lombok
@Data //Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@NoArgsConstructor
public class BookUser {
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDateTime from;
    private LocalDateTime to;
    private LocalDateTime returnDateTime;

    public BookUser(final Long bookId, final Long userId, final LocalDateTime from, final LocalDateTime to) {
        this.bookId = bookId;
        this.userId = userId;
        this.from = from;
        this.to = to;
    }

    public BookUser(final Long id, final Long bookId, final Long userId, final LocalDateTime from, final LocalDateTime to, final LocalDateTime returnDateTime) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.from = from;
        this.to = to;
        this.returnDateTime = returnDateTime;
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

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(final LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(final LocalDateTime to) {
        this.to = to;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(final LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    @Override
    public String toString() {
        return "BookUser{"
                + "id=" + id
                + ", bookId=" + bookId
                + ", userId=" + userId
                + ", from=" + from
                + ", to=" + to
                + ", returnDateTime=" + returnDateTime
                + '}';
    }
}
