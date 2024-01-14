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
    public void listen(String message) {
        System.out.println("Received message: " + message);
        Shelf shelf = Shelf.builder()
                .Name(message)
                .build();
        shelfRepository.save(shelf);
        for (Shelf s : shelfRepository.findAll()) {
            System.out.println(s.getName());
        }
    }

}
