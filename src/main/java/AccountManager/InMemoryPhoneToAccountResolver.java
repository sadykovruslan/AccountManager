package AccountManager;

import AccountManager.Model.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Service
@Component
public class InMemoryPhoneToAccountResolver implements PhoneToAccountResolver{
    private final Map<String, Account> phoneToAccountMapping;

    public InMemoryPhoneToAccountResolver() {
        this.phoneToAccountMapping = new HashMap<>();
    }

    @Override
    public Optional<Account> findAccountByPhoneNumber(String phoneNumber) {
        return Optional.ofNullable(phoneToAccountMapping.get(phoneNumber));
    }

    @Override
    public void addMapping(String phoneNumber, Account account) {
        phoneToAccountMapping.put(phoneNumber, account);
    }

    @Override
    public void removeMapping(String phoneNumber) {
        phoneToAccountMapping.remove(phoneNumber);
    }
}
