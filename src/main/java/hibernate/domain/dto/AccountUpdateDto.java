package hibernate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AccountUpdateDto {
    String firstName;
    String lastName;
}

