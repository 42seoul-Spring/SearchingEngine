package com.springstudy.crawler.Crawler.indexer;

import com.springstudy.crawler.Crawler.Indexer;

public class SimpleIndexer implements Indexer {

    private long questionId;

    @Override
    public long nextIndex() {
        return questionId++;
    }
}
