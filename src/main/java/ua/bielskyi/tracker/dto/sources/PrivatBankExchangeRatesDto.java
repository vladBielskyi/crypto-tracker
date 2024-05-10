package ua.bielskyi.tracker.dto.sources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivatBankExchangeRatesDto {
    private String date;
    private List<PrivatCurrencyDto> exchangeRate;
}
