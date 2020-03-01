package com.up42.apitests

import org.junit.Rule
import org.junit.rules.TestName
import org.junit.rules.Timeout
import spock.lang.Shared
import spock.lang.Specification

import static com.up42.apitests.factory.WorkflowFactory.buildWorkflow
import static com.up42.apitests.service.OAuthService.generateOAuthToken
import static com.up42.apitests.service.WorkflowService.deleteWorkflow
import static com.up42.apitests.service.WorkflowService.postNewWorkflow
import static io.restassured.RestAssured.useRelaxedHTTPSValidation

class BaseSpec extends Specification {

    @Shared
    static String OAUTH_TOKEN

    @Shared
    static String WORKFLOW_ID

    @Rule
    Timeout globalTimeout = new Timeout(200000)

    @Rule
    TestName name = new TestName()

    def setupSpec() {
        useRelaxedHTTPSValidation()
        OAUTH_TOKEN = generateOAuthToken()
        WORKFLOW_ID = postNewWorkflow(buildWorkflow())
    }

    def cleanupSpec() {
        deleteWorkflow(WORKFLOW_ID)
    }
}
