package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	
	 @Autowired
	    private SmsEntity twilioConfig;
	 
	 public void sendSms(String to, String body) {
	        Message.creator(
	                new PhoneNumber(to),
	                new PhoneNumber(twilioConfig.getFromNumber()),
	                body).create();
	    }

}
