package com.pde.pdedemo.model;

public class AzureModel {
	
	private String containerName;
	private String fileName;
	
	public AzureModel() {
	}
	public AzureModel(String containerName, String fileName) {
		this.containerName = containerName;
		this.fileName = fileName;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	

}
