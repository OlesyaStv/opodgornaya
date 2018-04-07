package ru.job4j.bank;

import java.util.*;

public class Bank {

    private Map<User, List<Account>> base = new HashMap<>();

    public Map<User, List<Account>> getBase() {
        return base;
    }

    public void addUser(User user) {
        this.base.putIfAbsent(user, new ArrayList<>());
    }

    public void delete(User user) {
        this.base.remove(user);
    }

    public User findUserByPassport(String passport) {
        User findUser = null;
        for (User user : base.keySet()) {
            String currentPassport = user.getPassport();
            if (currentPassport.equals(passport)) {
                findUser = user;
                break;
            }
        }
        return findUser;
    }

    public Account findAccountByRequisites(String requisites) {
        Account findAccount = null;
        for (User user : base.keySet()) {
            List<Account> accountListSrs = getUserAccounts(user.getPassport());
            ListIterator<Account> iterator = accountListSrs.listIterator();
            while (iterator.hasNext()) {
                Account currentAccount = iterator.next();
                if (currentAccount.getRequisites().equals(requisites)) {
                    findAccount = currentAccount;
                    break;
                }
            }
        }
        return findAccount;
    }

   public void addAccountToUser(String passport, Account account) {
       this.base.get(findUserByPassport(passport)).add(account);
   }

    public void deleteAccountFromUser(String passport, Account account) {
        this.base.get(findUserByPassport(passport)).remove(account);
    }

   public List<Account> getUserAccounts(String passport) {
       return this.base.get(findUserByPassport(passport));
   }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean wasTransfered = false;
        List<Account> accountListSrs = getUserAccounts(srcPassport);
        List<Account> accountListDest = getUserAccounts(destPassport);
        Account accountSrc = findAccountByRequisites(srcRequisite);
        Account accountDest = findAccountByRequisites(dstRequisite);
        Integer indexSrc = accountListSrs.indexOf(accountSrc);
        Integer indexDest = accountListDest.indexOf(accountDest);
        if (indexSrc != -1 && indexDest != -1) {
            if (accountSrc.getValue() >= amount) {
                accountDest.setValue(accountDest.getValue() + amount);
                accountSrc.setValue(accountSrc.getValue() - amount);
                wasTransfered = true;
            }
        }
        return  wasTransfered;
    }
}
