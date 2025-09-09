package fr.eni.ecole.demo2;

import fr.eni.ecole.demo2.entity.Account;
import fr.eni.ecole.demo2.repository.AccountRepository;
import fr.eni.ecole.demo2.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Start implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting AccountRepository......");

        Account aliceAccount = Account.builder().balance(500).build(); // New
        Account steveAccount = Account.builder().balance(60).build(); // New
        Account gaelAccount = Account.builder().balance(800).build(); // New
        // save
        accountRepository.save(aliceAccount);
        accountRepository.save(steveAccount);
        accountRepository.save(gaelAccount);
        try{
            accountService.transfert(aliceAccount.getId(),steveAccount.getId(),100);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        // print
        System.out.println("Accounts saved: "+accountRepository.findAll());

    }

}
