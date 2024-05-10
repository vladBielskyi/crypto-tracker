package ua.bielskyi.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.bielskyi.tracker.entity.CurrencyData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRatesReport {
    private String baseCurrency;
    private Map<String, Rate> ratesMap;
    private LocalDateTime date;
    private List<Error> errors;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Error {
        private CurrencyData.SourceName sourceName;
        private String message;
    }
}
