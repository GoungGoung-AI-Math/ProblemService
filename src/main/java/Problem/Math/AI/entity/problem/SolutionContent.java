package Problem.Math.AI.entity.problem;

import Problem.Math.AI.entity.Content;
import Problem.Math.AI.entity.problem.OfficialSolution;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "solution_content")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolutionContent extends Content {

    @ManyToOne
    @JoinColumn(name = "official_solution_id")
    private OfficialSolution officialSolution;
}
