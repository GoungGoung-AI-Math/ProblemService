package com.example.demo.kafka.mapper;

import com.example.demo.domain.attempt.dto.AttemptAnalysisRequest;
import com.example.demo.my.kafka.infra.avrobuild.AttemptAnalysisRequestAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AttemptAnalysisDataMapper {
    public AttemptAnalysisRequestAvroModel attemptAnalysisRequest(AttemptAnalysisRequest attemptAnalysisRequest) {
        return null;
    }
}
