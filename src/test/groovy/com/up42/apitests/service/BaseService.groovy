package com.up42.apitests.service

import static com.up42.apitests.utils.ConfigReader.getValue

class BaseService {

    protected static final String HOST_URL = getValue('host-url')
    protected static final String PROJECT_ID = getValue('project-id')
    protected static final String WORKFLOW_URL = "$HOST_URL/projects/$PROJECT_ID/workflows"
}
