package com.pde.pdedemo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.azure.spring.autoconfigure.storage.resource.AzureStorageResourcePatternResolver;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

@Component
public class AzureStorageSvcImpl implements AzureStorageSvc{
	
	@Override
	public String readFromBlob(String containerName, String fileName) throws IOException {
		 String searchLocation = "azure-blob://" + containerName + "/" + fileName;
	        String connectionString = "DefaultEndpointsProtocol=https;AccountName=mystorsgeaccountpde;AccountKey=Y6mX9oa3Qa3MAnz2Q0zcG/wN8AEhZMGup5RQSCq34yZAtHgWWWYWJY/Jl9QU6xy8Xe+FWRMyXie/uTEAkKpZTA==;EndpointSuffix=core.windows.net";
	        String endpoint = "https://mystorsgeaccountpde.blob.core.windows.net/";
		
		BlobServiceClient client = new BlobServiceClientBuilder().connectionString(connectionString).endpoint(endpoint).buildClient();
        AzureStorageResourcePatternResolver storageResourcePatternResolver = new AzureStorageResourcePatternResolver(client);

        Resource resource = storageResourcePatternResolver.getResource(searchLocation);

			return StreamUtils.copyToString(
					resource.getInputStream(),
			        Charset.defaultCharset());

	}

	@Override
	public void writeToBlob(String containerName, String fileName, String contect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSecret(String keyVaultName, String secretName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSecret(String keyVaultName, String secretName, String secretValue) {
		// TODO Auto-generated method stub
		
	}

}
