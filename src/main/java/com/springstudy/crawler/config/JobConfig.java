package com.springstudy.crawler.config;

import com.springstudy.crawler.Crawler.CrawlerReader;
import com.springstudy.crawler.Crawler.CrawlingResult;
import com.springstudy.crawler.Crawler.Indexer;
import com.springstudy.crawler.Crawler.indexer.SimpleIndexer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.mapping.RecordFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    @Bean
    public Indexer simpleIndexer() {
        return new SimpleIndexer();
    }

    @Bean
    public ItemReader<CrawlingResult> itemReader() {

        return new CrawlerReader(simpleIndexer());
    }


}
