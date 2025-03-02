package es.bxg.ps.price.usecase;

import es.bxg.ps.price.exception.PriceNotFoundException;
import es.bxg.ps.price.filter.PriceFilter;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.price.port.IPriceQueryPort;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
public class PriceQueryUseCase {

  private final IPriceQueryPort port;

  public PriceQueryUseCase(IPriceQueryPort port) {
    this.port = port;
  }

  public Price findOneByDate(Long brandId, Long productId, OffsetDateTime date) {
    List<Price> byFilters = port.findByFilters(PriceFilter.builder()
        .brandId(brandId)
        .productId(productId)
        .date(date)
        .build());

    return byFilters.stream()
        .findFirst()
        .orElseThrow(() -> new PriceNotFoundException("No hay precio definido para esa fecha"));
  }
}
