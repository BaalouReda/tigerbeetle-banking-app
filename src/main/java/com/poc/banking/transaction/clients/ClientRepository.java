package com.poc.banking.transaction.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDao, Long>, PagingAndSortingRepository<ClientDao, Long> {
}
