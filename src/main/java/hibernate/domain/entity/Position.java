package hibernate.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@ToString(exclude = "account")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "position_title")
    private String positionTitle;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    Account account;
}
