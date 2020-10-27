package com.silent.valley.service;

import com.silent.valley.entity.ContactRequest;
import com.silent.valley.entity.QuotationRequest;

public interface MailService {

	 public void sendQuotation(QuotationRequest quotationRequest);
	 
	 public void sendContact(ContactRequest contactRequest);
	
}
