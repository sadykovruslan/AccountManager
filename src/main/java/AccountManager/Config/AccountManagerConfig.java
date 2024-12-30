package AccountManager.Config;

import AccountManager.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import java.util.Set;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class AccountManagerConfig {

    @Value("#{'${blocked.accounts}'.split(',')}")
    private Set<Long> blockedAccounts;

    @Bean
    public AccountDao accountDao(){
        return new InMemoryAccountDao();
    }

    @Bean
    public PhoneToAccountResolver phoneToAccountResolver() {
        return new InMemoryPhoneToAccountResolver();
    }

    @Bean
    public AccountService accountService () {
        return new InMemoryAccountService(phoneToAccountResolver(), accountDao());
    }
}
