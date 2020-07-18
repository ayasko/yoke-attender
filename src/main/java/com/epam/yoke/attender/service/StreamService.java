package com.epam.yoke.attender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.epam.yoke.attender.configuration.NotifierBinding;
import com.epam.yoke.attender.model.rq.AttenderEventBody;

@Component
@EnableBinding(NotifierBinding.class)
public class StreamService {
		
	@Autowired
	private NotifierBinding notifierBinding;

	public void addAttenderToEvent(AttenderEventBody eventAttender) {
		notifierBinding.addEventAttender().send(MessageBuilder.withPayload(eventAttender).build()); 
	} 	
	
	public void deleteAttenderFromEvent(AttenderEventBody eventAttender) {
		notifierBinding.deleteEventAttender().send(MessageBuilder.withPayload(eventAttender).build());
	}
}