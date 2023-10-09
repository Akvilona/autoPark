/**
 * Создал Андрей Антонов 08.10.2023 18:09
 **/
package hibernate.habr.entity;

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

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "f_post")
public class FPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_post")
    private Long fPost;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "dateCreate", nullable = false)
    private LocalDate dateCreate;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "FComment", fetch = FetchType.LAZY)
    private List<FComment> fComments;


}
