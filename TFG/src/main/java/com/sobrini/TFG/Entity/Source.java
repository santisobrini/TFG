package com.sobrini.TFG.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Source")
public class Source {
		@Id
		
	    private String name;
	    private String contactEmail;
	    private List<String> sourceIdentifiers;
	    private String lastModified;
	    private String created;
	    @DBRef
	    private CVEAcceptanceLevel v3AcceptanceLevel;
	    @DBRef
	    private CVEAcceptanceLevel cweAcceptanceLevel;
	    
	    
		public Source() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Source(String name, String contactEmail, List<String> sourceIdentifiers, String lastModified,
				String created, CVEAcceptanceLevel v3AcceptanceLevel, CVEAcceptanceLevel cweAcceptanceLevel) {
			super();
			
			this.name = name;
			this.contactEmail = contactEmail;
			this.sourceIdentifiers = sourceIdentifiers;
			this.lastModified = lastModified;
			this.created = created;
			this.v3AcceptanceLevel = v3AcceptanceLevel;
			this.cweAcceptanceLevel = cweAcceptanceLevel;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContactEmail() {
			return contactEmail;
		}
		public void setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
		}
		public List<String> getSourceIdentifiers() {
			return sourceIdentifiers;
		}
		public void setSourceIdentifiers(List<String> sourceIdentifiers) {
			this.sourceIdentifiers = sourceIdentifiers;
		}
		public String getLastModified() {
			return lastModified;
		}
		public void setLastModified(String lastModified) {
			this.lastModified = lastModified;
		}
		public String getCreated() {
			return created;
		}
		public void setCreated(String created) {
			this.created = created;
		}
		public CVEAcceptanceLevel getV3AcceptanceLevel() {
			return v3AcceptanceLevel;
		}
		public void setV3AcceptanceLevel(CVEAcceptanceLevel v3AcceptanceLevel) {
			this.v3AcceptanceLevel = v3AcceptanceLevel;
		}
		public CVEAcceptanceLevel getCweAcceptanceLevel() {
			return cweAcceptanceLevel;
		}
		public void setCweAcceptanceLevel(CVEAcceptanceLevel cweAcceptanceLevel) {
			this.cweAcceptanceLevel = cweAcceptanceLevel;
		}
	    
	  
}
