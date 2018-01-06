package com.singh.common.validation;

import com.singh.common.exception.CommonException;

public interface GenericValidation<T> {
	 public T validate(T request) throws CommonException;

}
