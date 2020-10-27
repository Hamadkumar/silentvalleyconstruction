package com.silent.valley.entity;

import lombok.Data;

@Data
public class QuotationRequest {

	private String firstName;
	private String lastName;
	private String serviceName;
	private String phoneNumber;
	private String messageContent;
}
