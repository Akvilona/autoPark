/**
 * Создал Андрей Антонов 29.08.2023 6:39
 **/
package library.model;

import java.util.Date;

public class Book {

    private Integer id;
    private String name;
    private Date dateOfIssue;

    public Book(final Integer id, final String name, final Date dateOfIssue) {
        this.id = id;
        this.name = name;
        this.dateOfIssue = dateOfIssue;
    }

    public void setDateOfIssue(final Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
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
