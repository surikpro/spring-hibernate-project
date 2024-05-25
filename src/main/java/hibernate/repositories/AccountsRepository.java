package hibernate.repositories;

import hibernate.domain.dto.AccountUpdateDto;
import hibernate.domain.entity.Account;

public interface AccountsRepository {
    void save(Account account);
    Account getAccountInfo(Long accountId);
    Account update(Long accountId, AccountUpdateDto accountUpdateDto);

    Account getById(Long accountId);

    void deleteById(Long accountId);
}
