package com.silent.valley.entity;

import java.util.List;

import lombok.Data;

@Data
public class Mail {
	
	public Mail() {
        contentType = "text/plain";
    }

	private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType;
    private List<Object> attachments;
    
}
