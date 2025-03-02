package es.bxg.ps.price.rest;

import es.bxg.ps.PricesApi;
import es.bxg.ps.model.PriceDto;
import es.bxg.ps.price.adapters.mapper.IPriceDtoMapper;
import es.bxg.ps.price.usecase.PriceQueryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class PriceQueryRest implements PricesApi {

  private final IPriceDtoMapper mapper;
  private final PriceQueryUseCase queryUseCase;

  public PriceQueryRest(IPriceDtoMapper mapper, PriceQueryUseCase queryUseCase) {
    this.mapper = mapper;
    this.queryUseCase = queryUseCase;
  }

  @Override
  public ResponseEntity<PriceDto> findByDate(Long brandId, Long productId, OffsetDateTime date) {
    //OffsetDateTime.of(2020, 6, 14, 10, 00, 00, 0, ZoneOffset.ofHours(0));
    return ResponseEntity.ok(mapper.toDto(queryUseCase.findOneByDate(brandId, productId, date)));
  }
}
