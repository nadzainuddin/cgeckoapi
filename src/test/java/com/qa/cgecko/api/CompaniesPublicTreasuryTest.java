package com.qa.cgecko.api;

import com.qa.cgecko.common.APIHelpers;
import com.qa.cgecko.common.BaseTest;
import com.qa.cgecko.constants.Endpoints;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

public class CompaniesPublicTreasuryTest extends BaseTest {
    @Test(
            description = "GET Companies Public Treasury: Verify on entering valid coin_id",
            dataProvider = "correct-coin-id"
    )
    public void getCompaniesPublicTreasuryValidCoinId(String value) {
        JsonPath resp = APIHelpers.GETPathParam(requestSpecBuilder(), Endpoints.COMPANIES_PUBLIC_TREASURY, value,
                HttpStatus.SC_OK);
        assertThat(resp.get("total_holdings"),notNullValue());
        assertThat(resp.get("total_value_usd"),notNullValue());
        assertThat(resp.get("market_cap_dominance"),notNullValue());
        assertThat(resp.getList("companies").size(),greaterThan(0));
        assertThat(resp.get("companies.name"),notNullValue());
        assertThat(resp.get("companies.symbol"),notNullValue());
        assertThat(resp.get("companies.country"),notNullValue());
        assertThat(resp.get("companies.total_holdings"),notNullValue());
        assertThat(resp.get("companies.total_entry_value_usd"),notNullValue());
        assertThat(resp.get("companies.total_current_value_usd"),notNullValue());
        assertThat(resp.get("companies.percentage_of_total_supply"),notNullValue());
    }

    @Test(
            description = "GET Companies Public Treasury: Verify on entering invalid or non-existing coin id",
            dataProvider = "incorrect-coin-id"
    )
    public void getCompaniesPublicTreasuryIncorrectCoinId(String value) {
        JsonPath resp = APIHelpers.GETPathParam(requestSpecBuilder(), Endpoints.COMPANIES_PUBLIC_TREASURY, value,
                HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(resp.getString("error"), "Coin not supported");
    }

    @Test(description = "GET Companies Public Treasury: Verify when no coin_id specified")
    public void getCompaniesPublicTreasuryEmptyCoinId() {
        JsonPath resp = APIHelpers.GETPathParam(requestSpecBuilder(), Endpoints.COMPANIES_PUBLIC_TREASURY, "",
                HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(resp.getString("error"), "Incorrect path. Please check https://www.coingecko.com/api/");
    }

    @DataProvider(name = "correct-coin-id")
    public Object[][] correctCoinId(){
        return new Object[][] {
                {"bitcoin"},
                {"ethereum"}
        };
    }

    @DataProvider(name = "incorrect-coin-id")
    public Object[][] incorrectCoinId(){
        return new Object[][] {
                {"ETHEREUM"},
                {"eth"},
                {"ethereum0"},
                {"ethereum "},
                {" "},
                {"polymath"}
        };
    }
}
