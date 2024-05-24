package hibernate.repositories;

import hibernate.domain.dto.ProjectDto;
import java.util.Set;

public interface ProjectsRepository {
    Set<ProjectDto> getAllProjectsOfUser(Long accountId);
}
