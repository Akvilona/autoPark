/**
 * Создал Андрей Антонов 01.10.2023 12:05
 **/
<<<<<<<< HEAD:src/main/java/hibernate/libraly/entity/Review.java
package hibernate.libraly.entity;
========
package hibernate.library.entity;
>>>>>>>> origin/master:src/main/java/hibernate/library/entity/Review.java

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

<<<<<<<< HEAD:src/main/java/hibernate/libraly/entity/Review.java
    @ManyToOne(
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE })
========
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
>>>>>>>> origin/master:src/main/java/hibernate/library/entity/Review.java
    @JoinColumn(name = "book_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_review_book")
    )
    private Book book;

<<<<<<<< HEAD:src/main/java/hibernate/libraly/entity/Review.java
    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE })
========
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
>>>>>>>> origin/master:src/main/java/hibernate/library/entity/Review.java
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_review_user")
    )
    private User user;

    @Column(nullable = false)
    private String comment;

}
