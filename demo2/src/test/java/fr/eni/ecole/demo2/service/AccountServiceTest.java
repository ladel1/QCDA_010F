package fr.eni.ecole.demo2.service;

import fr.eni.ecole.demo2.entity.Account;
import fr.eni.ecole.demo2.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void addAccountTest(){

        Account sarahAccount = Account.builder().balance(300).build();
        try {
            accountService.addAccount(sarahAccount);
        }catch (Exception e){}

        Account savedAccount = accountRepository.findById(sarahAccount.getId()).orElse(null);
        Assertions.assertNotNull(savedAccount);
        Assertions.assertEquals(sarahAccount.getBalance(),savedAccount.getBalance());

    }

}
