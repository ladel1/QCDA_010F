package fr.eni.ecole.demo2.service;

import fr.eni.ecole.demo2.entity.Account;

public interface AccountService {
    void addAccount(Account account) throws Exception;
    void transfert(Long fromId, Long toId,double amount) throws Exception;
}
