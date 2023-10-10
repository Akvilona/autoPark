package db.jdbc.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data //Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@AllArgsConstructor
public class Book {

    private Long id;
    private String name;
    private LocalDate dateOfIssue;

    public Book(final String name, final LocalDate dateOfIssue) {
        this.name = name;
        this.dateOfIssue = dateOfIssue;
    }

}
