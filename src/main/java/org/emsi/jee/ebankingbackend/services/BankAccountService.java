package org.emsi.jee.ebankingbackend.services;

import org.emsi.jee.ebankingbackend.entities.BankAccount;
import org.emsi.jee.ebankingbackend.entities.Customer;
import org.emsi.jee.ebankingbackend.exceptions.CustomerNotFounException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer (Customer customer);
    BankAccount saveCurrentBank(double initiBalance,double overDraft ,Long customerid) throws CustomerNotFounException;
    BankAccount saveSavingBank(double initiBalance,double interestRate ,Long customerid) throws CustomerNotFounException;

    List<Customer>listCustomer();
    BankAccount getBankAccount(String accountId);
    void debit (String accountId,double amount,String description);
    void credit (String accountId,double amount,String description);
    void transfert (String accountIdSource,String accountIdDestination,double amount);

}
