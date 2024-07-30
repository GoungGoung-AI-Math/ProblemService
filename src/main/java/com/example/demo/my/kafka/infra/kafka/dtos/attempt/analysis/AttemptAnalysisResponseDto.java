package com.example.demo.my.kafka.infra.kafka.dtos.attempt.analysis;

import com.example.demo.my.kafka.infra.kafka.dtos.MessageType;
import com.example.demo.my.kafka.infra.kafka.dtos.AnalysisType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttemptAnalysisResponseDto {
    private Long attemptId;
    private AnalysisType analysisType;
    private MessageType messageType;
    private String content;
}