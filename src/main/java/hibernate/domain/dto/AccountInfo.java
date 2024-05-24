package hibernate.domain.dto;

import hibernate.domain.entity.Position;
import hibernate.domain.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfo {
    private String firstName;
    private String lastName;
    private List<ProjectDto> projects;
    private List<PositionDto> positions;
}
