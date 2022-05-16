package org.emsi.jee.ebankingbackend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.emsi.jee.ebankingbackend.entities.BankAccount;
import org.emsi.jee.ebankingbackend.entities.CurrentAccount;
import org.emsi.jee.ebankingbackend.entities.Customer;
import org.emsi.jee.ebankingbackend.entities.SavingAccount;
import org.emsi.jee.ebankingbackend.exceptions.CustomerNotFounException;
import org.emsi.jee.ebankingbackend.repositories.AccountOperationRepository;
import org.emsi.jee.ebankingbackend.repositories.BankAccountRepository;
import org.emsi.jee.ebankingbackend.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService{

    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;
    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new Customer");
        Customer savedCustomer=customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public BankAccount saveBank(double initiBalance, String type, Long customerid) throws CustomerNotFounException {
        Customer customer=customerRepository.findById(customerid).orElse(null);
        if(customer==null)
            throw new CustomerNotFounException("Customer not found");
        BankAccount bankAccount;
        if(type.equals("current")) {
            bankAccount = new CurrentAccount();
        }else{
            bankAccount=new SavingAccount();

        }
       bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreateAt(new Date());
        bankAccount.setBalance(initiBalance);


        return null;
    }

    @Override
    public List<Customer> listCustomer() {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfert(String accountIdSource, String accountIdDestination, double amount) {

    }
}
