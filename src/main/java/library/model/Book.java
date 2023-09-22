package library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data //Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@AllArgsConstructor
//@Table("book")
//@Entity
public class Book {

    private Long id;
    private String name;
    private LocalDate dateOfIssue;

    public Book(final String name, final LocalDate dateOfIssue) {
        this.name = name;
        this.dateOfIssue = dateOfIssue;
    }

}
