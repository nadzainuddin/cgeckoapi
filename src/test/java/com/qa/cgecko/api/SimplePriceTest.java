package com.qa.cgecko.api;

import com.qa.cgecko.common.APIHelpers;
import com.qa.cgecko.common.BaseTest;
import com.qa.cgecko.constants.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimplePriceTest extends BaseTest {
    @Test(description = "GET Simple Price: Verify able to retrieve crypto current price")
    public void getSimplePricePartial() {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", "ethereum");
        map.put("vs_currencies", "eth");
        map.put("precision", "5");
        JsonPath resp = APIHelpers.GETQueryParamsStr(requestSpecBuilder(), map, Endpoints.SIMPLE_PRICE,
                HttpStatus.SC_OK).jsonPath();
        assertThat(resp.getString("ethereum.eth"), equalTo(String.format("%.5f", Double.valueOf(resp.getString("ethereum.eth")))));
        assertThat(resp.getString("ethereum.eth_market_cap"), emptyOrNullString());
        assertThat(resp.getString("ethereum.eth_24h_vol"), emptyOrNullString());
        assertThat(resp.getString("ethereum.eth_24h_change"), emptyOrNullString());
        assertThat(resp.getString("ethereum.last_updated_at"), emptyOrNullString());

    }

    @Test(description = "GET Simple Price: Verify able to retrieve crypto current price")
    public void getSimplePriceFull() {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", "ethereum");
        map.put("vs_currencies", "eth");
        map.put("include_market_cap", true);
        map.put("include_24hr_vol", true);
        map.put("include_24hr_change", true);
        map.put("include_last_updated_at", true);
        map.put("precision", "full");
        JsonPath resp = APIHelpers.GETQueryParamsStr(requestSpecBuilder(), map, Endpoints.SIMPLE_PRICE,
                HttpStatus.SC_OK).jsonPath();
        assertThat(resp.getString("ethereum.eth"), equalTo(String.format("%.5f", Double.valueOf(resp.getString("ethereum.eth")))));
        assertThat(resp.get("ethereum.eth_market_cap"), notNullValue());
        assertThat(resp.get("ethereum.eth_24h_vol"), notNullValue());
        assertThat(resp.get("ethereum.eth_24h_change"), notNullValue());
        assertThat(resp.get("ethereum.last_updated_at"), notNullValue());
    }

    @Test(
            description = "GET Simple Price: Verify on retrieving crypto current price with invalid precision",
            dataProvider = "incorrect-precision"
    )
    public void getSimplePriceInvalidPrecision(String field, String value) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", "ethereum");
        map.put("vs_currencies", "eth");
        map.put(field, value);
        ResponseBody resp = APIHelpers.GETQueryParamsStr(requestSpecBuilder(), map, Endpoints.SIMPLE_PRICE,
                HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(resp.jsonPath().getString("error"), "Invalid value for precision");
    }

    @DataProvider(name = "incorrect-precision")
    public Object[][] incorrectPrecision(){
        return new Object[][] {
                {"precision", "-1"},
                {"precision", "19"}
        };
    }
}
