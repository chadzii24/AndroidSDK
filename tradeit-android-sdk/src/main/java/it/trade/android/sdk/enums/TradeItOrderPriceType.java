package it.trade.android.sdk.enums;


public enum TradeItOrderPriceType {
    MARKET("market"),
    LIMIT("limit"),
    STOP_MARKET("stopLimit"),
    STOP_LIMIT("stopMarket");

    private String priceTypeValue;

    TradeItOrderPriceType(String priceTypeValue) {
        this.priceTypeValue = priceTypeValue;
    }

    public String getPriceTypeValue() {
        return priceTypeValue;
    }

    public static TradeItOrderPriceType getPriceTypeForValue(String actionValue) {
        for (TradeItOrderPriceType priceType: TradeItOrderPriceType.values()) {
            if (priceType.priceTypeValue.equals(actionValue)) {
                return priceType;
            }
        }
        return null;
    }
}
