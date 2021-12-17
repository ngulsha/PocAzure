package com.pde.pdedemo.controller;

import java.time.Duration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azure.identity.AzureCliCredential;
import com.azure.identity.AzureCliCredentialBuilder;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.identity.EnvironmentCredential;
import com.azure.identity.EnvironmentCredentialBuilder;
import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.pde.pdedemo.model.AzureModel;
import com.pde.pdedemo.model.KeySecretModel;
import com.pde.pdedemo.service.SecretVaultSvc;

@RestController
public class KeyVaultController {
	
	

	@Value("${pdeBlobUrl}")
    private String pdeBlobUrl;
	
	@Autowired
	private SecretVaultSvc secretVaultSvc;
	
	@Value("${azure.keyvault.uri}")
    private String keyVaultUrl;
	


    
	
	@GetMapping("get")
    public String get() {
        return pdeBlobUrl;
    }
	
	@PutMapping("/secrets/{vaultName}")
    public String setSecret(@PathVariable String vaultName, @RequestBody KeySecretModel keySecretModel) {
		 KeySecretModel setKeySecretModel = new KeySecretModel();
		 setKeySecretModel.setKeyVaultName(vaultName);
		 setKeySecretModel.setSecretName(keySecretModel.getSecretName());
		 setKeySecretModel.setSecretValue(keySecretModel.getSecretValue());
        
		return secretVaultSvc.createSecret(setKeySecretModel);
    }
	
	@GetMapping("/getSecret/{vaultName}/{secretName}")
	public String getSecret(@PathVariable String vaultName, @PathVariable String secretName) {
		 KeySecretModel setKeySecretModel = new KeySecretModel();
		 setKeySecretModel.setKeyVaultName(vaultName);
		 setKeySecretModel.setSecretName(secretName);
		 
		 return secretVaultSvc.getSecret(setKeySecretModel);
		 
	    	 
	    }
}
