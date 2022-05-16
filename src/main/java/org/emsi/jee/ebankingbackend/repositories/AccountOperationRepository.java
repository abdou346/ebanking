package org.emsi.jee.ebankingbackend.repositories;

import org.emsi.jee.ebankingbackend.entities.AccountOperation;
import org.emsi.jee.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {

}
