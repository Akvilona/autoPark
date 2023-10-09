package hibernate.libraly.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data //Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<BookUser> bookUsers;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews;


}
