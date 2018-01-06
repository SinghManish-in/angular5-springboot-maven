package com.singh.common.generic.exception;

public enum ExceptionCode {

	BAD_REQUEST("E001"), NOT_FOUND("E002"), INTERNAL_SERVER_ERROR("E003");

	private String code;

	private ExceptionCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
