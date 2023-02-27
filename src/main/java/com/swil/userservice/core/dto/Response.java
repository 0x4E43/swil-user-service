package com.swil.userservice.core.dto;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Response implements Serializable{
    private static Logger logger = LoggerFactory.getLogger(Response.class);

	private static final long serialVersionUID = 5545860428411369724L;

	@JsonInclude(Include.NON_NULL)
	ResponseSuccess success = null;

	@JsonInclude(Include.NON_NULL)
	ResponseError error = null;

	static JSONObject json;

	public ResponseSuccess getSuccess() {
		return success;
	}

	public void setSuccess(ResponseSuccess success) {
		this.success = success;
	}

	public ResponseError getError() {
		return error;
	}

	public void createSuccess() {
		success = new ResponseSuccess();
	}

	public synchronized static String success(String message) {
		try {
			json = new JSONObject();
			json.put("success", objectToJSONObject(new ResponseSuccess(message)));
			return json.toString();
		} catch (Exception e) {
			logger.error("Exception : {}", e);
			return Response.error("error while getting data from server.");
		}
	}

	public synchronized static String success(int code, String message) {
		try {
			json = new JSONObject();
			json.put("success", objectToJSONObject(new ResponseSuccess(code, message)));
			return json.toString();
		} catch (Exception e) {
			logger.error("  Exception : {}", e);
			return Response.error("error while getting data from server.");
		}
	}

	public synchronized static String success(String message, Object data) {
		try {
			json = new JSONObject();
			json.put("success", objectToJSONObject(new ResponseSuccess(message, data)));
			return json.toString();
		} catch (Exception e) {
			logger.error("Exception : {}", e);
			return Response.error("error while getting data from server.");
		}
	}

	public synchronized static String success(int code, String message, Object data) {
		try {
			json = new JSONObject();
			json.put("success", objectToJSONObject(new ResponseSuccess(code, message, data)));
			return json.toString();
		} catch (Exception e) {
			logger.error("Exception : {}", e);
			return Response.error("error while getting data from server.");
		}
	}

	public void createError() {
		error = new ResponseError();
	}

	public synchronized static String error(String message) {
		try {
			json = new JSONObject();
			json.put("error", objectToJSONObject(new ResponseError(message)));
			return json.toString();
		} catch (Exception e) {
			logger.error("Exception : {}", e);
		}
		return message;
	}

	public synchronized static String error(int code, String message) {
		try {
			json = new JSONObject();
			json.put("error", objectToJSONObject(new ResponseError(code, message)));
			return json.toString();
		} catch (Exception e) {
			logger.error("Exception : {}", e);
		}
		return message;
	}
	
	

	public void setSuccessMessage(String message) {
		this.success.setMessage(message);
	}

	public void setSuccessCode(int code) {
		this.success.setCode(code);
	}

	public void setSuccessData(Object data) {
		this.success.setData(data);
	}

	public void setErrorMessage(String message) {
		this.error.setMessage(message);
	}

	public void setErrorCode(int code) {
		this.error.setCode(code);
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

	public static JSONObject objectToJSONObject(Object obj) throws JSONException {
		Gson gson = new Gson();
		 GsonBuilder builder = new GsonBuilder();
		     gson = builder.serializeNulls().create();

		return new JSONObject(gson.toJson(obj));
	}
	
	
	public synchronized static String success(int code, String message, Object data , int noOfRecords) {
		try {
			json = new JSONObject();
			json.put("success", objectToJSONObject(new ResponseSuccess(code, message, data,noOfRecords)));
			return json.toString();
		} catch (Exception e) {
			logger.error("Exception : {}", e);
			return Response.error("error while getting data from server.");
		}
	}

}
