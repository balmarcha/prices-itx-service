package es.bxg.ps.price.filter;

import es.bxg.ps.common.filter.SortFilter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Getter
@Setter
@SuperBuilder
public class PriceFilter extends SortFilter {

  private Long brandId;
  private Long productId;
  private OffsetDateTime date;
}
