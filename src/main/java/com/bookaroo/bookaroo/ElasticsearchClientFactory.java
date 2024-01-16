package com.bookaroo.bookaroo;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticsearchClientFactory {

    public static RestHighLevelClient createClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("31dcf93c9da94ee0bc914328ad5d0b49.us-central1.gcp.cloud.es.io", 9243, "https"))
        );
    }
}