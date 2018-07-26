package net.canway.activiti1.service;

import org.activiti.engine.repository.Deployment;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface WorkflowService {

    /**
     * 根据默认的流程图部署流程
     * @return
     */
    String deployDefaultFlow();

    /**
     * 根据客户上传的流程图（zip文件，里面须包含流程图bpmn文件）
     */
    String deployNewFlow(File processFile, String name, String category);

    /**
     * 查询部署对象信息
     */
    List queryDeployList();

    /**
     * 通过id查询部署的流程
     */
    Deployment queryDeployById(String id);

    /**
     * 通过名称查询部署的流程信息
     */
    List queryDeployByName(String processName);

    /**
     * 查询流程定义信息
     */
    List queryDefinitionList();

    /**
     * 获取部署的流程图片的流
     */
    InputStream queryProcessImage(String deployId, String imageName);

    /**
     * 删除部署流程
     */
    String delProcessDeploy(String deployName);

    /**
     * 删除流程定义
     */
    String delProcessDefinition(String processName);

    /**
     * 开启流程
     */
    String startProcess();

}
//afdsfsafasf
