package com.singh.common.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.singh.common.exception.CommonException;
import com.singh.common.generic.exception.ExceptionCode;

public class GenericValidationImpl<T> implements GenericValidation<T> {
  private static final Logger logger = LoggerFactory.getLogger(GenericValidationImpl.class);

  public T validate(T request) throws CommonException {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    try {
      Validator validator = factory.getValidator();
      Set<ConstraintViolation<T>> constraintViolations = validator.validate(request);
      if (!constraintViolations.isEmpty()) {
        StringBuilder validationMessages = new StringBuilder("");
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
          validationMessages.append(constraintViolation.getMessage());
        }
        if (logger.isDebugEnabled())
          logger.debug("Request Validation Errors " + constraintViolations);
        throw new CommonException(ExceptionCode.BAD_REQUEST, validationMessages.toString());
      }
    }
    finally {
      factory.close();
    }
    return request;
  }
}
