package com.eviro.assessment.grad001.phinakabemba;

import java.math.BigDecimal;

public interface AccountService {
    void withdraw(String accountNum, BigDecimal
            amountToWithdraw);
}
