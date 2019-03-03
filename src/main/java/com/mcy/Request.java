package com.mcy;

public class Request {

	private String requestValue1;
	private int requestValue2;

	public Request(String requestValue1, int requestValue2) {
		super();
		this.requestValue1 = requestValue1;
		this.requestValue2 = requestValue2;
	}

	public Request() {
		super();
	}

	public String getRequestValue1() {
		return requestValue1;
	}

	public void setRequestValue1(String requestValue1) {
		this.requestValue1 = requestValue1;
	}

	public int getRequestValue2() {
		return requestValue2;
	}

	public void setRequestValue2(int requestValue2) {
		this.requestValue2 = requestValue2;
	}

}
