package net.canway.activiti1.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class WorkflowServiceImpl implements WorkflowService {


    @Override
    public String deployDefaultFlow() {

        return null;
    }

    @Override
    public String deployNewFlow() {
        return null;
    }

    @Override
    public List queryDeployList() {
        return null;
    }

    @Override
    public List queryDefinitionList() {
        return null;
    }

    @Override
    public InputStream queryProcessImage() {
        return null;
    }

    @Override
    public String delProcessDeploy() {
        return null;
    }

    @Override
    public String delProcessDefinition(String processName) {
        return null;
    }
}
