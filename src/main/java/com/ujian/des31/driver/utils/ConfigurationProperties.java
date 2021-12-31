package com.ujian.des31.driver.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	@Value("${browser}")
	private String browser;

	@Value("${name}")
	private String name;

	@Value("${email}")
	private String email;

	@Value("${search}")
	private String search;

	@Value("${fname}")
	private String fname;
	
	@Value("${lname}")
	private String lname;
	
	@Value("${city}")
	private String city;
	
	@Value("${postcode}")
	private String postcode;
	
	@Value("${phone}")
	private String phone;
	
	@Value("${address}")
	private String address;

	public String getAddress() {
		return address;
	}

	public String getBrowser() {
		return browser;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getSearch() {
		return search;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}
	
	public String getCity() {
		return city;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getPhone() {
		return phone;
	}
	

}
