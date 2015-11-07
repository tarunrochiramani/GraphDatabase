package com.tr.springmvc.graph.repository;


import com.tr.springmvc.graph.AbstractRepositoryTest;
import com.tr.springmvc.graph.entity.AdminAction;
import com.tr.springmvc.graph.entity.AdminApproval;
import com.tr.springmvc.graph.entity.LicenseeTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminApprovalRepositoryTest extends AbstractRepositoryTest {
    @Autowired private AdminApprovalRepository adminApprovalRepository;

    private AdminApproval adminApproval;

    @Before
    public void setUp() {
        adminApproval = new AdminApproval();
        adminApproval.setName("AS Approval");

        adminApproval = adminApprovalRepository.save(adminApproval);
    }

    @After
    public void cleanUp() {
        adminApprovalRepository.delete(adminApproval);
    }

    @Test
    public void canFindByName() {
        AdminApproval nodeToVerify = adminApprovalRepository.findByName(adminApproval.getName());

        assertNotNull(nodeToVerify);
        assertEquals(adminApproval.getId(), nodeToVerify.getId());
        assertEquals(adminApproval.getName(), nodeToVerify.getName());
    }


    @Test
    public void canTakeAdminAction() {
        LicenseeTask licenseeTask = new LicenseeTask();
        licenseeTask.setName("Fix");

        AdminAction adminAction = new AdminAction();
        adminAction.setName("Reject");
        adminAction.setAdminApproval(adminApproval);
        adminAction.setLicenseeTask(licenseeTask);

        licenseeTask.setAdminAction(adminAction);
        adminApproval.setAdminAction(adminAction);

        adminApproval = adminApprovalRepository.save(adminApproval);

        AdminApproval nodeToVerify = adminApprovalRepository.findByName(adminApproval.getName());

        assertNotNull(nodeToVerify);
        assertNotNull(nodeToVerify.getAdminAction());
        assertNotNull(nodeToVerify.getAdminAction().getLicenseeTask());
        assertNotNull(nodeToVerify.getAdminAction().getLicenseeTask().getName());
        assertEquals(licenseeTask.getName(), nodeToVerify.getAdminAction().getLicenseeTask().getName());
    }
}
