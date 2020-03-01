package com.up42.apitests.service


import com.up42.apitests.dto.Job

import static com.up42.apitests.BaseSpec.OAUTH_TOKEN
import static io.restassured.RestAssured.given
import static io.restassured.http.ContentType.JSON
import static org.apache.http.HttpStatus.SC_OK
import static org.hamcrest.Matchers.equalTo

class JobService extends BaseService {

    static final String JOBS_URL = "$HOST_URL/projects/$PROJECT_ID/jobs"
    static final String INITIAL_JOB_STATUS = "NOT_STARTED"

    static String postNewJob(Job job, String workflowId) {
            given()
                    .log().all()
                    .contentType(JSON)
                    .header('Authorization', "Bearer $OAUTH_TOKEN")
                    .body(job)
            .when()
                    .post("$WORKFLOW_URL/$workflowId/jobs")
            .then()
                    .log().all()
                    .assertThat()
                    .body("data.status", equalTo(INITIAL_JOB_STATUS))
                    .body("error", equalTo(null))
                    .statusCode(SC_OK)
                    .extract().response().path("data.id")
    }

    static String getJobStatus(String jobId) {
            given()
                    .log().all()
                    .header('Authorization', "Bearer $OAUTH_TOKEN")
            .when()
                    .get("$JOBS_URL/$jobId")
            .then()
                    .log().all()
                    .assertThat()
                    .body("error", equalTo(null))
                    .statusCode(SC_OK)
                    .extract().response().path("data.status")
    }
}
