package hibernate.domain.dto;

import hibernate.domain.entity.Account;
import hibernate.domain.entity.Position;
import hibernate.domain.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private String firstName;
    private String lastName;
    private List<Project> projects;
    private List<Position> positions;

}
