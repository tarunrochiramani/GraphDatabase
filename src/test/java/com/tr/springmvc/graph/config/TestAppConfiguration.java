package com.tr.springmvc.graph.config;

import org.springframework.data.neo4j.server.InProcessServer;
import org.springframework.data.neo4j.server.Neo4jServer;

//@PropertySource("classpath:/test-application.properties")
public class TestAppConfiguration extends AppConfiguration {

    @Override
    public Neo4jServer neo4jServer() {
        return new InProcessServer();
    }
}
