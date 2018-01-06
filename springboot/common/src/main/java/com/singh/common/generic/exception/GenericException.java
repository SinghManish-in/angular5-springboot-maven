package com.singh.common.generic.exception;

public abstract class GenericException extends Throwable{
	
	private static final long serialVersionUID = 1L;
	
	protected ExceptionCode code;
	protected String message;
	
	
	protected GenericException(ExceptionCode code,String message) {
		this.code=code;
		this.message=message;
	}

}
