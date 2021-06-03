package com.practice.springKafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> KafkaTemplate;

    private static final String TOPIC = "kafka_test";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){

        KafkaTemplate.send(TOPIC, new User(name, "IT", 3000L));
        return "Published succcessfully";
    }


}
