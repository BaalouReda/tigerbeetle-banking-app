package com.poc.banking.transaction.enums;


public enum AccountType {
    CURRENT(1000),
    SAVINGS(1002),
    JOINT(1003);

    private int value;

    AccountType(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public static AccountType fromValue(int value) {
        for (AccountType accountType : AccountType.values()) {
            if (accountType.value == value) {
                return accountType;
            }
        }
        return null;
    }
}
