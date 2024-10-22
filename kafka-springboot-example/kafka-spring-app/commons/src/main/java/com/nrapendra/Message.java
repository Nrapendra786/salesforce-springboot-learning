package com.nrapendra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    private String id;
    private String schema_id;
    private byte[] payload;

}


/**
 *  event {
 *     id: "7cb562f2-c7aa-427d-99eb-f2a93b11cdd6"
 *     schema_id: "vjfSL_rX8hSnqyn0Yla8Zw"
 *     payload: "\016Account\002$0014H00002LbR7QQAV\000\002hcom/salesforce/api/soap/55.0;client=SfdcInternalAPI/H0000c8a0-6766-3414-949f-de10519bee7d\002\220\302\273\345\313`\342\205\265\215\337\223\005$00558000000yFyDAAU\000\000\004\0200x400000\f4-0x01\000\000\000\000\002\002\03412 Main Street\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\002\220\302\273\345\313`\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"
 *   }
 */