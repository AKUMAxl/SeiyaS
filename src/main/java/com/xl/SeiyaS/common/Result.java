package com.xl.SeiyaS.common;

public class Result <T>{
	private boolean result;
	private T params;
	private String message;
	private Integer code;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	
	public T geParams() {
		return params;
	}
	public void setParams(T datum) {
		this.params = datum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
