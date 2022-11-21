package com.colibear.core.workflow;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultWorkflow implements Workflow {
    private Map<String, Collection<? extends Workflow>> workflows = new ConcurrentHashMap();

    @Override
    public void run(String workflow) {
        if (workflows.containsKey(workflow)) {
            Collection<? extends Workflow> wc = workflows.get(workflow);
        }

    }

}
