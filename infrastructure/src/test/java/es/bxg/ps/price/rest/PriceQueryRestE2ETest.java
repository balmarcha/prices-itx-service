package es.bxg.ps.price.rest;

import es.bxg.ps.model.PriceDto;
import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.filter.specifications.PriceSpecificationStrategy;
import es.bxg.ps.price.adapters.mapper.IPriceDtoMapper;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.price.usecase.PriceQueryUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@AutoConfigureMockMvc
class PriceQueryRestE2ETest {

  @Autowired
  private MockMvc mockMvc;

  @ParameterizedTest
  @MethodSource("filterDataProvider")
  void findByDate(Long brandId, Long productId, OffsetDateTime date, BigDecimal price) throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
            .get("/prices")
            .param("brandId", brandId.toString())
            .param("productId", productId.toString())
            .param("date", date.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(price));
  }

  static Stream<Arguments> filterDataProvider() {

    PriceSpecificationStrategy strategy = Mockito.mock(PriceSpecificationStrategy.class);
    Specification<PriceEntity> specification = (root, query, cb) -> cb.equal(root.get("brandId"), 1);

    Mockito.when(strategy.apply(Mockito.any())).thenReturn(specification);

    return Stream.of(
        Arguments.of(1L, 1L, OffsetDateTime.of(2020, 6, 14, 10, 0, 0, 0, ZoneOffset.ofHours(0)), BigDecimal.valueOf(35.50)),
        Arguments.of(1L, 1L, OffsetDateTime.of(2020, 6, 14, 16, 0, 0, 0, ZoneOffset.ofHours(0)), BigDecimal.valueOf(25.45)),
        Arguments.of(1L, 1L, OffsetDateTime.of(2020, 6, 14, 21, 0, 0, 0, ZoneOffset.ofHours(0)), BigDecimal.valueOf(35.50)),
        Arguments.of(1L, 1L, OffsetDateTime.of(2020, 6, 15, 10, 0, 0, 0, ZoneOffset.ofHours(0)), BigDecimal.valueOf(35.50)),
        Arguments.of(1L, 1L, OffsetDateTime.of(2020, 6, 16, 21, 0, 0, 0, ZoneOffset.ofHours(0)), BigDecimal.valueOf(38.95))
    );
  }
}