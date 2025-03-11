package com.credibanco.transactions.application.service;

import com.credibanco.transactions.domain.model.Transaction;
import java.math.BigDecimal;

public interface TransactionService {
    Transaction processRecharge(String cardNumber, BigDecimal amount);
    Transaction processPayment(String cardNumber, BigDecimal amount);
    Transaction cancelTransaction(Long transactionId);
}
