package com.tr.springmvc.graph;

import com.tr.springmvc.graph.config.AppConfiguration;
import com.tr.springmvc.graph.config.TestAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public abstract class AbstractRepositoryTest {
}
