package com.tr.springmvc.graph.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

@Configuration
@ComponentScan(basePackages = "com.tr.springmvc.graph")
@PropertySource("classpath:/application.properties")
@EnableNeo4jRepositories (basePackages = "com.tr.springmvc.graph.repository")
public class AppConfiguration extends Neo4jConfiguration {

    @Autowired private Environment environment;

    @Override
    public Neo4jServer neo4jServer() {
        return new RemoteServer(environment.getProperty("neo4j.url"), environment.getProperty("neo4j.user"), environment.getProperty("neo4j.password"));
    }

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.tr.springmvc.graph.entity");
    }


//    @Bean
//    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public Session getSession() throws Exception {
//        return super.getSession();
//    }

}
