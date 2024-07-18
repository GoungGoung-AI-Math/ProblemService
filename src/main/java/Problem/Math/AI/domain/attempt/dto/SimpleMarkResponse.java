package Problem.Math.AI.domain.attempt.dto;

import Problem.Math.AI.domain.attempt.entity.Status;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SimpleMarkResponse {
    private Long problemId;
    private Status status;
}