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

import java.util.List;

@Data //Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@Entity
@Builder
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "age", unique = false, nullable = false)
    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<BookUser> bookUsers;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "userId")
    private List<Review> reviews;
}
