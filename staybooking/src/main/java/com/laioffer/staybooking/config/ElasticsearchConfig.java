package com.laioffer.staybooking.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticsearchConfig {
    @Value("${elasticsearch.address}")
    private String elasticsearch_address;

    @Value("${elasticsearch.username}")
    private String elasticsearch_username;

    @Value("${elasticsearch.password}")
    private String elasticsearch_password;

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo(elasticsearch_address)
                .withBasicAuth(elasticsearch_username, elasticsearch_password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
