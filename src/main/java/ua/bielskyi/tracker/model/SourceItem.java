package ua.bielskyi.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.bielskyi.tracker.entity.CurrencyData;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SourceItem {
    private Float rate;
    private CurrencyData.SourceName sourceName;
}
