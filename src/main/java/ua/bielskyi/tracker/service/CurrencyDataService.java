package ua.bielskyi.tracker.service;

import ua.bielskyi.tracker.model.Crypto;
import ua.bielskyi.tracker.model.CryptoReport;
import ua.bielskyi.tracker.model.ExchangeRatesReport;
import ua.bielskyi.tracker.model.TimeSeriesPeriod;

import java.time.LocalDateTime;

public interface CurrencyDataService {

    ExchangeRatesReport getExchangeRatesForPeriodReport(LocalDateTime dateTime);

    ExchangeRatesReport getExchangeRatesReport();

    CryptoReport getCryptoReport(Crypto base, Crypto quote, TimeSeriesPeriod period);

    void importCurrencies();
}
