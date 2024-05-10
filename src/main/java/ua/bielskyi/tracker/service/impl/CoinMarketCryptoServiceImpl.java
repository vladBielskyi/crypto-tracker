package ua.bielskyi.tracker.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.bielskyi.tracker.dto.sources.CoinApiCryptoDto;
import ua.bielskyi.tracker.exception.ApiRetrieveException;
import ua.bielskyi.tracker.exception.InternalException;
import ua.bielskyi.tracker.model.Crypto;
import ua.bielskyi.tracker.model.TimeSeriesPeriod;
import ua.bielskyi.tracker.service.CryptoService;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoinMarketCryptoServiceImpl implements CryptoService {

    @Value(value = "${ua.bielskyi.coin.api.url}")
    private String currencyUrl;

    @Value(value = "${ua.bielskyi.coin.api.key}")
    private String currencyKey;

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    @Override
    public CoinApiCryptoDto[] fetchCryptoData(Crypto base, Crypto quote, TimeSeriesPeriod period) {
        HttpUrl url = HttpUrl.parse(currencyUrl + "/v1/exchangerate/"
                        + base.name() + "/"
                        + quote.name() + "/history")
                .newBuilder()
                .addQueryParameter("period_id", period.getPeriodIdentifier())
                .build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .addHeader("X-CoinAPI-Key", currencyKey)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("Error while fetching coin api: {}", response);
                throw new ApiRetrieveException(String.format("Unexpected response code while fetching coin api: %s",
                        response.code()));
            }

            return objectMapper.readValue(response.body().string(), CoinApiCryptoDto[].class);
        } catch (IOException e) {
            log.error("Error while parsing data: {}", e);
            throw new InternalException("Something went wrong while parsing data", e);
        }
    }
}
