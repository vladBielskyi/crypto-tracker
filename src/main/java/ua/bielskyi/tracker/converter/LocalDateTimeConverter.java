package ua.bielskyi.tracker.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ua.bielskyi.tracker.utils.Utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Long> {
    @Override
    public Long convertToDatabaseColumn(LocalDateTime localDateTime) {
        return Utils.getTimestamp(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Long dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(dbData), ZoneOffset.UTC);
    }
}
