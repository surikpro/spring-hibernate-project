package hibernate.repositories;

import hibernate.domain.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ProjectsRepositoryJdbcImpl implements ProjectsRepository {
    private final DataSource dataSource;
    private static final String SQL_SELECT_PROJECTS_BY_ACCOUNT_ID = "SELECT * FROM project " +
            "INNER JOIN accounts_projects ON project.project_id = accounts_projects.project_id " +
            "WHERE accounts_projects.account_id = ?";

    @Override
    public Set<ProjectDto> getAllProjectsOfUser(Long accountId) {
        Set<ProjectDto> userProjects = new HashSet<>();
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PROJECTS_BY_ACCOUNT_ID);
            preparedStatement.setLong(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String projectName = resultSet.getString(2);
                userProjects.add(ProjectDto.builder()
                        .projectName(projectName)
                        .build());
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return userProjects;
    }
}
