package hibernate.repositories;

import hibernate.domain.dto.AccountUpdateDto;
import hibernate.domain.entity.Account;
import hibernate.exceptions.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Primary
public class AccountsRepositoryHibernateImpl implements AccountsRepository {
    private final SessionFactory sessionFactory;
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public Account getById(Long accountId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Account account = Optional.ofNullable(session.get(Account.class, accountId))
                .orElseThrow(() -> new AccountNotFoundException(accountId));
        transaction.commit();
        return account;
    }
    @Override
    public void deleteById(Long accountId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Account accountToRemove = Optional.ofNullable(session.get(Account.class, accountId))
                .orElseThrow(() -> new AccountNotFoundException(accountId));
        System.out.println(accountToRemove);
        session.remove(accountToRemove);
        transaction.commit();
    }
    @Override
    public void save (Account account) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(account);
        transaction.commit();
    }
    @Override
    public Account getAccountInfo(Long accountId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, accountId);
        transaction.commit();
        return account;
    }
    @Override
    public Account update(Long accountId, AccountUpdateDto accountUpdateDto) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Account forUpdate = Optional.ofNullable(session.find(Account.class, accountId))
                .orElseThrow(() -> new AccountNotFoundException(accountId));
        forUpdate.setFirstName(accountUpdateDto.getFirstName());
        forUpdate.setLastName(accountUpdateDto.getLastName());
        System.out.println(forUpdate);
        session.merge(forUpdate);
        transaction.commit();
        return forUpdate;
    }
}
