package com.up42.apitests.service


import com.up42.apitests.dto.Workflow

import static com.up42.apitests.BaseSpec.OAUTH_TOKEN
import static io.restassured.RestAssured.given
import static io.restassured.http.ContentType.JSON
import static org.apache.http.HttpStatus.SC_OK
import static org.hamcrest.Matchers.equalTo

class WorkflowService extends BaseService {

    static String postNewWorkflow(Workflow workflow) {
            given()
                    .log().all()
                    .contentType(JSON)
                    .header('Authorization', "Bearer $OAUTH_TOKEN")
                    .body(workflow)
            .when()
                    .post(WORKFLOW_URL)
            .then()
                    .log().all()
                    .assertThat()
                    .body("data.name", equalTo(workflow.name))
                    .body("data.description", equalTo(workflow.description))
                    .body("error", equalTo(null))
                    .statusCode(SC_OK)
                    .extract().response().path("data.id")
    }

    static void deleteWorkflow(String workflowId) {
            given()
                    .contentType(JSON)
                    .header('Authorization', "Bearer $OAUTH_TOKEN")
            .when()
                    .delete("$WORKFLOW_URL/$workflowId")
            .then()
                    .statusCode(204)
    }
}
