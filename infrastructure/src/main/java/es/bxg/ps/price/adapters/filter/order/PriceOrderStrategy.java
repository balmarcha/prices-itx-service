package es.bxg.ps.price.adapters.filter.order;

import es.bxg.ps.price.filter.PriceFilter;
import org.springframework.data.domain.Sort;

public interface PriceOrderStrategy {
  Sort getSort(PriceFilter filter);
}
