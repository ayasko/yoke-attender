package com.epam.yoke.attender.service;

import com.epam.yoke.attender.mapper.AttenderMapper;
import com.epam.yoke.attender.model.rq.AttenderEventBody;
import com.epam.yoke.attender.model.rs.AttenderEventResponse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifyService {

  @Autowired
  private StreamService streamService;

  @Autowired
  private AttenderMapper attenderMapper;

  public AttenderEventResponse add(AttenderEventBody eventAttender) {
    streamService.addAttenderToEvent(eventAttender);
    return attenderMapper.mapResponses(eventAttender);
  }

  public void delete(String eventId, String email) {
	AttenderEventBody eventAttender = new AttenderEventBody();
	eventAttender.setEventId(eventId);
	eventAttender.setEmails(Arrays.asList(email));
	streamService.deleteAttenderFromEvent(eventAttender);
  }
}
