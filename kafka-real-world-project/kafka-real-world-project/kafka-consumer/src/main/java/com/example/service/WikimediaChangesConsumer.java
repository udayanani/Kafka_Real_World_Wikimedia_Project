package com.example.service;

import com.example.entity.WikimediaChanges;
import com.example.repository.WikimediaChangesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaChangesConsumer {

    private static  final Logger logger = LoggerFactory.getLogger(WikimediaChangesConsumer.class);

    @Autowired
    private WikimediaChangesRepository wikimediaChangesRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String eventMessage){
        logger.info("Event Message is: {}", eventMessage);

        WikimediaChanges wikimediaChanges = new WikimediaChanges();
        wikimediaChanges.setEventMessage(eventMessage);
        wikimediaChangesRepository.save(wikimediaChanges);

    }

}
