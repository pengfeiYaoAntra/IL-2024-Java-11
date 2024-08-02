package org.example.Day3;

import java.util.Optional;

/**
 * demo optional here
 */
public class GoogleAccount {
    private String accountNumber;
    private Optional<String> password;
    public GoogleAccount(String accountNumber, Optional<String> password){
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Optional<String> getPassword() {
        return password;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPassword(Optional<String> password) {
        this.password = password;
    }
}
