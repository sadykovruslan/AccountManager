package AccountManager;

import AccountManager.Config.AccountManagerConfig;
import AccountManager.Config.AccountManagerConfigV2;
import AccountManager.Model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//       var applicationContext = new AnnotationConfigApplicationContext(AccountManagerConfig.class);
       var applicationContext = new ClassPathXmlApplicationContext("account-manager.xml");
//       var applicationContext = new AnnotationConfigApplicationContext(AccountManagerConfigV2.class);


       var phoneToCardResolver = applicationContext.getBean(PhoneToAccountResolver.class);
       var accountServise = applicationContext.getBean(AccountService.class);

       var accountDao = applicationContext.getBean(AccountDao.class);

        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 2000);

       accountDao.addAccount(account1);
       accountDao.addAccount(account2);

        System.out.println(account2);

        String phoneNumber = "1234567";

        phoneToCardResolver.addMapping(phoneNumber, account2);
        accountServise.transferByPhoneNumber(account1.getId(), phoneNumber, 500);

        System.out.println(account1);
        System.out.println(account2);

        accountServise.transfer(account1.getId(), account2.getId(), 250);

        System.out.println(account1);
        System.out.println(account2);

//        accountServise.transferByPhoneNumber(account1.getId(), "132", 500);
   }
}
