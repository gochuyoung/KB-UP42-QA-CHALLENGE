package com.up42.apitests.service


import com.up42.apitests.dto.Block

import static com.up42.apitests.BaseSpec.OAUTH_TOKEN
import static io.restassured.RestAssured.given
import static io.restassured.http.ContentType.JSON
import static org.apache.http.HttpStatus.SC_OK
import static org.hamcrest.CoreMatchers.equalTo

class BlockService extends BaseService {

    static void postNewBlock(ArrayList<Block> blocks, String workflowId) {
            given()
                    .log().all()
                    .contentType(JSON)
                    .header('Authorization', "Bearer $OAUTH_TOKEN")
                    .body(blocks)
            .when()
                    .post("$WORKFLOW_URL/$workflowId/tasks")
            .then()
                    .log().all()
                    .assertThat()
                    .body("error", equalTo(null))
                    .statusCode(SC_OK)
    }
}
