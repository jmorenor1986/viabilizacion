package com.samtel.validation.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NonContenException extends RuntimeException  {

	public NonContenException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
