package com.poc.banking.transaction.utils.converters;

import com.poc.banking.transaction.utils.types.Account;
import com.tigerbeetle.AccountBatch;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class AccountConverter {
    public AccountBatch convert(Account account) {
            AccountBatch accountBatch = new com.tigerbeetle.AccountBatch(1);
            accountBatch.add();
            accountBatch.setId(account.getIdLeastSignificant(), account.getIdMostSignificant());
            accountBatch.setUserData64(account.getUserData64());
            accountBatch.setLedger(account.getLedger());
            accountBatch.setCode(account.getCode());
            accountBatch.setFlags(account.getFlags());
            return accountBatch;
    }
}
