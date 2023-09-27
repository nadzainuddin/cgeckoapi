package com.qa.cgecko.api;

import com.qa.cgecko.common.APIHelpers;
import com.qa.cgecko.common.BaseTest;
import com.qa.cgecko.constants.Endpoints;
import com.qa.cgecko.enums.Symbol;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class GlobalDefiTest extends BaseTest {
    @Test(description = "GET Global Defi: Verify able to retrieve crypto global defi data")
    public void getGlobalDefi() {
        JsonPath resp = APIHelpers.GET(requestSpecBuilder(), Endpoints.GLOBAL_DEFI, HttpStatus.SC_OK);
        assertThat(resp.get("data.defi_market_cap"), notNullValue());
        assertThat(resp.get("data.eth_market_cap"), notNullValue());
        assertThat(resp.get("data.defi_to_eth_ratio"), notNullValue());
        assertThat(resp.get("data.trading_volume_24h"), notNullValue());
        assertThat(resp.get("data.defi_dominance"), notNullValue());
        assertThat(resp.get("data.top_coin_name"), notNullValue());
        assertThat(resp.get("data.top_coin_defi_dominance"), notNullValue());
    }
}
