package com.example.Producer.Producers;

import com.example.Producer.POCEntity.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, Shelf> kafkaTemplate;

    public void sendMessage(String topic, Shelf shelf) {
        kafkaTemplate.send(topic, shelf);
    }

}