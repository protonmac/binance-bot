package pl.bestapp.binancebot.infrastructure.candlestick.controller;

import org.springframework.web.bind.annotation.*;
import pl.bestapp.binancebot.client.domain.market.Candlestick;
import pl.bestapp.binancebot.client.domain.market.CandlestickInterval;
import pl.bestapp.binancebot.infrastructure.candlestick.domain.CandlestickDTO;
import pl.bestapp.binancebot.infrastructure.candlestick.service.CandlestickService;

import java.util.List;

@RequestMapping("/candlestick")
@RestController
public class CandlestickController {

    private final CandlestickService candlestickService;

    public CandlestickController(CandlestickService candlestickService) {
        this.candlestickService = candlestickService;
    }

    @GetMapping("/{symbol}/{interval}")
    public List<CandlestickDTO> getStrategy(@PathVariable("symbol") String symbol, @PathVariable("interval") String interval) {
        return candlestickService.getCandlestickBars(symbol, CandlestickInterval.fromString(interval));
    }


}
