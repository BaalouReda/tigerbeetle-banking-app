package com.poc.banking.transaction.accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poc.banking.transaction.clients.ClientDao;
import com.poc.banking.transaction.enums.AccountStatus;
import com.poc.banking.transaction.enums.AccountType;
import com.poc.banking.transaction.enums.Currency;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_ACCOUNT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccountDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ACCOUNT_NUMBER", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "ACCOUNT_TYPE")
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    @Column(name = "FId")
    private Long tigerBeetleId;

    @Column(name = "CURRENCY")
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @Column(name = "BALANCE", nullable = false)
    private double balance;

    @Column(name = "ACCOUNT_STATUS")
    @Enumerated(value = EnumType.STRING)
    private  AccountStatus status;

    @JoinColumn(name = "CLIENT_ID", nullable = false)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private  ClientDao client;

    @Column(name = "IBAN", nullable = false, unique = true)
    private String iban;

    @Column(name = "BIC", nullable = false, unique = true)
    private String bic;

    @Column(name = "RIB", nullable = false, unique = true)
    private String rib;

    @Column(name = "SWIFT", nullable = false, unique = true)
    private String swift;

    @JsonIgnore
    @CreatedDate
    @Column(name = "CDATE" , updatable = false)
    private LocalDateTime createdDate;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "MDATE")
    private LocalDateTime lastModifiedDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Long getTigerBeetleId() {
        return tigerBeetleId;
    }

    public void setTigerBeetleId(Long tigerBeetleId) {
        this.tigerBeetleId = tigerBeetleId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public ClientDao getClient() {
        return client;
    }

    public void setClient(ClientDao client) {
        this.client = client;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }


}