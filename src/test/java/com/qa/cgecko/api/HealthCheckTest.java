package com.qa.cgecko.api;

import com.qa.cgecko.common.APIHelpers;
import com.qa.cgecko.common.BaseTest;
import com.qa.cgecko.constants.Endpoints;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class HealthCheckTest extends BaseTest {
    @Test(description = "HealthCheck : Success 200 OK")
    @Description("Verify API Service Health - OK")
    public void ping() {
        APIHelpers.GET(requestSpecBuilder(), Endpoints.PING, HttpStatus.SC_OK);
    }
}
