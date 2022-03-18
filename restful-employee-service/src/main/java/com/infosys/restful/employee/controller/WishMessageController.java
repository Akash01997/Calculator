package com.infosys.restful.employee.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/i18n")
public class WishMessageController {
	
	@Autowired
    private MessageSource messageSource;
	
	
	@RequestMapping(value = "/wishing",method = RequestMethod.GET)
	public String helloInternational(@RequestHeader(name="Accept-Language", required = false) Locale locale){
		return messageSource.getMessage("good.morning.message",null, locale);
	}
	
	
	@RequestMapping(value = "/wish",method = RequestMethod.GET)
	public String helloInternationalDynamic(){
		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());
	}
	
	
	
	
	
	

}
