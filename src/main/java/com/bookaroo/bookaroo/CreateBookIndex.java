package com.bookaroo.bookaroo;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

public class CreateBookIndex {

    public static void createBookIndex(RestHighLevelClient client) {
        String indexName = "books";

        try {
            // Check if the index already exist
            IndicesExistsRequest existsRequest = new IndicesExistsRequest(indexName);
            IndicesExistsResponse existsResponse = client.indices().exists(existsRequest, RequestOptions.DEFAULT);

            if (existsResponse.isExists()) {
                System.out.println("Index " + indexName + " already exists. Skipping this part.");
                return;
            }

            // Create an index with the mapping
            CreateIndexRequest request = new CreateIndexRequest(indexName);
            XContentBuilder mapping = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("properties")
                    .startObject("id").field("type", "keyword").endObject()
                    .startObject("title").field("type", "text").endObject()
                    .startObject("year").field("type", "integer").endObject()
                    .startObject("genres").field("type", "keyword").endObject()
                    .endObject()
                    .endObject();
            request.mapping(mapping.toString());
            client.indices().create(request, RequestOptions.DEFAULT);

            System.out.println("Index " + indexName + " created with mapping");
        } catch (IOException e) {
            System.err.println("Error creating the index: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        RestHighLevelClient client = ElasticsearchClientFactory.createClient();

        // Call the method to create the book index
        createBookIndex(client);

        // Close the client when done
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}