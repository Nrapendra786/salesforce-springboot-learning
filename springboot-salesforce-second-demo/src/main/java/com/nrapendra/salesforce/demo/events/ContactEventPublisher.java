package com.nrapendra.salesforce.demo.events;


import com.nrapendra.salesforce.demo.models.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ContactEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishContactEvent(Contact contact) {
        applicationEventPublisher.publishEvent(new ContactEvent(contact));
    }
}
