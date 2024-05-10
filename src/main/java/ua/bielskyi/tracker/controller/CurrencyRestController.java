package ua.bielskyi.tracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.bielskyi.tracker.model.Crypto;
import ua.bielskyi.tracker.model.CryptoReport;
import ua.bielskyi.tracker.model.ExchangeRatesReport;
import ua.bielskyi.tracker.model.TimeSeriesPeriod;
import ua.bielskyi.tracker.service.CurrencyDataService;
import ua.bielskyi.tracker.utils.Utils;

import java.util.Date;

import static ua.bielskyi.tracker.utils.Utils.convertToLocalDateTime;

@RestController
@RequestMapping(value = "/api/currencies/")
@RequiredArgsConstructor
public class CurrencyRestController {

    private final CurrencyDataService currencyDataService;

    @GetMapping(value = "/actual")
    public ResponseEntity<ExchangeRatesReport> getExchangeRatesReport() {
        ExchangeRatesReport ratesReport = currencyDataService.getExchangeRatesReport();
        return ResponseEntity.ok(ratesReport);
    }

    @GetMapping(value = "/period")
    public ResponseEntity<ExchangeRatesReport> getExchangeRatesForPeriodReport(
            @DateTimeFormat(pattern = Utils.DEFAULT_DATE_PATTER)
            @RequestParam(value = "date") Date date) {
        ExchangeRatesReport periodReport = currencyDataService
                .getExchangeRatesForPeriodReport(convertToLocalDateTime(date));
        return ResponseEntity.ok(periodReport);
    }

    @GetMapping(value = "/crypto")
    public ResponseEntity<CryptoReport> getCryptoReport(
            @RequestParam(value = "base") Crypto base,
            @RequestParam(value = "quote") Crypto quote,
            @RequestParam(value = "period") TimeSeriesPeriod period) {
        CryptoReport cryptoReport = currencyDataService.getCryptoReport(base, quote, period);
        return ResponseEntity.ok(cryptoReport);
    }
}
