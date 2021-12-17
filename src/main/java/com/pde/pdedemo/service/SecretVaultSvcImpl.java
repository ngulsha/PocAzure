package com.pde.pdedemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.core.util.polling.SyncPoller;
import com.azure.identity.AzureAuthorityHosts;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.DeletedSecret;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@Service
public class SecretVaultSvcImpl implements SecretVaultSvc {

	@Value("${azure.keyvault.uri}")
	String keyVaultUri;

	public void createSecret(String secretName, String secretValue)
			throws InterruptedException, IllegalArgumentException {
		/*
		 * // String keyVaultName = System.getenv("KEY_VAULT_NAME"); // String
		 * keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";
		 * 
		 * DefaultAzureCredential defaultCredential = new
		 * DefaultAzureCredentialBuilder()
		 * .managedIdentityClientId("5dc12a4a-639c-43fd-935d-ac46865aa327") .build();
		 * 
		 * 
		 * DefaultAzureCredential defaultAzureCredential = new
		 * DefaultAzureCredentialBuilder()
		 * .authorityHost(AzureAuthorityHosts.AZURE_GOVERNMENT) .build();
		 * 
		 * 
		 * SecretClient secretClient = new SecretClientBuilder() .vaultUrl(keyVaultUri)
		 * .credential(defaultCredential) .buildClient();
		 * 
		 * secretClient.setSecret(new KeyVaultSecret(secretName, secretValue));
		 */}

}
