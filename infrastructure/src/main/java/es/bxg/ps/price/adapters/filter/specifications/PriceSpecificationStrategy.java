package es.bxg.ps.price.adapters.filter.specifications;

import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.filter.PriceFilter;
import org.springframework.data.jpa.domain.Specification;

public interface PriceSpecificationStrategy {
  Specification<PriceEntity> apply(PriceFilter filter);
}
