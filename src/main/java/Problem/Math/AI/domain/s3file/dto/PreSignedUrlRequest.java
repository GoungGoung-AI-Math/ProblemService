package Problem.Math.AI.domain.s3file.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PreSignedUrlRequest {
    private String keyName;
    private Map<String, String> metadata;
}