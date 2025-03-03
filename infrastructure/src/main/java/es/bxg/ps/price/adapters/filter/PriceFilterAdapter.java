package es.bxg.ps.price.adapters.filter;

import es.bxg.ps.common.filter.SortDirection;
import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.entity.PriceEntity_;
import es.bxg.ps.price.adapters.filter.order.PriceOrderStrategy;
import es.bxg.ps.price.adapters.filter.specifications.PriceSpecificationStrategy;
import es.bxg.ps.price.filter.PriceFilter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PriceFilterAdapter {

  private final List<PriceOrderStrategy> orderStrategies;
  private final List<PriceSpecificationStrategy> strategies;

  public PriceFilterAdapter(List<PriceOrderStrategy> orderStrategies, List<PriceSpecificationStrategy> strategies) {
    this.strategies = strategies;
    this.orderStrategies = orderStrategies;
  }

  public Specification<PriceEntity> buildSpecification(PriceFilter filter) {
    return strategies.stream()
        .map(strategy -> strategy.apply(filter))
        .filter(Objects::nonNull)
        .reduce(Specification::and)
        .orElse(null);
  }

  public Sort getSort(PriceFilter filter) {
    return orderStrategies.stream()
        .map(strategy -> strategy.getSort(filter))
        .filter(Objects::nonNull)
        .reduce(Sort::and)
        .orElse(Sort.unsorted());
  }
}
