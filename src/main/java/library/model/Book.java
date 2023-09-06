/**
 * Создал Андрей Антонов 29.08.2023 6:39
 **/
package library.model;

import java.time.LocalDate;
import java.util.Date;

public class Book {

    private Long id;
    private String name;
    private LocalDate dateOfIssue;

    private Long userId;

    public Book(final Long id, final String name, final LocalDate dateOfIssue) {
        this.id = id;
        this.name = name;
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(final LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", userId=" + userId +
                '}';
    }
}
