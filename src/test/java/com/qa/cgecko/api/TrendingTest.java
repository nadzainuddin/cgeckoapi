package com.qa.cgecko.api;

import com.qa.cgecko.common.APIHelpers;
import com.qa.cgecko.common.BaseTest;
import com.qa.cgecko.constants.Endpoints;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TrendingTest extends BaseTest {
    @Test(description = "GET Trending: Verify able to retrieve Top-7 trending coins on CoinGecko")
    public void getTrending() {
        JsonPath resp = APIHelpers.GET(requestSpecBuilder(), Endpoints.TRENDING, HttpStatus.SC_OK);
        int count = 7;
        assertThat(resp.getList("coins").size(), equalTo(count));
        for(int i = 0; i<count; i++) {
            assertThat(resp.get("coins.id"), notNullValue());
            assertThat(resp.get("coins.coin_id"), notNullValue());
            assertThat(resp.get("coins.name"), notNullValue());
            assertThat(resp.get("coins.symbol"), notNullValue());
            assertThat(resp.get("coins.market_cap_rank"), notNullValue());
            assertThat(resp.get("coins.thumb"), notNullValue());
            assertThat(resp.get("coins.small"), notNullValue());
            assertThat(resp.get("coins.large"), notNullValue());
            assertThat(resp.get("coins.slug"), notNullValue());
            assertThat(resp.get("coins.price_btc"), notNullValue());
            assertThat(resp.get("coins.score"), notNullValue());
        }
    }
    // TODO : Assertion on correct coin_id, name, symbol, price_btc based on id
}
