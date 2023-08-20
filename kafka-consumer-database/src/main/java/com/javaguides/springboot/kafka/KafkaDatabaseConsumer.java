package com.javaguides.springboot.kafka;

import com.javaguides.springboot.model.entity.WikimediaData;
import com.javaguides.springboot.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private final WikimediaDataRepository repository;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage) {
        log.info("Event message was received: {}", eventMessage);
        repository.save(new WikimediaData(eventMessage));
    }
}
