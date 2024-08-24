package com.poc.banking.transaction.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountDao, Long>, PagingAndSortingRepository<AccountDao, Long> {
}
