package AccountManager;

import AccountManager.Model.Account;

public interface AccountService {
    void transfer (long from, long to, long amount);
    void transferByPhoneNumber (long from, String number, long amount);
}
