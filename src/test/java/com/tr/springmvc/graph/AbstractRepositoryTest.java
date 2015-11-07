package com.tr.springmvc.graph;

import com.tr.springmvc.graph.config.AppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(classes = AppConfiguration.class)
public abstract class AbstractRepositoryTest {
}
