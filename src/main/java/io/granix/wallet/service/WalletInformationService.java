package io.granix.wallet.service;

import io.granix.wallet.entity.WalletEntity;
import io.granix.wallet.repository.WalletRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class WalletInformationService {
    @Inject
    WalletRepository repository;

    public List<WalletEntity> getAllWallet()
    {
        return repository.listAll();
    }

    public List<WalletEntity> searchByUser(UUID userId)
    {
        return repository.list("ownerId", userId);
    }
}
