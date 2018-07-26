package net.canway.activiti1.service;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private FormService formService;

    /**
     * 根据默认的流程图部署流程
     *
     * @return
     */
    @Override
    public String deployDefaultFlow() {
        repositoryService.createDeployment()
                .addClasspathResource("bpm/gatewayDemo.bpmn")
                .name("示例流程图")
                .category("请假单")
                .deploy();
        return "success";
    }

    /**
     * 根据客户上传的流程图（zip文件，里面须包含流程图bpmn文件）
     *
     * @param processFile
     * @param name
     * @param category
     */
    @Override
    public String deployNewFlow(File processFile, String name, String category) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(processFile));
            repositoryService.createDeployment()
                    .name(name)
                    .category(category)
                    .addZipInputStream(zipInputStream)
                    .deploy();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return name + "流程部署成功！";
    }

    /**
     * 查询部署对象信息
     */
    @Override
    public List queryDeployList() {
        List<Deployment> list = repositoryService.createDeploymentQuery()
                .orderByDeploymenTime().asc()
                .list();
        return list;
    }

    /**
     * 通过id查询部署的流程
     *
     * @param id
     */
    @Override
    public Deployment queryDeployById(String id) {
        Deployment deployment = repositoryService.createDeploymentQuery()
                .deploymentId(id)
                .singleResult();
        return deployment;
    }

    /**
     * 通过名称查询部署的流程信息
     *
     * @param processName
     */
    @Override
    public List queryDeployByName(String processName) {
        List<Deployment> list = repositoryService.createDeploymentQuery()
                .deploymentName(processName)
                .list();
        return list;
    }

    /**
     * 查询流程定义信息
     */
    @Override
    public List queryDefinitionList() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion().asc()
                .list();
        return list;
    }

    /**
     * 获取部署的流程图片的流
     *
     * @param deployId
     * @param imageName
     */
    @Override
    public InputStream queryProcessImage(String deployId, String imageName) {
        InputStream imageStream = repositoryService.getResourceAsStream(deployId, imageName);
        return imageStream;
    }

    /**
     * 删除部署流程
     *
     * @param deployName
     */
    @Override
    public String delProcessDeploy(String deployName) {
        return null;
    }

    /**
     * 删除流程定义
     *
     * @param processName
     */
    @Override
    public String delProcessDefinition(String processName) {
        return null;
    }

    /**
     * 开启流程
     */
    @Override
    public String startProcess() {
        return null;
    }
}
//sfdafdka;lsfa