package org.ozcanarpaci.utilities;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.ozcanarpaci.base.BaseConstants.BASE_SCHEMAS_PATH;

public class Verify {
    //schema validator website: https://www.liquid-technologies.com/online-json-to-schema-converter

    public static void verifySchema(Response response, String schemaName){
        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(BASE_SCHEMAS_PATH+schemaName));
    }

    public static void verifyStatusCode(Response response, int statusCode){
        response
                .then()
                .assertThat()
                .statusCode(statusCode);
    }

}

