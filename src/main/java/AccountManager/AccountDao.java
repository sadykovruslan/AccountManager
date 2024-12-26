package AccountManager;

import AccountManager.Model.Account;

import java.util.Optional;

public interface AccountDao {

    Optional <Account> findAccount (long accountId);
    Account getAccount (long accountId);
    void setAmount (long accountId, long amount);
    void addAccount (Account account);
}
