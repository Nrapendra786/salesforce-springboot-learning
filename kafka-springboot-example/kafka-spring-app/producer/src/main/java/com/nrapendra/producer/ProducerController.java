package com.nrapendra.producer;

import com.nrapendra.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping(value = "/produce")
    public ResponseEntity<Boolean> produce(@RequestBody Message myMsg) {
        try {
            kafkaProducerService.send("topic-name", myMsg);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception ex) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }
}
