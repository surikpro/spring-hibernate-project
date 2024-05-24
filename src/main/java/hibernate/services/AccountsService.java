package hibernate.services;

import hibernate.domain.dto.*;
import hibernate.domain.entity.Account;

import java.util.Set;

public interface AccountsService {

    Account getAccount(Long accountId);
    void create(AccountCreateDto accountCreateDto);

    Set<ProjectDto> getAllProjectsOfAccount(Long accountId);

    AccountDto update(Long accountId, AccountUpdateDto accountUpdateDto);

    void deleteById(Long accountId);

    public AccountInfo getAccountInfo(Long accountId);
}
