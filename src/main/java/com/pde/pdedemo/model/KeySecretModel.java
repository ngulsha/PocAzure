package com.pde.pdedemo.model;

public class KeySecretModel {
	
	private String secretName;
	private String secretValue;
	
	public KeySecretModel() {
		// TODO Auto-generated constructor stub
	}

	public KeySecretModel(String secretName, String secretValue) {
		this.secretName = secretName;
		this.secretValue = secretValue;
	}

	public String getSecretName() {
		return secretName;
	}

	public void setSecretName(String secretName) {
		this.secretName = secretName;
	}

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	
	

}
