package ua.bielskyi.tracker.dto.sources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivatCurrencyDto {
    private String baseCurrency;
    private String currency;
    private float saleRateNB;
    private float purchaseRateNB;
    private float saleRate;
    private float purchaseRate;
}
