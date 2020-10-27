package com.silent.valley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.silent.valley.entity.ContactRequest;
import com.silent.valley.entity.QuotationRequest;
import com.silent.valley.service.MailService;

@Controller
@RequestMapping("")
public class IndexController {
	
	@Autowired
	MailService mailService;
	
    @GetMapping(value = {"/", "/index"})
    public String home (){
        return "index";
    }

    @GetMapping(value = "/about")
    public String about (){
        return "about";
    }

    @GetMapping(value = "/contact")
    public String contactUs (){
        return "contact";
    }

    @GetMapping(value = "/project")
    public String project (){
        return "project";
    }
    
    @GetMapping(value = "/handyman-service")
    public String handymanService (){
        return "handyman-service";
    }
    
    @PostMapping("/submitQuote")
    public ResponseEntity<String> quoteSubmission(QuotationRequest quotationRequest) {
    	this.mailService.sendQuotation(quotationRequest);
    	return new ResponseEntity<>("", HttpStatus.OK);
    }
    
    @PostMapping("/contactRequest")
    public ResponseEntity<String> contactRequest(ContactRequest contactRequest) {
    	this.mailService.sendContact(contactRequest);
    	return new ResponseEntity<>("", HttpStatus.OK);
    }
    
}
