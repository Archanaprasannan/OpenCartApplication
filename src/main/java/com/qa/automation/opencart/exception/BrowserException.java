package com.qa.automation.opencart.exception;

/*  This class is used to handle exceptions related to browser operations in the OrangeHRM automation framework.
It extends RuntimeException, allowing it to be thrown without being declared in a method's throws clause.
The constructor takes a message string that describes the exception, which can be used for logging or debugging purposes. 
*/
public class BrowserException extends RuntimeException {
	public BrowserException(String mesg) {
		super(mesg);
	}
}
