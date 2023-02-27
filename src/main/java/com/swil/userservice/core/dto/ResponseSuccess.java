package com.swil.userservice.core.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonIgnoreProperties
public class ResponseSuccess implements Serializable {


	private static final long serialVersionUID = 5545860428411369724L;
	public static final int RETCODE_SUCCESS = 0;
	public static final int RETCODE_FAIL_DB = 100;

	@JsonInclude(Include.NON_DEFAULT)
	private int code = 222;

	@JsonInclude(Include.NON_NULL)
	private String message = null;

	@JsonInclude(Include.NON_NULL)
	private Object data;
	
	@JsonInclude(Include.NON_ABSENT)
	private Integer totalRecords;

	public Object getData() {
		return data;
	}

	public ResponseSuccess() {
		super();
	}

	public ResponseSuccess(String message) {
		super();
		this.message = message;
	}

	public ResponseSuccess(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ResponseSuccess(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public ResponseSuccess(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void copyBaseDate(ResponseSuccess vo) {
		vo.setMessage(this.message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int failureCode) {
		this.code = failureCode;
	}
	
	public ResponseSuccess(int code, String message, Object data , int totalRecords) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.totalRecords = totalRecords;
	}
    
}
