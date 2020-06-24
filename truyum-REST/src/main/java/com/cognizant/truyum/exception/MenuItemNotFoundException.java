package com.cognizant.truyum.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Employee not found")
public class MenuItemNotFoundException extends Exception {
	public MenuItemNotFoundException(String message) {
	super(message);
}
}

