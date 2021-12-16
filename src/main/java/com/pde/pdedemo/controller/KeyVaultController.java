package com.pde.pdedemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyVaultController {

	@GetMapping("get")
    public String get() {
        return pdeBlobUrl;
    }
	
	@Value("${pdeBlobUrl}")
    private String pdeBlobUrl;
}
