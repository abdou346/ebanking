package org.emsi.jee.ebankingbackend.repositories;

import org.emsi.jee.ebankingbackend.entities.BankAccount;
import org.emsi.jee.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
