/**
 * Создал Андрей Антонов 08.10.2023 18:15
 **/
package hibernate.habr.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "f_comments")
public class FComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_comment")
    private Long fComment;

    @Column(name = "commetn")
    private String comment;

    @Column(name = "dateCreate", nullable = false)
    private LocalDate dateCreate;

    @ToString.Exclude
    @ManyToOne(
            cascade = {
                            CascadeType.PERSIST,
                            CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "f_post",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_fcomment_fpost")
    )
    private FPost fPost;
}
