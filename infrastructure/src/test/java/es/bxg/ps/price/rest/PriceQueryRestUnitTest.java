package es.bxg.ps.price.rest;

import es.bxg.ps.model.PriceDto;
import es.bxg.ps.price.adapters.mapper.IPriceDtoMapper;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.price.usecase.PriceQueryUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

@ExtendWith(MockitoExtension.class)
class PriceQueryRestUnitTest {

  @InjectMocks
  private PriceQueryRest priceQueryRest;

  @Mock
  private IPriceDtoMapper mapper;

  @Mock
  private PriceQueryUseCase queryUseCase;

  @Test
  void findByDate() {
    PriceDto p = new PriceDto();
    p.setId(1L);

    Mockito.when(mapper.toDto(Mockito.any(Price.class))).thenReturn(p);
    Mockito.when(queryUseCase.findOneByDate(Mockito.any(Long.class), Mockito.any(Long.class), Mockito.any(java.time.OffsetDateTime.class))).thenReturn(Price.builder().build());

    ResponseEntity<PriceDto> result = priceQueryRest.findByDate(1L, 1L, OffsetDateTime.now());

    Assertions.assertNotNull(result.getBody());
    Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    Assertions.assertEquals(p.getId(), result.getBody().getId());

    Mockito.verify(mapper, Mockito.times(1)).toDto(Mockito.any(Price.class));
    Mockito.verify(queryUseCase, Mockito.times(1)).findOneByDate(Mockito.any(Long.class), Mockito.any(Long.class), Mockito.any(java.time.OffsetDateTime.class));
  }
}