package com.poc.banking.transaction.accounts;

import com.poc.banking.transaction.enums.AccountStatus;
import com.poc.banking.transaction.enums.AccountType;
import com.poc.banking.transaction.enums.Currency;



public class AccountDto {

     private Long id;
     private String accountNumber;
     private AccountType accountType;
     private Currency currency;
     private double balance;
     private Long clientId;
     private AccountStatus status;
     private String iban;
     private String bic;
     private String rib;
     private String swift;

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

     public Long getClientId() {
          return clientId;
     }

     public void setClientId(Long clientId) {
          this.clientId = clientId;
     }

     public AccountStatus getStatus() {
          return status;
     }

     public void setStatus(AccountStatus status) {
          this.status = status;
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
