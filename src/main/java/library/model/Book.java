package library.model;

import java.time.LocalDate;

public class Book {

    private Long id;
    private String name;
    private LocalDate dateOfIssue;

    public Book(final String name, final LocalDate dateOfIssue) {
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

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", dateOfIssue=" + dateOfIssue
                + '}';
    }
}
