package pl.bestapp.binancebot.infrastructure.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bestapp.binancebot.infrastructure.account.domain.AccountDetails;
import pl.bestapp.binancebot.infrastructure.account.domain.Position;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@RequestMapping("/account")
@RestController
public class AccountController {

    @GetMapping("/")
    public AccountDetails getDetails() {
        return new AccountDetails(
                new BigDecimal("123.14"),
                "USDT",
                Arrays.asList(
                        new Position("ETH", 145.0, new Date(), new BigDecimal("9562"))
                )
        );
    }




}
