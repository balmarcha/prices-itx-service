package es.bxg.ps.price.adapters.filter.specifications;

import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.entity.PriceEntity_;
import es.bxg.ps.price.filter.PriceFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceDateSpecification implements PriceSpecificationStrategy {

  @Override
  public Specification<PriceEntity> apply(PriceFilter filter) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();// Crea un predicado que siempre es verdadero

      if (filter.getDate() != null) {
        predicates.add(cb.and(cb.greaterThanOrEqualTo(root.get(PriceEntity_.END_DATE), filter.getDate()),
            cb.lessThanOrEqualTo(root.get(PriceEntity_.START_DATE), filter.getDate())));
      }

      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
