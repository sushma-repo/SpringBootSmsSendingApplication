package com.example.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class SmsEntity {
	
	 @Value("${twilio.account.sid}")
	    private String accountSid;

	    @Value("${twilio.auth.token}")
	    private String authToken;

	    @Value("${twilio.phone.number}")
	    private String fromNumber;

	    public SmsEntity(@Value("${twilio.account.sid}") String accountSid,
	                        @Value("${twilio.auth.token}") String authToken,
	                        @Value("${twilio.phone.number}") String fromNumber) {
	        this.accountSid = accountSid;
	        this.authToken = authToken;
	        this.fromNumber = fromNumber;
	        Twilio.init(accountSid, authToken);
	    }

	    @Bean
	    public SmsEntity twilioConfig() {
	        return new SmsEntity(accountSid, authToken, fromNumber);
	    }

	    public String getFromNumber() {
	        return fromNumber;
	    }

}
