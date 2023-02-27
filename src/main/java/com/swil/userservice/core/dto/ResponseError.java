package com.swil.userservice.core.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties
public class ResponseError implements Serializable{
    private static final long serialVersionUID = 5545860428411369724L;

	public static final int RETCODE_SUCCESS = 0;
	public static final int RETCODE_FAIL_DB = 100;

	@JsonInclude
	private int code = 333;

	@JsonInclude
	private String message = null;
	
	@JsonInclude
	private Object data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseError() {
		super();
	}

	public ResponseError(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ResponseError(String message) {
		super();
		this.message = message;
	}

	
	public void copyBaseDate(ResponseError vo) {
		vo.setMessage(this.message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int failureCode) {
		this.code = failureCode;
	}
}
