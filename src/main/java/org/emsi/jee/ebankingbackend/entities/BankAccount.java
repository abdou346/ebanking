package org.emsi.jee.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emsi.jee.ebankingbackend.enums.AccountStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",length=4)
@Data@AllArgsConstructor@NoArgsConstructor@Entity
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;

    private Date createAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
@ManyToOne
    private Customer customer;
@OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    private List<AccountOperation>accountOperations;
}
