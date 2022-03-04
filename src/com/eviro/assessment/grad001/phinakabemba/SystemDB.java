package com.eviro.assessment.grad001.phinakabemba;

import com.eviro.assessment.grad001.phinakabemba.domains.Account;

import java.util.HashMap;
import java.util.Map;

// Creating a singleton class "SystemDB"
public class SystemDB {
    //Creating a HashMap where we can prepopulate the dummy accounts
    public static Map<String, Account> ACCOUNTS = new HashMap<>();
}
