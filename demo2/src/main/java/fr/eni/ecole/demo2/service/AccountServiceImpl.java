package fr.eni.ecole.demo2.service;

import fr.eni.ecole.demo2.entity.Account;
import fr.eni.ecole.demo2.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public void addAccount(Account account) throws Exception {
        if(account.getBalance()<=0){
            throw new Exception("Insufficient balance");
        }
        accountRepository.save(account);
    }

    @Transactional(rollbackFor =  Exception.class)
    @Override
    public void transfert(Long fromId, Long toId, double amount) throws Exception {

        Account fromAccount = accountRepository.findById(fromId).orElseThrow();
        Account toAccount = accountRepository.findById(toId).orElseThrow();

        double newFromBalance = fromAccount.getBalance()-amount;
        if(newFromBalance<0){
            throw new Exception("Insufficent balance");
        }

        fromAccount.setBalance(newFromBalance);
        accountRepository.save(fromAccount);

        if(true) throw new Exception("Intentional RunTime Exception");

        double newToBalance = toAccount.getBalance() + amount;
        toAccount.setBalance(newToBalance);
        accountRepository.save(toAccount);


    }

}
