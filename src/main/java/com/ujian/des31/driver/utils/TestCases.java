package com.ujian.des31.driver.utils;

public enum TestCases {

	T1("Register new account"), T2("Login account"), T3("Add shoes to cart from compare"),
	T4("Add glass to cart from search"), T5("Checkout the cart");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
