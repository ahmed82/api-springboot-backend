package com.rbs.backendspringboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHundelerMethod {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleException(NullPointerException ex)
	{
	    //Do something additional if required
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("message", ex.getMessage());
	    return modelAndView;
	}

}
