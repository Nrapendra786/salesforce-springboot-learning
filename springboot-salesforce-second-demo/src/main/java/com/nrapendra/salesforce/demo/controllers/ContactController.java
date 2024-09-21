package com.nrapendra.salesforce.demo.controllers;

import com.nrapendra.salesforce.demo.models.Contact;
import com.nrapendra.salesforce.demo.models.PatchUpdates;
import com.nrapendra.salesforce.demo.services.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping(value = "/contacts")
    public ResponseEntity<List<Contact>> getContacts() {
        try {
            log.info(contactService.toString());
            return new ResponseEntity<>(contactService.getContacts(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/contacts/{id}")
    public ResponseEntity<Contact> getContacts(@PathVariable String id) {
        try {
            return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @RequestBody PatchUpdates patchUpdates) {
        log.debug("patchUpdates={}", patchUpdates);
        try {
            return new ResponseEntity<>(contactService.updateContact(id, patchUpdates), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
