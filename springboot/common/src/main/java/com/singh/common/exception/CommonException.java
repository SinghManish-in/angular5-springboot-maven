package com.singh.common.exception;

import com.singh.common.generic.exception.ExceptionCode;
import com.singh.common.generic.exception.GenericException;

public class CommonException extends GenericException{

	private static final long serialVersionUID = 1L;
	
	public CommonException(ExceptionCode code,String message) {
      super(code,message);
  }

}
