package hibernate.services;

import hibernate.domain.dto.*;
import hibernate.domain.entity.Account;
import hibernate.domain.entity.Project;
import hibernate.repositories.AccountsRepository;
import hibernate.repositories.ProjectsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsServiceHibernateImpl implements AccountsService {
    private final AccountsRepository accountsRepository;
    private final ProjectsRepository projectsRepository;

    @Override
    public Account getAccount(Long accountId) {
        Account account = accountsRepository.getById(accountId);
        System.out.println("service " + account.toString());
        return account;
    }
    @Override
    public void create(AccountCreateDto accountCreateDto) {
        accountsRepository.save(Account.builder()
                .firstName(accountCreateDto.getFirstName())
                .lastName(accountCreateDto.getLastName())
                .build());
    }
    @Override
    public Set<ProjectDto> getAllProjectsOfAccount(Long accountId) {
        return projectsRepository.getAllProjectsOfUser(accountId);
    }
    @Override
    public AccountDto update(Long accountId, AccountUpdateDto accountUpdateDto) {
        Account account = accountsRepository.update(accountId, accountUpdateDto);
        return AccountDto.builder()
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .projects(account.getProjects())
                .positions(account.getPositions())
                .build();
    }
    @Override
    public void deleteById(Long accountId) {
        accountsRepository.deleteById(accountId);
    }

    @Override
    public AccountInfo getAccountInfo(Long accountId) {
        Account account = accountsRepository.getById(accountId);
        return AccountInfo.builder()
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .projects(ProjectDto.from(account.getProjects()))
                .positions(PositionDto.from(account.getPositions()))
                .build();
    }
}
