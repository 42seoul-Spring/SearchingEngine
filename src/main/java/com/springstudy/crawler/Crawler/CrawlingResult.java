package com.springstudy.crawler.Crawler;

import org.jsoup.nodes.Document;

public class CrawlingResult {
	Document document;
	String status;
	
	public CrawlingResult(Document document, String status) {
		this.document = document;
		this.status = status;
	}
	
	public Document getDocument() {
		return document;
	}
	
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
