package com.qa.cgecko.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Locale;

public enum Symbol {
    BTC,
    ETH,
    LTC,
    BCH,
    BNB,
    EOS,
    XRP,
    XLM,
    LINK,
    DOT,
    YFI,
    USD;

    /**
     * Serialises to and from lower case for jackson.
     *
     * @return lower case Status name.
     */
    @JsonValue
    public String toLower() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
// TODO: Add complete list of symbol