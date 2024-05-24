package hibernate.domain.dto;

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
public class PositionDto {
    private String positionTitle;

    public static PositionDto from(Position position) {
        return PositionDto.builder()
                .positionTitle(position.getPositionTitle())
                .build();
    }
    public static List<PositionDto> from(List<Position> positions) {
        return positions.stream().map(PositionDto::from).collect(Collectors.toList());
    }
}
