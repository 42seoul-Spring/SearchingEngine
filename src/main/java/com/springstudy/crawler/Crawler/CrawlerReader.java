package com.springstudy.crawler.Crawler;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CrawlerReader implements ItemReader<CrawlingResult> {

    private Indexer indexer;

    public CrawlerReader(Indexer indexer) {

        this.indexer = indexer;
    }

    @Override
    public CrawlingResult read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        return Crawler.Crawling(indexer.nextIndex());
    }
}
