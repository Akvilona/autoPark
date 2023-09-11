/**
 * Создал Андрей Антонов 08.09.2023 15:04
 **/
package library.model;

import java.util.Random;

public class CommentUser {
    private Long id;
    private Long bookUser;
    private String comment;

    public CommentUser(final Long bookUser, final String comment) {
        this.id = new Random().nextLong();
        this.bookUser = bookUser;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getBookUser() {
        return bookUser;
    }

    public void setBookUser(final Long bookUser) {
        this.bookUser = bookUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentUser{"
                + "id=" + id
                + ", bookUser=" + bookUser
                + ", comment='" + comment + '\''
                + '}';
    }
}
