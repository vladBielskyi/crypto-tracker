package ua.bielskyi.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.bielskyi.tracker.entity.CurrencyData;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CurrencySourceFactory {

    private Map<CurrencyData.SourceName, CurrencyExchangerService> sources;

    @Autowired
    public CurrencySourceFactory(Set<CurrencyExchangerService> service) {
        createSource(service);
    }

    public CurrencyExchangerService findSource(CurrencyData.SourceName sourceName) {
        return sources.get(sourceName);
    }

    private void createSource(Set<CurrencyExchangerService> sourceSet) {
        sources = sourceSet.stream()
                .collect(Collectors.toMap(CurrencyExchangerService::getSourceName, Function.identity()));
    }
}
