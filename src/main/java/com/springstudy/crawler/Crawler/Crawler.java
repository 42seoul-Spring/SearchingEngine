package com.springstudy.crawler.Crawler;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

public class Crawler {
	private static final String baseUrl = "https://stackoverflow.com/questions/";
	// 각 count를 url로 연결할때 redirect가 아닌 not found가 나오는 경우가 있음
	private static long count;
	private static final String NOT_FOUND = "NOT_FOUND";
	private static final String REDIRECT = "REDIRECT";
	private static final String CONNECT = "CONNECT";
	private static final String ERROR = "ERROR";
	private static final String NOT_FOUND_URL = "org.jsoup.HttpStatusException: HTTP error fetching URL. Status=404";
	public Crawler() {
		count = 0;
	}
	
	static CrawlingResult Crawling(long question) {
		String url = baseUrl + question;
		try {
			Response response = Jsoup.connect(url).execute();
			String redirectUrl = response.url().toString();
			String[] tokens = redirectUrl.split("#");
			Connection conn = Jsoup.connect(url).timeout(5 * 1000);
			// redirect
			if (tokens[tokens.length - 1].equals(String.valueOf(question))) {
				return new CrawlingResult(conn.get(), REDIRECT);
			}
			// connect
			return new CrawlingResult(conn.get(), CONNECT);
		} catch (HttpStatusException e) {
			String[] temp = e.toString().split(",");
			//not found
			if (temp[0].equals(NOT_FOUND_URL)) {
				return new CrawlingResult(null, NOT_FOUND);
			}
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new CrawlingResult(null, ERROR);
	}
	
	public static void main(String[] args) {
		Crawling(86780047);
	}
	
}
