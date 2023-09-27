package com.qa.cgecko.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimplePrice {
    @JsonProperty("ids")
    private String ids;
    @JsonProperty("vs_currencies")
    private String vs_currencies;
    @JsonProperty("include_market_cap")
    private Boolean include_market_cap;
    @JsonProperty("include_24hr_vol")
    private Boolean include_24hr_vol;
    @JsonProperty("include_24hr_change")
    private Boolean include_24hr_change;
    @JsonProperty("include_last_updated_at")
    private Boolean include_last_updated_at;
    @JsonProperty("precision")
    private String precision;

    public SimplePrice(String ids, String vs_currencies, Boolean include_market_cap, Boolean include_24hr_vol, Boolean include_24hr_change, Boolean include_last_updated_at, String precision) {
        this.ids = ids;
        this.vs_currencies = vs_currencies;
        this.include_market_cap = include_market_cap;
        this.include_24hr_vol = include_24hr_vol;
        this.include_24hr_change = include_24hr_change;
        this.include_last_updated_at = include_last_updated_at;
        this.precision = precision;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getVs_currencies() {
        return vs_currencies;
    }

    public void setVs_currencies(String vs_currencies) {
        this.vs_currencies = vs_currencies;
    }

    public Boolean getInclude_market_cap() {
        return include_market_cap;
    }

    public void setInclude_market_cap(Boolean include_market_cap) {
        this.include_market_cap = include_market_cap;
    }

    public Boolean getInclude_24hr_vol() {
        return include_24hr_vol;
    }

    public void setInclude_24hr_vol(Boolean include_24hr_vol) {
        this.include_24hr_vol = include_24hr_vol;
    }

    public Boolean getInclude_24hr_change() {
        return include_24hr_change;
    }

    public void setInclude_24hr_change(Boolean include_24hr_change) {
        this.include_24hr_change = include_24hr_change;
    }

    public Boolean getInclude_last_updated_at() {
        return include_last_updated_at;
    }

    public void setInclude_last_updated_at(Boolean include_last_updated_at) {
        this.include_last_updated_at = include_last_updated_at;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
