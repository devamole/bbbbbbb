package com.credibanco.transactions.infrastructure.persistence.adapter;

import com.credibanco.transactions.domain.model.Transaction;
import com.credibanco.transactions.domain.port.TransactionRepository;
import com.credibanco.transactions.infrastructure.persistence.entity.TransactionEntity;
import com.credibanco.transactions.infrastructure.persistence.repository.TransactionJpaRepository;
import java.util.Optional;

public class TransactionRepositoryAdapter implements TransactionRepository {

    private final TransactionJpaRepository repository;

    public TransactionRepositoryAdapter(TransactionJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = mapToEntity(transaction);
        TransactionEntity savedEntity = repository.save(entity);
        return mapToDomain(savedEntity);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return repository.findById(id).map(this::mapToDomain);
    }

    private TransactionEntity mapToEntity(Transaction transaction) {
        return TransactionEntity.builder()
                .id(transaction.getId())
                .cardNumber(transaction.getCardNumber())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .status(transaction.getStatus())
                .transactionDate(transaction.getTransactionDate())
                .build();
    }

    private Transaction mapToDomain(TransactionEntity entity) {
        return Transaction.builder()
                .id(entity.getId())
                .cardNumber(entity.getCardNumber())
                .amount(entity.getAmount())
                .type(entity.getType())
                .status(entity.getStatus())
                .transactionDate(entity.getTransactionDate())
                .build();
    }
}

