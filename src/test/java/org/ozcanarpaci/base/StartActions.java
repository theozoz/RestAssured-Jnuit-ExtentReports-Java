package org.ozcanarpaci.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.ozcanarpaci.utilities.ExtentReport;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StartActions {

    @BeforeAll
    public void setup(){
        ExtentReport.extentReport();
    }

    @AfterAll
    void createReport(){
        ExtentReport.tearDown();
    }
}
