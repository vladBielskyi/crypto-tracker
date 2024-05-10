package ua.bielskyi.tracker.service;

import ua.bielskyi.tracker.dto.FetchedCurrencyDataDto;
import ua.bielskyi.tracker.entity.CurrencyData;

import java.time.LocalDateTime;
import java.util.List;

public interface CurrencyExchangerService {

    List<FetchedCurrencyDataDto> getCurrencyDataForThePeriod(LocalDateTime date);

    CurrencyData.SourceName getSourceName();
}
