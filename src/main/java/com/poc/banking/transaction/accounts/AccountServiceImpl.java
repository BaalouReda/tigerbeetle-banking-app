package com.poc.banking.transaction.accounts;

import com.poc.banking.transaction.clients.ClientRepository;
import com.poc.banking.transaction.exceptions.CreateAcountException;
import com.poc.banking.transaction.utils.TigerBeetleUtil;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.transaction.Transactional;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class AccountServiceImpl {

    public static final Logger log = LogManager.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;
    private final BankingAccountMapper accountMapper;
    private final ClientRepository clientRepository;
    private final TigerBeetleUtil tigerBeetleUtil;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, BankingAccountMapper accountMapper, ClientRepository clientRepository, TigerBeetleUtil tigerBeetleUtil) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.clientRepository = clientRepository;
        this.tigerBeetleUtil = tigerBeetleUtil;
    }


    @Transactional(rollbackOn = RuntimeException.class)
    @Retry(name = "createAccount")
    public AccountDto createAccount(AccountDto accountDto) throws CreateAcountException {
        log.info("Creating a new account");

        try {
            // Phase 1: Persist the AccountDao without TigerBeetleId
            AccountDao accountDao = accountMapper.toDao(accountDto);
            accountDao.setClient(clientRepository.findById(accountDto.getClientId()).orElseThrow());
            accountDao = accountRepository.save(accountDao);

            // Phase 2: Create the account in TigerBeetle and update the AccountDao with TigerBeetleId
            Long tigerBeetleId = tigerBeetleUtil.createAccount(accountDao.getCurrency(), accountDao.getAccountType(), accountDao.getId());
            accountDao.setTigerBeetleId(tigerBeetleId);
            accountRepository.saveAndFlush(accountDao);

            return accountMapper.toDto(accountDao);
        }catch (Exception e){
            log.error("Error while creating account", e);
            throw new CreateAcountException("Error while creating account");
        }

    }

}
