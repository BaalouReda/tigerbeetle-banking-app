package com.poc.banking.transaction.utils;

import com.poc.banking.transaction.configs.TigerBeetleClientConfig;
import com.poc.banking.transaction.enums.AccountType;
import com.poc.banking.transaction.enums.Currency;
import com.poc.banking.transaction.exceptions.TigerBeetleInternalException;
import com.poc.banking.transaction.utils.converters.AccountConverter;
import com.poc.banking.transaction.utils.types.Account;
import com.tigerbeetle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class TigerBeetleUtil {

    private final Client client;
    private static final AtomicLong idCounter = new AtomicLong();

    @Autowired
    public TigerBeetleUtil( Client client) {
        this.client = client;
    }

     public Long createAccount(Currency currency, AccountType accountType,long pgId) {
        Account account = new Account();
        long id = idCounter.incrementAndGet();
        account.setIdLeastSignificant(id);
        account.setIdMostSignificant(id);
        account.setUserData64(pgId);
        account.setLedger(currency.getValue());
        account.setCode(accountType.getValue());
        account.setFlags(1);
        try {
            return getAccountIdCreated(account);
        } catch (ConcurrencyExceededException | TigerBeetleInternalException e) {
            throw new RuntimeException(e);
        }
    }


    public Long getAccountIdCreated(Account account) throws ConcurrencyExceededException, TigerBeetleInternalException {
        AccountBatch createAccountResult = createAccount(account);
        return  new BigInteger(createAccountResult.getId()).longValue();
    }


    public AccountBatch createAccount(Account account) throws ConcurrencyExceededException, TigerBeetleInternalException {
             return  createAccount(new AccountConverter().convert(account));
    }

    public AccountBatch createAccount(AccountBatch createAccount) throws ConcurrencyExceededException, TigerBeetleInternalException {
        CreateAccountResultBatch  accountResultBatch = client.createAccounts(createAccount);
        if(!accountResultBatch.getResult().equals(CreateAccountResult.Ok)) throw new TigerBeetleInternalException("Error creating account");
        return createAccount;

    }



}
