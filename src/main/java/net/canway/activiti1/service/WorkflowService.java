package net.canway.activiti1.service;

import java.io.InputStream;
import java.util.List;

public interface WorkflowService {

    /**
     * 根据默认的流程图部署流程
     */
    String deployDefaultFlow();

    /**
     * 根据客户上传的流程图（zip文件，里面须包含流程图bpmn文件）
     */
    String deployNewFlow();

    /**
     * 查询部署对象信息
     */
    List queryDeployList();

    /**
     * 查询流程定义信息
     */
    List queryDefinitionList();

    /**
     * 获取部署的流程图片的流
     */
    InputStream queryProcessImage();

    /**
     * 删除部署流程
     */
    String delProcessDeploy();

    /**
     * 删除流程定义
     */
    String delProcessDefinition(String processName);




}
