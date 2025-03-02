package es.bxg.ps.price.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
public class PriceFilter {

  private Long brandId;
  private Long productId;
  private OffsetDateTime date;
}
