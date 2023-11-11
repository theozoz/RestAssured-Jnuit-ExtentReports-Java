package org.ozcanarpaci.test;

import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.ozcanarpaci.base.HttpClient;
import org.ozcanarpaci.base.StartActions;
import org.ozcanarpaci.utilities.ExtentReport;
import org.ozcanarpaci.utilities.Verify;

import java.util.HashMap;

public class First extends StartActions {


    @Test
    @Order(1)
    public void test(){
        String path="/comments";
        String schemaName="comments.json";
        HashMap<String,Object> query=new HashMap<>();
        query.put("postId","1");
        Response response= HttpClient.get(path,query);
        Verify.verifyStatusCode(response,200);
        Verify.verifySchema(response,schemaName);
        ExtentReport.logTest(Status.PASS,"Test başarılı 1");
    }


    @Test
    @Order(2)
    public void test1(){
        String path="/posts/1";
        Response response= HttpClient.get(path);
        Verify.verifyStatusCode(response,200);
        ExtentReport.logTest(Status.PASS,"Test başarılı 2");
    }

}
