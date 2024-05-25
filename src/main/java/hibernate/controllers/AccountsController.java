package hibernate.controllers;

import hibernate.HomeworkHibernateApplication;
import hibernate.domain.dto.*;
import hibernate.domain.entity.Account;
import hibernate.services.AccountsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class AccountsController {
    private final AccountsService accountsService;

    @GetMapping(path = "/accounts/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        if (accountsService.getAccount(accountId) != null) {
            return ResponseEntity.ok(accountsService.getAccount(accountId));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/accounts/{accountId}/getAccountInfo")
    public ResponseEntity<AccountInfo> getAccountInfo(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountsService.getAccountInfo(accountId));
    }

    @PostMapping("/accounts")
    public void createUser(@RequestBody AccountCreateDto accountCreateDto) {
        accountsService.create(accountCreateDto);
    }

    @GetMapping("/accounts/{accountId}/projects")
    public Set<ProjectDto> getAllProjectsOfUser(@PathVariable Long accountId) {
        return accountsService.getAllProjectsOfAccount(accountId);
    }

    @PatchMapping("/accounts/{accountId}")
    public ResponseEntity<AccountDto> update(@PathVariable(name = "accountId") Long accountId,
                                             @RequestBody AccountUpdateDto accountUpdateDto) {
        return ResponseEntity.ok(accountsService.update(accountId, accountUpdateDto));
    }

    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "accountId") Long accountId) {
        accountsService.deleteById(accountId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
