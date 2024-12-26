package AccountManager.Config;

import AccountManager.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class AccountManagerConfig {
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
