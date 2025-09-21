package io.granix.wallet.listener;

import io.granix.common.event.user.UserCreatedEvent;
import io.granix.wallet.entity.utils.BankCurrency;
import io.granix.wallet.service.WalletGeneratorService;
import io.granix.wallet.service.iban.config.Country;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@ApplicationScoped
public class WalletCreator {

    @Inject
    WalletGeneratorService generator;

    @Transactional
    public void onUserRegistered(@ObservesAsync UserCreatedEvent event) {

        try {
            var wallet = this.generator.generate(
                    Country.MADAGASCAR,
                    BankCurrency.MGA,
                    event.userId()
            );


        } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException |
                 NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }


    }
}
