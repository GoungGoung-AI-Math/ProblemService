package Problem.Math.AI.domain.question;

import Problem.Math.AI.domain.ContentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "answer_content")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerContentEntity extends ContentEntity {
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Question question;
}