package com.poc.banking.transaction.enums;

public enum Currency {

    USD(1),
    EUR(2),
    MAD(3);

    private int value;

    public int getValue() {
        return value;
    }

    Currency(int i) {
        this.value = i;
    }

    public static Currency fromValue(int value) {
        for (Currency currency : Currency.values()) {
            if (currency.value == value) {
                return currency;
            }
        }
        return null;
    }
}
