package com.nrapendra.producer;

import com.nrapendra.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApplicationStartupListener {

    private final KafkaProducerService producerService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) {
        log.info("Application is ready!");
        performStartupTasks();
    }

    @Scheduled(fixedDelay = 5000)
    private void performStartupTasks() {
        var message = new Message();
        String eventId="7cb562f2-c7aa-427d-99eb-f2a93b11cdd6";
        String schemaId="vjfSL_rX8hSnqyn0Yla8Zw";
        String payload= "\\016Account\\002$0014H00002LbR7QQAV\\000\\002hcom/salesforce/api/soap/55.0;client=SfdcInternalAPI/H0000c8a0-6766-3414-949f-de10519bee7d\\002\\220\\302\\273\\345\\313`\\342\\205\\265\\215\\337\\223\\005$00558000000yFyDAAU\\000\\000\\004\\0200x400000\\f4-0x01\\000\\000\\000\\000\\002\\002\\03412 Main Street\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\002\\220\\302\\273\\345\\313`\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000";
        message.setId(eventId);
        message.setPayload(payload.getBytes(StandardCharsets.UTF_8));
        message.setSchema_id(schemaId);
        producerService.send("my_topic", message);
    }
}
