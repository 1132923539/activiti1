package net.canway.activiti1;

import net.canway.activiti1.service.WorkflowServiceImpl1;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Activiti1ApplicationTests {
    @Autowired
    WorkflowServiceImpl1 workflowService;

    @Test
    public void contextLoads() {
    }

    //部署
    @Test
    public void deploy() {
        workflowService.deployDefaultFlow();
    }


    @Test
    public void ServiceTest() throws IOException {
        Deployment deployment = workflowService.queryDeployById("1");

        workflowService.queryDeployByName("示例流程图");

        List<ProcessDefinition> list = workflowService.queryDefinitionList();

        InputStream inputStream = workflowService.queryProcessImage("1", "bpm/gatewayDemo.myProcess_1.png");
        File imageFile = new File("bpm.png");
        FileOutputStream fos = new FileOutputStream(imageFile);
        fos.close();

//        for (ProcessDefinition processDefinition : list
//                ) {
//            System.out.println("----------------" + processDefinition + "--------------");
//        }

    }

}
