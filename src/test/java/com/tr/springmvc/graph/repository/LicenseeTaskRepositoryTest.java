package com.tr.springmvc.graph.repository;

import com.tr.springmvc.graph.AbstractRepositoryTest;
import com.tr.springmvc.graph.entity.LicenseeTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class LicenseeTaskRepositoryTest extends AbstractRepositoryTest {

    @Autowired private LicenseeTaskRepository licenseeTaskRepository;
    LicenseeTask licenseeTask;


    @Before
    public void setUp() {
        licenseeTask = new LicenseeTask();
        licenseeTask.setName("Fix");
        licenseeTask = licenseeTaskRepository.save(licenseeTask);
    }

    @After
    public void cleanUp() {
        licenseeTaskRepository.delete(licenseeTask);
    }

    @Test
    public void canFindByName() {
        LicenseeTask licenseeTaskToVerify = licenseeTaskRepository.findByName(licenseeTask.getName());

        assertNotNull(licenseeTaskToVerify);
    }
}
