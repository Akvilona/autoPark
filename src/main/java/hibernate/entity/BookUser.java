/**
 * Создал Андрей Антонов 01.10.2023 12:05
 **/
package hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data //Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
@Entity
@Builder
@Table(name = "BookUser")
@NoArgsConstructor
@AllArgsConstructor
public class BookUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private LocalDateTime returnDateTime;
}
