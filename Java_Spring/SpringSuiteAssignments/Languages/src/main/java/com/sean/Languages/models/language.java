package com.sean.Languages.models;

import javax.validation.constraints.Size;

public class language {
	@Size(min = 3, max = 20)
	private String name;
	@Size(min = 3, max = 20)
	private String creator;
	@Size(min = 3, max = 20)
	private String version;
	
	
	
	public language() {
	
	}

	public language(String LangName, String LangCreator, String LangVersion) {
		this.name=LangName;
		this.creator=LangCreator;
		this.version=LangVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
