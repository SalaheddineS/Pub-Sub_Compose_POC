package com.example.Producer.Subscribers;

import com.example.Producer.POCEntity.Shelf;
import com.example.Producer.POCRepository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @Autowired
    ShelfRepository shelfRepository;
    @KafkaListener(topics = "my-topic", groupId = "consumer-id")
    public void listen(Shelf shelf) {
        System.out.println("Received object: " + shelf.getName());
        shelfRepository.save(shelf);
        for (Shelf s : shelfRepository.findAll()) {
            System.out.println(s.getName());
        }
    }

}
