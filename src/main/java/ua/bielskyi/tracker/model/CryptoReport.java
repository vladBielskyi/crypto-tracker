package ua.bielskyi.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.bielskyi.tracker.dto.sources.CoinApiCryptoDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CryptoReport {
    private List<CoinApiCryptoDto> cryptos;
}
