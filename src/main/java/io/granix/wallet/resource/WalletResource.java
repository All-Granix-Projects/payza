package io.granix.wallet.resource;

import io.granix.wallet.dto.response.WalletResponse;
import io.granix.wallet.service.WalletInformationService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path(value = "/wallets")
public class WalletResource {
    @Inject
    WalletInformationService service;

    @Inject
    JsonWebToken jwt;

    @GET
    @Path(value = "/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<WalletResponse> list()
    {
        var wallets = service.getAllWallet();

        return wallets.stream()
                .map(w -> new WalletResponse(
                        w.id,
                        w.balance,
                        w.availableBalance,
                        w.currencyCode,
                        w.ownerId
                ))
                .collect(Collectors.toList());
    }

    @GET
    @Path("/user/{userId}")
    public List<WalletResponse> listByUserId(String userId)
    {
        var wallets = service.searchByUser(UUID.fromString(userId));

        return wallets.stream()
                .map(w -> new WalletResponse(
                        w.id,
                        w.balance,
                        w.availableBalance,
                        w.currencyCode,
                        w.ownerId
                ))
                .collect(Collectors.toList());
    }
}
