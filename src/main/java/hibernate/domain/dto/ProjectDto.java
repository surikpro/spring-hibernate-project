package hibernate.domain.dto;

import hibernate.domain.entity.Project;
import hibernate.domain.entity.Task;
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
public class ProjectDto {
    private String projectName;

    private List<TaskDto> tasks;
    public static ProjectDto from(Project project) {
        return ProjectDto.builder()
                .projectName(project.getProjectName())
                .tasks(project.getTasks().stream().map(TaskDto::from).collect(Collectors.toList()))
                .build();
    }
    public static List<ProjectDto> from(List<Project> projects) {
        return projects.stream().map(ProjectDto::from).collect(Collectors.toList());
    }
}
