package com.ktab.vision.api.resources.model;

import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {

	private String content;

	public OrderResource() {
		// TODO Auto-generated constructor stub
	}

	public OrderResource(String content) {
		super();	
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
