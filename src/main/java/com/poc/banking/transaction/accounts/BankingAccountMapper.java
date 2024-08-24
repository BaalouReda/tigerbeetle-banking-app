package com.poc.banking.transaction.accounts;


import org.springframework.stereotype.Component;

@Component
public class BankingAccountMapper {


    AccountDto toDto(AccountDao accountDao){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountDao.getId());
        accountDto.setAccountNumber(accountDao.getAccountNumber());
        accountDto.setAccountType(accountDao.getAccountType());
        accountDto.setCurrency(accountDao.getCurrency());
        accountDto.setBalance(accountDao.getBalance());
        accountDto.setStatus(accountDao.getStatus());
        accountDto.setIban(accountDao.getIban());
        accountDto.setBic(accountDao.getBic());
        accountDto.setRib(accountDao.getRib());
        accountDto.setSwift(accountDao.getSwift());
        accountDto.setClientId(accountDao.getClient().getId());
        return accountDto;
    }


    AccountDao toDao(AccountDto accountDto){
        AccountDao accountDao = new AccountDao();
        accountDao.setId(accountDto.getId());
        accountDao.setAccountNumber(accountDto.getAccountNumber());
        accountDao.setAccountType(accountDto.getAccountType());
        accountDao.setCurrency(accountDto.getCurrency());
        accountDao.setBalance(accountDto.getBalance());
        accountDao.setStatus(accountDto.getStatus());
        accountDao.setIban(accountDto.getIban());
        accountDao.setBic(accountDto.getBic());
        accountDao.setRib(accountDto.getRib());
        accountDao.setSwift(accountDto.getSwift());
        return accountDao;
    }
}
