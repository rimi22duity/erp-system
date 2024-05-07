package maks.erp.system.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duity
 * @since 5/4/24
 */
public enum Currency {

    BDT("\u09F3 (BDT)"), US_DOLLAR("$ (USD)");

    private String sign;

    Currency(String sign) {
        this.sign = sign;
    }

    public static List<String> getCurrencySigns() {
        List<String> currencyList = new ArrayList<>();
        for (Currency c: Currency.values()) {
            currencyList.add(c.sign);
        }

        return currencyList;
    }
}


