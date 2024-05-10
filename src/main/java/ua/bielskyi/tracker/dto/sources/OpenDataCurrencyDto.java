package ua.bielskyi.tracker.dto.sources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenDataCurrencyDto {
    @JsonProperty("r030")
    private int code;
    @JsonProperty("txt")
    private String name;
    @JsonProperty("rate")
    private float rate;
    @JsonProperty("cc")
    private String abbreviation;
    @JsonProperty("exchangedate")
    private String exchangeDate;
}
