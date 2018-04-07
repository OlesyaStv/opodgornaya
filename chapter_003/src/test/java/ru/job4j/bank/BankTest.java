package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "123456ss");
        User user2 = new User("Petrov", "ll789777");
        bank.addUser(user1);
        bank.addUser(user2);
        Map base = bank.getBase();
        assertThat(base.containsKey(user1), is(true));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "123456ss");
        User user2 = new User("Petrov", "ll789777");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.delete(user1);
        Map base = bank.getBase();
        assertThat(base.containsKey(user1), is(false));
    }

    @Test
    public void whenFindUserByPassport() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "123456ss");
        User user2 = new User("Petrov", "ll789777");
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.findUserByPassport("123456ss"), is(user1));
    }


    @Test
    public void whenAddAndGetUserAccounts() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "123456ss");
        bank.addUser(user1);
        Account account1User1 = new Account(8900.50, "qq7777");
        Account account2User1 = new Account(10000.00, "qqppp22");
        bank.addAccountToUser("123456ss", account1User1);
        bank.addAccountToUser("123456ss", account2User1);
        assertThat(bank.getUserAccounts("123456ss").get(1), is(account2User1));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "123456ss");
        bank.addUser(user1);
        Account account1User1 = new Account(8900.50, "qq7777");
        Account account2User1 = new Account(10000.00, "qqppp22");
        bank.addAccountToUser("123456ss", account1User1);
        bank.addAccountToUser("123456ss", account2User1);
        bank.deleteAccountFromUser("123456ss", account1User1);
        assertThat(bank.getUserAccounts("123456ss").get(0), is(account2User1));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "pass1");
        User user2 = new User("Petrov", "pass2");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1User1 = new Account(1000.00, "req1");
        bank.addAccountToUser("pass1", account1User1);
        Account account1User2 = new Account(00.00, "req2");
        bank.addAccountToUser("pass2", account1User2);
        bank.transferMoney("pass1", "req1", "pass2", "req2", 500);
        assertThat(bank.getUserAccounts("pass1").get(0).getValue(), is(500.00));
    }

}
