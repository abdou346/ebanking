package emsi.ma.ebankingbackend.web;

import emsi.ma.ebankingbackend.dtos.*;
import emsi.ma.ebankingbackend.exceptions.BalanceNotSufficientException;
import emsi.ma.ebankingbackend.exceptions.BankAccountNotFoundException;
import emsi.ma.ebankingbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin("*")
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String accountId, @RequestParam(name="page",defaultValue = "0") int page , @RequestParam(name="size",defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }
    @PostMapping("/accounts/debit")
public DebitDto debit(@RequestBody  DebitDto debitDto) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.debit(debitDto.getAccountId(),debitDto.getAmount(),debitDto.getDescription());
        return debitDto;
    }
    @PostMapping("/accounts/credit")
    public CreditDto credit(@RequestBody CreditDto creditDto) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.debit(creditDto.getAccountId(),creditDto.getAmount(),creditDto.getDescription());
        return creditDto;
    }
    @PostMapping("/accounts/transfer")
    public void transfer (@RequestBody TransferRequestdto transferRequestdto) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.transfer(
                transferRequestdto.getAccountsource(),
                transferRequestdto.getAccountdestination(),
                transferRequestdto.getAmount());
    }
}
