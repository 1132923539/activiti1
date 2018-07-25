package net.canway.activiti1.service;

import org.activiti.engine.RepositoryService;

public interface WorkflowService {

    //根据默认的流程图部署流程
    public String deployDefaultFlow();

    //根据客户上传的流程图（zip文件，里面须包含流程图bpmn文件）
}
