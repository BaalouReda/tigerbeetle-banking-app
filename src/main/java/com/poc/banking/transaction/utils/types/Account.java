package com.poc.banking.transaction.utils.types;


public class Account {

    private long idLeastSignificant;

    public long getIdLeastSignificant() {
        return idLeastSignificant;
    }

    public void setIdLeastSignificant(long idLeastSignificant) {
        this.idLeastSignificant = idLeastSignificant;
    }

    public long getIdMostSignificant() {
        return idMostSignificant;
    }

    public void setIdMostSignificant(long idMostSignificant) {
        this.idMostSignificant = idMostSignificant;
    }

    public long getUserData64() {
        return userData64;
    }

    public void setUserData64(long userData64) {
        this.userData64 = userData64;
    }

    public int getLedger() {
        return ledger;
    }

    public void setLedger(int ledger) {
        this.ledger = ledger;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    private long idMostSignificant;
    private long userData64;
    private int ledger;
    private int code;
    private int flags;
}
