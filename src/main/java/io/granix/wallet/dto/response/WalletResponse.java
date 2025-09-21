package io.granix.wallet.dto.response;

import io.granix.wallet.entity.utils.Currency;
import io.granix.wallet.entity.utils.CurrencyType;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletResponse {
    public UUID walletId;
    public BigDecimal balance;
    public BigDecimal availableBalance;
    public String currency;
    public UUID ownerId;

    public WalletResponse(UUID walletId, BigDecimal balance, BigDecimal availableBalance, String currency, UUID ownerId) {
        this.walletId = walletId;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.currency = currency;
        this.ownerId = ownerId;
    }
}
