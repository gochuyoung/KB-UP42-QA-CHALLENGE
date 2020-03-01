package com.up42.apitests.factory

import com.up42.apitests.dto.Workflow

class WorkflowFactory {

    static final String WORKFLOW_NAME = "QA test workflow"
    static final String WORKFLOW_DESC = "test workflow desc"

    static Workflow buildWorkflow() {
        return new Workflow(
                name: WORKFLOW_NAME,
                description: WORKFLOW_DESC
        )
    }
}
