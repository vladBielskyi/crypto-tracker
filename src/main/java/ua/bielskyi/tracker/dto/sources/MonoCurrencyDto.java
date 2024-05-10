package ua.bielskyi.tracker.dto.sources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonoCurrencyDto {
    private String currencyCodeA;
    private String currencyCodeB;
    private float rateBuy;
    private float rateSell;
    private float rateCross;
    private long date;
}
