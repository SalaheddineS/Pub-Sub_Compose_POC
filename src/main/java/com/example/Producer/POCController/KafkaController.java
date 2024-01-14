package com.example.Producer.POCController;

import com.example.Producer.POCEntity.Shelf;
import com.example.Producer.Producers.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Shelf shelf) {
        messageProducer.sendMessage("my-topic", shelf);
        return "Message sent: " + shelf.toString();
    }

}
