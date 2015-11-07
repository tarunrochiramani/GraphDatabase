package com.tr.springmvc.graph.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class LicenseeTask {
    @GraphId
    private Long id;

    @Property(name = "nodeName")
    private String name;

    @Relationship (direction = Relationship.INCOMING)
    private AdminAction adminAction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdminAction getAdminAction() {
        return adminAction;
    }

    public void setAdminAction(AdminAction adminAction) {
        this.adminAction = adminAction;
    }
}
