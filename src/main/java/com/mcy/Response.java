package com.mcy;

public class Response {

	private String responseValue1;
	private int responseValue2;

	public String getResponseValue1() {
		return responseValue1;
	}

	public void setResponseValue1(String responseValue1) {
		this.responseValue1 = responseValue1;
	}

	public int getResponseValue2() {
		return responseValue2;
	}

	public void setResponseValue2(int responseValue2) {
		this.responseValue2 = responseValue2;
	}

	public Response(String responseValue1, int responseValue2) {
		super();
		this.responseValue1 = responseValue1;
		this.responseValue2 = responseValue2;
	}

	public Response() {
		super();
	}

}
