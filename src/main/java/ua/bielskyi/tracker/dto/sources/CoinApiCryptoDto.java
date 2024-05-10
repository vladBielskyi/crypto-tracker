package ua.bielskyi.tracker.dto.sources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoinApiCryptoDto {
    @JsonProperty("time_period_start")
    private LocalDateTime timePeriodStart;
    @JsonProperty("time_period_end")
    private LocalDateTime timePeriodEnd;
    @JsonProperty("time_open")
    private LocalDateTime timeOpen;
    @JsonProperty("time_close")
    private LocalDateTime timeClose;
    @JsonProperty("rate_open")
    private Double rateOpen;
    @JsonProperty("rate_high")
    private Double rateHigh;
    @JsonProperty("rate_low")
    private Double rateLow;
    @JsonProperty("rate_close")
    private Double rateClose;
}
