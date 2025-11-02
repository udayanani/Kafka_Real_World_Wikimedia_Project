package com.example.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {

        EventHandler eventHandler = new WikimediaChangesEventHandler(kafkaTemplate, topicName);

        String uri = "https://stream.wikimedia.org/v2/stream/recentchange";

        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "KafkaProducer/1.0 (udaya@example.com)");

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(uri))
                .headers(Headers.of(headers));

        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

        eventSource.close();


    }
}
