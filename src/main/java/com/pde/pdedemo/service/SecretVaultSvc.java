package com.pde.pdedemo.service;

public interface SecretVaultSvc {
	public void createSecret(String secretName, String secretValue) throws InterruptedException, IllegalArgumentException;
}
