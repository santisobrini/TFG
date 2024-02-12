package com.sobrini.TFG.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection= "nvd_source_data")
public class NVDSourceData {
		@Id
		private int id;
	    private int resultsPerPage;
	    private int startIndex;
	    private int totalResults;
	    private String format;
	    private String version;
	    private String timestamp;
	   
	    
	    public NVDSourceData() {
			super();
			// TODO Auto-generated constructor stub
		}

		public NVDSourceData(int id, int resultsPerPage, int startIndex, int totalResults, String format,
				String version, String timestamp, List<Source> sources) {
			super();
			this.id = id;
			this.resultsPerPage = resultsPerPage;
			this.startIndex = startIndex;
			this.totalResults = totalResults;
			this.format = format;
			this.version = version;
			this.timestamp = timestamp;
			this.sources = sources;
		}
        @DBRef
		private List<Source> sources;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getResultsPerPage() {
			return resultsPerPage;
		}

		public void setResultsPerPage(int resultsPerPage) {
			this.resultsPerPage = resultsPerPage;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}

		public int getTotalResults() {
			return totalResults;
		}

		public void setTotalResults(int totalResults) {
			this.totalResults = totalResults;
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		public List<Source> getSources() {
			return sources;
		}

		public void setSources(List<Source> sources) {
			this.sources = sources;
		}
	    
	 
	    
}
