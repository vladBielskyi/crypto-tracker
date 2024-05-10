package ua.bielskyi.tracker.service;

import ua.bielskyi.tracker.dto.sources.CoinApiCryptoDto;
import ua.bielskyi.tracker.model.Crypto;
import ua.bielskyi.tracker.model.TimeSeriesPeriod;

public interface CryptoService {

    CoinApiCryptoDto[] fetchCryptoData(Crypto base, Crypto quote, TimeSeriesPeriod period);
}
