package com.javaguides.springboot;

import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesProducer {
    public static final String TOPIC = "wikimedia_recentchange";
    public static final String URL = "https://stream.wikimedia.org/v2/stream/recentchange";

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Read real time stream data from wikimedia via event source
     */
    @SneakyThrows
    public void sendMessage() {
        WikimediaChangesHandler handler = new WikimediaChangesHandler(kafkaTemplate, TOPIC);
        EventSource.Builder builder = new EventSource.Builder(handler, URI.create(URL));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
        }
}
