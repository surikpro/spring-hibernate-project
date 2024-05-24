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
public class TaskDto {
    private String taskName;
    private String taskDescription;
    public static TaskDto from(Task task) {
        return TaskDto.builder()
                .taskName(task.getTaskName())
                .taskDescription(task.getTaskDescription())
                .build();
    }
    public static List<TaskDto> from(List<Task> tasks) {
        return tasks.stream().map(TaskDto::from).collect(Collectors.toList());
    }
}
