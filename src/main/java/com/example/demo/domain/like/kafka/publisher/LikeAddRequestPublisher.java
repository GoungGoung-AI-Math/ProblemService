package com.example.demo.domain.like.kafka.publisher;

import Math.AI.my.kafka.infra.avrobuild.Math.AI.my.kafka.infra.avrobuild.LikeAddRequestAvroModel;
import Math.AI.my.kafka.infra.avrobuild.Math.AI.my.kafka.infra.avrobuild.RelationType;
import Math.AI.my.kafka.infra.kafka.config.ProblemServiceKafkaConfigData;
import Math.AI.my.kafka.infra.kafka.producer.KafkaProducer;
import Math.AI.my.kafka.infra.kafka.publisher.kafka.DomainEventPublisher;
import com.example.demo.domain.like.kafka.event.LikeAddRequestEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LikeAddRequestPublisher implements DomainEventPublisher<LikeAddRequestEvent> {
    private final KafkaProducer<String, LikeAddRequestAvroModel> kafkaProducer;
    private final ProblemServiceKafkaConfigData problemServiceKafkaConfigData;

    @Override
    public void publish(LikeAddRequestEvent domainEvent) {
        Long domainId = domainEvent.getLikeAddRequest().getRelationId();
        log.info("Received LikeAddRequestEvent id: {} type : {}", domainId, domainEvent.getLikeAddRequest().getType());
        try {
            String key = domainId+" "+domainEvent.getLikeAddRequest().getType().name();

            LikeAddRequestAvroModel avroModel = LikeAddRequestAvroModel.newBuilder()
                    .setRelationId(domainEvent.getLikeAddRequest().getRelationId())
                    .setGiverId(domainEvent.getLikeAddRequest().getGiverId())
                    .setReceiverId(domainEvent.getLikeAddRequest().getReceiverId())
                    .setRelationType(RelationType.valueOf(domainEvent.getLikeAddRequest().getType().name()))
                    .build();

            kafkaProducer.send(problemServiceKafkaConfigData.getLikeAddRequestTopicName(),
                    key,
                    avroModel);

            log.info("LikeAddRequestAvroModel sent to kafka at: {}", System.nanoTime());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error("Error while sending LikeAddRequestAvroModel message" +
                    " to kafka with domain id: {}, type: {} error: {}", domainId, domainEvent.getLikeAddRequest().getType(),e.getMessage());
        }
    }
}
