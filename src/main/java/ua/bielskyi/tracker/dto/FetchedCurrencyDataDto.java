package ua.bielskyi.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class FetchedCurrencyDataDto {
    private final String baseCurrencyCode;
    private final String currencyCode;
    private final Float rate;
    private final Float buyRate;
    private final Float sellRate;
    private final LocalDateTime date;
    private final Integer source;
}
