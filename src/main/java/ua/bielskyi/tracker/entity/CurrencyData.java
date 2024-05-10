package ua.bielskyi.tracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.bielskyi.tracker.converter.LocalDateTimeConverter;

import java.time.LocalDateTime;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyData extends BaseEntity {

    @Column(name = "base_currency_code")
    private String baseCurrencyCode;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "buy_rate")
    private Float buyRate;

    @Column(name = "sell_rate")
    private Float sellRate;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "date")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime date;

    @Column(name = "actual")
    private Boolean actual;

    @Column(name = "source")
    private Integer source;

    public enum SourceName {

        MONOBANK(1),
        PRIVATBANK(2),
        OPEN_DATA(3);

        private int value;

        SourceName(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static SourceName getSourceName(int value) {
            for (SourceName sourceName : SourceName.values()) {
                if (sourceName.getValue() == value) {
                    return sourceName;
                }
            }
            throw new IllegalArgumentException("Invalid value for SourceName: " + value);
        }
    }
}
