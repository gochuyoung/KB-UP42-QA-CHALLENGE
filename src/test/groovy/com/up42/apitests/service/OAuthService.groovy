package com.up42.apitests.service


import static com.up42.apitests.utils.ConfigReader.getValue
import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_OK

class OAuthService extends BaseService {

    static final String API_KEY = getValue('api-key')
    static final String OAUTH_URL = "https://$PROJECT_ID:$API_KEY@api.up42.com/oauth/token"

    static String generateOAuthToken() {
             given()
                    .contentType('application/x-www-form-urlencoded')
                    .body('grant_type=client_credentials')
            .when()
                    .post(OAUTH_URL)
            .then()
                    .statusCode(SC_OK)
                    .extract().response().path("access_token")
    }
}
