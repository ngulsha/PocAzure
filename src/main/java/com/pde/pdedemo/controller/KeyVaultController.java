package com.pde.pdedemo.controller;

import java.time.Duration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
import com.pde.pdedemo.service.SecretVaultSvc;

@RestController
public class KeyVaultController {
	
	 private SecretClient secretClient;

	@Value("${pdeBlobUrl}")
    private String pdeBlobUrl;
	
	@Autowired
	private SecretVaultSvc secretVaultSvc;
	
	@Value("${azure.keyvault.uri}")
    private String keyVaultUrl;

    @PostConstruct
    private void setupSecretClient() {
    	
        ManagedIdentityCredential managedIdentityCredential = new ManagedIdentityCredentialBuilder()
                .maxRetry(1)
                .retryTimeout(duration -> Duration.ofMinutes(1))
                .build();
        
        DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder()
                .managedIdentityClientId("5dc12a4a-639c-43fd-935d-ac46865aa32")
                .build();
        
        AzureCliCredential cliCredential = new AzureCliCredentialBuilder().build();
        
        EnvironmentCredential environmentCredential = new EnvironmentCredentialBuilder().build();

        secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUrl)
                .credential(managedIdentityCredential)
                .buildClient();
    }
	
	@GetMapping("get")
    public String get() {
        return pdeBlobUrl;
    }
	
	@PutMapping("/secrets/{name}")
    public String setSecret(@PathVariable String name, @RequestParam String value) {
        try {
            KeyVaultSecret secret = secretClient.setSecret(name, value);
            return String.format("Successfully set secret %s in Key Vault %s", name, keyVaultUrl);
        } catch (Exception ex) {
            return String.format("Failed to set secret %s in Key Vault %s due to %s", name,
                    keyVaultUrl, ex.getMessage());
        }
    }
	
//	 @PostMapping("/createSecret")
//	    public String createSecret(@RequestBody KeySecretModel keySecretModel) throws IllegalArgumentException, InterruptedException {
//	    	 secretVaultSvc.createSecret(keySecretModel.getSecretName(), keySecretModel.getSecretValue());
//	    	 return "Created";
//	    }
}
