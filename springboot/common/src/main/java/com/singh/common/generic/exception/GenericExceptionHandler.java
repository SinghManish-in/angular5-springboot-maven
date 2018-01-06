package com.singh.common.generic.exception;

import org.springframework.http.HttpStatus;

public interface GenericExceptionHandler<T extends GenericException> {
 
public void handle(GenericException exception) throws T;
 
public void handle(Exception exception) throws T;
 
public void handle(HttpStatus httpStatus) throws T;
 
public HttpStatus getHttpStatusCode(T exception);
 
public String getExceptionStackTrace(Exception exception);
 
}