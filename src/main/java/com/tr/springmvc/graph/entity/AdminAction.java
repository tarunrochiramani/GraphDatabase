package com.tr.springmvc.graph.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="ADMIN_ACTION")
public class AdminAction {
    @GraphId
    private Long id;

    @Property (name = "actionName")
    private String name;

    @StartNode
    private AdminApproval adminApproval;

    @EndNode
    private LicenseeTask licenseeTask;


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

    public AdminApproval getAdminApproval() {
        return adminApproval;
    }

    public void setAdminApproval(AdminApproval adminApproval) {
        this.adminApproval = adminApproval;
    }

    public LicenseeTask getLicenseeTask() {
        return licenseeTask;
    }

    public void setLicenseeTask(LicenseeTask licenseeTask) {
        this.licenseeTask = licenseeTask;
    }
}
