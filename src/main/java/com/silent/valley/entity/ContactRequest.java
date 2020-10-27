package com.silent.valley.entity;

import lombok.Data;

@Data
public class ContactRequest {

	private String name;
	private String emailId;
	private String phoneNumber;
	private String subject;
	private String messageContent;
	
}
