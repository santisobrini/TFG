package com.sobrini.TFG.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "CVE_Acceptance_Level")
public class CVEAcceptanceLevel {
	@Id
	@DBRef
	private String description;
	private String lastModified;
	
	
	public CVEAcceptanceLevel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CVEAcceptanceLevel(String description, String lastModified) {
		super();
		this.description = description;
		this.lastModified = lastModified;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	
}
