package io.granix.wallet.repository;

import io.granix.wallet.entity.WalletEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WalletRepository implements PanacheRepository<WalletEntity> {
}
