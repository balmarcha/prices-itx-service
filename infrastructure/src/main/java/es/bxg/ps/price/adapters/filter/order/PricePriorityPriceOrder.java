package es.bxg.ps.price.adapters.filter.order;

import es.bxg.ps.common.filter.SortDirection;
import es.bxg.ps.price.adapters.entity.PriceEntity_;
import es.bxg.ps.price.filter.PriceFilter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PricePriorityPriceOrder implements PriceOrderStrategy {

  @Override
  public Sort getSort(PriceFilter filter) {

    if(filter.getField().equals(PriceEntity_.PRIORITY)) {
      return Sort.by(
          SortDirection.DESC.equals(filter.getDirection()) ? Sort.Direction.DESC : Sort.Direction.ASC,
          PriceEntity_.PRIORITY);
    }

    return null;
  }
}
