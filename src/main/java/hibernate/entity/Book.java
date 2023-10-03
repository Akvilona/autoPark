package hibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;


@Data //Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@Entity
@Builder
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "date_of_issue", unique = false, nullable = false)
    private LocalDate dateOfIssue;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "bookId")
    private List<BookUser> bookUsers;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "bookId")
    private List<Review> reviews;

}
