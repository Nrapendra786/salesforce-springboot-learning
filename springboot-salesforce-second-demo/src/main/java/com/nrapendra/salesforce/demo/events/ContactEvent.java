package com.nrapendra.salesforce.demo.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.nrapendra.salesforce.demo.models.Contact;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactEvent {
    private Contact contact;
}
