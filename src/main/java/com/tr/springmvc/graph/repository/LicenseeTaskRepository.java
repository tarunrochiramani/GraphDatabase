package com.tr.springmvc.graph.repository;

import com.tr.springmvc.graph.entity.LicenseeTask;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

@Component
public interface LicenseeTaskRepository extends GraphRepository<LicenseeTask> {

    @Query("MATCH (licenseeTask : LicenseeTask) where licenseeTask.nodeName={0} return licenseeTask")
    LicenseeTask findByName(String name);
}
