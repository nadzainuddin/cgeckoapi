package com.qa.cgecko.constants;

public class Endpoints {

    public static final String BASE_URL = "https://api.coingecko.com/api/v3";

    public static final String PING = "/ping";

    public static final String SIMPLE_PRICE = "/simple/price";
    public static final String SIMPLE_TOKEN_PRICE = "/simple/token_price/{id}";
    public static final String SIMPLE_SUPP_CURRENCIES = "/simple/supported_vs_currencies";

    public static final String COINS_LIST = "/coins/list";
    public static final String COINS_MARKET = "/coins/markets";
    public static final String COINS = "/coins/{id}";
    public static final String COINS_TICKERS = "/coins/{id}/tickers";
    public static final String COINS_HISTORY = "/coins/{id}/history";
    public static final String COINS_MARKET_CHART = "/coins/{id}/market_chart";
    public static final String COINS_MARKET_CHART_RANGE = "/coins/{id}/market_chart/range";
    public static final String COINS_OHLC = "/coins/{id}/ohlc";

    public static final String CONTRACT = "/coins/{id}/contract/{contract_address}";
    public static final String CONTRACT_MARKET_CHART = "/coins/{id}/contract/{contract_address}/market_chart/";
    public static final String CONTRACT_MARKET_CHART_RANGE = "/coins/{id}/contract/{contract_address}/market_chart/range";

    public static final String ASSET_PLATFORMS = "/asset_platforms";

    public static final String CATEGORIES = "/coins/categories";
    public static final String CATEGORIES_LIST = "/coins/categories/list";

    public static final String EXCHANGES = "/exchanges";
    public static final String EXCHANGES_LIST = "/exchanges/list";
    public static final String EXCHANGES_BY_ID = "/exchanges/{id}";
    public static final String EXCHANGES_TICKERS = "/exchanges/{id}/tickers";
    public static final String EXCHANGES_VOL_CHART = "/exchanges/{id}/volume_chart";

    public static final String DERIVATIVES = "/derivatives";
    public static final String DERIVATIVES_EXCHANGES = "/derivatives/exchanges";
    public static final String DERIVATIVES_EXCHANGES_BY_ID = "/derivatives/exchanges/{id}";
    public static final String DERIVATIVES_EXCHANGES_LIST = "/derivatives/exchanges/list";

    public static final String NFTS = "/nfts/{id}";
    public static final String NFTS_LIST = "/nfts/list";
    public static final String NFTS_CONTRACT = "/nfts/{asset_platform_id}/contract/{contract_address}";

    public static final String EXCHANGE_RATES = "/exchange_rates";

    public static final String SEARCH = "/search";

    public static final String TRENDING = "/search/trending";

    public static final String GLOBAL = "/global";
    public static final String GLOBAL_DEFI = "/global/decentralized_finance_defi";

    public static final String COMPANIES_PUBLIC_TREASURY = "/companies/public_treasury/{coin_id}";
}
