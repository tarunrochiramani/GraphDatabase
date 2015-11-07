package com.tr.springmvc.graph.repository;

import com.tr.springmvc.graph.entity.AdminApproval;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdminApprovalRepository extends GraphRepository<AdminApproval> {

    @Query("MATCH (adminApproval : AdminApproval) where adminApproval.nodeName={0} return adminApproval")
    AdminApproval findByName(String name);
}
