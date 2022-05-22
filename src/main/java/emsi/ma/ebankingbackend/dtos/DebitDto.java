package emsi.ma.ebankingbackend.dtos;

import lombok.Data;

import javax.persistence.Id;
@Data
public class DebitDto {
    private String accountId;
    private double amount;
    private String description;

}
