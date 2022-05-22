package emsi.ma.ebankingbackend.dtos;

import lombok.Data;

@Data
public class TransferRequestdto {
    private String accountsource;
    private String accountdestination;
    private double amount;
    private String description;
    
}
