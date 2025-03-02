package es.bxg.ps.price.adapters.filter;

import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.filter.specifications.PriceSpecificationStrategy;
import es.bxg.ps.price.filter.PriceFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PriceFilterAdapter {

  private final List<PriceSpecificationStrategy> strategies;

  public PriceFilterAdapter(List<PriceSpecificationStrategy> strategies) {
    this.strategies = strategies;
  }

  public Specification<PriceEntity> buildSpecification(PriceFilter filter) {
    return strategies.stream()
        .map(strategy -> strategy.apply(filter))
        .filter(Objects::nonNull)
        .reduce(Specification::and)
        .orElse(null);
  }
}
