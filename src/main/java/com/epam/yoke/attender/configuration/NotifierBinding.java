package com.epam.yoke.attender.configuration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NotifierBinding {

	String OUTPUT_ADD_EVENT_ATTENDER = "addEventAttender";
	String OUTPUT_DELETE_EVENT_ATTENDER = "deleteEventAttender";
    
    @Output(OUTPUT_ADD_EVENT_ATTENDER)
    MessageChannel addEventAttender();
    
    @Output(OUTPUT_DELETE_EVENT_ATTENDER)
    MessageChannel deleteEventAttender();
}