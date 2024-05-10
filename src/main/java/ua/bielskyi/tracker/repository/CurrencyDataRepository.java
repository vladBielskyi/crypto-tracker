package ua.bielskyi.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.bielskyi.tracker.entity.CurrencyData;

import java.util.List;

@Repository
public interface CurrencyDataRepository extends JpaRepository<CurrencyData, Long> {

    @Query(value = "SELECT * FROM currencies c " +
            "WHERE c.source = :source " +
            "AND c.date >= :from " +
            "AND c.date <= :to", nativeQuery = true)
    List<CurrencyData> findCurrencyDataByTimestamp(@Param("source") Integer source,
                                                   @Param("from") Long from,
                                                   @Param("to") Long to);

    @Query(value = "SELECT * FROM currencies c " +
            "WHERE c.source = :source " +
            "AND c.actual = :actual " +
            "AND c.date >= :from " +
            "AND c.date <= :to", nativeQuery = true)
    List<CurrencyData> findCurrencyDataByTimestampAndActual(@Param("source") Integer source,
                                                            @Param("actual") Boolean actual,
                                                            @Param("from") Long from,
                                                            @Param("to") Long to);

    @Modifying
    @Query(value = "UPDATE currencies " +
            "SET actual = false " +
            "WHERE source = :source " +
            "AND actual = true", nativeQuery = true)
    void updateActualToFalseBySource(@Param("source") Integer source);
}
