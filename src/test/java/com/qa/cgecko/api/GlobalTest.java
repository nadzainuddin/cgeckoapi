package com.qa.cgecko.api;

import com.qa.cgecko.common.APIHelpers;
import com.qa.cgecko.common.BaseTest;
import com.qa.cgecko.constants.Endpoints;
import com.qa.cgecko.enums.Symbol;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GlobalTest extends BaseTest {
    @Test(description = "GET Global: Verify able to retrieve crypto global data")
    public void getGlobal() {
        JsonPath resp = APIHelpers.GET(requestSpecBuilder(), Endpoints.GLOBAL, HttpStatus.SC_OK);
        assertThat(resp.get("data.active_cryptocurrencies"), notNullValue());
        assertThat(resp.get("data.upcoming_icos"), notNullValue());
        assertThat(resp.get("data.ongoing_icos"), notNullValue());
        assertThat(resp.get("data.ended_icos"), notNullValue());
        assertThat(resp.get("data.markets"), notNullValue());
        assertThat(resp.get("data.total_market_cap"), notNullValue());
        assertThat(resp.get("data.total_market_cap."+ Symbol.BTC.toLower()), notNullValue());
        assertThat(resp.get("data.total_market_cap."+ Symbol.ETH.toLower()), notNullValue());
        assertThat(resp.get("data.total_market_cap."+ Symbol.BNB.toLower()), notNullValue());
        assertThat(resp.get("data.total_volume"), notNullValue());
        assertThat(resp.get("data.total_volume."+ Symbol.BTC.toLower()), notNullValue());
        assertThat(resp.get("data.total_volume."+ Symbol.ETH.toLower()), notNullValue());
        assertThat(resp.get("data.total_volume."+ Symbol.BNB.toLower()), notNullValue());
        assertThat(resp.get("data.market_cap_percentage"), notNullValue());
        assertThat(resp.get("data.market_cap_percentage."+ Symbol.BTC.toLower()), notNullValue());
        assertThat(resp.get("data.market_cap_percentage."+ Symbol.ETH.toLower()), notNullValue());
        assertThat(resp.get("data.market_cap_percentage."+ Symbol.BNB.toLower()), notNullValue());
        assertThat(resp.get("data.market_cap_change_percentage_24h_usd"), notNullValue());
        assertThat(resp.get("data.updated_at"), notNullValue());
    }
}
